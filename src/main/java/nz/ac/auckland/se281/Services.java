package nz.ac.auckland.se281;

public abstract class Services {
  private BookingsCreator currentBooking;

  public Services(BookingsCreator currentBooking) {
    this.currentBooking = currentBooking;
  }

  public abstract void addingServices();

  public abstract void getCost();

  public abstract void getName();
}
