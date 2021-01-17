package ro.mta.se.lab.controller.Model;

import java.io.File;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
public class WeatherAppModelTest {

    String cityName;
    String countryName;
    String countryCode;
    WeatherAppModel model;
    @org.junit.Before
    public void setUp() throws Exception {
        cityName="Gaborone";
        countryCode="BW";
        countryName="Botswana";
        File myObj = new File("src/main/resources/input.txt");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        String delims = "#";
        String[] tokens = data.split(delims);
        model= new WeatherAppModel(tokens[1], tokens[2], tokens[0]);

    }

    @org.junit.Test
    public void getCityName() {
        assertEquals(model.getCityName(),cityName);
    }

    @org.junit.Test
    public void getCountryName() {
        assertEquals(model.getCountryName(),countryName);
    }

    @org.junit.Test
    public void getCountryCode() {
        assertEquals(model.getCountryCode(),countryCode);
    }

}