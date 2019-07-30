import java.util.Random;
import java.util.ArrayList;

public class PassengerManager
{
    private Elevator elevator;    
    private ArrayList<Passenger> passengers;
    
    public PassengerManager(Elevator elevator)
    {
       this.elevator = elevator;
       this.passengers = new ArrayList<Passenger>();
    }
    
    public Passenger newPassenger() 
    {
        Random rand = new Random();
        int start = rand.nextInt(elevator.getNumberOfFloors) + 1;
        int dest = rand.nextInt(elevator.getNumberOfFloors) + 1;
        
        while (dest == start) 
        {
            dest = rand.nextInt(elevator.getNumberOfFloors) + 1;
        }

        Passenger newPass = new Passenger(elevator, start, dest);
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
