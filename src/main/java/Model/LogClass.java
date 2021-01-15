package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogClass {

    public LogClass() {
        try {
            File yourFile = new File("log.txt");
            yourFile.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void PrintInLogSearches(String country, String city)
    {

        try {
            String result = "Searched " + city + " in country: " + country+"\n";
            Files.write(Paths.get("log.txt"), result.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
    public void PrintInLogStart()
    {
        try {
            String result = "Application started...\n";
            Files.write(Paths.get("log.txt"), result.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
    public void PrintInLogResult(String weather, String imageCod, String temperature, String temperatureMax, String temperatureMin, String windSpeed)
    {
        try {
            String result = "Search successful\nResults: Weather "+weather+";Temperature "+temperature+";Minim Temperature "+ temperatureMin+";Maxim Temperature "+ temperatureMax +";Wind Speed " + windSpeed+";ImageCode "+imageCod+"\n";
            Files.write(Paths.get("log.txt"), result.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
}
