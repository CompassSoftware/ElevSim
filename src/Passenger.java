public class Passenger
{
   private int startFloor;
   private int destinationFloor;
   private boolean waiting;
   Elevator elev;
   public Passenger(Elevator elev, int startFloor, int destinationFloor)
   {
      this.elev = elev;
      this.startFloor = startFloor;
      this.destinationFloor = destinationFloor;
      this.waiting = false;
   }

   public Passenger(Elevator elev, int destinationFloor)
   {
      this.elev = elev;
      this.waiting = false;
      this.startFloor = 1;
      this.destinationFloor = destinationFloor;
   }

   public void next()
   {
       if(!this.waiting)
       {
           if(this.destinationFloor > elev.getCurrentFloor())
           {
               elev.pushUp(this.startFloor);
           }
           else
           {
               elev.pushDown(this.startFloor);
           }
           this.waiting = true;
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
