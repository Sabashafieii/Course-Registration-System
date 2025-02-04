import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Lesson implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4077613019291048197L;
	private String name;
    transient private Professor professor;
    private String ID;
    private int unitNumber;
    private int hour;
    private int capacity ;
    private int maxCapacity ;
    private ArrayList<Integer> entranceYears = new ArrayList<>();
    private ArrayList<Major> fields = new ArrayList<>();
    private ArrayList<Lesson> prerequisitesLessons = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private int remainedCapacity = capacity - students.size();

    public Lesson(String ID) {
        this.ID = ID;
    }

    public Lesson(String name,  String ID) {
        this.name = name;
        this.ID = ID;
    }


    public Lesson(String name, Professor professor, String ID, int unitNumber, int hour, int maxCapacity, ArrayList<Integer> entranceYears, ArrayList<Major> fields, ArrayList<Lesson> prerequisitesLessons, ArrayList<Student> students) {
        this.name = name;
        this.professor = professor;
        this.ID = ID;
        this.unitNumber = unitNumber;
        this.hour = hour;
        this.maxCapacity = maxCapacity;
        this.entranceYears = entranceYears;
        this.fields = fields;
        this.prerequisitesLessons = prerequisitesLessons;
        this.students = students;
        if (students==null){
            remainedCapacity = maxCapacity;
        }else {
            remainedCapacity = maxCapacity-students.size();
        }
        if (students==null){
            capacity = 0;
        }else {
            capacity = maxCapacity - students.size();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getCapacity() {
        if (students==null){
            capacity = 0;
        }else {
            capacity = students.size();
        }
        return capacity;
    }

    public ArrayList<Integer> getEntranceYears() {
        return entranceYears;
    }

    public void setEntranceYears(ArrayList<Integer> entranceYears) {
        this.entranceYears = entranceYears;
    }

    public ArrayList<Major> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Major> fields) {
        this.fields = fields;
    }


    public ArrayList<Lesson> getPrerequisitesLessons() {
        return prerequisitesLessons;
    }

    public void setPrerequisitesLessons(ArrayList<Lesson> prerequisitesLessons) {
        this.prerequisitesLessons = prerequisitesLessons;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     *
     * @return and calculate remained capacity of the class
     */
    public int getRemainedCapacity() {
        if (students==null){
            remainedCapacity = maxCapacity;
        }else {
            remainedCapacity = maxCapacity - students.size();
        }
        return remainedCapacity;
    }

    public void increaseCapacity(){
        System.out.println("Enter the value added to the class capacity :");
        Scanner scanner = new Scanner(System.in);
        String added = scanner.next();
        capacity = capacity + Integer.parseInt(String.valueOf(added));
        scanner.close();
    }

    /**
     *
     * @param lessons
     */
    public static void lessonMainMenu(ArrayList<Lesson> lessons){
        Scanner scanner = new Scanner(System.in);
        boolean isFoundLesson = false;
        System.out.println("Enter class ID:");
        String id = scanner.next();

        for (Lesson lesson:lessons){
            if (lesson.getID().equals(id)){
                isFoundLesson = true;
                System.out.println("1-show related students 2-Edit capacity 9-Exit");
                int res = scanner.nextInt();
                if (res==1){
                    for (Student s:lesson.getStudents()){
                        System.out.println(s.toString());
                    }
                }
                else if (res==2){
                    System.out.println("Enter new maxCapacity:");
                    int capacity = scanner.nextInt();
                    lesson.setMaxCapacity(capacity);
                    lesson.getRemainedCapacity();
                    lesson.getCapacity();
                    System.out.println("Edited successfully");
                    System.out.println(lesson.toString());
                }
                else if (res==9){
                    MenuDetails.startMenu();
                }
                FileDetails.updateSubjects(lessons);
            }
        }if (!isFoundLesson){
            System.out.println("class not found");
        }
    }

    /**
     * this method add a lesson to lessons list
     */
    public static void addLesson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lesson name:");
        String name = scanner.next();
        System.out.println("teacher name:");
        String teacherName = scanner.next();
        System.out.println("teacher id:");
        String teacherID = scanner.next();
        System.out.println("id:");
        String id = scanner.next();
        System.out.println("unit number:");
        int unitNumber = scanner.nextInt();
        System.out.println("class time:(1-8)");
        int hour = scanner.nextInt();
        if (hour>8 || hour<1){
            System.out.println("Your input must be between 1-8");
            addLesson();
        }
        System.out.println("capacity:");
        int capacity = scanner.nextInt();
        System.out.println("Max capacity:");
        int maxCapacity = scanner.nextInt();
        System.out.println("Enter entrance years:(Enter 0 to stop)");
        ArrayList<Integer> years = new ArrayList<>();
        while (true){
            int year = scanner.nextInt();
            if (year==0){
                break;
            }
            years.add(year);
        }
        System.out.println("Enter related fields:(Enter 0 to stop)");
        ArrayList<Major> fields = new ArrayList<>();
        while (true){
            String field = scanner.next();
            if (field.equals("0")){
                break;
            }
            fields.add(new Major(field, 0));
        }
        System.out.println("Enter Prerequisites lessons:(Enter 0 to stop)");
        ArrayList<Lesson> lessons = new ArrayList<>();
        while (true){
            System.out.println("Enter lesson name:");
            String lessonName = scanner.next();
            if (lessonName.equals("0")){
                break;
            }
            System.out.println("Enter lesson id:");
            String lessonId = scanner.next();
            Lesson lesson = new Lesson(lessonName,lessonId);
            lessons.add(lesson);
        }
        System.out.println("You can also add students to the class in selectUnit part");
        Lesson lesson = new Lesson(name,new Professor(teacherName, teacherID),id,unitNumber,hour,maxCapacity,years,fields,lessons,null);
        lesson.getRemainedCapacity();
//        MenuDetails.lessons.add(lesson);
        FileDetails.saveSubjects(MenuDetails.lessons, lesson);
        System.out.println(lesson.toString());
    }

    /**
     * this method edit a lesson except for its id
     */
    public static void editLesson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter class id:");
        String id = scanner.next();
        boolean isFondLesson = false;
        for (Lesson lesson:MenuDetails.lessons){
            if (lesson.getID().equals(id)){
                isFondLesson = true;
                System.out.println(lesson.toString());
                System.out.println("Select a choice:");
                System.out.println("1-Edit name 2-Edit teacher name 3-Edit max capacity 4-Edit unit number 5-edit class time  ");
                System.out.println("6-Edit entrance years 7-Edit students 8-Edit related fields 9-Edit prerequisitesLessons 10-Delete lesson");
                String answer = scanner.next();
                switch (answer){
                    case "1":
                        System.out.println("Enter new class name:");
                        String name = scanner.next();
                        lesson.setName(name);
                        System.out.println("Edited successfully");
                        System.out.println(lesson.toString());
                        break;
                    case "2":
                        System.out.println("Enter new teacher id:");
                        String teacherID = scanner.next();
                        lesson.setProfessor(new Professor(teacherID));
                        System.out.println("Edited successfully");
                        System.out.println(lesson.toString());
                        break;
                    case "3":
                        System.out.println("Enter new maxCapacity:");
                        int capacity = scanner.nextInt();
                        lesson.setMaxCapacity(capacity);
                        lesson.getRemainedCapacity();
                        System.out.println("Edited successfully");
                        System.out.println(lesson.toString());
                        break;
                    case "4":
                        System.out.println("Enter new unit number:");
                        int unit = scanner.nextInt();
                        lesson.setUnitNumber(unit);
                        System.out.println("Edited successfully");
                        System.out.println(lesson.toString());
                        break;
                    case "5":
                        System.out.println("Enter new class time:");
                        int time = scanner.nextInt();
                        if (time<=8 && time>=1){
                            lesson.setHour(time);
                            System.out.println("Edited successfully");
                            System.out.println(lesson.toString());
                        }else {
                            System.out.println("Your input must be between (1-8)");
                            editLesson();
                        }
                        break;
                    case "6":
                        System.out.println("1-Add to related entrance years 2-remove a year from entrance year");
                        int ans = scanner.nextInt();
                        if (ans==1){
                            System.out.println("Enter new entrance year:");
                            int year = scanner.nextInt();
                            ArrayList<Integer> years = lesson.getEntranceYears();
                            years.add(year);
                            lesson.setEntranceYears(years);
                            System.out.println("Edited successfully");
                            System.out.println(lesson.toString());

                        }else if (ans==2){
                            System.out.println("Enter entrance year:");
                            int year = scanner.nextInt();
                            ArrayList<Integer> years = lesson.getEntranceYears();
                            if (years.contains(year)){
                                years.remove(year);
                                lesson.setEntranceYears(years);
                                System.out.println("Edited successfully");
                                System.out.println(lesson.toString());
                            }else {
                                System.out.println("This year is not between entrance years(you may enter wrong year)");
                                editLesson();
                            }
                        }
                        break;
                    case "7":
                        System.out.println("1-Add student to class 2-remove student fom class");
                        int res = scanner.nextInt();
                        if (res==1){
                            Student student = null;
                            System.out.println("Enter student id");
                            String studentId = scanner.next();
                            MenuDetails.selectUnit(lesson.getID(),studentId);
                        }else if (res==2){
                            Student student = null;
                            System.out.println("Enter student id");
                            String studentId = scanner.next();
                            for (Student s:MenuDetails.students){
                                if (s.getIdNumber().equals(studentId)){
                                    student = s;
                                    break;
                                }
                            }
                            if (student==null){
                                System.out.println("This student has not been declared yet(you may enter wrong student id)");
                            }else {
                                ArrayList<Student> students = lesson.getStudents();
                                if (students.contains(student)){
                                    students.remove(student);
                                    lesson.setStudents(students);
                                    ArrayList<Lesson> lessons = student.getCurrentLessons();
                                    lessons.remove(lesson);
                                    student.setCurrentLessons(lessons);
                                    lesson.getRemainedCapacity();
                                    System.out.println("Edited successfully");
                                    System.out.println(lesson.toString());
                                }else {
                                    System.out.println("This student is not in the class");
                                }
                            }
                        }
                        break;
                    case "8":
                        System.out.println("1-Add new field to related fields 2-remove a field from list");
                        int choice = scanner.nextInt();
                        if (choice==1){
                            System.out.println("Enter field:");
                            String field = scanner.next();
                            ArrayList<Major> fields = lesson.getFields();
                            fields.add(new Major(field, 0));
                            lesson.setFields(fields);
                            System.out.println("Edited successfully");
                            System.out.println(lesson.toString());
                        }else if (choice==2){
                            System.out.println("Enter field:");
                            String field = scanner.next();
                            ArrayList<Major> fields = lesson.getFields();
                            fields.remove(field);
                            lesson.setFields(fields);
                            System.out.println("Edited successfully");
                            System.out.println(lesson.toString());
                        }
                        break;
                    case "9":
                        System.out.println("1-Add a lesson to prerequisitesLessons 2-remove a lesson from prerequisitesLessons");
                        int n = scanner.nextInt();
                        if (n==1){
                            System.out.println("Lesson name:");
                            String lessonName = scanner.next();
                            System.out.println("id:");
                            String lessonId = scanner.next();
                            Lesson lesson1 = new Lesson(lessonName,lessonId);
                            ArrayList<Lesson> pre = lesson.getPrerequisitesLessons();
                            pre.add(lesson1);
                            lesson.setPrerequisitesLessons(pre);
                            System.out.println("Edited successfully");
                            System.out.println(lesson.toString());
                        }else if (n==2){
                            System.out.println("prerequisite lesson name:");
                            String lessonName = scanner.next();
                            System.out.println("id:");
                            String lessonId = scanner.next();
                            Lesson lesson1 = new Lesson(lessonName,lessonId);
                            ArrayList<Lesson> pre = lesson.getPrerequisitesLessons();
                            if (pre.contains(lesson1)){
                                pre.remove(lesson1);
                                lesson.setPrerequisitesLessons(pre);
                                System.out.println("Edited successfully");
                                System.out.println(lesson.toString());
                            }else {
                                System.out.println("This lesson is not in prerequisitesLessons list");
                            }
                        }
                        break;
                    case "10":
                        MenuDetails.lessons.remove(lesson);
                        showAllDeclaredClasses();
                        break;
                }
                FileDetails.updateSubjects(MenuDetails.lessons);
                break;
            }
        }
        if (!isFondLesson){
            System.out.println("This class has not been declared yet(you may enter wrong class id)");
        }
    }
    public static void showAllDeclaredClasses(){
        System.out.println("All declared classes List :");
        MenuDetails.lessons = FileDetails.readSubjects();
        for (Lesson lesson:MenuDetails.lessons){
            System.out.println(lesson.toString());
        }
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", professor='" + professor + '\'' +
                ", ID='" + ID + '\'' +
                ", unitNumber=" + unitNumber +
                ", hour=" + hour +
                ", capacity=" + capacity +
                ", entranceYears=" + entranceYears +
                ", fields=" + fields +
                ", prerequisitesLessons=" + prerequisitesLessons +
                ", remainedCapacity=" + remainedCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(name, lesson.name) &&
                Objects.equals(ID, lesson.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }
}
