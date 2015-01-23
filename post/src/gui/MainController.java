package gui;

import domain.Store;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MainController {

  @FXML
  private Parent root;
  @FXML
  private BorderPane contentArea;
  
  private ProcessSaleController processSaleController;
  private Store store;
  
  public MainController() {
    
  }

  public Parent getView() {
    return root;
  }
  
  public void showProcessSale() {
    contentArea.setCenter(processSaleController.getView());
  }
  
  public void setProcessSaleController() {
    this.processSaleController = loadController("/gui/ProcessSale.fxml");
    this.processSaleController.setRegister(store.getRegister());
  }
  
  public void setStore(Store store) {
    this.store = store;
  }
  
  @SuppressWarnings("unchecked")
  public <T> T loadController(String fxmlFile) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.load(getClass().getResourceAsStream(fxmlFile));
      return (T) loader.getController();
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Unable to load FXML file '%s'", fxmlFile), e
      );
    }
  }
      
}
