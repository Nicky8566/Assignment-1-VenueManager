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

    // test 
    MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
    MessageCli.VENUE_ENTRY.printMessage("'Frugal Fiesta Hall'", "FFH", "80", "150");
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
        // add venu name 
        this.venueName = venueName;
        this.venueCode = venueCode;
        this.capacityInput = capacityInput;
        this.hireFeeInput = hireFeeInput;
        // add venue info to the venue array
        this.Venue[0] = venueName;
        this.Venue[1] = venueCode;
        this.Venue[2] = capacityInput;
        this.Venue[3] = hireFeeInput;
        // put venue in allvenues array
        this.AllVenues[this.NumberOfVenues] = Venue;
        // increment number of venues
        this.NumberOfVenues++;

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
