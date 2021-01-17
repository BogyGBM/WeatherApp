package ro.mta.se.lab.controller.Model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import static org.mockito.Mockito.when;

public class WeatherAppModelTestMockito {
    String cityName;
    String countryName;
    String countryCode;

    private WeatherAppModel testModelMockito;
    @Before
    public void setUp() throws Exception {
        BufferedReader inputStreamReader=mock(BufferedReader.class);
        when(inputStreamReader.readLine()).thenReturn("Gaborone").thenReturn("Botswana").thenReturn("BW");

        testModelMockito=new WeatherAppModel(inputStreamReader.readLine(),inputStreamReader.readLine(),inputStreamReader.readLine());

        File myObj = new File("src/main/resources/input.txt");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        String delims = "#";
        String[] tokens = data.split(delims);
        cityName=tokens[1];
        countryName=tokens[2];
        countryCode=tokens[0];
    }

    @Test
    public void getCityName() {
        assertEquals(testModelMockito.getCityName(),cityName);
    }

    @Test
    public void getCountryName() {
        assertEquals(testModelMockito.getCountryName(),countryName);
    }

    @Test
    public void getCountryCode() {
        assertEquals(testModelMockito.getCountryCode(),countryCode);
    }
}