package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Caleb
 */
public class Sale {

  private List<SalesLineItem> saleLineItems = new ArrayList<>();
  private boolean isComplete = false;
  private Date date = new Date();
  private Payment payment;

  public void makeLineItem(ProductSpecification spec, int quantity) {
    saleLineItems.add(new SalesLineItem(spec, quantity));
  }

  public void becomeComplete() {
    isComplete = true;
    saleLineItems = new ArrayList<>();
  }
  
  public boolean isComplete() {
    return isComplete;
  }

  public Money getTotal() {
    Money total = new Money();
    Iterator it = saleLineItems.iterator();
    while (it.hasNext()) {
      SalesLineItem sli = (SalesLineItem) it.next();
      total.add(sli.getSubtotal());
    }
    return total;
  }

  public void makePayment(Money cashTendered) {
    payment = new Payment(cashTendered);
  }

  public Money getBalance() {
    return payment.getAmount().minus(getTotal());
  }
  
  public SalesLineItem getLastItem() {
    return saleLineItems.get(saleLineItems.size() - 1);
  }

}
