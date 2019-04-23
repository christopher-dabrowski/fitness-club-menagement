package pw.pio;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import lombok.*;

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
}
