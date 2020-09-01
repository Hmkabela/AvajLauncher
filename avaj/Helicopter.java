package avaj;
public class Helicopter  extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    @Override
    public void updateConditions()
    {
        String cw = weatherTower.getWeather(this.coordinates);
        WTF wtf = new WTF();
        switch(cw)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "sun\'s out,smooth sailing all the way. Fly Chopper Fly");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "it's raining, be careful.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 12);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "it\'s getting foggy, can you still see?.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "oh snap there\'s snow ahead, keep your eyes open. Dont let the rotor freeze");
                break;
        }
        if(this.coordinates.getHeight() == 0)
        {
            wtf.write_to_file("Tower says: Houston we have a problem ... "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "is preparing to land, how sad.");
            this.weatherTower.unregister(this);
            wtf.write_to_file("Tower says: "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "has landed safely.");
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WTF wtf = new WTF();
        wtf.write_to_file("Tower says: "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "registered to weather tower.");
    }
}
