/**
 * This is the International Student class that extends Student.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class International extends Student {
    private boolean exchange;

    public final int INTER_TUITION_PER_CRED = 945;
    public final int INTER_STUD_FEE = 350;

    /**
     * This is the parameterized constructor for this class. This constructor is only invoked
     * after checking that all the given information is valid.
     * @param fname is the first name of the Student
     * @param lname is the last name of the Student
     * @param credit is the number of credits that the Student is taking
     * @param exchange is whether the Student is an exchange student or not
     */
    public International(String fname, String lname, int credit, boolean exchange)
    {
        super(fname, lname, credit);
        this.exchange = exchange;
    } // International()

    /**
     * This method will be use to calculate the tuition due by this Student.
     * @return the total tuition amount
     */
    public int tuitionDue()
    {
        int payForCredits;
        int total;
        International ptr = this;
        if (ptr.credit < PART_FULL_THRESHOLD)
        {
            if (ptr.exchange)
            {
                total = FULL_TIME_STUD_FEE + INTER_STUD_FEE;
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
                payForCredits = ptr.credit * INTER_TUITION_PER_CRED;
                total = payForCredits + PART_TIME_STUD_FEE + INTER_STUD_FEE;
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
        else
        {
            if (ptr.credit >= CREDIT_PAYMENT_MAX)
            {
                if (ptr.exchange)
                {
                    total = FULL_TIME_STUD_FEE + INTER_STUD_FEE;
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
                    payForCredits = CREDIT_PAYMENT_MAX * INTER_TUITION_PER_CRED;
                    total = payForCredits + FULL_TIME_STUD_FEE + INTER_STUD_FEE;
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
            else
            {
                if (ptr.exchange)
                {
                    total = FULL_TIME_STUD_FEE + INTER_STUD_FEE;
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
                    payForCredits = ptr.credit * INTER_TUITION_PER_CRED;
                    total = payForCredits + FULL_TIME_STUD_FEE + INTER_STUD_FEE;
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
        }
    } // tuitionDue()

    /**
     * This method will print all the information about this Student.
     * @return String with Name, Credits, Type and Exchange status about this Student
     */
    @Override
    public String toString()
    {
        International ptr = this;
        if (ptr.exchange)
        {
            String getNameAndCreds = super.toString();
            return getNameAndCreds + " , Student Type: International , Exchange: YES";
        }
        else
        {
            String getNameAndCreds = super.toString();
            return getNameAndCreds + " , Student Type: International , Exchange: NO";
        }
    } // toString()

    /**
     * This is the test-bed main where the constructor and the methods will be tested.
     * @param args is the code
     */
    public static void main(String [] args)
    {
        // test creating an instance of International
        International one = new International("Chris","Zachariah",17,true);

        // test the tuitionDue() method
        System.out.println(one.tuitionDue());

        // test compareTo() method
        International two = new International("Chris","Zachariah",17,false);
        System.out.println(one.compareTo(two));

        International three = new International("Alex","Zachariah",17,true);
        System.out.println(one.compareTo(three));

        International four = new International("Chris","Zechariah",17,false);
        System.out.println(one.compareTo(four));

        // test out the toString() method
        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());
        System.out.println(four.toString());
    } // main()

} // International
