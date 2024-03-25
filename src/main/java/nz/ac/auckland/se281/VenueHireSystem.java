package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // fields
  private String[][] AllVenues;
  private String[] Venue;
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
    if (NumberOfVenues != 0) {
      String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      if (NumberOfVenues == 1) {
        MessageCli.NUMBER_VENUES.printMessage("is", numbers[NumberOfVenues - 1], "");
      } else if (NumberOfVenues < 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", numbers[NumberOfVenues - 1], "s");
      } else if (NumberOfVenues >= 10) {
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(NumberOfVenues), "s");
      }
      // create a for loop to print out all the venues
      for (int i = 0; i < NumberOfVenues; i++) {
        MessageCli.VENUE_ENTRY.printMessage(
            AllVenues[i][0], AllVenues[i][1], AllVenues[i][2], AllVenues[i][3]);
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
    Venue = new String[] {venueName, venueCode, capacityInput, hireFeeInput};

    // checking if the venue code already exists
    if (NumberOfVenues >= 1) {
      for (int i = 0; i < NumberOfVenues; i++) {
        if (AllVenues[i][1].equals(venueCode) == true) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(AllVenues[i][1], venueName);
          return;
        }
      }
    }

    // if venue name is empty, print error message
    if (venueName.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // if venue code is empty, print error message
    if (venueCode.isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_CODE_IS_EMPTY.printMessage();
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
    if (AllVenues == null) {
      AllVenues = new String[1][4];
    }
    // add one more row to the array
    else {
      String[][] temp = AllVenues;
      AllVenues = new String[NumberOfVenues + 1][4];
      for (int i = 0; i < NumberOfVenues; i++) {
        AllVenues[i] = temp[i];
      }
    }
    // add the new info to the array
    for (int i = 0; i < Venue.length; i++) {
      AllVenues[NumberOfVenues][i] = Venue[i];
    }
    NumberOfVenues++;

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
