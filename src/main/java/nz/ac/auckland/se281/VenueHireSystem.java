package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // fields
  private String[][] allVenues;
  private String[] venue;
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;
  private Integer numberOfVenues = 0;

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
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(allVenues[i][1], venueName);
          return;
        }
      }
    }

    // if venue name is empty, print error message
    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // write a error meesage condition for when the string capacityInput isnt a interger
    if (isInteger(capacityInput) == false) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity input", "");
      return;
    }

    if (Integer.parseInt(capacityInput) < 0) {
      // write error meesage for it being negative
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
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
