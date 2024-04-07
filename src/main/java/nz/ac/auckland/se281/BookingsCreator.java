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
    this.nextAvaiabledDate = nextDate(partyDate);
    for (BookingsCreator booking : allBookings) {
      if (booking.getVenueCode().equals(venueCode)) {
        this.nextAvaiabledDate = booking.nextDate(booking.getPartyDate());
      }
    }
  }

  public String getBookingReference() {
    return BookingReferenceGenerator.generateBookingReference();
  }

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

  public String getVenueName() {
    return venueName;
  }

  public String getNextAvaiableDate() {
    return nextAvaiabledDate;
  }

  // make a setter for getting next current date
  public String nextDate(String partyDate) {

    String[] dateParts = partyDate.split("/");
    String day = dateParts[0];
    String month = dateParts[1];
    String year = dateParts[2];
    // if the day is less then 31, increment the day by 1
    if (Integer.parseInt(day) < 31) {
      day = Integer.toString(Integer.parseInt(day) + 1);
    }
    // if the day is 31, increment the month by 1 and set the day to 1
    else if (Integer.parseInt(day) == 31) {
      day = "1";
      month = Integer.toString(Integer.parseInt(month) + 1);
    }
    // if the month is 13, increment the year by 1 and set the month to 1
    if (Integer.parseInt(month) == 13) {
      month = "1";
      year = Integer.toString(Integer.parseInt(year) + 1);
    }
    // set the new date
    String nextAvaiabledDate = day + "/" + month + "/" + year;
    return nextAvaiabledDate;
  }
}
