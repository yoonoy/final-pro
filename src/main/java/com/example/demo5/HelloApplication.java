package com.example.demo5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Main class for the BMI Calculator JavaFX application.
 * This class extends the JavaFX Application class and acts as the entry point for the application.
 */
public class HelloApplication extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     * It sets up the primary stage (window) and loads the FXML layout.
     *
     * @param stage the primary stage for this application, onto which the
     *              application scene can be set.
     * @throws IOException if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the user interface.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Create a Scene object using the loaded FXML and set the dimensions.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the primary stage (window).
        stage.setTitle("BMI Calculator");

        // Attach the Scene to the Stage.
        stage.setScene(scene);

        // Show the Stage (window) to the user.
        stage.show();
    }
    /**
     * The main method is the entry point of the application.
     * It calls the launch() method, which starts the JavaFX application lifecycle.
     *
     * @param args the command line arguments (if any) passed to the application.
     */
    public static void main(String[] args) {
        launch();
    }
}