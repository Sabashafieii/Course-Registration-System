import java.util.ArrayList;

public class BachelorStudent extends Student{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4187045422297834371L;

	public BachelorStudent(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear) {
        super(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, field, entranceYear);
    }

}
