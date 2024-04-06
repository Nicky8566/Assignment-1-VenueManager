package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  protected ArrayList<VenuesCreator> allVenues = new ArrayList<VenuesCreator>();
  protected ArrayList<BookingsCreator> allBookings = new ArrayList<BookingsCreator>();
  protected String dateInput;

  public VenueHireSystem() {
    allVenues = new ArrayList<>();
    allBookings = new ArrayList<>();
  }

  public void printVenues() {
    // if theres no venues in all venues print error meesages
    if (allVenues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    }
    // if all venues does have a venue then print the number of venues
    if (!allVenues.isEmpty()) {
      String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      if (allVenues.size() == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", numbers[allVenues.size() - 1], "");
      } else if (allVenues.size() < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", numbers[allVenues.size() - 1], "s");
      } else if (allVenues.size() >= 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(allVenues.size()), "s");
      }
      // create a for loop to print out all the venues dont worry about date
      for (VenuesCreator venue : allVenues) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(), venue.getCode(), venue.getCapacity(), venue.getHireFee());
      }
    }
  }

  public boolean isInteger(String s) {
    try {
      // converts string to integer, if so return true, otherwise
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      // if it fails, return false
      return false;
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // check if the venue code already exists
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue.getName());
        return;
      }
    }
    // if venue name is empty, print error message
    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // write a error meesage fow when capcity input is not a whole number
    if (capacityInput.contains(".")) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " whole");
      return;
    }

    // write a error meesage condition for when the string capacityInput isnt a interger
    if (isInteger(capacityInput) == false) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }

    if (Integer.parseInt(capacityInput) < 0) {
      // write error meesage for it being negative
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      return;
    }

    // write a error meesage fow when hire fee input is not a whole number
    if (hireFeeInput.contains(".")) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " whole");
      return;
    }

    // write a error meesage condition for when the string hireFeeinput isnt a interger
    if (isInteger(hireFeeInput) == false) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    if (Integer.parseInt(hireFeeInput) < 0) {
      // write error meesage for it being negative
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      return;
    }

    VenuesCreator newVenue = new VenuesCreator(venueName, venueCode, capacityInput, hireFeeInput);
    // print succesfully created venue meesage
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    allVenues.add(newVenue);
  }

  public void setSystemDate(String dateInput) {
    MessageCli.DATE_SET.printMessage(dateInput);
    this.dateInput = dateInput;
  }

  public void printSystemDate() {
    // make a if statement for when dateinut is not set
    if (dateInput != null) {
      MessageCli.CURRENT_DATE.printMessage(dateInput);
    } else {
      MessageCli.CURRENT_DATE.printMessage("not set");
    }
  }

  public void makeBooking(String[] options) {
    // booking not made assign the date first
    if (dateInput == null) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }
    // booking not made if there are no venues
    if (allVenues.isEmpty()) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }
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
