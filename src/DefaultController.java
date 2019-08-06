
import java.util.ArrayList;

public class DefaultController extends Controller
{
   private Timer time = new Timer(3000);
   private boolean leftMovingUp;
   private boolean leftMovingDown;
   private boolean leftRest;

   private boolean rightMovingUp;
   private boolean rightMovingDown;
   private boolean rightRest;
   
   public DefaultController(int numberOfFloors, int numberOfElevators)
   {
      super(numberOfFloors, numberOfElevators);
      
      super.elevators[1] = new Elevator(super.numberOfFloors - 1, super.numberOfFloors);
      
      leftMovingUp = false;
      leftMovingDown = false;
      leftRest = true;

      rightMovingUp = false;
      rightMovingDown = false;
      rightRest = true;
   }

   public void next()
   {
      Elevator leftElev = super.elevators[0];
      int leftCurrentFloor = leftElev.getCurrentFloor();
      boolean[] leftDestFloors = leftElev.getDestinationFloor();

      Elevator rightElev = super.elevators[1];
      int rightCurrentFloor = rightElev.getCurrentFloor();
      boolean[] rightDestFloors = rightElev.getDestinationFloor();

      if(super.pushTrue() == 0)
      {
         if(leftElev.hasDestFloors() == 0)
         {
            if(leftCurrentFloor > 1)
            {
               leftMovingDown = true;
               leftMovingUp = false;
            }
            else
            {
               leftMovingDown = false;
               leftMovingUp = false;
               leftRest = true;
            }
         }

         if(rightElev.hasDestFloors() == 0)
         {
            if(rightCurrentFloor < super.numberOfFloors)
            {
               rightMovingUp = true;
               rightMovingDown = false;
            }
            else 
            {
               rightMovingUp = false;
               rightMovingDown = false;
               rightRest = true;
            }
         }
      }
      else
      {
         int pushedUp = 0;
         int pushedDown = 0;
         
         for(int loop = 1; loop <= super.numberOfFloors; loop++)
         {
            if(super.pushedUp[loop])
               pushedUp++;

            if(super.pushedDown[loop])
               pushedDown++;
         }
         
         if(pushedUp > 0 && !rightMovingUp && !leftMovingUp)
         {
            leftMovingUp = true;
            leftMovingDown = false;
            leftRest = false;
         }

         if(pushedDown > 0 && !rightMovingDown && !leftMovingDown)
         {
            rightMovingDown = true;
            rightMovingUp = false;
            rightRest = false;
         }

      }
      

      if((leftMovingUp && pushedUp[leftCurrentFloor]) || (leftMovingDown && pushedDown[leftCurrentFloor]) || leftDestFloors[leftCurrentFloor])
      {
         leftElev.stop();
         
         if(leftMovingUp)
         {
            pushedUp[leftCurrentFloor] = false;
         }
         else if(leftMovingDown)
         {
            pushedDown[leftCurrentFloor] = false;
         }
      }
      else if(leftMovingUp)
      {
         leftElev.moveUp();
      }
      else if(leftMovingDown)
      {
         leftElev.moveDown();
      }

      if((rightMovingUp && pushedUp[rightCurrentFloor]) || (rightMovingDown && pushedDown[rightCurrentFloor]) || rightDestFloors[rightCurrentFloor])
      {
         rightElev.stop();

         if(rightMovingUp)
         {
            pushedUp[rightCurrentFloor] = false;
         }
         else if(rightMovingDown)
         {
            pushedDown[rightCurrentFloor] = false;
         }
      }
      else if(rightMovingUp)
      {
         rightElev.moveUp();
      }
      else if(rightMovingDown)
      {
         rightElev.moveDown();
      }

      time.run();

   }
  
}
