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
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class implements the controller in charge of the process sale gui.
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

  /**
   * Returns the gui components of the view.
   * 
   * @return root gui components to display for this view.
   */
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

  /**
   * Executes when the "enter item" button is clicked.
   * Creates new sale if this has not been done yet.
   * Informs the register instance of the item and quantity being added to sale.
   * Shows item's information on the gui.
   * 
   * @param event Click event that fires this method.
   */
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
  
  /**
   * Executes when the "process sale" button is clicked.
   * Switches to the payment gui.
   * 
   * @param event Click event that fires this method.
   */
  @FXML
  private void processSaleButtonClick(ActionEvent event) {
    mainController.showPayment();
  }
  
  /**
   * Returns the instance of the Register class currently associated with 
   * this controller.
   * 
   * @return this.register
   */
  public Register getRegister() {
    return this.register;
  }
  
  /**
   * Informs this controller of the current instance of the 
   * MainController class.
   * 
   * @param mainController Current instance of the MainController class
   */
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }
  
  /**
   * Informs this controller of the current instance of the Register class.
   * 
   * @param register Current instance of the Register class.
   */
  public void setRegister(Register register) {
    this.register = register;
  }
  
  /**
   * Clears the labels on the process sale gui that show item details
   *
   */
  public void resetView() {
    descriptionLabel.setText(null);
    quantityLabel.setText(null);
    priceLabel.setText(null);
    runningTotalLabel.setText(null);
  }
  
}
