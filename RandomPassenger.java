/**
* Author: Matthew Frankel
* Issue 6
*/

import java.util.Random;

public class RandomPassenger 
{
    public Passenger randPass() 
    {
        Random rand = new Random();
        int s = rand.nextInt(100); 
        int s += 1;
        int d = rand.nextInt(100);
        int d += 1; 
        while (d == s) 
        {
            d = rand.nextInt(100);
            d += 1;
        }
        Passenger randPass = new Passenger(s, d);
        return randPass;
    }
}
