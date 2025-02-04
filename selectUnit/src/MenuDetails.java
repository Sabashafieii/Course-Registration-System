import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuDetails {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Lesson> lessons = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();
    static ArrayList<Major> majors = new ArrayList<>();

    /**
     * this method starts the menu
     */
    public static void startMenu(){
        System.out.println("Enter admin username :(that will be admin username until the program close.So keep it)");
        String username = scanner.next();
        System.out.println("Enter admin password :(that will be admin password until the program close.So keep it)");
        String password = scanner.next();
        while (true){
            System.out.println("0 : Admin");
            System.out.println("1 : Student");
            System.out.println("2 : Professor");
            System.out.println("3 : Subject");
            String answer = scanner.next();
            switch (answer){
                case "0":
                    adminMenu(username, password);
                    break;
                case "1":
                    Student.studentMenu(students);
                    break;
                case "2":
                    Professor.professorMenu();
                    break;
                case "3":
                    Lesson.lessonMainMenu(lessons);
                    break;
            }
        }
    }

    /**
     * admin menu
     * @param userN
     * @param pass
     */
    public static void adminMenu(String userN, String pass){
        System.out.println("Admin Username :");
        String username = scanner.next();
        System.out.println("Admin Password :");
        String password = scanner.next();
        if (username.equals(userN) && password.equals(pass)){
            System.out.println("1 :  professor part");
            System.out.println("2 :  Subject part");
            System.out.println("3 :  Major part");
            System.out.println("4 :  student part");
            System.out.println("9 : Exit");
            String answer = scanner.next();
            switch (answer){
                case "1":
                    System.out.println("1-Add professor 2-show all professors 9-Exit");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            MenuDetails.professors = FileDetails.readProfessors();
                            Professor.addProfessor(professors);
                            break;
                        case 2:
                            FileDetails.readProfessors();
                            break;
                        case 9:
                            adminMenu(userN,pass);
                            break;
                    }
                    break;
                case "2":
                    System.out.println("1-Add a course 2-Show all courses 3-Edit a course  9-Exit");
                    int answer2 = scanner.nextInt();
                    switch (answer2){
                        case 1:
                            Lesson.addLesson();
                            break;
                        case 2:
                            Lesson.showAllDeclaredClasses();
                            break;
                        case 3:
                            Lesson.editLesson();
                            break;
                        case 9:
                            adminMenu(userN,pass);
                            break;
                    }
                    break;
                case "3":
                    Major.MajorMenu(lessons, majors);
                    break;

                case "4":
                    System.out.println("1-Add student 2-Show All students 3-Take course 4-Add student's subject score 9-Exit");
                    int ans = scanner.nextInt();
                    switch (ans){
                        case 1:
                            Student.addStudent(students);
                            break;
                        case 2:
                            MenuDetails.students = FileDetails.readStudents();
                            break;
                        case 3:
                            System.out.println("Enter class id:");
                            String classId = scanner.next();
                            System.out.println("Enter student id:");
                            String studentId = scanner.next();
                            selectUnit(classId ,studentId);
                            break;
                        case 4:
                            System.out.println("Enter lesson id:");
                            String classId2 = scanner.next();
                            System.out.println("Enter student id:");
                            String studentId2 = scanner.next();
                            for (Student student:students){
                                if (student.getIdNumber().equals(studentId2)){
                                    for (Lesson lesson:student.getCurrentLessons()){
                                        if (lesson.getID().equals(classId2)){
                                            System.out.println("Enter course score:");
                                            Double score = scanner.nextDouble();
                                            student.setScores((Map<Lesson, Double>) new HashMap<>().put(lesson,score));
                                            FileDetails.updateStudents(students);
                                        }
                                    }
                                }else {
                                    System.out.println("Student not found");
                                }
                            }
                            break;
                        case 9:
                            adminMenu(userN,pass);
                            break;
                    }
                    break;
                    case "9":
                    startMenu();
                    break;
            }
        }
        else {
            if (!userN.equals(username)){
                System.out.println("user not found!(you may enter wrong username)");
            }else{
                System.out.println("password is not correct!");
            }
        }
    }

    /**
     * this method do all we need to select unit
     * @param lessonId
     * @param studentId
     */
    public static void selectUnit(String lessonId ,String studentId){

        boolean isFoundStudent = false;
        boolean isFoundLesson = false;
        MenuDetails.lessons = FileDetails.readSubjects();

        for (Lesson lesson:MenuDetails.lessons){
            if (lesson.getID().equals(lessonId)){
                isFoundLesson = true;
                for (Student student:MenuDetails.students){
                    if (student.getIdNumber().equals(studentId)){
                        isFoundStudent = true;
                        if (checkCollision(lesson ,student) && checkPrerequisites(lesson ,student) && checkCapacity(lesson) && checkAccommodation(lesson ,student)){
                            int sumOfUnits = 0;
                            if (student.getCurrentLessons()==null){
                                sumOfUnits = 0;
                            }else {
                                for (Lesson lesson1:student.getCurrentLessons()){
                                    sumOfUnits += lesson1.getUnitNumber();
                                }
                            }
                            if (student.getMaxUnit() >= sumOfUnits + lesson.getUnitNumber()){
                                if (!student.getCurrentLessons().contains(lesson)){
                                    ArrayList<Student> students = lesson.getStudents();
                                    students.add(student);
                                    lesson.setStudents(students);
                                    lesson.getRemainedCapacity();
                                    ArrayList<Lesson> lessons = student.getCurrentLessons();
                                    lessons.add(lesson);
                                    student.setCurrentLessons(lessons);
                                    System.out.println("The student successfully joined to this class!");
                                    System.out.println(Student.showClasses(student));
                                    FileDetails.updateStudents(MenuDetails.students);
                                    FileDetails.updateSubjects(MenuDetails.lessons);
                                }else {
                                    System.out.println("student has joint to this class before!");
                                }

                            }else {
                                System.out.println("Sum of units is more than allowed limit");
                            }
                        }else {
                            System.out.println("Sorry!");
                        }
                        break;
                    }
                }
                if (!isFoundStudent){
                    System.out.println("This student has not been declared yet(you may enter wrong student id)");
                }
                break;
            }
        }
        if (!isFoundLesson){
            System.out.println("This lesson has not been declared yet(you may enter wrong class id)");
        }
    }

    /**
     *
     * @param lesson
     * @param student
     * @return true if the Prerequisites have been passed or the class has no Prerequisite
     */
    public static boolean checkPrerequisites(Lesson lesson, Student student){
        if (lesson.getPrerequisitesLessons() == null){
            return true;
        }else if(student.getPassedLessons()==null){
            if (lesson.getPrerequisitesLessons()==null){
                return true;
            }
        }
        else {
            for (Lesson lesson1:lesson.getPrerequisitesLessons()){
                if (!student.getPassedLessons().contains(lesson1)){
                    System.out.println("Some prerequisites have not been passed yet!");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param lesson
     * @param student
     * @return true if there is no collision
     */
    public static boolean checkCollision(Lesson lesson, Student student){
        for (Lesson lesson1:student.getCurrentLessons()){
            if (lesson1.getHour()==lesson.getHour()){
                System.out.println("This lesson has collision with other lessons");
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param lesson
     * @return true if the class is not full
     */
    public static boolean checkCapacity(Lesson lesson){
        if (lesson.getRemainedCapacity()<=0){
            System.out.println("This class is full!");
            return false;
        }else {
            return true;
        }
    }

    /**
     *
     * @param lesson
     * @param student
     * @return true if the lesson is appropriate for major and entrance
     */
    public static boolean checkAccommodation(Lesson lesson, Student student){
        if (!lesson.getFields().contains(student.getField()) ){
            System.out.println("This lesson is not appropriate for this major");
            return false;
        }if (!(lesson.getEntranceYears().contains(student.getEntranceYear()))){
            System.out.println("This lesson is not appropriate for this entrance");
            return false;
        }
        return true;
    }

}
