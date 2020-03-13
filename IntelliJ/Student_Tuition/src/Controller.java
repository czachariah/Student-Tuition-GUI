import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.w3c.dom.Text;

/**
 * This class is the controller for all the actions for the GUI and will connect
 * with the TuitionManager to keep track of the Students.
 * @author Chris Zachariah (cvz2)
 */
public class Controller
{
    // TuitionManger reference variable
    public static TuitionManager backEnd = new TuitionManager();

    public final int CRED_MIN_IN_OUT = 0;
    public final int CRED_MIN_INTERN = 9;

    public final int FUND_MIN = 0;
    public final int DEFAULT_FUNDING = 0;

    public final String EMPTY = "";

    public final boolean TRUE = true;
    public final boolean FALSE = false;

    // three text fields on the top
    @FXML
    public TextField FirstNameText;
    @FXML
    public TextField LastNameText;
    @FXML
    public TextField NumCreditsText;

    // three radio buttons
    @FXML
    public RadioButton InstateRadioButton;
    public boolean isInStateRadioButtonClicked;
    @FXML
    public RadioButton OutStateRadioButton;
    public boolean isOutStateRadioButtonClicked;
    @FXML
    public RadioButton InternationalRadioButton;
    public boolean isInternationalRadioButtonClicked;

    // three checkboxes
    @FXML
    public CheckBox FundingCheck;
    public boolean isFundingCheckClicked;
    @FXML
    public CheckBox TriStateCheck;
    public boolean isTriStateCheckClicked;
    @FXML
    public CheckBox ExchangeCheck;
    public boolean isExchangeCheckClicked;

    // funding amount text field
    @FXML
    public TextField FundingAmount;

    // 3 action buttons
    @FXML
    public Button AddButton;
    @FXML
    public Button RemoveButton;
    @FXML
    public Button PrintButton;

    // Text Area for output
    @FXML
    public TextArea TextOutput;

    /**
     * This method is connected to the Add Button
     * to add a new Student to the list.
     */
    public void addNewStudent() {
        String firstName = FirstNameText.getText();
        if (firstName.equals(EMPTY))
        {
            TextOutput.appendText("ERROR: Please make sure to enter a First Name.\n\n");
            return;
        }

        String lastName = LastNameText.getText();
        if (lastName.equals(EMPTY))
        {
            TextOutput.appendText("ERROR: Please make sure to enter a Last Name.\n\n");
            return;
        }

        int credits = 0;
        try
        {
            credits = Integer.parseInt(NumCreditsText.getText());
        }
        catch (Exception ex)
        {
            TextOutput.appendText("ERROR: Please make sure the number of credits entered is an Integer number greater than 0.\n\n");
            return;
        }
        if (credits <= CRED_MIN_IN_OUT)
        {
            TextOutput.appendText("ERROR: Please make sure the number of credits is strictly greater than 0.\n\n");
            return;
        }

        if (isInStateRadioButtonClicked)
        {
            addInStateStudent(firstName,lastName,credits);
        }
        else if (isOutStateRadioButtonClicked)
        {
            addOutStateStudent(firstName,lastName,credits);
        }
        else if (isInternationalRadioButtonClicked)
        {
            if (credits < CRED_MIN_INTERN)
            {
                TextOutput.appendText("ERROR: Please make sure the number of credits is strictly greater than or equal to 9 for an International Student.\n\n");
                return;
            }
            addInternationalStudent(firstName,lastName,credits);
        }
        else
        {
            TextOutput.appendText("ERROR: Please make sure to choose the correct type of Student that is to be added.\n\n");
        }
    } // addNewStudent()

