package org.example.Lab3.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.Lab3.controller.SmartHomeController;
import org.example.Lab3.domain.adapters.ThirdPartyDeviceAdapter;
import org.example.Lab3.domain.clases.Device;
import org.example.Lab3.domain.clases.ThirdPartyDevice;
import org.example.Lab3.domain.commands.*;
import org.example.Lab3.domain.factories.LightFactory;
import org.example.Lab3.domain.factories.ThermostatFactory;
import org.example.Lab3.domain.facade.SmartHomeFacade;

public class Main extends Application {
    private static SmartHomeController controller = SmartHomeController.getInstance();
    private static SmartHomeFacade facade = new SmartHomeFacade(controller);
    private CommandExecutor commandExecutor = new CommandExecutor();

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
        Button turnAllOnButton = new Button("Turn All Devices On");
        Button turnAllOffButton = new Button("Turn All Devices Off");
        Button enablePowerSavingButton = new Button("Enable Power Saving");
        Button disablePowerSavingButton = new Button("Disable Power Saving");
        Button addTurnOnCommandButton = new Button("Add Turn On Command");
        Button addTurnOffCommandButton = new Button("Add Turn Off Command");
        Button executeCommandsButton = new Button("Execute All Commands");

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setMinHeight(200);

        // Actions
        viewDevicesButton.setOnAction(e -> viewDevices(outputArea));
        turnAllOnButton.setOnAction(e -> {
            facade.turnAllDevicesOn();
            outputArea.setText("All devices have been turned on.");
        });
        turnAllOffButton.setOnAction(e -> {
            facade.turnAllDevicesOff();
            outputArea.setText("All devices have been turned off.");
        });
        enablePowerSavingButton.setOnAction(e -> {
            facade.enablePowerSavingMode();
            outputArea.setText("Power-saving mode enabled for all compatible devices.");
        });
        disablePowerSavingButton.setOnAction(e -> {
            facade.disablePowerSaving();
            outputArea.setText("Power-saving mode disabled for all compatible devices.");
        });
        addTurnOnCommandButton.setOnAction(e -> addTurnOnCommand(outputArea));
        addTurnOffCommandButton.setOnAction(e -> addTurnOffCommand(outputArea));
        executeCommandsButton.setOnAction(e -> {
            commandExecutor.executeAll();
            outputArea.appendText("\nExecuted all queued commands.");
        });

        // Add controls to layout
        mainLayout.getChildren().addAll(
                viewDevicesButton, turnAllOnButton, turnAllOffButton,
                enablePowerSavingButton, disablePowerSavingButton,
                addTurnOnCommandButton, addTurnOffCommandButton,
                executeCommandsButton, outputArea
        );

        // Scene and Stage setup
        Scene scene = new Scene(mainLayout, 400, 500);
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

    private void addTurnOnCommand(TextArea outputArea) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Turn On Command");
        dialog.setHeaderText("Enter device name to turn on:");
        dialog.showAndWait().ifPresent(deviceName -> {
            Device device = controller.getDevices().stream()
                    .filter(d -> d.getName().equalsIgnoreCase(deviceName))
                    .findFirst()
                    .orElse(null);
            if (device != null) {
                commandExecutor.addCommand(new TurnOnCommand(device));
                outputArea.appendText("Added Turn On Command for " + deviceName + "\n");
            } else {
                outputArea.appendText("Device not found: " + deviceName + "\n");
            }
        });
    }

    private void addTurnOffCommand(TextArea outputArea) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Turn Off Command");
        dialog.setHeaderText("Enter device name to turn off:");
        dialog.showAndWait().ifPresent(deviceName -> {
            Device device = controller.getDevices().stream()
                    .filter(d -> d.getName().equalsIgnoreCase(deviceName))
                    .findFirst()
                    .orElse(null);
            if (device != null) {
                commandExecutor.addCommand(new TurnOffCommand(device));
                outputArea.appendText("Added Turn Off Command for " + deviceName + "\n");
            } else {
                outputArea.appendText("Device not found: " + deviceName + "\n");
            }
        });
    }
}
