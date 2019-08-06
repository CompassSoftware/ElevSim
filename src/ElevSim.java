import java.util.Scanner; 

public class ElevSim 
{    
    
    public static void main(String[] args) 
    {
      
        Controller control = new DefaultController(10, 2);
        PassengerManager passengerManager = new PassengerManager(control); 
        Display disp = new Display(passengerManager, control);

        Passenger p1 = passengerManager.newPassenger(5, 8);
        Passenger p2 = passengerManager.newPassenger(7, 2);
        
        while(true)
        {
            passengerManager.next();
            control.next(); 
            disp.display();
        }
   }
}
