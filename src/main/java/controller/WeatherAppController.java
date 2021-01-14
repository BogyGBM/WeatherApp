package controller;

import Model.WeatherAppModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WeatherAppController {
    private ObservableList<WeatherAppModel> weatherData = FXCollections.observableArrayList();


    @FXML
    private Label cityName;
    @FXML
    private Label cityTemperature;
    @FXML
    private Label cityWeather;
    @FXML
    private Label cityLowestTemperature;
    @FXML
    private Label cityHighestTemperature;
    @FXML
    private Label cityWindSpeed;
    @FXML
    private ChoiceBox<String> countryBox;
    @FXML
    private ChoiceBox<String> cityBox;
    @FXML
    private ImageView weatherImage;

    public void InitializareData()
    {
        try {
            File myObj = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                String delims = "#";
                String[] tokens = data.split(delims);
                WeatherAppModel vreme= new WeatherAppModel(tokens[1], tokens[2], tokens[0]);
                weatherData.add(vreme);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    @FXML
    private void initialize() {
        InitializareData();
        ArrayList<String> countries = new ArrayList<>();
        for(int i=0;i<weatherData.size();i++) {
            if (!countries.contains(weatherData.get(i).getCountryName())) {
                countries.add(weatherData.get(i).getCountryName());
            }
        }
        countryBox.getItems().addAll(countries);

    }

    public void WriteCities(ActionEvent actionEvent) {
        cityBox.getItems().clear();
        String country = countryBox.getValue();
        ArrayList<String> cities = new ArrayList<>();
        for(int i=0;i<weatherData.size();i++) {

            if(weatherData.get(i).getCountryName().equals(country))
            {
                cities.add(weatherData.get(i).getCityName());
            }
        }
        cityBox.getItems().addAll(cities);
    }

    public void WriteDatas(ActionEvent actionEvent) {
        String countryCode= new String();
        for(int i=0;i<weatherData.size();i++) {
            if (weatherData.get(i).getCountryName().equals(countryBox.getValue())) {
                countryCode = weatherData.get(i).getCountryCode();
            }
        }
    }
}
