public class Elevator {

    private int currentFloor;
    private boolean[] destinationFloor;
    private int numberOfFloors;
    private boolean stopped;
    Elevator elev = new Elevator(10);
    Controller control = new DefaultController(elev);
    Passenger pass = new Passenger(elev, 0);
    Timer time = new Timer(3000);
    /**
     * Author: Elijah Smith
     * Issue #61 new Constructor
     */ 
    public Elevator(int numberOfFloors) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
        this.destinationFloor = new boolean[numberOfFloors+1];
        this.stopped = true;
    }

    /**
     * Author: Elijah Smith
     * Issue #18 Constructor
     */ 
    public Elevator(int currentFloor, int numberOfFloors) {
        this.currentFloor = currentFloor;
        this.numberOfFloors = numberOfFloors;
        this.destinationFloor = new boolean[numberOfFloors+1];
        this.stopped = true;
    }

    /**
     * Author: Elijah Smith
     * Issue #57/51 moveDown()
     * @throws Exception 
     */
    public void moveDown() {
        time.run();
        currentFloor--;
        this.stopped = false;
    }
    
   /**
    * Author: Elijah Smith
    * Issue #57/51 moveUp
    */
    public void moveUp() {
        time.run();
        currentFloor++;
        this.stopped = false;
    }
    
    /**
    * Author: Erik Burr
    * Issue #17 pushUp/pushDown
    */
    public void pushUp(int currentFloor){
        pushedUp[currentFloor] = true;   
    }
             
    public void pushDown(int currentFloor){
        pushedDown[currentFloor] = true;  
    }

    public int pushTrue()
    {
        int counter = 0;
        for(int loop = 0; loop < pushedUp.length; loop++)
        {
            if(pushedUp[loop] || pushedDown[loop])
               counter++;
        }
        return counter;
    }

    public int hasDestFloors()
    {
        int count = 0;
        for(int loop = 0; loop < destinationFloor.length; loop++)
        {
            if(destinationFloor[loop])
               count++;
        }
        return count;
    }

      public int getCurrentFloor() {
        return this.currentFloor;
      }

      public void addDestinationFloor(int currentFloor) {
          destinationFloor[currentFloor] = true;
      }
  
      public boolean[] getDestinationFloor() {
        return this.destinationFloor;
      }
      
      public int getNumberOfFloors() {
        return this.numberOfFloors;
      }

      public void stop() {
        this.stopped = true;
        destinationFloor[currentFloor] = false;
      }

      public boolean getStopped() {
        return this.stopped;
      }

      public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
      }


      public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
      }
}
