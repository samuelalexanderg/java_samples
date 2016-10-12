package javafx.image;

import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class BarChartSample extends Application {
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart SparkXMLUtilsSample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Opportunity Amount");
        xAxis.setLabel("Stage");
        yAxis.setLabel("Amount");

        XYChart.Series series1 = new XYChart.Series();
//        series1.setCustomer_name("2003");
        series1.getData().add(new XYChart.Data("Deal Identified", 4238913));
        series1.getData().add(new XYChart.Data("Prospecting", 233713));
        series1.getData().add(new XYChart.Data("Quote Prepared", 767486));
        series1.getData().add(new XYChart.Data("Stage 0 - Qualified Lead", 2071712));
//        series1.getData().add(new XYChart.Data(usa, 12000));

        URL resource = getClass().getClassLoader().getResource("colored-chart.css");
        System.out.println("Resource : " + resource);
        bc.getStylesheets().add(getClass().getClassLoader().getResource("colored-chart.css").toExternalForm());
        bc.setAnimated(false);
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);

        WritableImage snapShot = scene.snapshot(null);

        try {
        	ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("/home/sam/tmp/chart/barchat_javafx.png"));
        } catch (Exception e) {
        	e.printStackTrace();
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}