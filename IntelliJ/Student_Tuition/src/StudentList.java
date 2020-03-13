/**
 * This class makes a list of Students.
 * The methods are used to add to, remove from or print from the current set of Students.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public class StudentList
{
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4; //initial and grow size
    private Student [] list;
    private int numStudents;

    /**
     * This is the default constructor where an array that can
     * hold Students will be initialized.
     */
    public StudentList()
    {
        list = new Student[GROW_SIZE];
    } // StudentList()

    /**
     * This private method is used to iterate through the list of Students
     * to find a specific Student.
     * @param s is the Student to be found
     * @return index number where the student is found, else -1
     */
    private int find(Student s)
    {
        for (int i = 0 ; i < list.length ; i++)
        {
            if ((list[i] != null) && (list[i].compareTo(s) == 0))
            {
                return i;
            }
        }
        return NOT_FOUND;
    } // find()

    /**
     * This method will grow the total size of the array by the GROW_SIZE(4).
     */
    private void grow()
    {
        int newLength = list.length + GROW_SIZE;
        Student [] newList = new Student[newLength];

        for (int i = 0 ; i < list.length ; i++)
        {
            newList[i] = list[i];
        }
        list = newList;
    } // grow()

    /**
     * This method will check if the list id empty or not.
     * @return true if empty and false otherwise
     */
    public boolean isEmpty()
    {
        if (list[0] == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    } // isEmpty()

    /**
     * This method will add a new Student to the list.
     * Assuming that the person does not already belong in the list.
     * @param s is the new Student to add
     */
    public void add(Student s)
    {
        if (numStudents == list.length) // need to grow the list
        {
            grow();
            list[numStudents] = s;
            numStudents++;
        }
        else
        {
            list[numStudents] = s;
            numStudents++;
        }
    } // add()

    /**
     * This method will remove a specific Student from the list.
     * @param s is the Student to remove
     * @return true if the Student has been removed, false otherwise
     */
    public boolean remove(Student s)
    {
        if ((numStudents != 0) && (contains(s)))
        {
            int place = find(s);

            if (place == (numStudents - 1)) // last person on the list
            {
                list[place] = null;
                numStudents--;
                return true;
            }
            else
            {
                list[place] = null;
                list[place] = list[numStudents-1];
                list[numStudents-1] = null;
                numStudents--;
                return true;
            }
        }
        else
        {
            return false;
        }
    } // remove()

    /**
     * This method will check to see if the list has a specific student.
     * @param s is the Student to be searched for
     * @return true if the Student is in the list, false otherwise
     */
    public boolean contains(Student s)
    {
        if (find(s) != NOT_FOUND)
        {
            return true;
        }
        else
        {
            return false;
        }
    } // contains()

    /**
     * This method will print out all the current Students on the list.
     */
    public void print()
    {
        if (isEmpty())
        {
            System.out.println("There are 0 students currently on the list.");
        }
        else
        {
            System.out.println("Here are the following students on the list:");
            for (int i = 0 ; i < numStudents ; i++)
            {
                System.out.println(list[i].toString() + " , Tuition Due: $" + list[i].tuitionDue());
            }
            System.out.println("-- end of the list --");
        }
    } // print()

    public Student[] printForGUI()
    {
        return list;
    }
} // StudentList
