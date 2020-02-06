import java.util.Random;
import java.util.ArrayList;

public class PassengerManager
{
    private ArrayList<Passenger> passengers;
    private Controller control;
    
    public PassengerManager(Controller control)
    {
       this.control = control;
       this.passengers = new ArrayList<Passenger>();
    }
    
    public Passenger newPassenger() 
    {
        Random rand = new Random();
        int start = rand.nextInt(control.getNumberOfFloors()) + 1;
        int dest = rand.nextInt(control.getNumberOfFloors()) + 1;
        
        while (dest == start) 
        {
            dest = rand.nextInt(control.getNumberOfFloors()) + 1;
        }

        Passenger newPass = new Passenger(control, start, dest);
        passengers.add(newPass);
        
        return newPass;
    }

    
    public Passenger newPassenger(int startFloor, int destFloor)
    {
        Passenger newPass = new Passenger(control, startFloor, destFloor);
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
    
    public ArrayList<Passenger> getPassengers()
    {
        return passengers;
    } 
}