    /**
     * This private method is used to add Instate Students to the list.
     * @param firstName is the first name of the Student
     * @param lastName is the last name of the Student
     * @param credits is the number of credits that the Student is taking
     */
    private void addInStateStudent(String firstName , String lastName , int credits)
    {
        if (isFundingCheckClicked)
        {
            int funds = 0;
            try
            {
                funds = Integer.parseInt(FundingAmount.getText());
                if (funds >= FUND_MIN)
                {
                    if (backEnd.addInstateGUI(firstName,lastName,credits,funds))
                    {
                        TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                        setAllDefault();
                    }
                    else
                    {
                        TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                        setAllDefault();
                    }
                }
                else
                {
                    TextOutput.appendText("ERROR: Please make sure the amount of funding entered is greater than or equal to 0.\n\n");
                }
            }
            catch (Exception ex)
            {
                TextOutput.appendText("ERROR: Please make sure the amount of funding entered is an Integer number greater than or equal to 0.\n\n");
            }
        }
        else
        {
            if (backEnd.addInstateGUI(firstName,lastName,credits,DEFAULT_FUNDING))
            {
                TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                setAllDefault();
            }
            else
            {
                TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                setAllDefault();
            }
        }
    } // addInStateStudent

    /**
     * This is a private method used to add Out-State Students to the list.
     * @param firstName is the first name of the Student
     * @param lastName is the last name of the Student
     * @param credits is the number of credits that the Student is taking
     */
    private void addOutStateStudent(String firstName , String lastName , int credits)
    {
        if (isTriStateCheckClicked)
        {
            if (backEnd.addOutStateGUI(firstName,lastName,credits,TRUE))
            {
                TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                setAllDefault();
            }
            else
            {
                TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                setAllDefault();
            }
        }
        else
        {
            if (backEnd.addOutStateGUI(firstName,lastName,credits,FALSE))
            {
                TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                setAllDefault();
            }
            else
            {
                TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                setAllDefault();
            }
        }
    } // addOutStateStudent()

    /**
     * This is a private method used to add an International Student to the list.
     * @param firstName is the first name of the Student
     * @param lastName is the last name of the Student
     * @param credits is the number of credits that the Student is taking
     */
    private void addInternationalStudent(String firstName, String lastName , int credits)
    {
        if (isExchangeCheckClicked)
        {
            if (backEnd.addInternGUI(firstName,lastName,credits,TRUE))
            {
                TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                setAllDefault();
            }
            else
            {
                TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                setAllDefault();
            }
        }
        else
        {
            if (backEnd.addInternGUI(firstName,lastName,credits,FALSE))
            {
                TextOutput.appendText(firstName + " " + lastName + " is added to the list.\n\n");
                setAllDefault();
            }
            else
            {
                TextOutput.appendText("ERROR: " + firstName + " " + lastName + " is already on the list.\n\n");
                setAllDefault();
            }
        }
    } // addInternationalStudent()

    /**
     * This method is connected to the InState Radio Button. Will toggle the other radio buttons off
     * and make sure the funding checkbox and the funding text field is enabled. Will do the opposite
     * if the button is pressed again.
     */
    public void InStateRadioButtonClicked()
    {
        FundingCheck.setSelected(false);
        TriStateCheck.setSelected(false);
        ExchangeCheck.setSelected(false);
        FundingAmount.clear();

        if (OutStateRadioButton.isSelected())
        {
            FundingCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isOutStateRadioButtonClicked = false;
            OutStateRadioButton.setSelected(false);
        }

        if (InternationalRadioButton.isSelected())
        {
            FundingCheck.setDisable(false);
            TriStateCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isInternationalRadioButtonClicked = false;
            InternationalRadioButton.setSelected(false);
        }

        if (InstateRadioButton.isSelected())
        {
            TriStateCheck.setDisable(true);
            ExchangeCheck.setDisable(true);
            isInStateRadioButtonClicked = true;
        }
        else
        {
            TriStateCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            isInStateRadioButtonClicked = false;
        }
    } // InStateRadioButtonClicked()

