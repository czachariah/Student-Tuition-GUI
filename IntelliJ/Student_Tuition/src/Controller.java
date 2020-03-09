import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller
{
    @FXML
    public TextField FirstNameText;

    @FXML
    public Button AddButton;

    @FXML
    public TextArea TextOutput;

    public void getText()
    {
        TextOutput.clear();
        if (FirstNameText.getText().equals(""))
        {
            TextOutput.setText("Empty value\n");
        }
        TextOutput.appendText("Button Clicked. First Name: " + FirstNameText.getText() + "\n");
    }
}

/*
1) Go to TutitonManager.java and add more commands : make sure that the commands now look at the whole first word not just the first char
2) Add more methods to the Tuition Manager class that return T/F or the StudentList to the Controller
3) Make sure to test the code at the end and see if it still works normally and for the GUI
4) EXTRA: for adding people in, change the system.out.println() to "First Last has been added" and make sure to do the same for the GUI version  of the add method
 */
