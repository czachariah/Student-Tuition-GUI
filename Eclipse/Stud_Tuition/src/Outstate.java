/**
 * This is the Out-Of-State Student class that extends Student.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class Outstate extends Student 
{
	private boolean tristate;
	
	public final int OUTSTATE_TUITION_PER_CRED = 756;
	public final int OUTSTATE_DISCOUNT = 200;
	
	/**
	 * This is the parameterized constructor for this class. This constructor is only invoked
	 * after checking that all the given information is valid.
	 * @param fname is the first name of the Student
	 * @param lname is the last name of the Student
	 * @param credit is the number of credits that the Student is taking
	 * @param tristate is whether the Student is in the tri-state area or not
	 */
	public Outstate(String fname, String lname, int credit, boolean tristate)
	{
		super(fname, lname, credit);
		this.tristate = tristate;
	} // Outstate()

	/**
	 * This method will be use to calculate the tuition due by this Student.
	 * @return the total tuition amount
	 */
	public int tuitionDue() 
	{
		int payForCredits;
		int total;
		Outstate ptr = this;
		if (ptr.credit < PART_FULL_THRESHOLD)
		{
			payForCredits = ptr.credit * OUTSTATE_TUITION_PER_CRED;
			total = payForCredits + PART_TIME_STUD_FEE;
			return total;
		}
		else
		{
			if (ptr.credit >= CREDIT_PAYMENT_MAX)
			{
				if (ptr.tristate)
				{
					payForCredits = CREDIT_PAYMENT_MAX * (OUTSTATE_TUITION_PER_CRED - OUTSTATE_DISCOUNT);
					total = payForCredits + FULL_TIME_STUD_FEE;
					return total;
				}
				else			
				{
					payForCredits = CREDIT_PAYMENT_MAX * OUTSTATE_TUITION_PER_CRED;
					total = payForCredits + FULL_TIME_STUD_FEE;	
					return total;				
				}
			}
			else
			{
				if (ptr.tristate)
				{
					payForCredits = ptr.credit * (OUTSTATE_TUITION_PER_CRED - OUTSTATE_DISCOUNT);
					total = payForCredits + FULL_TIME_STUD_FEE;
					return total;
				}
				else			
				{
					payForCredits = ptr.credit * OUTSTATE_TUITION_PER_CRED;
					total = payForCredits + FULL_TIME_STUD_FEE;	
					return total;				
				}
			}
		}
	} // tuitionDue()
	
	/**
	 * This method will print all the information about this Student.
	 * @return String with Name, Credits, Type and Tri-State status about this Student
	 */
	@Override
	public String toString() 
	{
		Outstate ptr = this;
		if (ptr.tristate)
		{
			String getNameAndCreds = super.toString();
			return getNameAndCreds + " , Student Type: Out-Of-State , Tri-State: YES";
		}
		else
		{
			String getNameAndCreds = super.toString();
			return getNameAndCreds + " , Student Type: Out-Of-State , Tri-State: NO";
		}		
	} // toString()
	
	/**
	 * This is the test-bed main where the constructor and the methods will be tested.
	 * @param args is the code
	 */
	public static void main(String [] args)
	 {
		// test creating an instance of Outstate
		Outstate one = new Outstate("Chris","Zachariah",17,true);
				
		// test the tuitionDue() method
		System.out.println(one.tuitionDue());
				
		// test compareTo() method
		Outstate two = new Outstate("Chris","Zachariah",17,false);
		System.out.println(one.compareTo(two));
				
		Outstate three = new Outstate("Alex","Zachariah",17,true);
		System.out.println(one.compareTo(three));
				
		Outstate four = new Outstate("Chris","Zechariah",17,false);
		System.out.println(one.compareTo(four));
				
		// test out the toString() method
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
		System.out.println(four.toString());
	 } // main()
} // Outstate
