package avaj;

public abstract class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates co = new Coordinates(longitude, latitude, height);
        if(type != null)
        {
            switch(type)
            {
                case "Baloon":
                    Baloon b = new Baloon(name, co);
                    return b;
                case "Helicopter":
                    Helicopter h = new Helicopter(name, co);
                    return h;
                case "JetPlane" :
                    JetPlane jp = new JetPlane(name, co);
                    return jp;
            }
        }
        return null;
    }
}
