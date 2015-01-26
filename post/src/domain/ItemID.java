package domain;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 10/23/2015
 * 
 * This class represents a UPC for an item in a store.
 */
public class ItemID {
  
    public String upc;
    
    /**
     * Parameterized constructor creates an ItemID instance with a specified
     * UPC.
     * 
     * @param upc The specified UPC for the ItemID to store.
     */
    public ItemID(String upc) {
      this.upc = upc;
    }
    
    /**
     * Returns the UPC stored by the ItemID instance.
     * 
     * @return The UPC stored by the ItemID instance.
     */
    public String getUpc() {
      return this.upc;
    }
}
