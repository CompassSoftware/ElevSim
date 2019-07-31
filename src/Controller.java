public abstract class Controller
{
   protected Elevator[] elevators;
   protected boolean[] pushedUp;
   protected boolean[] pushedDown;
   
   /**
    * Editor: Elijah Smith
    * initialized size of new pushed fields.
    */  
   protected Controller(Elevator[] elevators)
   {
      this.elevators = elevators;
      pushedUp = new boolean[elevators[0].getNumberOfFloors() + 1];
      pushedDown = new boolean[elevators[0].getNumberOfFloors() +1];
   }

   public abstract void next();
    
    /**
     * Editor: Elijah Smith
     * Issue #108 moving this method from Elevator
     */ 
    public void pushUp(int currentFloor) {
        pushedUp[currentFloor] = true;    
    }

    /**
     * Editor: Elijah Smith
     * Issue #108 moving this method from Elevator
     */ 
    public void pushDown(int currentFloor) {
        pushedDown[currentFloor] = true;
    }

    /**
     * Editor: Elijah Smith
     * Issue #108 moving this method from Elevator
     */ 
    public boolean pushTrue() {
        for(int loop = 0; loop < pushedUp.length; loop++) {
            if(pushedUp[loop] || pushedDown[loop])
                return true;
        }
        return false;
    }
}
