package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a cash register at a store.
 */
public class Register {

  private Sale sale;
  private ProductCatalog catalog;
  
  /**
   * Parameterized constructor creates a Register instance with a specified
   * ProductCatalog object.
   * 
   * @param catalog 
   */
  public Register(ProductCatalog catalog) {
    this.catalog = catalog;
    this.sale = new Sale();
  }

  /**
   * This method creates a new Sale object for the Register instance.
   */
  public void makeNewSale() {
    this.sale = new Sale();
  }

  /**
   * Returns the Sale object for the Register instance.
   * 
   * @return The Sale object for the Register instance.
   */
  public Sale getSale() {
    return this.sale;
  }
  
  /**
   * This method enters a ProductSpecification with a matching ID from the 
   * ProductCatalog and adds it to the Sale object in the Register instance.
   * 
   * @param id The ID of the ProductSpecification of the item.
   * @param quantity The amount of the item to add to the Sale.
   */
  public void enterItem(String id, int quantity) {
    ProductSpecification spec = catalog.getSpecification(id);
    sale.makeLineItem(spec, quantity);
  }

}
