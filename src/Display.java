import java.util.ArrayList;

public class Display 
{
   private PassengerManager passengerManager;
   private Controller control;

   public Display(PassengerManager passengerManager, Controller control) 
   {   
       this.passengerManager = passengerManager;
       this.control = control;

       start();
   }
   
   public void display()
   { 
      System.out.println("=============================================================");
      
      ArrayList<Passenger> passengers = passengerManager.getPassengers();
      for(int loop = 0; loop < elevators.size(); loop++)
      {
         Passenger passenger = passengers.get(loop);
         printPassenger(loop, passenger);
      }
      
      System.out.println("=============================================================");
      
      Elevator[] elevators = control.getElevators();
      for(int loop = 0; loop < elevators.length; loop++)
      {
         printElevator(loop, elevators[loop]);
         System.out.println("=============================================================");
      }

      System.out.println("=============================================================\n\n");
   }
   
   public void start()
   {
       System.out.println("Welcome to our Elevator Simulation:\n  (Enter Ctrl+C to exit simulation) \n\n\n");
   }

   public void printPassenger(int number, Passenger passenger)
   {
         if(passenger.getWaiting()
         {
            System.out.print("Passenger " + loop + " is on Floor " + passenger.getStartFloor());
            
            if(passenger.getStartFloor() > passenger.getDestinationFloor())
            {
               System.out.println(" waiting to go down.");
            }
            else
            {
               System.out.println(" waiting to go up.");
            }
         }
   }

   public void printElevator(int number, Elevator elevator)
   {
      if(elevator.getStopped())
      {
         System.out.println("Elevator " + number + " has stopped on Floor " + elevator.getCurrentFloor());
         System.out.println("Elevator doors have opened.");

         ArrayList<Passenger> passengers = passengerManager.getPassengers();
         for(int loop = 0; loop < passengerManager.size(); loop++)
         {
            Passenger passenger = passengers.get(loop);

            if(elevator.getCurrentFloor() == passenger.getStartFloor() && passenger.getRiding())
            {
               System.out.println("Passenger " + loop + " has boarded the elevator.");
            }
            else if(elevator.getCurrentFloor() == passenger.getDestinationFloor() && passenger.getDone())
            {
               System.out.println("Passenger " + loop + " has left the elevator.");
            }

         }
      }
      else
      {
         System.out.println("Elevator " + number + " is on Floor " + elevator.getCurrentFloor());
      }
   }
}
