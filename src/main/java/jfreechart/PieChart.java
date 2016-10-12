package jfreechart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChart {

	public PieChart(String title) {	}

	private static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("IPhone 5s", new Double(20));
		dataset.setValue("SamSung Grand", new Double(20));
		dataset.setValue("MotoG", new Double(40));
		dataset.setValue("Nokia Lumia", new Double(10));
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Mobile Sales", // chart
																		// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public void createImage() throws IOException {
		JFreeChart chart = createChart(createDataset());

		int width = 640; /* Width of the image */
	    int height = 480; /* Height of the image */
	    File pieChart = new File( "/home/sam/tmp/chart/PieChart.jpeg" );
	    ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
	}

	public static void main(String[] args) throws IOException {
		PieChart demo = new PieChart("Mobile Sales");
		demo.createImage();
	}
}