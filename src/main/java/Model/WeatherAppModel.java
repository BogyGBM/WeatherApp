package Model;

import javafx.beans.property.StringProperty;

public class WeatherAppModel {
    String cityName;
    String countryName;
    String countryCode;
    Integer idCity;
    Integer latitude;
    Integer longitude;

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

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
