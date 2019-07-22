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
    * Author Erik Burr
    * Issue #11 Current floor
    */
    private int floorDifference(int floorA, int floorB){
        if( floorA < floorB ){
            return (floorB - floorA);
	}
	else{
	return (floorA - floorB);
    	}
    }

    /**
     * Author: Elijah Smith
     * Issue #22 getter method
     */ 
    public int getCurrentFloor() {
        return this.currentFloor;
     }
	    
     /**
      * Author: Erik Burr
      * Issue #9 moveUp
      */
     public int getDestinationFloor() {
	  return this.destinationFloor;
      }

}


