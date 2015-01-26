package gui;

import domain.Register;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Caleb
 */
public class ProcessSaleController implements Initializable {

  @FXML
  private Node root;
  @FXML
  private Label descriptionLabel;
  @FXML
  private Label quantityLabel;
  @FXML
  private Label priceLabel;
  @FXML
  private Label runningTotalLabel;
  @FXML
  private TextField itemIdField;
  @FXML
  private Button processSaleButton;
  @FXML
  private TextField quantityField;
  @FXML
  private Button enterItemButton;
  
  private MainController mainController;
  
  private Register register;

  public Node getView() {
    return root;
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    itemIdField.setText(null);
    quantityField.setText(null);
  }

  @FXML
  private void enterItemButtonClick(ActionEvent event) {
    if (register.getSale().isComplete())
      register.makeNewSale();
    
    if (itemIdField.getText() != null && quantityField.getText() != null)
    {
      register.enterItem(
          itemIdField.getText(),
          Integer.valueOf(quantityField.getText())
      );
    
      String [] details = register.getSale().getLastItem().getDetails();
      descriptionLabel.setText(details[0]);
      quantityLabel.setText(details[1]);
      priceLabel.setText(details[2]);
      runningTotalLabel.setText(String.valueOf(
          register.getSale().getTotal().getAmount()
      ));
    }
    
    itemIdField.setText(null);
    quantityField.setText(null);
  }
  
  @FXML
  private void processSaleButtonClick(ActionEvent event) {
    mainController.showPayment();
  }
  
  public Register getRegister() {
    return this.register;
  }
  
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }
  
  public void setRegister(Register register) {
    this.register = register;
  }
  
  public void resetView() {
    descriptionLabel.setText(null);
    quantityLabel.setText(null);
    priceLabel.setText(null);
    runningTotalLabel.setText(null);
  }
  
}
