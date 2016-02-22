package it.marcoberri.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFSDBFile;

import it.marcoberri.helper.PathConstants;
import it.marcoberri.model.MaxMinData;
import it.marcoberri.model.Raw;
import it.marcoberri.repositories.MaxMinDataRepository;
import it.marcoberri.repositories.RawRepository;

@Controller
@RequestMapping("/draw")
public class DrawController {

	@Autowired
	private RawRepository rawRepository;

	@Autowired
	private MaxMinDataRepository maxMinDataRepository;

	@Autowired
	private GridFsOperations operations;

	@RequestMapping(value = "/archive/{"
			+ PathConstants.PARAM_FILTER_TYPE
			+ "}/{"
			+ PathConstants.PARAM_FILTER_FROM_MONTH
			+ "}/{"
			+ PathConstants.PARAM_FILTER_FROM_YEAR
			+ "}/{"
			+ PathConstants.PARAM_SIZE_X
			+ "}/{" +
			PathConstants.PARAM_SIZE_Y + "}", method = RequestMethod.GET)
	public void drawChartMonth(@PathVariable(value = PathConstants.PARAM_FILTER_FROM_MONTH) int month, @PathVariable(value = PathConstants.PARAM_FILTER_FROM_YEAR) int year, @PathVariable(value = PathConstants.PARAM_FILTER_TYPE) String type, @PathVariable(value = PathConstants.PARAM_SIZE_X) int x, @PathVariable(value = PathConstants.PARAM_SIZE_Y) int y, HttpServletResponse resp) {

		final GridFSDBFile fileCache = operations.findOne(query(where("metadata.type").is(type + month + year).and(
				"metadata.x").is(x).and("metadata.y").is(y)));

		if (fileCache != null) {
			resp.reset();
			resp.setContentType(MediaType.IMAGE_PNG_VALUE);
			try {
				IOUtils.copy(fileCache.getInputStream(), resp.getOutputStream());
				resp.flushBuffer();
			} catch (final IOException e) {
				e.printStackTrace();
			}

			return;

		}

		Calendar cal = Calendar.getInstance();

		final TimeSeries s1 = new TimeSeries("Series " + type);
		Float pre = 0f;
		Sort sort = new Sort(Direction.DESC, "ts");
		final List<Raw> resultList = rawRepository.findAll(sort);
		for (Raw r : resultList) {

			if (r.getTs() == null)
				continue;

			cal.setTime(r.getTs());
			int act_month = cal.get(Calendar.MONTH);
			int act_year = cal.get(Calendar.YEAR);

			if ((act_month + 1) != month) {
				continue;
			}

			if (act_year != year) {
				continue;
			}

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

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);

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

		title += " " + month + "/" + year;

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				title,
				null,
				unity,
				dataset,
				false,
				false,
				false);

		chart.setBackgroundPaint(Color.white);
		chart.addSubtitle(getLeggendDate());

