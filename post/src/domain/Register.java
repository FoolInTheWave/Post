package domain;

/**
 *
 * @author Caleb
 */
public class Register {

  private Sale sale;
  private ProductCatalog catalog;
  
  public Register(ProductCatalog catalog) {
    this.catalog = catalog;
    this.sale = new Sale();
  }

  public void makeNewSale() {
    sale = new Sale();
  }

  public Sale getSale() {
    return this.sale;
  }
  
  public void enterItem(String id, int quantity) {
    ProductSpecification spec = catalog.getSpecification(id);
    sale.makeLineItem(spec, quantity);
  }

}
