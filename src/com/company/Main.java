package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.channels.InterruptedByTimeoutException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui.fxml"));
        Parent layout = fxmlLoader.load();
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
