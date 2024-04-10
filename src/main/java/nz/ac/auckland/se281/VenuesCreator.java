package nz.ac.auckland.se281;

import java.util.ArrayList;

public class VenuesCreator  {
  private String name;
  private String code;
  private String capacity;
  private String hireFee;
  // make a array list for all booking objects for this particular venue
  private ArrayList<BookingsCreator> venueBookings = new ArrayList<>();

  public VenuesCreator(
      String venueName,
      String venueCode,
      String capacityInput,
      String hireFeeInput,
      ArrayList<BookingsCreator> allBookings) {
    this.name = venueName;
    this.code = venueCode;
    this.capacity = capacityInput;
    this.hireFee = hireFeeInput;
    this.venueBookings = venueBookings;
  }

  public void addBooking(BookingsCreator booking) {
    venueBookings.add(booking);
  }

  public ArrayList<BookingsCreator> getVenueBookings() {
    return venueBookings;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public String getCapacity() {
    return capacity;
  }

  public String getHireFee() {
    return hireFee;
  }

  // make a setter for getting next current date
  public String nextDate(String systemDate) {

    String[] dateParts = systemDate.split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);

    if (venueBookings.isEmpty()) {
      return systemDate;
    } else {
      while (true) {
        boolean isAvailable = true;
        // make a for loop through booking instances
        for (BookingsCreator booking : venueBookings) {
          String[] partyDateParts = booking.getPartyDate().split("/");
          int partyDay = Integer.parseInt(partyDateParts[0]);
          int partyMonth = Integer.parseInt(partyDateParts[1]);
          int partyYear = Integer.parseInt(partyDateParts[2]);
          if (partyDay == day && partyMonth == month && partyYear == year) {
            isAvailable = false;
            break;
          }
        }
        if (isAvailable) {
          return String.format("%02d/%02d/%d", day, month, year);
        }

        // if the day is less then 31, increment the day by 1
        if ((day) < 31) {
          day++;
        }
        // if the day is 31, increment the month by 1 and set the day to 1
        if ((day) == 31) {
          day = 01;
          month++;
        }
        // if the month is 13, increment the year by 1 and set the month to 1
        if ((month) == 13) {
          month = 01;
          year++;
        }
        if (day == Integer.parseInt(dateParts[0])
            && month == Integer.parseInt(dateParts[1])
            && year == Integer.parseInt(dateParts[2])) {
          return "not dates avaible";
        }
      }
    }
  }
}
