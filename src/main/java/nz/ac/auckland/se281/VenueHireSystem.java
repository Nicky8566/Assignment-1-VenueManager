package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  //fields
  private Object[] AllVenues;
  private Object[] Venue;
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;
  private Integer NumberOfVenues = 0;

  public VenueHireSystem() {}

  public void printVenues() {
    if (AllVenues == null) {
      MessageCli.NO_VENUES.printMessage();
    }

  
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
      // if venue name is empty, print error message
    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }
    else {
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
