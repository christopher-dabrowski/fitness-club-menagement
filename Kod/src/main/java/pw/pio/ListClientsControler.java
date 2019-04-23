package pw.pio;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lombok.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ListClientsControler {
    @FXML
    private ListView clientsListView;

    @FXML
    public void initialize() {
        val clients = BazaKlientow.getInstance().getKlienci();

//        clients.add(new Klient("Jan", "Kowalski", new Date(), null));

        List<String> toDisplay = clients.stream().map(c -> c.getImie() + " " + c.getNazwisko()).collect(Collectors.toList());
        val list = FXCollections.observableArrayList(toDisplay);
        clientsListView.setItems(list);
        clientsListView.setOrientation(Orientation.VERTICAL);
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
