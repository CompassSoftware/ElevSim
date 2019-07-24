import java.util.ArrayList;

/**
 * 
 */ 

public class Elevator {

    private int currentFloor;
    private int destinationFloor;
    private int numberOfFloors;
    ArrayList<Passenger> pushedUp = new ArrayList<Passenger>();
    ArrayList<Passenger> pushedDown = new ArrayList<Passenger>();

    
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
     * Issue #16 moveDown()
     */
    public void moveDown() {
        int decrementValue = this.currentFloor - this.destinationFloor;
        for(int i = 0; i < decrementValue; i++) {
            this.currentFloor--;
        }
    }
    
   /**
    * Author: Erik Burr
    * Issue #9 moveUp
    */
    public void moveUp(){
        int newCurrent = this.currentFloor - this.destinationFloor;
        for(int i = 0; i < newCurrent; i++) {
            while(this.currentFloor != this.destinationFloor) {
            this.currentFloor--;
         }
     }

	    
   /**
    * Author: Erik Burr
    * Issue #17 pushUp/pushDown
    *
    public void pushUp(){
    
    }
	    	    

    public void pushDown(){
    
    }
*/    
	    
    /**
     * Author: Elijah Smith
     * Issue #22 getter method
     */ 
    public int getCurrentFloor() {
        return this.currentFloor;
     }
	    
     /**
      * Author: Erik Burr
      * Issue #9 destinationFloor
      */
     public int getDestinationFloor() {
	  return this.destinationFloor;
      }
}


