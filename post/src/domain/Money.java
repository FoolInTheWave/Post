package domain;

/**
 *
 * @author Caleb
 */
public class Money {
  
  double amount;
  
  public Money() {
    
  }
  
  public Money(double amount) {
    this.amount = amount;
  }
  
  public double getAmount() {
    return this.amount;
  }
  
  public Money add(Money newItemPrice) {
    return new Money(this.amount += newItemPrice.getAmount());
  }
  
  public Money minus(Money newItemPrice) {
    return new Money(this.amount -= newItemPrice.getAmount());
  }
  
}
