package domain;

/**
 *
 * @author Caleb
 */
public class ItemID {
    public String upc;
    
    public ItemID(String upc) {
      this.upc = upc;
    }
    
    public String getUpc() {
      return this.upc;
    }
}
