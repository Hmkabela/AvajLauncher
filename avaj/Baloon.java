package avaj;
public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates)
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
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "sun\'s out,smooth sailing all the way. Baloons wont crash");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "it's raining, be careful. Risky flying a baloon");
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "it\'s getting foggy, can you still see?. We need a windscreen");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                wtf.write_to_file(this.getClass().getSimpleName() + "#" +this.name +"("+this.id+"): " + "oh snap there\'s snow ahead, keep your eyes open, it wont help though.");
                break;
        }
        if(this.coordinates.getHeight() <= 0)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
            wtf.write_to_file("Tower says: Houston we have a problem ... "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "is preparing to land, how sad.");
            this.weatherTower.unregister(this);
            wtf.write_to_file("Tower says: "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "has landed safely and was unregistered.");
        }
        else if(this.coordinates.getHeight() >= 100)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
            wtf.write_to_file("Tower says: "+ this.getClass().getSimpleName() + "#" +this.name +"("+this.id+") " + "you are flying too high, keep it steady.");
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
