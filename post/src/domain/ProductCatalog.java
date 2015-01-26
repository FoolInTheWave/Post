package domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class represents a product catalog for a store. Products specifications
 * are read from a delimited file and stored in a HashMap.
 */
public class ProductCatalog {

  private Map<String, ProductSpecification> productSpecs = new HashMap<>();

  /**
   * Default constructor reads ProductSpecification objects from a delimited
   * file and stores each object in a HashMap.
   */
  public ProductCatalog() {
    ProductSpecification spec;
    String [] tokens;

    String path = new File("src/items.txt").getAbsolutePath();
    
    try {
      for (String line : Files.readAllLines(Paths.get(path))) {
        tokens = line.split(";");
        spec = new ProductSpecification(
            new ItemID(tokens[0]),
            new Money(Double.valueOf(tokens[1])),
            tokens[2]
        );
        productSpecs.put(spec.getUPC(), spec);
      }
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  /**
   * This method returns a ProductSpecification instance from the HashMap using
   * the given ID in the parameter.
   * 
   * @param id The HashMap ID of the ProductSpecification instance.
   * @return The ProductSpecification instance.
   */
  public ProductSpecification getSpecification(String id) {
    return (ProductSpecification) productSpecs.get(id);
  }

}
