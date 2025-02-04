import java.util.ArrayList;

public class KnowledgeableStudent extends BachelorStudent {

    /**
	 * 
	 */
	private static final long serialVersionUID = -107322024184831063L;
	private Major secondField;

    public Major getSecondField() {
        return secondField;
    }

    public void setSecondField(Major secondField) {
        this.secondField = secondField;
    }

    public KnowledgeableStudent(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear) {
        super(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, field, entranceYear);
    }

    public KnowledgeableStudent(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear, Major secondField) {
        super(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, field, entranceYear);
        this.secondField = secondField;
    }
}
