package domain;

import java.text.NumberFormat;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents an instance of currency.
 */
public class Money {
  
  double amount;
  
  /**
   * No argument constructor to create an empty Money object instance.
   */
  public Money() {
    
  }
  
  /**
   * Parameterized constructor to create a Money instance with a specified
   * amount.
   * 
   * @param amount The specified amount for the Money instance to store.
   */
  public Money(double amount) {
    this.amount = amount;
  }
  
  /**
   * Returns the amount stored in the Money object instance.
   * 
   * @return The amount stored in the Money instance.
   */
  public double getAmount() {
    return this.amount;
  }
  
  /**
   * This method adds the amount of the Money instance passed in the parameter 
   * to this instance.
   * 
   * @param newItemPrice The Money instance to add to this instance.
   * @return A Money instance representing the sum of this and the parameter
   * Money instances.
   */
  public Money add(Money newItemPrice) {
    return new Money(this.amount += newItemPrice.getAmount());
  }
  
  /**
   * This method subtracts the amount of the Money instance passed in the parameter 
   * from this instance.
   * 
   * @param newItemPrice The Money instance to subtract from this instance.
   * @return A Money instance representing the difference of this and the 
   * parameter Money instances.
   */
  public Money minus(Money newItemPrice) {
    return new Money(this.amount -= newItemPrice.getAmount());
  }
  
  /**
   * Overrides the Object toString method to produce a formatted currency string
   * of this Money instance.
   * 
   * @return A formatted string representing this Money instance.
   */
  @Override
  public String toString() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    return formatter.format(this.amount);
  }
}
