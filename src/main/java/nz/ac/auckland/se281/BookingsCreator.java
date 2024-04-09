package nz.ac.auckland.se281;

public class BookingsCreator extends VenueHireSystem {
  private String venueCode;
  private String partyDate;
  private String customerEmail;
  private String numberOfAttendees;
  private String venueName;
  private String nextAvaiabledDate;

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

  public String getVenueCode() {
    return venueCode;
  }

  public String getPartyDate() {
    return this.partyDate;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public String getNumberOfAttendees() {
    return numberOfAttendees;
  }

  public String getVenueName() {
    return venueName;
  }

  public String getNextAvaiableDate() {
    return this.nextAvaiabledDate;
  }

  // make a setter for getting next current date
  public void setNextAviableDate(String partyDate) {
    this.nextAvaiabledDate = partyDate;
  }

  public void setPartyDate(String partyDate) {
    this.partyDate = partyDate;
  }
}
