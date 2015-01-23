package domain;

/**
 *
 * @author Caleb
 */
public class SalesLineItem {

  private ProductSpecification spec;
  private int quant;

  public SalesLineItem(ProductSpecification s, int q) {
    spec = s;
    quant = q;
  }

  public Money getSubtotal() {    
    return new Money(spec.getPrice().getAmount() * quant);
  }

}
