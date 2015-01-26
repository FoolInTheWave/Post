package gui;

import domain.Store;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

  @FXML
  private Parent root;
  @FXML
  private BorderPane contentArea;
  @FXML
  private ImageView logoView;
  
  private ProcessSaleController processSaleController;
  private PaymentController paymentController;
  
  private Image logo;
  private Store store;
  
  public MainController() {
    
  }

  public Parent getView() {
    return root;
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    logo = new Image(new File("src/Moe.gif").toURI().toString());
    logoView.setImage(logo);
  }
  
  public void showProcessSale() {
    processSaleController.resetView();
    contentArea.setCenter(processSaleController.getView());
  }
  
  public void showPayment() {
    this.paymentController.setAmountDueField(String.valueOf(
        processSaleController.getRegister().getSale().getTotal().toString()
    ));
    this.paymentController.setSale(
        processSaleController.getRegister().getSale()
    );
    paymentController.resetView();
    contentArea.setCenter(paymentController.getView());
  }
  
  public void setProcessSaleController() {
    this.processSaleController = loadController("/gui/ProcessSale.fxml");
    this.processSaleController.setMainController(this);
    this.processSaleController.setRegister(store.getRegister());
  }
  
  public void setPaymentController() {
    this.paymentController = loadController("/gui/Payment.fxml");
    this.paymentController.setMainController(this);
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
