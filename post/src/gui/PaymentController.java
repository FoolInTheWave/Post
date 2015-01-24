package gui;

import domain.Money;
import domain.Sale;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Caleb
 */
public class PaymentController implements Initializable {

  @FXML
  private Node root;
  @FXML
  private TextField amountDueField;
  @FXML
  private Button submitPaymentButton;
  @FXML
  private Button calculateChangeButton;
  @FXML
  private TextField amountTenderedField;
  @FXML
  private TextField changeDueField;
  
  private MainController mainController;
  
  private Sale sale;
  
  public Node getView() {
    return root;
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }
  
  @FXML
  private void calculateChangeButtonClick(ActionEvent event) {
    double amountDue = Double.valueOf(amountDueField.getText());
    double amountTendered = 0;
    
    if (amountTenderedField.getText() != null)
      amountTendered = Double.valueOf(amountTenderedField.getText());
    
    if (amountTendered >= amountDue) {
      sale.makePayment(new Money(amountTendered));
      changeDueField.setText(String.valueOf(sale.getBalance().getAmount())); 
    }
  }
  
  @FXML
  private void submitPaymentButtonClick(ActionEvent event) {
    if (changeDueField != null) {
      sale.becomeComplete();
      mainController.showProcessSale();
    }
  }
  
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }
  
  public void setAmountDueField(String amount) {
    amountDueField.setText(amount);
  }
  
  public void setSale(Sale sale) {
    this.sale = sale;
  }
  
  public void resetView() {
    amountTenderedField.setText(null);
    changeDueField.setText(null);
  }

}
