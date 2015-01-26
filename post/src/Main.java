import domain.Register;
import domain.Store;
import gui.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Caleb Miller
 */
public class Main extends Application {
  
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
