public class Passenger
{
   private Controller control;

   private int startFloor;
   private int destinationFloor;
   private int ridingElev;

   private boolean waiting;
   private boolean riding;
   private boolean done;
   
   public Passenger(Controller control, int startFloor, int destinationFloor)
   {
      this.control = control;

      this.startFloor = startFloor;
      this.destinationFloor = destinationFloor;
      this.ridingElev = -1;

      this.waiting = false;
      this.riding = false;
      this.done = false;
   }

   public Passenger(Controller control, int destinationFloor)
   {
      this.control = control;
      
      this.startFloor = 1;
      this.destinationFloor = destinationFloor;
      this.ridingElev = -1;

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
               control.pushUp(this.startFloor);
           }
           else
           {    
               control.pushDown(this.startFloor);
           }
           this.waiting = true;
       }
       else
       {
           Elevator[] elevators = control.getElevators();
           for(int loop = 0; loop < elevators.length; loop++)
           {
               Elevator elev = elevators[loop];
               if(!riding && elev.getStopped() && elev.getCurrentFloor() == startFloor)
               {
                  elev.addDestinationFloor(destinationFloor);
                  this.riding = true;
                  this.ridingElev = loop;

                  break;
               }
               else if(loop == ridingElev && elev.getStopped() && elev.getCurrentFloor() == destinationFloor)
               {
                  this.done = true;
                  break;
               }
           }
       }
   }

   public boolean getWaiting()
   {
       return this.waiting;
   }

   public boolean getRiding()
   {
      return this.riding;
   }

   public int getRidingElev()
   {
      return this.ridingElev;
   }

   public boolean getDone()
   {
      return this.done;
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