    /**
     * This method is connected to the OutState Radio Button. This method will disable all
     * checkbox options except for tri-state, disable the funding text field, and turn the
     * OutStateRadioButtonClicked on. It will also toggle the other radio buttons off.
     * Will do the opposite if the button is clicked again.
     */
    public void OutStateRadioButtonClicked()
    {
        FundingCheck.setSelected(false);
        TriStateCheck.setSelected(false);
        ExchangeCheck.setSelected(false);
        FundingAmount.clear();

        if (InstateRadioButton.isSelected())
        {
            TriStateCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            isInStateRadioButtonClicked = false;
            InstateRadioButton.setSelected(false);
        }

        if (InternationalRadioButton.isSelected())
        {
            FundingCheck.setDisable(false);
            TriStateCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isInternationalRadioButtonClicked = false;
            InternationalRadioButton.setSelected(false);
        }

        if (OutStateRadioButton.isSelected())
        {
            FundingCheck.setDisable(true);
            ExchangeCheck.setDisable(true);
            FundingAmount.setDisable(true);
            isOutStateRadioButtonClicked = true;
        }
        else
        {
            FundingCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isOutStateRadioButtonClicked = false;
        }
    } // OutStateRadioButtonClicked()

    /**
     * This method is connected to the International Radio Button. It will toggle the other
     * radio buttons off and only enable the exchange status checkbox. Will do the opposite if
     * the button is clicked again.
     */
    public void InternationalRadioButtonClicked()
    {
        FundingCheck.setSelected(false);
        TriStateCheck.setSelected(false);
        ExchangeCheck.setSelected(false);
        FundingAmount.clear();

        if (InstateRadioButton.isSelected())
        {
            TriStateCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            isInStateRadioButtonClicked = false;
            InstateRadioButton.setSelected(false);
        }

        if (OutStateRadioButton.isSelected())
        {
            FundingCheck.setDisable(false);
            ExchangeCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isOutStateRadioButtonClicked = false;
            OutStateRadioButton.setSelected(false);
        }

        if (InternationalRadioButton.isSelected())
        {
            FundingCheck.setDisable(true);
            TriStateCheck.setDisable(true);
            FundingAmount.setDisable(true);
            isInternationalRadioButtonClicked = true;
        }
        else
        {
            FundingCheck.setDisable(false);
            TriStateCheck.setDisable(false);
            FundingAmount.setDisable(false);
            isInternationalRadioButtonClicked = false;
        }
    } // InternationalRadioButtonClicked()

    /**
     * This method can be used to turn on the Funding checkbox.
     * The other checkboxes will be toggled off.
     */
    public void fundingBoxClicked()
    {
        if (TriStateCheck.isSelected())
        {
            TriStateCheck.setSelected(false);
            isTriStateCheckClicked = false;
        }

        if (ExchangeCheck.isSelected())
        {
            ExchangeCheck.setSelected(false);
            isExchangeCheckClicked = false;
        }

        if (FundingCheck.isSelected())
        {
            isFundingCheckClicked = true;
        }
        else
        {
            isFundingCheckClicked = false;
        }
    } // fundingBoxClicked()

    /**
     * This method can be used to turn on the Tri-State checkbox.
     * The other checkboxes will be toggled off.
     */
    public void triStateBoxClicked()
    {
        if (FundingCheck.isSelected())
        {
            FundingCheck.setSelected(false);
            isFundingCheckClicked = false;
        }

        if (ExchangeCheck.isSelected())
        {
            ExchangeCheck.setSelected(false);
            isExchangeCheckClicked = false;
        }

        if (TriStateCheck.isSelected())
        {
            isTriStateCheckClicked = true;
        }
        else
        {
            isTriStateCheckClicked = false;
        }
    } // triStateBoxClicked()

