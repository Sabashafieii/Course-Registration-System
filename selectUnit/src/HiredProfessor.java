import java.io.Serializable;

public class HiredProfessor extends Professor implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -126877924148584369L;
	private int workingYears;

    public HiredProfessor(String firstname, String lastName, String idNumber, String password, int maxUnit, int workingYears) {
        super(firstname, lastName, idNumber, password, maxUnit);
        this.workingYears = workingYears;
    }

    public int getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(int workingYears) {
        this.workingYears = workingYears;
    }

    public HiredProfessor(String firstname, String lastName, String idNumber, String password, int maxUnit) {
        super(firstname, lastName, idNumber, password, maxUnit);
    }

    public HiredProfessor(String lastName, String idNumber) {
        super(lastName, idNumber);
    }

    public HiredProfessor(String idNumber) {
        super(idNumber);
    }
}