		final XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.BLACK);

		final DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
		axis.setVerticalTickLabels(true);

		File file = null;

		try {

			file = File.createTempFile("tmp", ".png");

			resp.reset();
			resp.setContentType(MediaType.IMAGE_PNG_VALUE);

			ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, x, y, new ChartRenderingInfo());

			ChartUtilities.saveChartAsPNG(file, chart, x, y);

			final BasicDBObject obj = new BasicDBObject();
			obj.append("type", type + month + year);
			obj.append("x", x);
			obj.append("y", y);
			obj.append("ts", new Date());

			operations.store(new FileInputStream(file.toString()), file.toString(), MediaType.IMAGE_PNG_VALUE, obj);
			resp.flushBuffer();

		} catch (IOException e) {
		} finally {
			if (file != null)
				file.deleteOnExit();

		}
	}

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
	@RequestMapping(value = "/{"
			+ PathConstants.PARAM_FILTER_TYPE
			+ "}/{"
			+ PathConstants.PARAM_FILTER_FROM_DAY
			+ "}/{"
			+ PathConstants.PARAM_SIZE_X
			+ "}/{"
			+ PathConstants.PARAM_SIZE_Y
			+ "}", method = RequestMethod.GET)
	public void drawChart(@PathVariable(value = PathConstants.PARAM_FILTER_FROM_DAY) int dayFirst, @PathVariable(value = PathConstants.PARAM_FILTER_TYPE) String type, @PathVariable(value = PathConstants.PARAM_SIZE_X) int x, @PathVariable(value = PathConstants.PARAM_SIZE_Y) int y, HttpServletResponse resp) {

		boolean cache = false;

		if (dayFirst >= 7) {
			cache = true;
		}

		if (cache) {
			// verifico se esiste in cache
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -dayFirst);
			final Date datePre = c.getTime();

			GridFSDBFile fileCache = operations.findOne(query(where("metadata.type").is(type).and("metadata.dayFirst")
					.is(dayFirst).and("metadata.x").is(x).and("metadata.y").is(y).and("metadata.ts").gte(datePre)));

			if (fileCache != null) {
				// lo tiro fuori e lo servo altrimenti pulisco quelli cecchi e
				// proseguo

				resp.reset();
				resp.setContentType(MediaType.IMAGE_PNG_VALUE);
				try {
					IOUtils.copy(fileCache.getInputStream(), resp.getOutputStream());
					resp.flushBuffer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return;

			} else {
				// se il file è nullo pulisco
				operations.delete(query(where("metadata.type").is(type).and("metadata.dayFirst").is(dayFirst).and(
						"metadata.x").is(x).and("metadata.y").is(y)));
			}

		}

		Sort sort = new Sort(Direction.DESC, "ts");
		final Raw rawLast = rawRepository.findFirstBy(sort);

		final Calendar cal = Calendar.getInstance();
		cal.setTime(rawLast.getTs());
		cal.add(Calendar.DATE, -dayFirst);

		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		long fromDateMillis = cal.getTimeInMillis();

		final List<Raw> resultList = rawRepository.findByTsMillisGreaterThan(fromDateMillis, sort);

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

				MaxMinData dataLoad = maxMinDataRepository.findByTs(date2, sort);

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
				title,
				null,
				unity,
				dataset,
				false,
				false,
				false);

		chart.setBackgroundPaint(Color.white);
		chart.addSubtitle(getLeggendDate());

		final XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.BLACK);

		final DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
		axis.setVerticalTickLabels(true);

		File file = null;

		try {

			file = File.createTempFile("tmp", ".png");

			resp.reset();
			resp.setContentType(MediaType.IMAGE_PNG_VALUE);

			ChartUtilities.writeChartAsPNG(resp.getOutputStream(), chart, x, y, new ChartRenderingInfo());

			if (cache) {
				ChartUtilities.saveChartAsPNG(file, chart, x, y);

				final BasicDBObject obj = new BasicDBObject();
				obj.append("type", type);
				obj.append("dayFirst", dayFirst);
				obj.append("x", x);
				obj.append("y", y);
				obj.append("ts", new Date());

				operations.store(new FileInputStream(file.toString()), file.toString(), MediaType.IMAGE_PNG_VALUE, obj);
			}
			resp.flushBuffer();

		} catch (IOException e) {
		} finally {
			if (file != null)
				file.deleteOnExit();

		}

	}

	/**
	 * revove all cache files
	 * 
	 * @return
	 */
	@RequestMapping(value = "/removecache/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCache() {

		final List<GridFSDBFile> files = operations.find(null);

		for (GridFSDBFile f : files) {
			operations.delete(query(where("_id").is(f.getId())));
		}

		return "ok";

	}

	private TextTitle getLeggendDate() {
		SimpleDateFormat sdfHourDay = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		final TextTitle legendText = new TextTitle(sdfHourDay.format(new Date()));
		legendText.setPosition(RectangleEdge.RIGHT);
		legendText.setFont(new java.awt.Font("SansSerif", java.awt.Font.ITALIC, 12));
		return legendText;

	}
}