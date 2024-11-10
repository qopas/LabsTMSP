package org.example.Lab2.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.Lab2.controller.SmartHomeController;
import org.example.Lab2.domain.adapters.ThirdPartyDeviceAdapter;
import org.example.Lab2.domain.clases.Device;
import org.example.Lab2.domain.clases.ThirdPartyDevice;
import org.example.Lab2.domain.factories.LightFactory;
import org.example.Lab2.domain.factories.ThermostatFactory;
import org.example.Lab2.domain.facade.SmartHomeFacade;

public class Main extends Application {
    private static SmartHomeController controller = SmartHomeController.getInstance();
    private static SmartHomeFacade facade = new SmartHomeFacade(controller);

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

        // Add controls to layout
        mainLayout.getChildren().addAll(
                viewDevicesButton, turnAllOnButton, turnAllOffButton,
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
}
