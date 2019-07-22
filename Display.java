/*
 *
 *Author Jake Wooten
 * Iusse #7
 * */

public class Display {

Elevator elevator;
Passenger passenger;

    public Display(Passenger passenger, Elevator elevator) {
       
        this.passenger = passenger;
        this.elevator = elevator;
    }
    /*
     *Displays floor passenger is currently on
     */
    public void display_currentP (Passenger passenger) {
        
        System.out.println("Passenger is on floor " + passenger.getStartFloor());
    }
    
    /*
     *Displays the floor the passenger has selected
     */
    public void display_selectP (Passenger passenger) {
      
        System.out.println("Passenger has selected floor " + passenger.getDestinationFloor());
    }
    
    /*
     *Displays the floor the passenger has arrived at
     */
    public void display_destP (Passenger passenger) {

        System.out.printlnP("Passenger has arrived at floor " + passenger.getDestinationFloor());
    }
    
    /*
     *Displays the floor the elevator leaves from
     */
    public void display_currentE (Elevator elevator) {
       
        System.out.println("Elevator doors close\nElevator leaves from floor " + elevator.getCurrentFloor());
    }

    /*
     *Displays the floor the elevator has arrived at
     */
    public void display_destE (Elevator elevator) {
    
        System.out.println("Elevator doors open\nEleavtor arrives at floor " + elevator.getDestinationFloor());
    }



}
