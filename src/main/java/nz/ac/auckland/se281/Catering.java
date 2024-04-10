package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Services {
  private CateringType cateringType;

  public Catering(BookingsCreator currentBooking, CateringType cateringType) {
    super(currentBooking);
    this.cateringType = cateringType;
  }

  @Override
  public void addingServices() {
    currentBooking.addServices(this);
  }

  @Override
  public int getCost() {
    return cateringType.getCostPerPerson()
        * Integer.parseInt(currentBooking.getNumberOfAttendees());
  }

  @Override
  public String getName() {
    return cateringType.getName();
  }
}
