import static org.junit.Assert.*;
import org.junit.Test;

//brought in from TimerTest.java
interface TimerClient {
   public void timerCallback();
}

public class Tests implements TimerClient
{
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testMoveDown() {
        Elevator elevator = new Elevator(5, 5);
        elevator.moveDown();
        int newCurrent = elevator.getCurrentFloor();
        assertEquals(4, newCurrent);      
   }
   
   /**
    * Author: Erik Burr
    *
    */
   @Test
   public void testMoveUp() {
        Elevator elev = new Elevator(1, 5);
        elev.moveUp();
        int newCurrent = elev.getCurrentFloor();
        assertEquals(2, newCurrent);
   }
   
  
    //simple values needed for Timer
    double numSeconds = 4.5;
    double pollDelay = 0.25;
    int numPolls = 0; 
    int numExpectedPolls = (int)(numSeconds / pollDelay) - 1; // last poll will work!
    boolean timerExpired = false;
    boolean state = false;
    //method needed for TimerClient
    public void timerCallback() {
          timerExpired = true;
   }   
    
    /**
     * Author: Elijah Smith
     */ 
    public void runPollTest() {
            pollDelay *= 1000;
            System.out.println("Testing using poll method:");
            System.out.println("\tTest will sleep for " 
                        + pollDelay + "ms then poll timer to see if expired.");
            System.out.println("\tEach poll will print a dot.");

            System.out.println("\tCreating " + numSeconds + " second timer...");        
            Timer t = new Timer((int)(numSeconds*1000));

            System.out.println("\tStarting timer...");
            System.out.print("\t");
            t.start();

            while(true)
            {
                try
                {
                    Thread.sleep((int)pollDelay);
                    
                }
                catch(Exception e)
                {
                }

                if(!t.expired())
                {
                    numPolls++;
                    System.out.print(".");
                }
                else
                {
                    break;
                }
            }
            System.out.println();
            System.out.println("\tNumber of polls was " + numPolls);    
            System.out.println("\tNumber of expected polls was " + numExpectedPolls);   
            if (numExpectedPolls == numPolls) {
                System.out.println("Poll Test PASSED!");
                assertEquals(numExpectedPolls, numPolls);
            }
            else if (numExpectedPolls-1 <= numPolls && numPolls <= numExpectedPolls+1) { 
                System.out.println("Poll Test PASSED! (small timing variance between threads is allowed)");
                state = true; 
                assertTrue(state);
            }
            else {   
                System.out.println("Poll Test FAILED!");
                assertTrue(state);
            }
        }
    
    /**
     * Author: Elijah Smith
     * test brought from TimerTest.java
     */ 
    /*
    @Test
    public void runInterruptTest() {
            numPolls = 0;
            System.out.println("Testing using interrupt method:");
            System.out.println("\tTest will sleep for " 
                        + pollDelay + "ms and then awake and print a dot.");
            System.out.println("\tWhen timer expires it will interrupt causing sleeping to stop.");

            System.out.println("\tCreating " + numSeconds + " second timer...");        
            Timer t = new Timer((int)(numSeconds*1000), this); // pass object with callback method

            System.out.println("\tStarting timer...");
            System.out.print("\t");
            t.start();

            while(! timerExpired)
            {
                try
                {
                   Thread.sleep((int)pollDelay);
                    
                }
                catch(Exception e)
                {
                }

                numPolls++;
                System.out.print(".");
            }
            System.out.println();
            System.out.println("\tNumber of sleeps was " + numPolls);   
            System.out.println("\tNumber of expected sleeps was " + numExpectedPolls);  
       
            if (numExpectedPolls == numPolls) {
                System.out.println("Interrupt Test PASSED!");
                assertEquals(numExpectedPolls, numPolls);
            }
            else if (numExpectedPolls-1 <= numPolls && numPolls <= numExpectedPolls+1) {
                System.out.println("Interrupt Test PASSED! (small timing variance between threads is allowed)"); 
                state = true;
                assertTrue(state);
            }
            else { 
                state = false;
                System.out.println("Interrupt Test FAILED!");
                assertTrue(state);   
            }
    }
    */
     
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testCurrentFloor() {
        int currentFloor = 60;
        int totalFloors = 600;
        Elevator elevator = new Elevator(currentFloor, totalFloors);

        assertEquals(60, elevator.getCurrentFloor());
   }

    @Test
    public void testElevatorConstructor1() {
        Elevator elev = new Elevator(100);

        assertEquals(1, elev.getCurrentFloor());
        assertEquals(100, elev.getNumberOfFloors());
    }

    /**
     * Author: Elijah Smith
     */ 
    @Test
    public void testElevatorConstructor2() {
        Elevator elev = new Elevator(2, 100);

        assertEquals(2, elev.getCurrentFloor());
        assertEquals(100, elev.getNumberOfFloors());

    }

/* needs to change
 @Test
   public void testPassengerNext1()
   {
      Elevator elev = new Elevator(1, 10);
      Passenger pass = new Passenger(elev, 7);

      pass.next();

      assertEquals(true, elev.pushTrue());      
   }
*/  
     @Test 
   public void testdisplay1()
   {
      Elevator[] elevators = new Elevator[2];
      elevators[0] = new Elevator(1, 10);
      PassengerManager passman = new PassengerManager(elevators);
      Display disp = new Display(passman, elevators[0]);
      disp.goingUp();
      disp.goingDown();

      assertEquals(Display.current, 1);
   }
   

   @Test 
   public void testdisplay2()
   {
      Elevator[] elevators = new Elevator[2];
      elevators[0] = new Elevator(1, 10);
      PassengerManager passman = new PassengerManager(elevators);
      Display disp = new Display(passman, elevators[0]);
      disp.goingUp();
      disp.goingUp();
      disp.goingUp();
      disp.goingUp();
      disp.goingUp();
      
      assertEquals(Display.current, 6);
   }
   
   @Test
   public void testHasDestFloor()
   {
      Elevator elev = new Elevator(1, 10);
      
      assertEquals(0, elev.hasDestFloors());
      
      elev.addDestinationFloor(7);
      
      assertEquals(1, elev.hasDestFloors());  
   }


   @Test
   public void testpushTrue()
   {
      Elevator[] elevators = new Elevator[2];
      DefaultController control = new DefaultController(elevators);
      assertEquals(0, control.pushTrue());   
   }


/* needs to change  
   @Test
   public void testDefaultController1()
   {
      Elevator[] elevators = new Elevator[2];
      elevators[0] = new Elevator(1, 10);
      DefaultController control = new DefaultController(elevators[0]);

      elev.pushUp(5);
      control.next();

      assertEquals(2, elev.getCurrentFloor());
   }
*/   
}
