package pw.pio;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.val;

import java.time.LocalDate;

public class CreateClientController {
//    @FXML
//    private javafx.scene.control.Label nameField;

    @FXML
    private TextField nameLabel;
    @FXML
    private TextField surnameLabel;
    @FXML
    private DatePicker passStartDatePicker;
    @FXML
    private Spinner passDurationSpinner;

    @FXML
    public void initialize() {
        System.out.println("Tworzenie okna");

        passStartDatePicker.setValue(LocalDate.now());

        val valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 90, 30);
        passDurationSpinner.setValueFactory(valueFactory);
    }

//    @FXML
//    private Spinner karnetDurationSpinner;

//    {
////        nameField.setText("Test bloku inicjalizacyjnego");
////        karnetDurationSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 90, 30));
//    }

    @FXML
    public void submitButtonPressed(Event event)
    {
        System.out.println("Klient zatwierdzony");
    }
}
