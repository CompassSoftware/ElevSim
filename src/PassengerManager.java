/**
* Author: Matthew Frankel
* Issue 6
*/

import java.util.Random;
import java.util.ArrayList;

public class PassengerManager
{
    private Elevator elevator;    
    private ArrayList<Passenger> passengers;
    
    public PassengerManager(Elevator elevator)
    {
       this.elevator = elevator;
       this.passenger = new ArrayList<Passenger>();
    }
    
    public Passenger newPassenger(int numFloors) 
    {
        Random rand = new Random();
        int start = rand.nextInt(numFloors) + 1;
        int dest = rand.nextInt(numFloors) + 1;
        
        while (dest == start) 
        {
            dest = rand.nextInt(numFloors) + 1;
        }

        Passenger newPass = new Passenger(start, dest);
        passengers.add(newPass);
        
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
