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
        start++;
        int dest = rand.nextInt(numFloors);
        dest++; 
        while (dest == start) 
        {
            dest = rand.nextInt(numFloors);
            dest++;
        }
        Passenger newPass = new Passenger(start, dest);
        return newPass;
    }
    
    public void next()
    {
        for (int i = 0; i < passengers.size(); i++)
        {
           passengers.get(i).next(); 
        }
    }
}
