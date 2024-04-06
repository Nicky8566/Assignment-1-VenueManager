package nz.ac.auckland.se281;

public class BookingsCreator extends VenueHireSystem {
  private String venueCode;
  private String partyDate;
  private String customerEmail;
  private String numberOfAttendees;
  private String venueName;

  public BookingsCreator(
      String venueName,
      String venueCode,
      String partyDate,
      String customerEmail,
      String numberOfAttendees) {
    this.venueCode = venueCode;
    this.partyDate = partyDate;
    this.customerEmail = customerEmail;
    this.numberOfAttendees = numberOfAttendees;
    this.venueName = venueName;
  }

  public String getBookingReference() {
    return BookingReferenceGenerator.generateBookingReference();
  }
}
