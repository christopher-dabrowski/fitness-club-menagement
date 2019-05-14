package pw.pio;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import lombok.val;
import lombok.var;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.UnaryOperator;

public class CreateClientController {
//    @FXML
//    private javafx.scene.control.Label nameField;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private DatePicker passStartDatePicker;
    @FXML
    private TextField passNameTextField;
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

        UnaryOperator<TextFormatter.Change> positiveIntegerFilter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };

        val textFormatter = new TextFormatter(positiveIntegerFilter);
        monthlyCostTextField.setTextFormatter(textFormatter);
    }

//    @FXML
//    private Spinner karnetDurationSpinner;

//    {
////        nameField.setText("Test bloku inicjalizacyjnego");
////        karnetDurationSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 90, 30));
//    }

    /**
     * Check if fields have correct values
     *
     * @param errorsOut Localized error message describing firs invalid value.
     * @return <c>True</c> if fields have correct values <c>False</c> otherwise.
     */
    private boolean isInputValid(ArrayList<String> errorsOut) {
        boolean isOk = true;

        if (!nameTextField.getText().matches("\\p{L}+")) {
            errorsOut.add("Nieprawidłowe imie");
            isOk = false;
        }
        if (!surnameTextField.getText().matches("\\p{L}+")) {
            errorsOut.add("Nieprawidłowe nazwisko");
            isOk = false;
        }
        //Pass start can be any date
        if (!passNameTextField.getText().matches(".+")) {
            errorsOut.add("Nieprawidłowa nazwa pakietu");
            isOk = false;
        }
        //Pass duration already has data validation
        if (!monthlyCostTextField.getText().matches("\\d+([\\.,]\\d{1,2})?")) { //Can have either . or , as decimal separator
            errorsOut.add("Nieprawidłowy miesięczny koszt");
            isOk = false;
        }
        //freeActivitiesChoiceBox is always valid as it's value from list

        return isOk;
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

    @FXML
    public void submitButtonPressed(Event event) {
        var errors = new ArrayList<String>(4);
        if (!isInputValid(errors)) {
            val alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nieprawidłowe dane");
            alert.setHeaderText("Niektóre pola mają nieprawidłowe wartości");
            alert.setContentText(String.join("\n", errors));

            alert.showAndWait();

            return;
        }

        val cost = Double.parseDouble(monthlyCostTextField.getText().replace(',', '.'));
        val freeActivity = freeActivitiesChoiceBox.getValue().equals("True") ? true : false;

        val newClient = new Klient
                (
                        nameTextField.getText(),
                        surnameTextField.getText(),
                        Date.from(passStartDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        new PakietUslug
                                (
                                        passNameTextField.getText(),
                                        (int) passDurationSpinner.getValue(),
                                        cost,
                                        freeActivity
                                )
                );

        BazaKlientow.getInstance().dodajKlienta(newClient);

        val alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Klient dodany");
        alert.setHeaderText("Dodanie klienta przebiegło poprawnie");

        alert.showAndWait();
    }
}
