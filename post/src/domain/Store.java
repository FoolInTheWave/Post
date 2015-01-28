package domain;

import java.util.ArrayList;

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
  private ArrayList<Sale> sales = new ArrayList<>();

  /**
   * Returns the single Register instance of the Store.
   * 
   * @return register Instance of register class currently being used.
   */
  public Register getRegister() {
    return this.register;
  }

  /**
   * Adds a sale to the completed sales of the store.
   * 
   * @param s Sale instance to add.
   */
  public void addSale(Sale s) {
    this.sales.add(s);
  }
  
}
