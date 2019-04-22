package pw.pio;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML
    private Button exitButton;

    public void exit(Event event)
    {
        System.exit(0);
    }
}
