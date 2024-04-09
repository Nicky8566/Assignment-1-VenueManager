package nz.ac.auckland.se281;


public class Music extends Services {


  public Music(BookingsCreator currentBooking) {
    super(currentBooking);
  }


  @Override
  public void addingServices(){
    currentBooking.addServices(this);
  }
  @Override
  public int getCost(){
    return 500;

  }
  @Override
  public String getName(){
    return "Music";

  }
  
 
}
