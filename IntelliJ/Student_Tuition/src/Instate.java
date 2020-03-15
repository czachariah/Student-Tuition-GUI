/**
 * This is the In-State Student class that extends Student.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class Instate extends Student
{
    private int funds;

    public final int INSTATE_TUITION_PER_CRED = 433;

    /**
     * This is the parameterized constructor for this class. This constructor is only invoked
     * after checking that all the given information is valid.
     * @param fname is the first name of the Student
     * @param lname is the last name of the Student
     * @param credit is the number of credits that the Student is taking
     * @param funds	is the amount of funding that the student receives
     */
    public Instate(String fname, String lname, int credit, int funds)
    {
        super(fname, lname, credit);
        this.funds = funds;
    } // Instate()

    /**
     * This method will be use to calculate the tuition due by this Student.
     * @return the total tuition amount
     */
    public int tuitionDue()
    {
        int payForCredits;
        int total;
        Instate ptr = this;
        if (ptr.credit < PART_FULL_THRESHOLD)
        {
            payForCredits = ptr.credit * INSTATE_TUITION_PER_CRED;
            total = payForCredits + PART_TIME_STUD_FEE;
            if (total < TOTAL_MIN)
            {
                return TOTAL_MIN;
            }
            else
            {
                return total;
            }
        }
        else
        {
            if (ptr.credit >= CREDIT_PAYMENT_MAX)
            {
                payForCredits = CREDIT_PAYMENT_MAX * INSTATE_TUITION_PER_CRED;
                total = (payForCredits + FULL_TIME_STUD_FEE) - ptr.funds;
                if (total < TOTAL_MIN)
                {
                    return TOTAL_MIN;
                }
                else
                {
                    return total;
                }
            }
            else
            {
                payForCredits = ptr.credit * INSTATE_TUITION_PER_CRED;
                total = (payForCredits + FULL_TIME_STUD_FEE) - ptr.funds;
                if (total < TOTAL_MIN)
                {
                    return TOTAL_MIN;
                }
                else
                {
                    return total;
                }
            }
        }
    } // tuitionDue()


    /**
     * This method will print all the information about this Student.
     * @return String with Name, Credits, Type and Funds about this Student
     */
    @Override
    public String toString()
    {
        String getNameAndCreds = super.toString();
        return getNameAndCreds + " , Student Type: In-State , Funds: $" + funds;
    } // toString()

    /**
     * This is the test-bed main where the constructor and the methods will be tested.
     * @param args is the code
     */
    public static void main(String [] args)
    {
        // test creating an instance of Instate
        Instate one = new Instate("Chris","Zachariah",12,1000);

        // test the tuitionDue() method
        System.out.println(one.tuitionDue());

        // test compareTo() method
        Instate two = new Instate("Chris","Zachariah",12,1000);
        System.out.println(one.compareTo(two));

        Instate three = new Instate("Alex","Zachariah",12,1000);
        System.out.println(one.compareTo(three));

        Instate four = new Instate("Chris","Zechariah",12,1000);
        System.out.println(one.compareTo(four));

        // test out the toString() method
        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());
        System.out.println(four.toString());
    } // main()
} // Instate
