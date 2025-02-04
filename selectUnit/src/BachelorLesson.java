import java.util.ArrayList;

public class BachelorLesson extends Lesson{

    //ArrayList of prerequisite lessons is declared i 'Lesson' class

    /**
	 * 
	 */
	private static final long serialVersionUID = -3053383646108774258L;

	public BachelorLesson(String ID, int max_participant) {
        super(ID);

    }

    public BachelorLesson(String name, Professor professor, String ID, int unitNumber, int hour, int capacity, int maxCapacity, ArrayList<Integer> entranceYears, ArrayList<Major> fields, ArrayList<Lesson> prerequisitesLessons, ArrayList<Student> students) {
        super(name, professor, ID, unitNumber, hour,  maxCapacity, entranceYears, fields, prerequisitesLessons, students);

    }
}
