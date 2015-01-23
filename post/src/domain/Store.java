package domain;

/**
 *
 * @author Caleb
 */
public class Store {

  private ProductCatalog catalog = new ProductCatalog();
  private Register register = new Register(catalog);

  public Register getRegister() {
    return register;
  }

  public void addSale(Sale s) {
    // Add to the completed sale list
  }
  
}
