package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a single item in a sale.
 */
public class SalesLineItem {

  private ProductSpecification spec;
  private int quant;

  /**
   * Parameterized constructor creates a SalesLineItem instance with a
   * specified ProductSpecification and quantity.
   * 
   * @param s The ProductSpecification the instance will represent.
   * @param q  The number of the product to add to the sale.
   */
  public SalesLineItem(ProductSpecification s, int q) {
    spec = s;
    quant = q;
  }

  /**
   * Returns the total price of the SalesLineItem, taking quantity into
   * consideration.
   * 
   * @return Money object.
   */
  public Money getSubtotal() {    
    return new Money(spec.getPrice().getAmount() * quant);
  }

  /**
   * Returns the details of the SalesLineItem in a String array, the indexes of
   * the array hold the following data:
   * [0]: Item description
   * [1]: Quantity
   * [2]: Subtotal
   * 
   * @return String array representing the details of the SalesLineItem instance.
   */
  public String [] getDetails() {
    String [] details = {
      spec.getDescription(),
      String.valueOf(quant),
      String.valueOf(getSubtotal().getAmount())
    };
    
    return details;
  }
  
}