    /**
     * This method can be used to turn on the Exchange checkbox.
     * The other checkboxes will be toggled off.
     */
    public void exchangeBoxClicked()
    {
        if (TriStateCheck.isSelected())
        {
            TriStateCheck.setSelected(false);
            isTriStateCheckClicked = false;
        }

        if (FundingCheck.isSelected())
        {
            FundingCheck.setSelected(false);
            isFundingCheckClicked = false;
        }

        if (ExchangeCheck.isSelected())
        {
            isExchangeCheckClicked = true;
        }
        else
        {
            isExchangeCheckClicked = false;
        }
    } // exchangeBoxClicked()

    /**
     * This method can be used to set all the areas of the GUI to its default
     * after adding and removing Students.
     */
    private void setAllDefault()
    {
        // clear the top text fields
        FirstNameText.clear();
        FirstNameText.setDisable(false);
        LastNameText.clear();
        LastNameText.setDisable(false);
        NumCreditsText.clear();
        NumCreditsText.setDisable(false);

        // de-select any radio buttons and set their booleans to false
        InstateRadioButton.setSelected(false);
        InstateRadioButton.setDisable(false);
        isInStateRadioButtonClicked = false;

        OutStateRadioButton.setSelected(false);
        OutStateRadioButton.setDisable(false);
        isOutStateRadioButtonClicked = false;

        InternationalRadioButton.setSelected(false);
        InternationalRadioButton.setDisable(false);
        isInternationalRadioButtonClicked = false;

        // de-select any checkboxes and set their booleans to false
        FundingCheck.setSelected(false);
        FundingCheck.setDisable(false);
        isFundingCheckClicked = false;

        TriStateCheck.setSelected(false);
        TriStateCheck.setDisable(false);
        isTriStateCheckClicked = false;

        ExchangeCheck.setSelected(false);
        ExchangeCheck.setDisable(false);
        isExchangeCheckClicked = false;

        // clear the funding amount
        FundingAmount.clear();
        FundingAmount.setDisable(false);
    } // setAllDefault()

    public void removeStudent()
    {
        String firstName = FirstNameText.getText();
        if (firstName.equals(EMPTY))
        {
            TextOutput.appendText("ERROR: Please make sure to enter a First Name.\n\n");
            return;
        }

        String lastName = LastNameText.getText();
        if (lastName.equals(EMPTY))
        {
            TextOutput.appendText("ERROR: Please make sure to enter a Last Name.\n\n");
            return;
        }

        if (backEnd.removeGUI(firstName,lastName))
        {
            TextOutput.appendText(firstName + " " + lastName + " has been removed from the list.\n\n");
            setAllDefault();
        }
        else
        {
            TextOutput.appendText(firstName + " " + lastName + " is not on the list.\n\n");
            setAllDefault();
        }
    } // removeStudent

    /**
     * This method will be connected to the Print button.
     * This will print out the current Students that are in the list
     * along with the tuition that each one needs to pay.
     */
    public void printStudents()
    {
        setAllDefault();
        if (backEnd == null)
        {
            backEnd = new TuitionManager();
            TextOutput.appendText("There are currently no Students on the list.\n\n");
            return;
        }
        Student[] list = backEnd.listForPrinting();
        int numStudents = backEnd.numCurrentStudents();

        if (backEnd.cs213.isEmpty())
        {
            TextOutput.appendText("There are currently no Students on the list.\n\n");
        }
        else
        {
            TextOutput.appendText("Here are the current Students on the list with the tuition amount they are required to pay:\n");
            for (int i = 0 ; i < numStudents ; i++)
            {
                TextOutput.appendText(list[i].toString() + " , Tuition Due: $" + list[i].tuitionDue() + "\n");
            }
            TextOutput.appendText("-- end of the list --\n\n");
        }
    } // printStudents()
} // Controller

/*
1) Go to TutitonManager.java and add more commands : make sure that the commands now look at the whole first word not just the first char
2) Add more methods to the Tuition Manager class that return T/F or the StudentList to the Controller
3) Make sure to test the code at the end and see if it still works normally and for the GUI
4) EXTRA: for adding people in, change the system.out.println() to "First Last has been added" and make sure to do the same for the GUI version  of the add method
 */
