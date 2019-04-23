package pw.pio;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.val;
import lombok.var;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button exitButton;

    public void exit(Event event)
    {
        System.exit(0);
    }

    public void openClientAdditionWindow(Event event)
    {
        try {
            val root = (Parent) FXMLLoader.load(getClass().getResource("/NewClient.fxml"));

            val stage = new Stage();
            stage.setTitle("Nowy klient");
            stage.setScene(new Scene(root));
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e)
        {
            System.exit(1);
        }

    }

    public void openEmployeeAdditionWindow(Event event)
    {
        try {
            val root = (Parent) FXMLLoader.load(getClass().getResource("/NewEmployee.fxml"));

            val stage = new Stage();
            stage.setTitle("Nowy pracownik");
            stage.setScene(new Scene(root));
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e)
        {
            System.exit(1);
        }

    }

}
