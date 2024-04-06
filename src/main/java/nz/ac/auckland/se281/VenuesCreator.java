package nz.ac.auckland.se281;

public class VenuesCreator extends VenueHireSystem {
  private String name;
  private String code;
  private String capacity;
  private String hireFee;

  public VenuesCreator(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.name = venueName;
    this.code = venueCode;
    this.capacity = capacityInput;
    this.hireFee = hireFeeInput;
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
}
