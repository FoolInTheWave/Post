package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a form of payment submitted by a customer.
 */
public class Payment {

  private Money amount;

  /**
   * Parameterized constructor creates a Payment instance with a specified
   * Money object.
   * 
   * @param cashTendered 
   */
  public Payment(Money cashTendered) {
    amount = cashTendered;
  }

  /**
   * Returns the amount of this Payment instance as a Money object.
   * 
   * @return The amount of this Payment instance as a Money object.
   */
  public Money getAmount() {
    return amount;
  }
}
