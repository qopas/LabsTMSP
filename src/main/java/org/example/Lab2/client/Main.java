package org.example.Lab2.client;

import org.example.Lab2.controller.SmartHomeController;
import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.adapters.ThirdPartyDeviceAdapter;
import org.example.Lab2.domain.clases.ThirdPartyDevice;
import org.example.Lab2.domain.factories.LightFactory;
import org.example.Lab2.domain.factories.ThermostatFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class Main extends Application {
    private static SmartHomeController controller = SmartHomeController.getInstance();

    public static void main(String[] args) {
        // Pre-configured devices
        controller.addDevice(new LightFactory().createDevice());
        controller.addDevice(new ThermostatFactory().createDevice());
        controller.addDevice(new ThirdPartyDeviceAdapter(new ThirdPartyDevice()));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smart Home System");

        // Layouts
        VBox mainLayout = new VBox(10);
        mainLayout.setStyle("-fx-padding: 10;");

        // Buttons and Controls
        Button viewDevicesButton = new Button("View Devices");
        Button turnOnButton = new Button("Turn On Device");
        Button turnOffButton = new Button("Turn Off Device");
        Button adjustLightButton = new Button("Adjust Light Brightness");
        Button setThermostatButton = new Button("Set Thermostat Temperature");
        Button enablePowerSavingButton = new Button("Enable Power Saving");
        Button disablePowerSavingButton = new Button("Disable Power Saving");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setMinHeight(200);

        // Actions
        viewDevicesButton.setOnAction(e -> viewDevices(outputArea));
        turnOnButton.setOnAction(e -> toggleDeviceStatus(outputArea, true));
        turnOffButton.setOnAction(e -> toggleDeviceStatus(outputArea, false));
        adjustLightButton.setOnAction(e -> adjustLightBrightness(outputArea));
        setThermostatButton.setOnAction(e -> setThermostatTemperature(outputArea));
        enablePowerSavingButton.setOnAction(e -> enablePowerSavingMode(outputArea));
        disablePowerSavingButton.setOnAction(e -> disablePowerSavingMode(outputArea));

        // Add controls to layout
        mainLayout.getChildren().addAll(
                viewDevicesButton, turnOnButton, turnOffButton,
                adjustLightButton, setThermostatButton,
                enablePowerSavingButton, disablePowerSavingButton,
                outputArea
        );

        // Scene and Stage setup
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void viewDevices(TextArea outputArea) {
        StringBuilder devicesList = new StringBuilder("Current Devices:\n");
        for (Device device : controller.getDevices()) {
            devicesList.append(device.getName()).append("\n");
        }
        outputArea.setText(devicesList.toString());
    }

    private void toggleDeviceStatus(TextArea outputArea, boolean turnOn) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Device Name");
        dialog.setHeaderText("Enter the device name to " + (turnOn ? "turn on" : "turn off") + ":");
        dialog.showAndWait().ifPresent(deviceName -> {
            controller.toggleDevice(deviceName, turnOn);
            outputArea.setText(deviceName + " is now " + (turnOn ? "ON" : "OFF"));
        });
    }

    private void adjustLightBrightness(TextArea outputArea) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Light Brightness");
        dialog.setHeaderText("Enter the name of the light to adjust:");
        dialog.showAndWait().ifPresent(lightName -> {
            TextInputDialog brightnessDialog = new TextInputDialog();
            brightnessDialog.setTitle("Brightness Level");
            brightnessDialog.setHeaderText("Enter brightness level (0-100):");
            brightnessDialog.showAndWait().ifPresent(brightness -> {
                try {
                    int brightnessLevel = Integer.parseInt(brightness);
                    controller.adjustLightBrightness(lightName, brightnessLevel);
                    outputArea.setText("Brightness of " + lightName + " adjusted to " + brightnessLevel + ".");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Invalid brightness level.");
                }
            });
        });
    }

    private void setThermostatTemperature(TextArea outputArea) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Thermostat Temperature");
        dialog.setHeaderText("Enter the name of the thermostat to adjust:");
        dialog.showAndWait().ifPresent(thermostatName -> {
            TextInputDialog tempDialog = new TextInputDialog();
            tempDialog.setTitle("Temperature");
            tempDialog.setHeaderText("Enter the temperature:");
            tempDialog.showAndWait().ifPresent(temp -> {
                try {
                    double temperature = Double.parseDouble(temp);
                    controller.setThermostatTemperature(thermostatName, temperature);
                    outputArea.setText("Temperature of " + thermostatName + " set to " + temperature + "°C.");
                } catch (NumberFormatException ex) {
                    outputArea.setText("Invalid temperature value.");
                }
            });
        });
    }

    private void enablePowerSavingMode(TextArea outputArea) {
        controller.enablePowerSaving();
        outputArea.setText("Power-saving mode enabled for all compatible devices.");
    }

    private void disablePowerSavingMode(TextArea outputArea) {
        controller.disablePowerSaving();
        outputArea.setText("Power-saving mode disabled for all compatible devices.");
    }
}
