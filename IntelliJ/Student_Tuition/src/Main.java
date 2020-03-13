import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the class that can be used to build and run the GUI for the user.
 * @author Chris Zachariah (cvz2)
 */
public class Main extends Application
{
    public final int FIXED_WIDTH = 900;
    public final int FIXED_LENGTH = 1000;

    /**
     * This method will build the GUI using sample.fxml and get it ready for the User.
     * @param primaryStage the main Student-Tuition-GUI Stage
     * @throws Exception any Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Program 3 - Tuition Manager");
        primaryStage.setScene(new Scene(root, FIXED_WIDTH, FIXED_LENGTH));
        primaryStage.setResizable(false);
        primaryStage.show();
    } // start()

    /**
     * This method will launch the GUI for the user.
     * @param args are the arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    } // main()
} // Main
