public abstract class Controller
{
   protected Elevator elevator;

   protected Controller(Elevator elevator)
   {
      this.elevator = elevator;
   }

   public abstract void next();
}
