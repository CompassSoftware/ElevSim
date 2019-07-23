/**
* Author: Matthew Frankel
* Issue 6
*/

import java.util.Random;
import java.util.ArrayList;

public class PassengerManager
{
    private ArrayList<Passenger> passengers;
    
    public Passenger newPassenger(int numFloors) 
    {
        Random rand = new Random();
        int start = rand.nextInt(numFloors); 
        int start += 1;
        int dest = rand.nextInt(numFloors);
        int dest += 1; 
        while (dest == start) 
        {
            dest = rand.nextInt(numFloors);
            dest += 1;
        }
        Passenger newPass = new Passenger(start, dest);
        return newPass;
    }
}
