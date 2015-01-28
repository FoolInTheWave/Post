package gui;

import domain.Money;
import domain.Sale;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This class implements the controller in charge of the payment gui.
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

  }

  /**
   * Executes when the "calculate change" button is clicked.
   * Calculates change due after the sale.
   * If the payment was sufficient, informs the sale class of the payment
   * being made.
   * 
   * @param event Click event that fires this method.
   */
  @FXML
  private void calculateChangeButtonClick(ActionEvent event) {
    double amountDue = Double.valueOf(amountDueField.getText().substring(1));
    double amountTendered = 0;

    if (amountTenderedField.getText() != null) {
      if (amountTenderedField.getText().startsWith("$")) {
        amountTendered = Double.valueOf(amountTenderedField.getText().substring(1));
      } else {
        amountTendered = Double.valueOf(amountTenderedField.getText());
      }

      if (amountTendered >= amountDue) {
        sale.makePayment(new Money(amountTendered));
        changeDueField.setText(sale.getBalance().toString());
      }
    }
  }

  /**
   * Executes when the "submit payment" button is clicked.
   * If the sale has completely successfully, informs the sale class of this.
   * Resets the gui to show the sale input screen again.
   * 
   * @param event Click event that fires this method.
   */
  @FXML
  private void submitPaymentButtonClick(ActionEvent event) {
    if (changeDueField != null) {
      sale.becomeComplete();
      sale.setDate(new Date());
      mainController.getStore().addSale(sale);
      sale.clearSaleLineItems();
      mainController.showProcessSale();
    }
  }

  /**
   * Informs this class about the current instance of the main controller class.
   * 
   * @param mainController Current instance of main controller class.
   */
  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }
  
  public void setStore() {
    
  }

  /**
   * Populates the "amount due" field with the amount due on the current sale.
   * 
   * @param amount The amount of money due for the current sale.
   */
  public void setAmountDueField(String amount) {
    amountDueField.setText(amount);
  }

  /**
   * Informs this class about the current instance of the Sale class.
   * 
   * @param sale The current instance of the Sale class.
   */
  public void setSale(Sale sale) {
    this.sale = sale;
  }

  /**
   * Clears the text from the text fields on the payment gui.
   * 
   */
  public void resetView() {
    amountTenderedField.setText(null);
    changeDueField.setText(null);
  }

}
