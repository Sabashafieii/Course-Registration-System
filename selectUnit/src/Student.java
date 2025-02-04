
import java.io.Serializable;
import java.util.*;


public class Student implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5847494030099466815L;
	private String firstname;
    private String lastName;
    private String idNumber;
    private String nationalCode;

    private String password ;
    private static final int maxUnit = 20;

    private ArrayList<Lesson> passedLessons = new ArrayList<>();
    private ArrayList<Lesson> currentLessons = new ArrayList<>();
    private ArrayList<Lesson> readLessons = new ArrayList<>();
    private  Map<Lesson, Double> scores = new HashMap<>();
    private Map<Integer, List<Float>> GPAs = new HashMap<>();
    private List<Integer> GPAAndUnits = new ArrayList<>();


    private Major field;
    private int entranceYear;//added by myself

    public Student(String firstname, String lastName, String idNumber, String nationalCode, String password, ArrayList<Lesson> passedLessons, ArrayList<Lesson> currentLessons, Major field, int entranceYear) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.nationalCode = nationalCode;
        this.password = password;
        this.passedLessons = passedLessons;
        this.currentLessons = currentLessons;
        this.field = field;
        this.entranceYear = entranceYear;
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

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getMaxUnit() {
        return maxUnit;
    }

    public ArrayList<Lesson> getPassedLessons() {
        return passedLessons;
    }

    public void setPassedLessons(ArrayList<Lesson> passedLessons) {
        this.passedLessons = passedLessons;
    }

    public ArrayList<Lesson> getCurrentLessons() {
        return currentLessons;
    }

    public void setCurrentLessons(ArrayList<Lesson> currentLessons) {
        this.currentLessons = currentLessons;
    }

    public Major getField() {
        return field;
    }

    public void setField(Major field) {
        this.field = field;
    }



    public ArrayList<Lesson> getReadLessons() {
        return readLessons;
    }

    public void setReadLessons(ArrayList<Lesson> readLessons) {
        this.readLessons = readLessons;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public Map<Integer, List<Float>> getGPAs() {
        return GPAs;
    }

    public void setGPAs(Map<Integer, List<Float>> GPAs) {
        this.GPAs = GPAs;
    }

    public List<Integer> getGPAAndUnits() {
        return GPAAndUnits;
    }

    public void setGPAAndUnits(List<Integer> GPAAndUnits) {
        this.GPAAndUnits = GPAAndUnits;
    }

    public Map<Lesson, Double> getScores() {
        return scores;
    }

    public void setScores(Map<Lesson, Double> scores) {
        this.scores = scores;
    }

    public static void studentMenu(ArrayList<Student> students){
        Scanner scanner = new Scanner(System.in);
        Student student = null;
        System.out.println("id number :");
        String id = scanner.next();
        System.out.println("Password :");
        String password = scanner.next();
        for (Student s:students){
            if (s.getIdNumber().equals(id) && s.getPassword().equals(password)){
                student = s;
                break;
            }
        }if (student==null){
            System.out.println("not");
            boolean isFoundId = false;
            boolean isCorrectPass = false;
            for (Student s:students){
                if (s.getIdNumber().equals(id)){
                    isFoundId = true;
                    break;
                }
            }
            for (Student s:students){
                if (s.getPassword().equals(password)){
                    isCorrectPass = true;
                    break;
                }
            }
            if (!isFoundId){
                System.out.println("user not found!(you may enter wrong id number)");
            }else if (!isCorrectPass){
                System.out.println("password is not correct!");
            }
        }else {
            System.out.println("0 : Leave a class");
            System.out.println("1 : Show student courses and grades");
            System.out.println("2 : Edit password");
            System.out.println("9 : Exit");
            String answer = scanner.next();
            switch (answer){
                case "0":
                    System.out.println("Enter Class id:");
                    String classId = scanner.next();
                    Lesson lesson = null;
                    for (Lesson l:student.getCurrentLessons()){
                        if (l.getID().equals(classId)){
                            lesson = l;
                            break;
                        }
                    }
                    if (lesson==null){
                        System.out.println("this lesson is not in your current class lists(you may enter wrong class id)");
                    }else {
                        System.out.println("You want to remove this lesson from your current lessons list.Are you sure?(Y,N)");
                        String result = scanner.next();
                        if (result.equals("y")){
                            ArrayList<Lesson> lessons = student.getCurrentLessons();
                            lessons.remove(lesson);
                            student.setCurrentLessons(lessons);
                            ArrayList<Student> students1 = lesson.getStudents();
                            students1.remove(student);
                            lesson.setStudents(students1);
                            lesson.getRemainedCapacity();
                            System.out.println("successfully deleted.");
                            System.out.println(showClasses(student));
                        }else if (result.equals("n")){
                            System.out.println("Lesson is not deleted.");
                        }
                    }
                    break;

                case "1":
                    for (Student s:students){
                        System.out.println(s.getGPAAndUnits());
                    }
                    break;
                case "2":
                    System.out.println("Enter new password:");
                    String pass = scanner.next();
                    student.setPassword(pass);
                    System.out.println("Your new password is: "+student.getPassword());
                    break;
                case "9":
                    MenuDetails.startMenu();
                    break;
            }
        }
    }

    /**
     * This method add student to university
     * @param students
     */
    public static void addStudent(ArrayList<Student> students){
        Scanner scanner = new Scanner(System.in);
        System.out.println("first name:");
        String firstName = scanner.next();
        System.out.println("last name:");
        String lastName = scanner.next();
        System.out.println("id:");
        String id = scanner.next();
        System.out.println("nationalCode:");
        String nationalCode = scanner.next();
        System.out.println("field:");
        String field = scanner.next();
        System.out.println("average of last term in this field:");
        double average = scanner.nextInt();
        System.out.println("Entrance year:");
        int year = scanner.nextInt();
        System.out.println("Do you want to select units for this student right now?(Y,N)");
        String choice = scanner.next();
        if (choice.equals("y")){
            System.out.println("Enter lesson id:");
            String classId = scanner.next();
            MenuDetails.selectUnit(classId,id);
        }
        else if (choice.equals("n")){
            Student student = new Student(firstName,lastName,id,nationalCode,nationalCode,null,null,new Major(field, average),year);
//            students.add(student);
            FileDetails.saveStudents(students, student);
            System.out.println(student.toString());
        }
    }

    /**
     *
     * @param student
     * @return student details
     */
    public static String showClasses(Student student) {
        return "Student{" +
                "currentLessons=" + student.getCurrentLessons() +
                '}';
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", password='" + password + '\'' +
                ", passedLessons=" + passedLessons +
                ", currentLessons=" + currentLessons +
                ", field='" + field + '\'' +
                ", entranceYear=" + entranceYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return entranceYear == student.entranceYear && Objects.equals(firstname, student.firstname) && Objects.equals(lastName, student.lastName) && Objects.equals(idNumber, student.idNumber) && Objects.equals(nationalCode, student.nationalCode) && Objects.equals(password, student.password) && Objects.equals(passedLessons, student.passedLessons) && Objects.equals(currentLessons, student.currentLessons) && Objects.equals(readLessons, student.readLessons) && Objects.equals(field, student.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, idNumber, nationalCode, password, passedLessons, currentLessons, readLessons, field, entranceYear);
    }
}
