package avaj;
import java.io.*;
import java.util.*;
public class Simulator {

    public static void main(String[] args)
    {
        if(args.length == 1)
        {
            try
            {
                int i = 1;
                int times;
                List<String> data = new ArrayList<>();
                File fn = new File(args[0]);
                Scanner sc = new Scanner(fn);
                WTF wtf = new WTF();
                wtf.create();
                while (sc.hasNextLine())
                {
                    data.add(sc.nextLine());
                }
                sc.close();
                String udata[][] = new String[data.size()][6];
                times = Integer.parseInt(data.get(0));
                validate(data, i, udata,times);
                WeatherTower wt = new WeatherTower();
                i = 0;
                while(i < udata.length - 1)
                {
                    AircraftFactory.newAircraft(udata[i][0], udata[i][1], Integer.parseInt(udata[0][3]), Integer.parseInt(udata[i][4]), Integer.parseInt(udata[i][5])).registerTower(wt);
                    i++;
                }
                while(times > 0)
                {
                    wt.changeWeather();
                    times--;
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else
            System.out.println("Too many or little arguments");
    }
    public static void validate(List<String> data, int i, String udata[][],int t)
    {
        try
        {
            if(t < 0)
            {
                System.out.println("The number of weather changes can not be less than 0");
                System.exit(0);
            }
            int n = 0;
            while (i < data.size())
            {
                String arr[] = data.get(i).split(" ",data.size());
                udata[i - 1][0] = arr[0];
                udata[i - 1][1] = arr[1];
                udata[i- 1][2] = Integer.toString(i);
                udata[i - 1][3] = arr[2];
                udata[i - 1][4] = arr[3];
                udata[i - 1][5] = arr[4];
                if(Integer.parseInt(udata[i - 1][3]) < 1 || Integer.parseInt(udata[i - 1][4]) < 1 || Integer.parseInt(udata[i - 1][5]) < 1)
                {
                    System.out.print("Coordinates cannot equal or less than zero!!!!\n");
                    System.exit(1);
                }
                i++;
            }
            while (n < data.size() - 1)
            {
                try
                {
                    if(!((udata[n][0].equals("Baloon") && udata[n][1].charAt(0) == 'B')
                            || (udata[n][0].equals("JetPlane") && udata[n][1].charAt(0) == 'J')
                            || (udata[n][0].equals("Helicopter") && udata[n][0].charAt(0) == 'H')))
                    {
                        System.out.println("False That wont work, the scenarios are invalid!!!");
                        System.exit(0);
                    }
                    Integer.parseInt(udata[n][3]);
                    Integer.parseInt(udata[n][4]);
                    Integer.parseInt(udata[n][5]);
                }
                catch(Exception e)
                {
                    System.out.println("That wont work, the scenarios are invalid!!!");
                }
                n++;
            }
        }
        catch(Exception e)
        {
            System.out.println("That wont work, the scenarios are invalid!!!");
        }
    }
}
