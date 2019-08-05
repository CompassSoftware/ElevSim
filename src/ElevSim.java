import java.util.Scanner; 

public class ElevSim 
{    
    
    public static void main(String[] args) 
    {
      
        Controller control = new DefaultController(10, 2);
        PassengerManager passengerManager = new PassengerManager(control); 
        Display disp = new Display(passengerManager, control);

        Passenger pass = new Passenger(control, 0);
        Passenger p1 = passengerManager.newPassenger();
        Passenger p2 = passengerManager.newPassenger();
        
        Elevator[] elevs = control.getElevators();
        
        while(true)
        {
            passengerManager.next();
            control.next(); 
            disp.display();
        }
   }
}
