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

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class implements the main controller in charge of running the program.
 */
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
  
  /**
   * No argument constructor to create an empty MainController object instance.
   */
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
  
  /**
   * Switches to the sale input screen.
   */
  public void showProcessSale() {
    processSaleController.resetView();
    contentArea.setCenter(processSaleController.getView());
  }
  
  /**
   * Switches to the payment screen and populates values needed for checkout.
   */
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
  
  /**
   * Assigns correct .fxml file to the process sale controller.
   * Provides the process sale controller with a reference to the register 
   * instance.
   */
  public void setProcessSaleController() {
    this.processSaleController = loadController("/gui/ProcessSale.fxml");
    this.processSaleController.setMainController(this);
    this.processSaleController.setRegister(store.getRegister());
  }
  
  /**
   * Assigns correct .fxml file to the payment controller.
   */
  public void setPaymentController() {
    this.paymentController = loadController("/gui/Payment.fxml");
    this.paymentController.setMainController(this);
  }
  
  /**
   * Provides the main controller with a reference to the current store
   * instance
   * 
   * @param store The current instance of the Store class.
   */
  public void setStore(Store store) {
    this.store = store;
  }
  
  /**
   * Used in assigning .fxml gui files to their controllers.
   * 
   * @param fxmlFile The file path of the .fxml gui file to be assigned.
   */
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
