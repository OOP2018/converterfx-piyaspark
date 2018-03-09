package converter;

/**
 * Main class for running user interface.
 * @author Piyaphol Wiengperm.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * initialize the user interface window.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
        primaryStage.setTitle("Length Converter");
        primaryStage.setScene(new Scene(root, 619, 65));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
