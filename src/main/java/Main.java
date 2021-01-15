import Model.WeatherAppModel;
import controller.WeatherAppController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *  This is the main class that will be runned
 *
 *
 * @author Gutu Bogdan
 */
public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }


    /**
     *
     * This is the function that will start the grafic application
     */
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader();
        primaryStage.setTitle("WeatherApp-Bogy");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/view/icon.png")));
        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherAppView.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}