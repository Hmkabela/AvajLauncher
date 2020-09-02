package avaj;
import java.util.Random;
public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"SUN","RAIN","FOG", "SNOW"};
    private WeatherProvider()
    {
    }
    public static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
        Random r = new Random();
        return weather[r.nextInt(4)];
    }
}
