import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Elevator {

    private int currentFloor;
    private ArrayList<Integer> destinationFloor;
    private int numberOfFloors;
    private boolean[] pushedUp;
    private boolean[] pushedDown;
    private boolean stopped;
    private Timer timerDelay;

    /**
     * Author: Elijah Smith
     * Issue #61 new Constructor
     */ 
    public Elevator(int numberOfFloors) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfFloors;
        this.destinationFloor = new ArrayList<>();
        pushedUp = new boolean[numberOfFloors+1];
        pushedDown = new boolean[numberOfFloors+1];
        //elevator time delay
        timerDelay = new Timer(3000);
    }
    /**
     * Author: Elijah Smith
     * Issue #18 Constructor
     */ 
    public Elevator(int currentFloor, int numberOfFloors) {
        this.currentFloor = currentFloor;
        this.destinationFloor = new ArrayList<Integer>();
        this.numberOfFloors = numberOfFloors;
        pushedUp = new boolean[numberOfFloors];
        pushedDown = new boolean[numberOfFloors];
        //elevator time delay
        timerDelay = new Timer(3000);
    }

    /**
     * Author: Elijah Smith
     * Issue #57/51 moveDown()
     * @throws Exception 
     */
    public void moveDown() {
        currentFloor--;
        stopped = false;
        //idk if this works
        t.run();
        t.expired();
    }
   /**
    * Author: Elijah Smith
    * Issue #57/51 moveUp
    */
    public void moveUp() {
        currentFloor++;
        stopped = false;
        //idk if this works
        t.run();
        t.expired();    
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

      public void addDestinationFloor(int df) {
        destinationFloor.add(df);
      }
  
      public ArrayList<Integer> getDestinationFloor() {
        return this.destinationFloor;
      }
      
      public int getNumberOfFloors() {
        return this.numberOfFloors;
      }

      public void stop() {
        this.stopped = true;
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
