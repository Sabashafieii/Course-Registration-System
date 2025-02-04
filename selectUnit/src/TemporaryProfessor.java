import java.io.Serializable;

public class TemporaryProfessor extends Professor implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1426912872022574089L;
	private int teachingHours;

    public TemporaryProfessor(String firstname, String lastName, String idNumber, String password, int maxUnit, int teachingHours) {
        super(firstname, lastName, idNumber, password, maxUnit);
        this.teachingHours = teachingHours;
    }

    public TemporaryProfessor(String idNumber, int teachingHours) {
        super(idNumber);
        this.teachingHours = teachingHours;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    public TemporaryProfessor(String firstname, String lastName, String idNumber, String password, int maxUnit) {
        super(firstname, lastName, idNumber, password, maxUnit);
    }

    public TemporaryProfessor(String lastName, String idNumber) {
        super(lastName, idNumber);
    }

    public TemporaryProfessor(String idNumber) {
        super(idNumber);
    }
}
