public class Passenger
{
   private Elevator elev;

   private int startFloor;
   private int destinationFloor;
   
   private boolean waiting;
   private boolean riding;
   private boolean done;
   
   public Passenger(Elevator elev, int startFloor, int destinationFloor)
   {
      this.elev = elev;

      this.startFloor = startFloor;
      this.destinationFloor = destinationFloor;
      
      this.waiting = false;
      this.riding = false;
      this.done = false;
   }

   public Passenger(Elevator elev, int destinationFloor)
   {
      this.elev = elev;
      
      this.startFloor = 1;
      this.destinationFloor = destinationFloor;
      
      this.waiting = false;
      this.riding = false;
      this.done = false;
   }

   public void next()
   {
       if(!this.waiting)
       {
           if(this.destinationFloor > this.startFloor)
           {
               //This will change when Passenger starts using Controller not Elevator
               //elev.pushUp(this.startFloor);
                System.out.println("Passenger on floor " + startFloor + " pushed Up.");
           }
           else
           {    
                //This will change when Passenger starts using Controller not Elevator
               //elev.pushDown(this.startFloor);
               System.out.println("Passenger on floor " + startFloor + " pushed Down.");
           }
           this.waiting = true;
       }
       else if(waiting && !riding && elev.getStopped() && elev.getCurrentFloor() == startFloor)
       {
           System.out.println("Passenger boarded elevator and pushed floor " + destinationFloor + ".");
           elev.addDestinationFloor(destinationFloor);
           this.riding = true;
       }
       else if(elev.getStopped() && elev.getCurrentFloor() == destinationFloor)
       {
           System.out.println("Passenger got off.");
           this.done = true;
       }
   }

   public boolean getWaiting()
   {
       return this.waiting;
   }

   public int getStartFloor()
   {
      return this.startFloor;
   }

   public int getDestinationFloor()
   {
      return this.destinationFloor;
   }

   public void setStartFloor(int startFloor) 
   {
      this.startFloor = startFloor;
   }

   public void setDestinationFloor(int destinationFloor)
   {
       this.destinationFloor = destinationFloor;
   }
}
