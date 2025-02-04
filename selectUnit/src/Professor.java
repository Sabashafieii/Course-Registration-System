import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6217900465108686151L;
	private String firstname;
    private String lastName;
    private String idNumber;
    private String password;
    private int maxUnit ;

    public Professor(String firstname, String lastName, String idNumber, String password, int maxUnit) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.password = password;
        this.maxUnit = maxUnit;
    }

    public Professor(String lastName, String idNumber) {
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public Professor(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  int getMaxUnit() {
        return maxUnit;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", password='" + password + '\'' +
                ", maxUnit=" + maxUnit +
                '}';
    }

    public static void professorMenu(){
        ArrayList<Professor> professors = FileDetails.readProfessors();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID number:");
        String id = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        boolean isFoundP = false;
        for (Professor professor:professors){
            if (professor.getIdNumber().equals(id)){
                if (professor.getPassword().equals(password)){
                    isFoundP = true;
                    System.out.println("1-show info 9-Exit");
                    int res = scanner.nextInt();
                    if (res==1){
                        System.out.println(professor.toString());
                    }
                    else if (res==9){
                        MenuDetails.startMenu();
                    }

                    break;
                }
            }
        }if (!isFoundP){
            System.out.println("User not found");
        }
    }
    public static void addProfessor(ArrayList<Professor> professors){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = scanner.next();
        System.out.println("Enter last name:");
        String lastName = scanner.next();
        System.out.println("Enter ID:");
        String id = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Enter max units:");
        int max = scanner.nextInt();
        Professor professor = new Professor(firstName,lastName,id,password,max);
//        professors.add(professor);
        FileDetails.saveProfessors(professors, professor);
        System.out.println(professor.toString());
    }
}
