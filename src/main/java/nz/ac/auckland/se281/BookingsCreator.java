package nz.ac.auckland.se281;
import java.util.ArrayList;
public class BookingsCreator  {
   // make a array list for all booking objects for this particular venue
  private String venueCode;
  private String partyDate;
  private String customerEmail;
  private String numberOfAttendees;
  private String venueName;
  private String nextAvaiabledDate;
  private String refernce;
  private ArrayList<Services> bookingServices = new ArrayList<Services>();


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
    this.refernce = setBookingReference();

  }

  public String setBookingReference() {
    return BookingReferenceGenerator.generateBookingReference();
  }

  public String getBookingReference() {
    return this.refernce;
  }

  public String getVenueCode() {
    return this.venueCode;
  }

  public String getPartyDate() {
    return this.partyDate;
  }

  public String getCustomerEmail() {
    return this.customerEmail;
  }

  public String getNumberOfAttendees() {
    return this.numberOfAttendees;
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

  public ArrayList<Services> getBookingServices() {
    return bookingServices;
  }

  public void addServices(Services services) {
    bookingServices.add(services);
  }
}
