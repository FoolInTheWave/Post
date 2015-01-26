package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a product sold at a store.
 */
public class ProductSpecification {

  private ItemID id;
  private Money price;
  private String description;

  /**
   * Parameterized constructor creates a ProductSpecification instance based on
   * the ItemID, Money, and String (description) objects passed in the
   * parameter.
   * 
   * @param id
   * @param price
   * @param description 
   */
  public ProductSpecification(ItemID id, Money price, String description) {
    this.id = id;
    this.price = price;
    this.description = description;
  }

  /**
   * Returns the UPC of the ProductSpecification instance.
   * 
   * @return The UPC of the ProductSpecification instance as a String.
   */
  public String getUPC() {
    return this.id.getUpc();
  }

  /**
   * Returns the price of the ProductSpecification instance as a Money object.
   * 
   * @return The price of the ProductSpecification instance as a Money object.
   */
  public Money getPrice() {
    return price;
  }

  /**
   * Returns the description of the ProductSpecification instance as a String.
   * 
   * @return The description of the ProductSpecification.
   */
  public String getDescription() {
    return description;
  }
  
}
