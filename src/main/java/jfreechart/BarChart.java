package jfreechart;

import java.awt.Color;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	public static void main(String[] args) throws Exception {

		final String stage = "CurrentStage";

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(4238913, stage, "Deal Identified");
		dataset.addValue(233713, stage, "Prospecting");
		dataset.addValue(767486, stage, "Quote Prepared");
		dataset.addValue(2071712, stage, "Stage 0 - Qualified Lead");

		JFreeChart barChart = ChartFactory.createBarChart("Opportunity Amount", stage, "Amount", dataset,
				PlotOrientation.HORIZONTAL, false, true, false);
		CategoryPlot plot = (CategoryPlot) barChart.getPlot();
		plot.getRenderer().setSeriesPaint(0, Color.BLUE);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File BarChart = new File("/home/sam/tmp/chart/BarChart.jpeg");
		ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
	}
}