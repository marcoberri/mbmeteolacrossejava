package it.marcoberri.controller;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.model.MaxMinData;
import it.marcoberri.model.Raw;
import it.marcoberri.repositories.MaxMinDataRepository;
import it.marcoberri.repositories.RawRepository;
import it.marcpberri.helper.PathConstants;

@Controller
@RequestMapping("/draw")
public class DrawController {

	@Autowired
	private RawRepository rawRepository;

	@Autowired
	private MaxMinDataRepository maxMinDataRepository;

	/**
	 * 
	 * Example: http://localhost:8080/meteo/draw/T/30/700/500
	 * db.rawdata.remove({"T1":NaN}); db.rawdata.remove({"H1":NaN});
	 * db.rawdata.remove({"PRESS":NaN}); db.rawdata.remove({"WC":NaN});
	 * 
	 * @param dayFirst
	 * @param type
	 * @param x
	 * @param y
	 * @param resp
	 */
	@RequestMapping(value = "/{" + PathConstants.PARAM_FILTER_TYPE + "}/{" + PathConstants.PARAM_FILTER_FROM_DAY + "}/{"
			+ PathConstants.PARAM_SIZE_X + "}/{" + PathConstants.PARAM_SIZE_Y + "}", method = RequestMethod.GET)
	public void drawChart(@PathVariable(value = PathConstants.PARAM_FILTER_FROM_DAY) int dayFirst, @PathVariable(value = PathConstants.PARAM_FILTER_TYPE) String type, @PathVariable(value = PathConstants.PARAM_SIZE_X) int x, @PathVariable(value = PathConstants.PARAM_SIZE_Y) int y, HttpServletResponse resp) {

		final Raw rawLast = rawRepository.findFirstByOrderByTsDesc();

		final Calendar cal = Calendar.getInstance();
		cal.setTime(rawLast.getTs());
		cal.add(Calendar.DATE, -dayFirst);

		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		long fromDateMillis = cal.getTimeInMillis();

		final List<Raw> resultList = rawRepository.findByTsMillisGreaterThanOrderByTsDesc(fromDateMillis);

		final List<String> dateForMaxAndMin = new ArrayList<String>();

		final TimeSeries s1 = new TimeSeries("Series " + type);

		Float pre = 0f;
		for (Raw r : resultList) {

			if (r.getTs() == null)
				continue;

			final String date = df.format(r.getTs());
			if (!dateForMaxAndMin.contains(date))
				dateForMaxAndMin.add(date);

			if (type.equals("T")) {

				if (r.getT1() == null) {
					continue;
				}
				if (r.getT1() == null || r.getT1().floatValue() == pre.floatValue()) {
					continue;
				}

				s1.addOrUpdate(new Second(r.getTs()), r.getT1());
				pre = r.getT1();
			} else

			if (type.equals("H")) {
				if (r.getH1() == null || r.getH1().floatValue() == pre.floatValue()) {
					continue;
				}

				s1.addOrUpdate(new Second(r.getTs()), r.getH1());
				pre = r.getH1();
			} else

			if (type.equals("PRESS")) {
				if (r.getPress() == null || r.getPress().floatValue() == pre.floatValue()) {
					continue;
				}

				s1.addOrUpdate(new Second(r.getTs()), r.getPress());
				pre = r.getPress();
			} else

			if (type.equals("WC")) {
				if (r.getWc() == null || r.getWc().floatValue() == pre.floatValue()) {
					continue;
				}

				s1.addOrUpdate(new Second(r.getTs()), r.getWc());
				pre = r.getWc();
			} else

			if (type.equals("WS")) {
				if (r.getWs() == null || r.getWs().floatValue() == pre.floatValue()) {
					continue;
				}

				s1.addOrUpdate(new Second(r.getTs()), r.getWs());
				pre = r.getWs();
			}

		}

		final TimeSeries s2 = new TimeSeries("Series Max " + type);
		final TimeSeries s3 = new TimeSeries("Series Min " + type);

		if (dayFirst > 1 && dayFirst < 60) {
			for (String date2 : dateForMaxAndMin) {


				MaxMinData dataLoad = maxMinDataRepository.findByTsOrderByTs(date2);

				if (dataLoad == null)
					continue;

				try {
					if (type.equals("T")) {
						s2.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getT1MaxDay());
						s3.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getT1MinDay());
					} else if (type.equals("H")) {
						s2.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getH1MaxDay());
						s3.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getH1MinDay());
					} else if (type.equals("PRESS")) {
						s2.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getPressMaxDay());
						s3.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getPressMinDay());
					} else if (type.equals("WC")) {
						s2.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getWcMaxDay());
						s3.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getWcMinDay());
					} else if (type.equals("WS")) {
						s2.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getWsMaxDay());
						s3.addOrUpdate(new Hour(df.parse(date2)), dataLoad.getWsMinDay());
					}

				} catch (ParseException e) {

				}

			}
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		if (dayFirst > 1 && dayFirst < 60) {
			dataset.addSeries(s3);
			dataset.addSeries(s2);
		}

		String title = "Temperature °C";
		String unity = "°C";

		if (type.equals("H")) {
			title = "Humidity %";
			unity = "%";
		} else

		if (type.equals("PRESS")) {
			title = "Pressure mBar";
			unity = "mBar";
		} else

		if (type.equals("WC")) {
			title = "Wind Chill °C";
			unity = "°C";
		} else

		if (type.equals("WS")) {
			title = "Wind Speed m/s";
			unity = "m/s";
		}

		title += " last " + dayFirst + " days";

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title, // title
				"Date", // x-axis label
				unity, // y-axis label
				dataset, // data
				false, // create legend?
				false, // generate tooltips?
				false // generate URLs?
		);

		chart.setBackgroundPaint(Color.white);

		final XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.BLACK);

		final DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
		axis.setVerticalTickLabels(true);

		try {

			resp.reset();
			resp.setContentType(MediaType.IMAGE_PNG_VALUE);
			ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, x, y, new ChartRenderingInfo());
			resp.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}