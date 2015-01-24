package domain;

import java.io.File;
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

  private Map<String, ProductSpecification> productSpecs = new HashMap<>();

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

  public ProductSpecification getSpecification(String id) {
    return (ProductSpecification) productSpecs.get(id);
  }

}
