import java.util.Scanner; 

public class ElevSim {
    
    
    public static void main(String[] args) throws InterruptedException {
        Scanner kb = new Scanner(System.in);
        int maxFloors = 10;
        Elevator elev = new Elevator(maxFloors);
        PassengerManager passengerManager= new PassengerManager(elev);
        Controller control = new DefaultController(elev);
        Passenger pass = new Passenger(elev, 0);
        
        System.out.println("Welcome to the Elevator Simulator.\n\nElevator is currently on: " + elev.getCurrentFloor());
        System.out.println("\nPassenger 1, which floor would you like to go?");
        int destination = kb.nextInt();
        pass.setDestinationFloor(destination);
        System.out.println("Passenger 1 is going to: " + destination);
        
        Passenger p1 = passengerManager.newPassenger();
       Passenger p2 = passengerManager.newPassenger();
        
        
        while(true)
        {
            passengerManager.next();
            control.next(); 
            System.out.println("\nElevator is currently on: " + elev.getCurrentFloor());
            
        }
   }
}
