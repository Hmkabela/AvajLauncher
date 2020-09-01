package avaj;

import java.io.*;

public class WTF {
    public void create() {
        File nf = new File("Simulation.txt");
        try {
            nf.delete();
            nf.createNewFile();
        } catch (Exception e) {
            System.out.println("Theres an error with creating the log");
        }
    }

    public void write_to_file(String s)
    {
        try 
        {
            FileWriter w = new FileWriter("Simulation.txt", true);
            w.write(s + "\n");
            w.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}