package com.example.temperatureconverterfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private TextField temperatureField;

    @FXML
    private RadioButton celsiusRadio;

    @FXML
    private RadioButton fahrenheitRadio;

    @FXML
    private RadioButton kelvinRadio;

    @FXML
    private Label resultLabel;
    @FXML
    private void handleMouseEntered(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #0069bf; -fx-text-fill: white;");
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: black;"); // reset to default style
    }


    @FXML
    public void handleConvertButtonAction() {
        try {
            double temperature = Double.parseDouble(temperatureField.getText());

            String originalUnit = getSelectedUnit();
            double celsius = 0, fahrenheit = 0, kelvin = 0;

            if (originalUnit.equals("Celsius")) {
                celsius = temperature;
                fahrenheit = celsiusToFahrenheit(celsius);
                kelvin = celsiusToKelvin(celsius);
            } else if (originalUnit.equals("Fahrenheit")) {
                fahrenheit = temperature;
                celsius = fahrenheitToCelsius(fahrenheit);
                kelvin = fahrenheitToKelvin(fahrenheit);
            } else if (originalUnit.equals("Kelvin")) {
                kelvin = temperature;
                celsius = kelvinToCelsius(kelvin);
                fahrenheit = kelvinToFahrenheit(kelvin);
            }

            String result = String.format("Celsius: %.2f, Fahrenheit: %.2f, Kelvin: %.2f", celsius, fahrenheit, kelvin);
            resultLabel.setText(result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid temperature value.");
        }
    }


    private String getSelectedUnit() {
        if (celsiusRadio.isSelected()) {
            return "Celsius";
        } else if (fahrenheitRadio.isSelected()) {
            return "Fahrenheit";
        } else if (kelvinRadio.isSelected()) {
            return "Kelvin";
        }
        return "";
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    private double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}