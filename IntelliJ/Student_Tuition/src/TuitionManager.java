import java.util.Scanner;
/**
 * This class is called when running the program.
 * The methods are the different commands that can be run to change the list of Students.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class TuitionManager
{
    Scanner stdin;
    StudentList cs213;

    public final int CRED_MIN_IN_OUT = 0;
    public final int CRED_MIN_INTERN = 9;
    public final int FUND_MIN = 0;

    public final char TRUE = 'T';
    public final char FALSE = 'F';

    /**
     * This method will be used to run the main program. The rest of the
     * private methods are accepted commands that will be used to
     * manipulate the list of Students.
     */
    public void run()
    {
        System.out.println("Program started.");
        stdin = new Scanner(System.in);
        cs213 = new StudentList();

        boolean done = false;
        while (!done)
        {
            String command = stdin.next();
            switch (command.charAt(0))
            {
                case 'i':
                    System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    break;
                case 'o':
                    System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    break;
                case 'n':
                    System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    command = stdin.next();
                    break;
                case 'r':
                    System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
                    command = stdin.next();
                    command = stdin.next();
                    break;
                case 'I':
                    addInState();
                    break;
                case 'O':
                    addOutState();
                    break;
                case 'N':
                    addIntern();
                    break;
                case 'R':
                    remove();
                    break;
                case 'P':
                    print();
                    break;
                case 'Q':
                    print();
                    done = !done; // terminate the program
                    break;
                default:
                    System.out.println("Command '"+ command.charAt(0) +"' is not supported!");
            } // ends the switch-statement
        } // ends the while loop
        System.out.println("Program terminated.");
        stdin.close();
    } // run()

    /**
     * This private method will make an instance of an In-State Student and
     * add him/her to the list.
     */
    private void addInState()
    {
        String firstName;
        firstName = stdin.next();

        String lastName;
        lastName = stdin.next();

        String creditString;
        creditString = stdin.next();

        String fundingString;
        fundingString = stdin.next();

        try
        {
            int creds = Integer.parseInt(creditString);
            int funds = Integer.parseInt(fundingString);

            if (creds > CRED_MIN_IN_OUT)
            {
                if (funds >= FUND_MIN)
                {
                    Instate newStudent = new Instate(firstName, lastName, creds, funds);
                    if ((cs213.isEmpty() == false) && (cs213.contains(newStudent) == true))
                    {
                        System.out.println(firstName + " " + lastName + " is already on the list.");
                    }
                    else
                    {
                        cs213.add(newStudent);
                        System.out.println(firstName + " " + lastName + " has been added to the list.");
                    }
                }
                else
                {
                    System.out.println("Invalid entry: Amount of funding entered must be 0 or greater.");
                }
            }
            else
            {
                System.out.println("Invalid entry: Number of credits entered must be greater than 0.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid entry: Please make sure that number of credits and amount of "
                    + "funding are integer numbers.");
        }
    } // addInstate()

    /**
     * This private method will make an instance of an Out-State Student and
     * add him/her to the list.
     */
    private void addOutState()
    {
        String firstName;
        firstName = stdin.next();

        String lastName;
        lastName = stdin.next();

        String creditString;
        creditString = stdin.next();

        String tristateString;
        tristateString = stdin.next();

        try
        {
            int creds = Integer.parseInt(creditString);
            boolean isInTristate;

            if (creds > CRED_MIN_IN_OUT)
            {
                if (tristateString.charAt(0) == TRUE)
                {
                    isInTristate = true;
                    Outstate newStudent = new Outstate(firstName, lastName, creds, isInTristate);
                    if ((cs213.isEmpty() == false) && (cs213.contains(newStudent) == true))
                    {
                        System.out.println(firstName + " " + lastName + " is already on the list.");
                    }
                    else
                    {
                        cs213.add(newStudent);
                        System.out.println(firstName + " " + lastName + " has been added to the list.");
                    }
                }
                else if (tristateString.charAt(0) == FALSE)
                {
                    isInTristate = false;
                    Outstate newStudent = new Outstate(firstName, lastName, creds, isInTristate);
                    if ((cs213.isEmpty() == false) && (cs213.contains(newStudent) == true))
                    {
                        System.out.println(firstName + " " + lastName + " is already on the list.");
                    }
                    else
                    {
                        cs213.add(newStudent);
                        System.out.println(firstName + " " + lastName + " has been added to the list.");
                    }
                }
                else
                {
                    System.out.println("Invalid entry: Please use T or F for declaring whether the Student"
                            + "is in the tri-state or not.");
                }
            }
            else
            {
                System.out.println("Invalid entry: Number of credits entered must be greater than 0.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid entry: Please make sure that number of credits "
                    + "is an integer number.");
        }
    } // addOutState()

    /**
     * This private method will make an instance of an International Student and
     * add him/her to the list.
     */
    private void addIntern()
    {
        String firstName;
        firstName = stdin.next();

        String lastName;
        lastName = stdin.next();

        String creditString;
        creditString = stdin.next();

        String exchangeString;
        exchangeString = stdin.next();

        try
        {
            int creds = Integer.parseInt(creditString);
            boolean isExchange;

            if (creds >= CRED_MIN_INTERN)
            {
                if (exchangeString.charAt(0) == TRUE)
                {
                    isExchange = true;
                    International newStudent = new International(firstName, lastName, creds, isExchange);
                    if ((cs213.isEmpty() == false) && (cs213.contains(newStudent) == true))
                    {
                        System.out.println(firstName + " " + lastName + " is already on the list.");
                    }
                    else
                    {
                        cs213.add(newStudent);
                        System.out.println(firstName + " " + lastName + " has been added to the list.");
                    }
                }
                else if (exchangeString.charAt(0) == FALSE)
                {
                    isExchange = false;
                    International newStudent = new International(firstName, lastName, creds, isExchange);
                    if ((cs213.isEmpty() == false) && (cs213.contains(newStudent) == true))
                    {
                        System.out.println(firstName + " " + lastName + " is already on the list.");
                    }
                    else
                    {
                        cs213.add(newStudent);
                        System.out.println(firstName + " " + lastName + " has been added to the list.");
                    }
                }
                else
                {
                    System.out.println("Invalid entry: Please use T or F for declaring whether the Student"
                            + " has exchange status or not.");
                }
            }
            else
            {
                System.out.println("Invalid entry: Number of credits entered must be greater than or equal to 9.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid entry: Please make sure that number of credits "
                    + "is an integer number.");
        }
    } // addIntern()

    /**
     * This private method will be used to remove a specific Student from the list.
     * The Student must be present within the list.
     */
    private void remove()
    {
        String firstName;
        firstName = stdin.next();

        String lastName;
        lastName = stdin.next();

        int cred = CRED_MIN_INTERN; // need a positive integer to hold place for credits
        boolean placeHolder = true; // need a place holder for the T/F value

        Outstate newStudent = new Outstate(firstName, lastName, cred, placeHolder);
        if (cs213.remove(newStudent))
        {
            System.out.println(firstName + " "+ lastName + " has been removed from the list.");
        }
        else
        {
            System.out.println(firstName + " "+ lastName + " is not on the list.");
        }
    } // remove()

    /**
     * This private method will print the Students currently on the list.
     */
    private void print()
    {
        cs213.print();
    } // print()
} // TuitionManager
