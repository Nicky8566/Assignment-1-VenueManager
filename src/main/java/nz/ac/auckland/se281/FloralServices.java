package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class FloralServices extends Services {
  private FloralType floralType;

  public FloralServices(BookingsCreator currentBooking, FloralType floralType) {
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
