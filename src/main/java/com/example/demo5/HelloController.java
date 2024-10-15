package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private ComboBox<String> unitComboBox;

    @FXML
    private Label bmiResultLabel;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        unitComboBox.getItems().addAll("Metric (kg/m)", "English (lbs/in)");
    }

    @FXML
    protected void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            String unit = unitComboBox.getValue();

            if (unit == null) {
                bmiResultLabel.setText("Select unit.");
                return;
            }

            double bmi;
            if (unit.equals("Metric (kg/m)")) {
                bmi = weight / (height * height);
            } else { // English (lbs/in)
                bmi = (weight / (height * height)) * 703;
            }

            bmiResultLabel.setText(String.format("%.2f", bmi));
            updateStatus(bmi);

        } catch (NumberFormatException e) {
            bmiResultLabel.setText("Invalid input.");
            statusLabel.setText("");
        }
    }

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
}