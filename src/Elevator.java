/**
 * 
 */ 
public class Elevator {

    private int currentFloor;
    private int destinationFloor;
    private int numberOfFloors;
    
    /**
     * Author: Elijah Smith
     * Issue #18 Constructor
     */ 
    public Elevator(int currentFloor, int destinationFloor, int numberOfFloors) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * Author: Elijah Smith
     * Issue #57/51 moveDown()
     */
    public void moveDown() {
        currentFloor--;
    }
    
   /**
    * Author: Elijah Smith
    * Issue #57/51 moveUp
    */
    public void moveUp(){
        currentFloor++;        
    }
	
    /**
     * Author: Elijah Smith
     * Issue #22 getter method
     */ 
    public int getCurrentFloor() {
        return this.currentFloor;
     }
	    
     public int getDestinationFloor() {
	  return this.destinationFloor;
      }

      public int getNumberOfFloors() {
        return this.numberOfFloors;
      }

      public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
      }

      public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
      }

      public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
      }
}


