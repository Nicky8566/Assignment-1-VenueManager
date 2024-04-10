package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Services {
  private FloralType floralType;

  public Floral(BookingsCreator currentBooking, FloralType floralType) {
    super(currentBooking);
    this.floralType = floralType;
  }

  @Override
  public void addingServices() {
    currentBooking.addServices(this);
  }

  @Override
  public int getCost() {
    return floralType.getCost();
  }

  @Override
  public String getName() {
    return floralType.getName();
  }
}
