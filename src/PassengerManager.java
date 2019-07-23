/**
* Author: Matthew Frankel
* Issue 6
*/

import java.util.Random;
import java.util.ArrayList;

public class PassengerManager
{
    private ArrayList<Passenger> passengers;
    
    public Passenger newPassenger() 
    {
        Random rand = new Random();
        int start = rand.nextInt(100); 
        int start += 1;
        int dest = rand.nextInt(100);
        int dest += 1; 
        while (dest == start) 
        {
            dest = rand.nextInt(100);
            dest += 1;
        }
        Passenger newPass = new Passenger(start, dest);
        return newPass;
    }
}
