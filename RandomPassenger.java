/**
* Author: Matthew Frankel
* Issue 6
*/

import java.util.Random;

public class RandomPassenger 
{
    public void createPassenger() 
    {
        Random rand = new Random();
        int s = rand.nextInt(5); 
        int s += 1;
        int d = rand.nextInt(5);
        int d += 1; 
        while (d == s) 
        {
            d = rand.nextInt(5);
            d += 1;
        }
    Passenger randPass = new Passenger(s, d);
    }
}
