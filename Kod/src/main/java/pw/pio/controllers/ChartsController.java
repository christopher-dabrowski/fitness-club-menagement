package pw.pio.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import lombok.val;
import lombok.var;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ChartsController implements Initializable {
    @FXML
    private LineChart lineChart;

    private int year = 2020;

    private final static Random random = new Random();

    public void predictFirmStocks() {
        var values = new ArrayList<Double>(100);
        for (int i = 0; i < 100; i++) {
            values.add(random.nextGaussian());
        }

        values = cumulativeSum(values);

        val dataSeries1 = new XYChart.Series();
        dataSeries1.setName(Integer.toString(year++));

//        dataSeries1.getData().add(new XYChart.Data( 1.2, 567.1));
//        dataSeries1.getData().add(new XYChart.Data( 5, 612));
//        dataSeries1.getData().add(new XYChart.Data(10, 800));
//        dataSeries1.getData().add(new XYChart.Data(20, 780));
//        dataSeries1.getData().add(new XYChart.Data(40, 810));
//        dataSeries1.getData().add(new XYChart.Data(80, 850));

        for (int i = 0; i < values.size(); i++) {
            dataSeries1.getData().add(new XYChart.Data(i+1, values.get(i)));
        }

        lineChart.getData().add(dataSeries1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineChart.getXAxis().setLabel("Dni w roku");
        lineChart.getYAxis().setLabel("Wartość akcji");
    }

    private ArrayList<Double> cumulativeSum(List<Double> data) {
        val result = new ArrayList<Double>(data);

        for (int i = 1; i < result.size(); i++) {
            result.set(i, result.get(i-1) + result.get(i));
        }

        return result;
    }

    @FXML
    public void returnToMainMenu(Event event) {
        try {
            val root = (Parent) FXMLLoader.load(getClass().getResource("/App.fxml"));

            val stage = new Stage();
            stage.setTitle("Główne menu");
            stage.setScene(new Scene(root));
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e)
        {
            System.exit(1);
        }
    }
}
