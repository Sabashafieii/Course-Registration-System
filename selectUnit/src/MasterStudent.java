import java.util.ArrayList;

public class MasterStudent extends Student{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1213084207587609281L;

	public MasterStudent(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear) {
        super(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, field, entranceYear);
    }
}
