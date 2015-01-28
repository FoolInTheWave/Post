package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a sale in a store.
 */
public class Sale {

  private List<SalesLineItem> saleLineItems = new ArrayList<>();
  private boolean isComplete = false;
  private Date date = new Date();
  private Payment payment;

  /**
   * This method adds a SalesLineItem to the saleLineItems collection in the
   * Sale instance.
   * 
   * @param spec ProductSpecification of the SalesLineItem.
   * @param quantity Number of the SalesLineItem to add.
   */
  public void makeLineItem(ProductSpecification spec, int quantity) {
    saleLineItems.add(new SalesLineItem(spec, quantity));
  }

  /**
   * This method marks the Sale as complete and creates a new saleLineItems 
   * list.
   */
  public void becomeComplete() {
    this.isComplete = true;
  }
  
  /**
   * This method checks whether or not a Sale instance is complete.
   * 
   * @return Boolean value indicating whether or not the Sale instance is 
   * complete.
   */
  public boolean isComplete() {
    return isComplete;
  }

  /**
   * This method gets the total price of the Sale instance  as a Money object.
   * 
   * @return The total price of the Sale instance.
   */
  public Money getTotal() {
    Money total = new Money();
    
    Iterator it = saleLineItems.iterator();
    while (it.hasNext()) {
      SalesLineItem sli = (SalesLineItem) it.next();
      total.add(sli.getSubtotal());
    }
    
    return total;
  }

  /**
   * This method applies a payment to the total balance of the Sale instance.
   * 
   * @param cashTendered Payment instance made by the customer.
   */
  public void makePayment(Money cashTendered) {
    payment = new Payment(cashTendered);
  }

  /**
   * Returns the current balance of the Sale instance.
   * 
   * @return The current balance of the Sale instance as a Money object.
   */
  public Money getBalance() {
    return payment.getAmount().minus(getTotal());
  }
  
  /**
   * Returns the last SalesLineItem object in the salesLineItem list.
   * 
   * @return SalesLineItem object.
   */
  public SalesLineItem getLastItem() {
    return saleLineItems.get(saleLineItems.size() - 1);
  }
  
  /**
   * Sets the date attribute for this Sale instance.
   * 
   * @param date 
   */
  public void setDate(Date date) {
    this.date = date;
  }
  
  /**
   * Clears the saleLineItems ArrayList for this Sale instance.
   */
  public void clearSaleLineItems() {
    saleLineItems = new ArrayList<>();
  }

}
