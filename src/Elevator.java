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
        int newCurrent = this.currentFloor - this.destinationFloor;
        for(int i = 0; i < newCurrent; i++) {
            this.currentFloor--;
        }
    }

    /**
     * Author: Erik Burr
     * Issue #5 move()
     */
    public void move()
    	{ System.out.println("Current floor: " + currentFloor);  
    	if (destinationFloor > currentFloor) {
      	moveUp(); 
    	}
    	else {
      	moveDown();
    	}
    }

    /**
     * Author: Elijah Smith
     * Issue #22 getter method
     */ 
    public int getCurrentFloor() {
        return this.currentFloor;
    }
}


