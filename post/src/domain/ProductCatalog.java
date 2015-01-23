package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Caleb
 */
public class ProductCatalog {

  private Map<Integer, ProductSpecification> productSpecs = new HashMap<>();

  public ProductCatalog() {
    String [] tokens;
    ProductSpecification spec;
    
    try {
      for (String line : Files.readAllLines(Paths.get("items.txt"))) {
        tokens = line.split(";");
        spec = new ProductSpecification(
            new ItemID(tokens[1]),
            new Money(Double.valueOf(tokens[2])),
            tokens[3]
        );
        productSpecs.put(Integer.valueOf(tokens[0]), spec);
      }
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  public ProductSpecification getSpecification(int id) {
    return (ProductSpecification) productSpecs.get(id);
  }

}
