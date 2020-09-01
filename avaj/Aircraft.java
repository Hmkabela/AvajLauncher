package avaj;

public abstract class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextID();
    }
    private long nextID()
    {
        idCounter++;
        return idCounter;
    }
}
