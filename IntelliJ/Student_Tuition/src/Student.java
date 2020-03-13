/**
 * This class is the abstract parent class for the different types of Students.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public abstract class Student implements Comparable
{
    private String fname;
    private String lname;
    protected int credit;

    public final int EQUAL = 0;
    public final int LESS = -1;
    public final int MORE = 1;

    public final int PART_FULL_THRESHOLD = 12; // < 12 is part-time and >= 12 is full time
    public final int PART_TIME_STUD_FEE = 846;
    public final int FULL_TIME_STUD_FEE = 1441;

    public final int CREDIT_PAYMENT_MAX = 15; // Max amount of credits that the students can pay for

    /**
     * This is the parameterized Constructor of the Student class.
     * @param fname is the first name
     * @param lname is the last name
     * @param credit is the number of credits taken by the student
     */
    public Student(String fname, String lname, int credit)
    {
        this.fname = fname;
        this.lname = lname;
        this.credit = credit;
    } // Student()

    /**
     * This method will compare two Students. Comparisons start with first name and then last name.
     * @param obj is the Student that needs to be compared to the current Student
     * @return 0 if the first and last name are the same, 1 if this greater than obj and -1 if this less than obj
     */
    public int compareTo(Object obj)
    {
        Student ptr = (Student) obj;
        if ((this.fname.compareToIgnoreCase(ptr.fname) == 0) && (this.lname.compareToIgnoreCase(ptr.lname) == 0))
        {
            return EQUAL;
        }
        else if (this.fname.compareToIgnoreCase(ptr.fname) > 0)
        {
            return MORE;
        }
        else if ((this.fname.compareToIgnoreCase(ptr.fname) == 0) && (this.lname.compareToIgnoreCase(ptr.lname) > 0))
        {
            return MORE;
        }
        else if (this.fname.compareToIgnoreCase(ptr.fname) < 0)
        {
            return LESS;
        }
        else if ((this.fname.compareToIgnoreCase(ptr.fname) == 0) && (this.lname.compareToIgnoreCase(ptr.lname) < 0))
        {
            return LESS;
        }
        else
        {
            return LESS;
        }
    } // compareTo()

    /**
     * This method will be used to print and full name and number of credits for a specific Student.
     * @return String containing fname, lname and credit hours
     */
    public String toString()
    {
        return "Name: " + this.fname + " " + this.lname + " , Credits: " + this.credit;
    } // toString()

    /**
     * This method will be used to compute the tuition that a specific Student must pay.
     * @return the amount of tuition that the student must pay
     */
    public abstract int tuitionDue();
} // Student