package nz.ac.auckland.se281;

public class BookingsCreator extends VenueHireSystem {
  private String venueCode;
  private String partyDate;
  private String customerEmail;
  private String numberOfAttendees;
  private String venueName;

  public BookingsCreator(String[] options) {
    // assign options in more understandable variables
    String venueCode = options[0];
    String partyDate = options[1];
    String customerEmail = options[2];
    String numberOfAttendees = options[3];
  }

  // set up getters
  public String getVenueCode() {
    return venueCode;
  }

  public String getPartyDate() {
    return partyDate;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public String getNumberOfAttendees() {
    return numberOfAttendees;
  }

  public String getReference() {
    String bookingReference = BookingReferenceGenerator.generateBookingReference();
    return bookingReference;
  }

  // look for the venue code in the all venues array and return the name its corresponds to
  public String getVenueName() {
    for (VenuesCreator venue : allVenues) {
      if (venue.getCode().equals(venueCode)) {
        return venue.getName();
      }
    }
    return null;
  }
}
