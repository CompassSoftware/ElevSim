import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Elevator {

    private int currentFloor;
    private boolean[] destinationFloor;
    private int numberOfFloors;
    private boolean[] pushedUp;
    private boolean[] pushedDown;
    private boolean stopped;
    Timer time = new Timer(3000);
    /**
     * Author: Elijah Smith
     * Issue #61 new Constructor
     */ 
    public Elevator(int numberOfFloors) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
        destinationFloor = new boolean[numberOfFloors+1];
        pushedUp = new boolean[numberOfFloors+1];
        pushedDown = new boolean[numberOfFloors+1];
    }
    /**
     * Author: Elijah Smith
     * Issue #18 Constructor
     */ 
    public Elevator(int currentFloor, int numberOfFloors) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        destinationFloor = new boolean[numberOfFloors+1];
        pushedUp = new boolean[numberOfFloors + 1];
        pushedDown = new boolean[numberOfFloors + 1];
    }

    /**
     * Author: Elijah Smith
     * Issue #57/51 moveDown()
     * @throws Exception 
     */
    public void moveDown() {
        time.run();
        currentFloor--;
        stopped = false;
    }
    
   /**
    * Author: Elijah Smith
    * Issue #57/51 moveUp
    */
    public void moveUp() {
        time.run();
        currentFloor++;
        stopped = false;
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

    public boolean pushTrue()
    {
        for(int loop = 0; loop < pushedUp.length; loop++)
        {
            if(pushedUp[loop] || pushedDown[loop])
               return true;
        }
        return false;
    }
    
    /**
     * Author: Elijah Smith
     * Issue #22 getter method
     */ 
      public boolean[] getPushedUp() {
        return this.pushedUp;
      }

      public boolean[] getPushedDown() {
        return this.pushedDown;
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

      /**
       * Author: Elijah Smith
       * Issue #67 pushedUp accessor
       */ 
      public boolean[] getPushedUpArray() {
        return this.pushedUp;
      }

      /**
       * Author: Elijah Smith
       * Issue #67 pushedDown accessor
       */ 
      public boolean[] getPushedDownArray() {
        return this.pushedDown;
      }
      public void stop() {
        this.stopped = true;
        destinationFloor[currentFloor] = false;
        pushedUp[currentFloor] = false;
        pushedDown[currentFloor] = false;
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
