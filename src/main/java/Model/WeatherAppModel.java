package Model;

import javafx.beans.property.StringProperty;

public class WeatherAppModel {
    String cityName;
    String countryName;
    String countryCode;

    public WeatherAppModel(String cityName, String countryName, String countryCode) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
