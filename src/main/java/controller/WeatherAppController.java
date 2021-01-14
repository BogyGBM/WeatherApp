package controller;

import Model.WeatherAppModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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
    private SplitPane splitPane;
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
    @FXML
    private Label labelTemperature;
    @FXML
    private Label labelWeather;
    @FXML
    private Label labelFrom;
    @FXML
    private Label labelTo;
    @FXML
    private Label labelWindSpeed;


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

    public void ClearLables()
    {
        labelTemperature.setText("");
        labelFrom.setText("");
        labelTo.setText("");
        labelWindSpeed.setText("");
        labelWeather.setText("");
        cityName.setText("");
        cityHighestTemperature.setText("");
        cityWindSpeed.setText("");
        cityLowestTemperature.setText("");
        cityTemperature.setText("");
        cityWeather.setText("");
    }

    public void WriteLables()
    {
        labelTemperature.setText("Temperature:");
        labelFrom.setText("From:");
        labelTo.setText("To:");
        labelWindSpeed.setText("Wind Speed:");
        labelWeather.setText("Weather:");
    }

    @FXML
    private void initialize() {
        ClearLables();
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
        ClearLables();
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
        ClearLables();

        String countryCode= new String();
        for(int i=0;i<weatherData.size();i++)
        {
            if(weatherData.get(i).getCountryName().equals(countryBox.getValue()))
            {
                countryCode=weatherData.get(i).getCountryCode();
            }
        }
        if(cityBox.getValue() != null) {
                WriteLables();
                String url1 = "http://api.openweathermap.org/data/2.5/weather?q=" + cityBox.getValue() + "," + countryCode + "&appid=07eabd997e8469117b037403a758455a&units=metric";
                //System.out.println(url1);
                URL url=null;
                try {
                    url = new URL(url1);
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
                URLConnection conn=null;
                BufferedReader reader=null;
                String json = null;
                try {
                   conn  = url.openConnection();
                   reader = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
                   json = org.apache.commons.io.IOUtils.toString(reader);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }


                String iconCode= "";
               // System.out.println(json);
                JsonArray items = Json.parse(json).asObject().get("weather").asArray();
                String weather = items.get(0).asObject().getString("main","Unknown");

                JsonObject main = Json.parse(json).asObject().get("main").asObject();
           // String temperature = items.get(0).asObject().getString("description", "Unknown Item");
           // String _capInfo=_info.substring(0,1).toUpperCase(Locale.ROOT)+_info.substring(1);
                JsonObject wind = Json.parse(json).asObject().get("wind").asObject();
                Double speed = wind.getDouble("speed", 0);
                Double temperature = main.getDouble("temp", 0);
                Double temperatureMin= main.getDouble("temp_min", 0);
                Double temperatureMax= main.getDouble("temp_max", 0);
                cityTemperature.setText(temperature.toString() + " °C");
                cityName.setText(cityBox.getValue());
                cityName.textAlignmentProperty();
                cityWeather.setText(weather);
                cityLowestTemperature.setText(temperatureMin.toString()+" °C");
                cityHighestTemperature.setText(temperatureMax.toString()+" °C");
                cityWindSpeed.setText(speed.toString()+" m/s");
        }
    }
}
