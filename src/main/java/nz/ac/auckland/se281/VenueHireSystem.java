package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // fields
  private String[][] allVenues;
  private String[] venue;
  private String[][] bookings;
  private String dateInput;
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;
  private Integer numberOfVenues = 0;
  private Integer numberOfBookings = 0;

  public VenueHireSystem() {}

  public void printVenues() {
    if (allVenues == null) {
      MessageCli.NO_VENUES.printMessage();
    }
    if (numberOfVenues != 0) {
      String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      if (numberOfVenues == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", numbers[numberOfVenues - 1], "");
      } else if (numberOfVenues < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", numbers[numberOfVenues - 1], "s");
      } else if (numberOfVenues >= 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(numberOfVenues), "s");
      }
      // create a for loop to print out all the venues
      for (int i = 0; i < numberOfVenues; i++) {
        MessageCli.VENUE_ENTRY.printMessage(
            allVenues[i][0], allVenues[i][1], allVenues[i][2], allVenues[i][3]);
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

    // put all the info into a array
    venue = new String[] {venueName, venueCode, capacityInput, hireFeeInput};

    // checking if the venue code already exists
    if (numberOfVenues >= 1) {
      for (int i = 0; i < numberOfVenues; i++) {
        if (allVenues[i][1].equals(venueCode) == true) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(allVenues[i][1], allVenues[0][i]);
          return;
        }
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

    // put the array in a array as the first element and continue increasing the number of venues
    // intialize allvenue array
    if (allVenues == null) {
      allVenues = new String[1][4];
    }
    // add one more row to the array
    else {
      String[][] temp = allVenues;
      allVenues = new String[numberOfVenues + 1][4];
      for (int i = 0; i < numberOfVenues; i++) {
        allVenues[i] = temp[i];
      }
    }
    // add the new info to the array
    for (int i = 0; i < venue.length; i++) {
      allVenues[numberOfVenues][i] = venue[i];
    }
    numberOfVenues++;

    // print success message
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
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
    // assign options in more understandable variables
    String venueCode = options[0];
    String partyDate = options[1];
    String customerEmail = options[2];
    String numberOfAttendees = options[3];

    // if dates are empty
    if (dateInput == null) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }
    // if venues are empty
    if (allVenues == null) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }
    // print error meesage for when the venue is already booked by comparing the codes in bookings
    for (int i = 0; i < numberOfBookings; i++) {
      if (bookings[i][2].equals(venueCode) && bookings[i][3].equals(partyDate)) {
        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(bookings[i][1], partyDate);
        return;
      }
    }

    // using BookingReferenceGenerator.generateBookingReference() to generate a booking reference
    String bookingReference = BookingReferenceGenerator.generateBookingReference();
    // find the venue name corresponding to the venue code given in options
    for (int i = 0; i < numberOfVenues; i++) {
      if (allVenues[i][1].equals(venueCode)) {
        venueName = allVenues[i][0];

        break;
      }
    }
    // put all the info into a array
    String[] booking =
        new String[] {bookingReference, venueName, venueCode, partyDate, numberOfAttendees};
    // add the new info to the bookings array
    if (bookings == null) {
      bookings = new String[1][5];
    }
    // add one more row to the array
    else {
      String[][] temp = bookings;
      bookings = new String[numberOfBookings + 1][5];
      for (int i = 0; i < numberOfBookings; i++) {
        bookings[i] = temp[i];
      }
    }
    // add the new info to the array
    for (int i = 0; i < booking.length; i++) {
      bookings[numberOfBookings][i] = booking[i];
    }
    numberOfBookings++;

    // succesfully created venue using MAKE_BOOKING_SUCCESSFUL meesage
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        bookingReference, venueName, partyDate, numberOfAttendees);
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
