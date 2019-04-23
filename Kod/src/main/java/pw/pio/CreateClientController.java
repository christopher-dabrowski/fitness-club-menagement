package pw.pio;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.val;
import lombok.var;

import java.time.LocalDate;

public class CreateClientController {
//    @FXML
//    private javafx.scene.control.Label nameField;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField passNameTextField;
    @FXML
    private DatePicker passStartDatePicker;
    @FXML
    private Spinner passDurationSpinner;
    @FXML
    private TextField monthlyCostTextField;
    @FXML
    private ChoiceBox freeActivitiesChoiceBox;

    @FXML
    public void initialize() {
        System.out.println("Tworzenie okna");

        passStartDatePicker.setValue(LocalDate.now());

        val valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 90, 30);
        passDurationSpinner.setValueFactory(valueFactory);

        var options = FXCollections.observableArrayList("Nie", "Tak");
        freeActivitiesChoiceBox.setItems(options);
        freeActivitiesChoiceBox.setValue(freeActivitiesChoiceBox.getItems().get(0));
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
