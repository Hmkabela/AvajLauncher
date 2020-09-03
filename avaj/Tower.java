package avaj;
import java.util.*;
public abstract class Tower
{
    private List <Flyable> observers = new ArrayList<Flyable>();
    private boolean deregistered = false;
    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }
    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
        deregistered = true;
    }
    protected void conditionsChanged()
    {
        int i = 0;
        while(i < observers.size())
        {
            observers.get(i++).updateConditions();
            if(deregistered == true)
            {
                i--;
                deregistered = false;
            }
        }
    }

}
