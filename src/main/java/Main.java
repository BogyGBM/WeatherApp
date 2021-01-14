import Model.WeatherAppModel;
import controller.WeatherAppController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }




    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader();
        primaryStage.setTitle("WeatherApp-Bogy");
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/view/icon.png")));
        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherAppView.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}