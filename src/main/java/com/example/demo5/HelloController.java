package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Platform;

public class HelloController {

    // TextField for entering weight
    @FXML
    private TextField weightField;

    // TextField for entering height
    @FXML
    private TextField heightField;

    // ComboBox for selecting units (Metric or English)
    @FXML
    private ComboBox<String> unitComboBox;

    // Label to display the calculated BMI result
    @FXML
    private Label bmiResultLabel;

    // Label to display the BMI status (Underweight, Normal, Overweight, Obese)
    @FXML
    private Label statusLabel;

    // Initialize method called when the controller is loaded
    @FXML
    public void initialize() {
        // Add unit options to the ComboBox
        unitComboBox.getItems().addAll("Metric (kg/m)", "English (lbs/in)");
    }

    // Method called when the "Calculate BMI" button is pressed
    @FXML
    protected void calculateBMI() {
        try {
            // Parse weight and height inputs from the user
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            String unit = unitComboBox.getValue();

            // Check if the user selected a unit
            if (unit == null) {
                bmiResultLabel.setText("Select unit.");
                return;
            }

            double bmi;
            // Calculate BMI based on the selected unit (Metric or English)
            if (unit.equals("Metric (kg/m)")) {
                bmi = weight / (height * height); // Metric BMI formula
            } else { // English (lbs/in)
                bmi = (weight / (height * height)) * 703; // English BMI formula
            }

            // Display the calculated BMI
            bmiResultLabel.setText(String.format("%.2f", bmi));

            // Update the BMI status (Underweight, Normal, etc.)
            updateStatus(bmi);

        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., non-numeric values)
            bmiResultLabel.setText("Invalid input.");
            statusLabel.setText("");
        }
    }

    // Method to update the BMI status based on the calculated BMI value
    private void updateStatus(double bmi) {
        if (bmi < 18.5) {
            statusLabel.setText("Underweight");
        } else if (bmi < 24.9) {
            statusLabel.setText("Normal");
        } else if (bmi < 29.9) {
            statusLabel.setText("Overweight");
        } else {
            statusLabel.setText("Obese");
        }
    }

    // Method to clear the input fields and labels when "Clear" is selected
    @FXML
    protected void clearFields() {
        weightField.clear();
        heightField.clear();
        unitComboBox.getSelectionModel().clearSelection();
        bmiResultLabel.setText("");
        statusLabel.setText("");
    }

    // Method to exit the application when "Exit" is selected
    @FXML
    protected void exitApplication() {
        Platform.exit();
    }

    // Method to show a help dialog with information about using the BMI Calculator
    @FXML
    protected void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("How to use the BMI Calculator");
        alert.setContentText("1. Enter your weight in kilograms or pounds.\n"
                + "2. Enter your height in meters or inches.\n"
                + "3. Select the unit of measurement from the dropdown.\n"
                + "4. Click 'Calculate BMI' to see your BMI and status.\n"
                + "5. Use 'Clear' to reset the fields or 'Exit' to close the application.");
        alert.showAndWait();
    }
}