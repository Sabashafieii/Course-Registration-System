import java.util.ArrayList;

public class MasterDegree extends Lesson{


    /**
	 * 
	 */
	private static final long serialVersionUID = 5393291698051948207L;
	//ArrayList of prerequisite lessons is declared i 'Lesson' class
    private ArrayList<Lesson> prerequisiteLessonInBachelor;

    public MasterDegree(String ID, int max_participant) {
        super(ID);

    }

    public MasterDegree(String name, Professor professor, String ID, int unitNumber, int hour, int capacity, int maxCapacity, ArrayList<Integer> entranceYears, ArrayList<Major> fields, ArrayList<Lesson> prerequisitesLessons, ArrayList<Student> students, ArrayList<Lesson> prerequisiteLessonInBachelor) {
        super(name, professor, ID, unitNumber, hour,  maxCapacity, entranceYears, fields, prerequisitesLessons, students);
        this.prerequisiteLessonInBachelor = prerequisiteLessonInBachelor;
    }

    public ArrayList<Lesson> getPrerequisiteLessonInBachelor() {
        return prerequisiteLessonInBachelor;
    }

    public void setPrerequisiteLessonInBachelor(ArrayList<Lesson> prerequisiteLessonInBachelor) {
        this.prerequisiteLessonInBachelor = prerequisiteLessonInBachelor;
    }
}
