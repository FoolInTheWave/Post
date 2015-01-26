package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a store.
 */
public class Store {

  private ProductCatalog catalog = new ProductCatalog();
  private Register register = new Register(catalog);

  /**
   * Returns the single Register instance of the Store.
   * 
   * @return
   */
  public Register getRegister() {
    return register;
  }

  /**
   * Adds a sale to the completed sales of the store.
   * 
   * @param s Sale instance to add.
   */
  public void addSale(Sale s) {
    // Add to the completed sale list
  }
  
}
