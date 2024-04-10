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
    }

    //

    // if a dateinput exists, print the venue entry with the date
    if (dateInput != null) {
      for (VenuesCreator venue : allVenues) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCapacity(),
            venue.getHireFee(),
            venue.nextDate(dateInput));
      }
    } else if (dateInput == null) {
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

    VenuesCreator newVenue =
        new VenuesCreator(venueName, venueCode, capacityInput, hireFeeInput, new ArrayList<>());
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

  public boolean isDateInThePast(String partyDate) {
    // splitting and grabbing the party date day, month and year
    String[] partyDateParts = partyDate.split("/");
    int partyDay = Integer.parseInt(partyDateParts[0]);
    int partyMonth = Integer.parseInt(partyDateParts[1]);
    int partyYear = Integer.parseInt(partyDateParts[2]);

    // splitting and grabbing the system date day, month and year
    String[] systemDateParts = dateInput.split("/");
    int systemDay = Integer.parseInt(systemDateParts[0]);
    int systemMonth = Integer.parseInt(systemDateParts[1]);
    int systemYear = Integer.parseInt(systemDateParts[2]);

    // check if the system date parts is bigger then party date parts
    if (partyYear < systemYear) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(partyDate, dateInput);
      return true;
    } else if (partyMonth < systemMonth) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(partyDate, dateInput);
      return true;
    } else if (partyDay < systemDay) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(partyDate, dateInput);
      return true;
    }
    return false;
  }

  public void makeBooking(String[] options) {
    // assign options to more readable variables
    String venueCode = options[0];
    String partyDate = options[1];
    String customerEmail = options[2];
    String attendees = options[3];
    VenuesCreator requiredVenue = null;

    ArrayList<BookingsCreator> requiredVenueBookings = new ArrayList<BookingsCreator>();

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

    // go through for loop for venues
    for (VenuesCreator venue : allVenues) {
      // if venue. get code is equal to given venue code
      if (venue.getCode().equals(venueCode)) {
        // if the date is less then the current date, print error message
        requiredVenue = venue;
        break;
      }
    }
    // check if the code exists
    if (requiredVenue == null) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(venueCode);
      return;

    } else {
      requiredVenueBookings = requiredVenue.getVenueBookings();
    }

    // if the booking is already made on that day for the venue code print error message
    for (BookingsCreator booking : requiredVenueBookings) {
      if (booking.getVenueCode().equals(venueCode) && booking.getPartyDate().equals(partyDate)) {
        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
            booking.getVenueName(), booking.getPartyDate());
        return;
      }
    }

    // check if date is in the past
    boolean datevalid = isDateInThePast(partyDate);
    if (datevalid) {
      return;
    }

    // if the number of attendes it less then a quater of the venue size, make the number of
    // attendees at least a quater of the venue size
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        if (Integer.parseInt(attendees) < Integer.parseInt(venue.getCapacity()) / 4) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              attendees,
              Integer.toString(Integer.parseInt(venue.getCapacity()) / 4),
              venue.getCapacity());
          attendees = Integer.toString(Integer.parseInt(venue.getCapacity()) / 4);
        }
      }
    }

    // if the number of attendees is greater then the venue capacity make the number of attendess
    // the max capcity
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        if (Integer.parseInt(attendees) > Integer.parseInt(venue.getCapacity())) {
          MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
              attendees, venue.getCapacity(), venue.getCapacity());
          attendees = venue.getCapacity();
        }
      }
    }

    // find the venue name corresponding to the given venue code
    String venueName = "";
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        venueName = venue.getName();
      }
    }

    // create a instance of a booking and put it in the array
    BookingsCreator newBooking =
        new BookingsCreator(venueName, venueCode, partyDate, customerEmail, attendees);
    allBookings.add(newBooking);
    requiredVenue.addBooking(newBooking);
    // print succesful created booking meesage
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        newBooking.getBookingReference(), venueName, partyDate, attendees);
  }

  public VenuesCreator getVenue(String venueCode) {
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        return venue;
      }
    }
    return null;
  }

  public void printBookings(String venueCode) {
    // if the venue code does not exist print error message
    boolean venueExists = false;
    VenuesCreator requiredVenue = null;
    ArrayList<BookingsCreator> requiredVenueBookings = new ArrayList<BookingsCreator>();

    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        venueExists = true;
        requiredVenue = venue;
        break;
      }
    }
    if (!venueExists) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    } else {
      requiredVenueBookings = requiredVenue.getVenueBookings();
    }
    if (requiredVenue.getVenueBookings().isEmpty()) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(requiredVenue.getName());
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(requiredVenue.getName());
      return;
    }

    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(requiredVenue.getName());
    // print all the venues in the venue array
    for (BookingsCreator booking : requiredVenueBookings) {
      MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
          booking.getBookingReference(), booking.getPartyDate());
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    String meesage = String.format("Catering (%s)", cateringType.getName());

    // if there are no bookings print error message
    if (allBookings.isEmpty()) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      return;
    }

    for (BookingsCreator booking : allBookings) {
      // look for the refernce in the bookings
      if (booking.getBookingReference().equals(bookingReference)) {
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(meesage, bookingReference);
        Catering newCatering = new Catering(booking, cateringType);
        newCatering.addingServices();
        return;
      } else {
        // else is the booking with the refernce is not found print error message
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
        return;
      }
    }
  }

  public void addServiceMusic(String bookingReference) {
    String meesage = String.format("Music");

    // if there are no bookings print error message
    if (allBookings.isEmpty()) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      return;
    }

    for (BookingsCreator booking : allBookings) {
      // look for the refernce in the bookings
      if (booking.getBookingReference().equals(bookingReference)) {
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(meesage, bookingReference);
        Music newMusic = new Music(booking);
        newMusic.addingServices();
        return;
      } else {
        // else is the booking with the refernce is not found print error message
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
        return;
      }
    }
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    String meesage = String.format("Floral (%s)", floralType.getName());

    // if there are no bookings print error message
    if (allBookings.isEmpty()) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      return;
    }

    for (BookingsCreator booking : allBookings) {
      // look for the refernce in the bookings
      if (booking.getBookingReference().equals(bookingReference)) {
        MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(meesage, bookingReference);
        FloralServices newFloral = new FloralServices(booking, floralType);
        newFloral.addingServices();
        return;
      } else {
        // else is the booking with the refernce is not found print error message
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
        return;
      }
    }
  }

  public void viewInvoice(String bookingReference) {
    BookingsCreator currentBooking = null;
    boolean bookingValid = false;

    // check if the refernces are equal
    for (BookingsCreator booking : allBookings) {
      if (booking.getBookingReference().equals(bookingReference)) {
        bookingValid = true;
        currentBooking = booking;
        break;
      }
    }

    if (bookingValid) {

      // grab all the info out
      String customerEmail = currentBooking.getCustomerEmail();
      String partyDate = currentBooking.getPartyDate();
      String numberOfAttendees = currentBooking.getNumberOfAttendees();
      String venueName = currentBooking.getVenueName();
      String venueCode = currentBooking.getVenueCode();
      int venueHireFee = Integer.parseInt(getVenue(venueCode).getHireFee());
      int cateringCost = 0;
      int musicCost = 0;
      int floralCost = 0;
      String cateringinfo = "";
      String floralInfo = "";
      for (Services service : currentBooking.getBookingServices()) {
        // check what instance the service is to determine the cost
        if (service instanceof Catering) {
          cateringCost += service.getCost();
          cateringinfo = service.getName();
        }
        if (service instanceof Music) {
          musicCost += service.getCost();
        }
        if (service instanceof FloralServices) {
          floralCost += service.getCost();
          floralInfo = service.getName();
        }
      }
      int totalCost = venueHireFee + cateringCost + musicCost + floralCost;

      // the huge invoice print statement
      MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(
          bookingReference, customerEmail, dateInput, partyDate, numberOfAttendees, venueName);
      MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(Integer.toString(venueHireFee));
      MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(
          cateringinfo, Integer.toString(cateringCost));
      MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(Integer.toString(musicCost));
      MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(
          floralInfo, Integer.toString(floralCost));
      MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(Integer.toString(totalCost));
    }

    // if the booking is not valid print error message
    else if (bookingValid == false) {
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
    }
  }
}
