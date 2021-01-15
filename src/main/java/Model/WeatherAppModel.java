package Model;

import javafx.beans.property.StringProperty;

/**
 * This is the Class that contains the datas for our application
 */
public class WeatherAppModel {
    String cityName;
    String countryName;
    String countryCode;

    /**
     * This is the constructor
     * @param cityName - The name of the city form the input file
     * @param countryName - Tha name of the country from the input file
     * @param countryCode - The code of the country from the input file
     */
    public WeatherAppModel(String cityName, String countryName, String countryCode) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    /**
     *
     * @return the Name of the city
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @return the Name of the country
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     *
     * @return the country Code
     */
    public String getCountryCode() {
        return countryCode;
    }

}
