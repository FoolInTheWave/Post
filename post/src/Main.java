import domain.Register;
import domain.Store;
import gui.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Caleb Miller, Steve Foco
 * @date 01/23/2015
 * 
 * This program simulates a simple Point of Sale Terminal for a store.
 * 
 * Technologies used:
 * Java 8
 * JavaFX 2.2
 */
public class Main extends Application {
  
  /**
   * Sets up the stage for the initial load of the gui.
   * Provides main controller with references to other controllers.
   * Shows the sale input screen with the correct size and attributes.
   * 
   * @param stage Instance of JavaFX Stage class which is used to show the gui.
   */
  @Override
  public void start(Stage stage) {
    Store store = new Store();
    Register register = store.getRegister();
    MainController mainController = new MainController();
    
    mainController = mainController.loadController("/gui/Main.fxml");
    mainController.setStore(store);
    mainController.setProcessSaleController();
    mainController.setPaymentController();
    
    mainController.showProcessSale();
    
    Scene scene = new Scene(mainController.getView(), 650, 530);
    scene.getStylesheets().add("gui/Styles.css");
    
    stage.setScene(scene);
    stage.setTitle("MoeMart - Point of Sale System");
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
