package it.marcoberri.controller;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.marcoberri.model.Raw;
import it.marcoberri.repositories.RawRepository;
import it.marcpberri.helper.PathConstants;

@Controller
@RequestMapping("/draw")
public class DrawController {

	@Autowired
	private RawRepository rawRepository;

	
	
	/**
	 * 
	 * Example: http://localhost:8080/meteo/draw/T/30/700/500
	 *  db.rawdata.remove({"T1":NaN});
	 *  db.rawdata.remove({"H1":NaN});
	 *  db.rawdata.remove({"PRESS":NaN});
	 * @param dayFirst
	 * @param type
	 * @param x
	 * @param y
	 * @param resp
	 */
	@RequestMapping(value = "/{"+PathConstants.PARAM_FILTER_TYPE+"}/{" + PathConstants.PARAM_FILTER_FROM_DAY+ "}/{" + PathConstants.PARAM_SIZE_X + "}/{" + PathConstants.PARAM_SIZE_Y + "}", method = RequestMethod.GET)
	public void getValues(@PathVariable(value = PathConstants.PARAM_FILTER_FROM_DAY) int dayFirst, @PathVariable(value = PathConstants.PARAM_FILTER_TYPE) String type, @PathVariable(value = PathConstants.PARAM_SIZE_X) int x, @PathVariable(value = PathConstants.PARAM_SIZE_Y) int y,HttpServletResponse resp) {

		final Raw rawLast = rawRepository.findFirstByOrderByTsDesc();

		final Calendar cal = Calendar.getInstance();
		cal.setTime(rawLast.getTs());
		cal.add(Calendar.DATE, -dayFirst);
		
		long fromDateMillis = cal.getTimeInMillis();

		List<Raw> resultList = rawRepository.findByTsMillisGreaterThanOrderByTsDesc(fromDateMillis);
		
		TimeSeries s1 = new TimeSeries("Series 1");

		Float pre = 0f;
		for (Raw r : resultList) {
			if(type.equals("T")){
				if(r.getT1() == null){
					continue;
				}
				if(r.getT1().floatValue() == pre.floatValue()){
					continue;
				}
	
				s1.addOrUpdate(new Second(r.getTs()), r.getT1());
				pre = r.getT1();
			}

			if(type.equals("H")){
				if(r.getH1().floatValue() == pre.floatValue()){
					continue;
				}
	
				s1.addOrUpdate(new Second(r.getTs()), r.getH1());
				pre = r.getH1();
			}

			if(type.equals("PRESS")){
				if(r.getPress().floatValue() == pre.floatValue()){
					continue;
				}
	
				s1.addOrUpdate(new Second(r.getTs()), r.getPress());
				pre = r.getPress();
			}

		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);

		String title = "Temperature °C";
		String unity = "°C";		
		if(type.equals("H")){
			title = "Humidity %";
			unity = "%";
		}

		if(type.equals("PRESS")){
			title = "Pressure mBar";
			unity = "mBar";
		}

		title +=" last " + dayFirst + " days";
		
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

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
		axis.setVerticalTickLabels(true);

		try {
			ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, x , y, new ChartRenderingInfo());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}