package nz.ac.auckland.se281;

public abstract class Services {
  protected BookingsCreator currentBooking;

  public Services(BookingsCreator currentBooking) {
    this.currentBooking = currentBooking;
  }

  public abstract void addingServices();

  public abstract int getCost();

  public abstract String getName();
}
