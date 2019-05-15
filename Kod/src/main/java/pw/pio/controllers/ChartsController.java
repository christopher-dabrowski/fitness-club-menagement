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

    private double lastValues = 0.;
    private double lastPoint = 1;

    private final static Random random = new Random();

    public void predictFirmStocks() {
        var values = new ArrayList<Double>(100);
        for (int i = 0; i < 100; i++) {
            values.add(random.nextGaussian());
        }

        values.set(0, lastValues);

        values = cumulativeSum(values);

        lastValues = values.get(values.size()-1);

        val dataSeries1 = new XYChart.Series();
        dataSeries1.setName(Integer.toString(year++));

        for (int i = 0; i < values.size(); i++) {
            dataSeries1.getData().add(new XYChart.Data( lastPoint++, values.get(i)));
        }

        lineChart.getData().add(dataSeries1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineChart.getXAxis().setLabel("Czas");
        lineChart.getYAxis().setLabel("Wartość akcji firmy");
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
