package pw.pio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.val;
import lombok.var;

import java.time.LocalDate;

public class CreateEmployeeController {

        ObservableList<String> EmployeeList = FXCollections.observableArrayList("Trener", "Obsługa Recepcji", "Ochroniarz", "Manager");

        @FXML
        private TextField nameTextField;
        @FXML
        private TextField surnameTextField;
        @FXML
        private DatePicker passStartDatePicker;
        @FXML
        private ComboBox EmployeeComboBox;

        @FXML
        public void initialize() {
            System.out.println("Tworzenie okna");

            passStartDatePicker.setValue(LocalDate.now());

            EmployeeComboBox.setValue("Trener");
            EmployeeComboBox.setItems(EmployeeList);



        }


        @FXML
        public void submitButtonPressed(Event event)
        {
            System.out.println("Pracownik zatwierdzony");
        }
}


