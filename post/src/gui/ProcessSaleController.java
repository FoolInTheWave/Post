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
  private Label runningTotalLabel;
  @FXML
  private Label currentItemLabel;
  @FXML
  private TextField itemIdField;
  @FXML
  private Button processSaleButton;
  @FXML
  private TextField quantityField;
  @FXML
  private Button enterItemButton;
  
  private Register register;

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
  private void enterItemButtonClick(ActionEvent event) {
    
  }
  
  @FXML
  private void processSaleButtonClick(ActionEvent event) {
    
  }
  
  public void setRegister(Register register) {
    this.register = register;
  }
  
}
