import java.util.ArrayList;

public class OrdinaryStudent extends BachelorStudent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6969821922079857330L;

	public OrdinaryStudent(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear) {
        super(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, field, entranceYear);
    }
}
