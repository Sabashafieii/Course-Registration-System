import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * save read and update files here
 */
public class FileDetails {

    /**
     * save students in file
     * @param students
     * @param student
     */
    public static void saveStudents(ArrayList<Student> students, Student student){
        students.add(student);
        
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Students.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(students);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> readStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Students.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Student student:students){
            System.out.println(student.toString());
        }
        return students;
    }
    public static void updateStudents(ArrayList<Student> students){
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Students.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(students);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveSubjects(ArrayList<Lesson> lessons, Lesson lesson){
        lessons.add(lesson);
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Subjects.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(lessons);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Lesson> readSubjects(){
        ArrayList<Lesson> lessons = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Subjects.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            lessons = (ArrayList<Lesson>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Lesson lesson:lessons){
            System.out.println(lesson.toString());
        }
        return lessons;
    }

    public static void updateSubjects(ArrayList<Lesson> lessons){
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Subjects.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(lessons);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveProfessors(ArrayList<Professor> professors, Professor professor){
        professors.add(professor);
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Professors.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(professors);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Professor> readProfessors(){
        ArrayList<Professor> professors = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Professors.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            professors = (ArrayList<Professor>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Professor professor:professors){
            System.out.println(professor.toString());
        }
        return professors;
    }
    public static void updateProfessors(ArrayList<Professor> professors){
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Professors.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(professors);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveMajors(ArrayList<Major> majors, Major major){
        majors.add(major);
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Majors.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(majors);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Major> readMajors(){
        ArrayList<Major> majors = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Majors.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            majors = (ArrayList<Major>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Major major:majors){
            System.out.println(major.toString());
        }
        return majors;
    }
    public static void updateMajors(ArrayList<Major> majors){
        try {
            FileOutputStream fut=new  FileOutputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Majors.txt");
            ObjectOutputStream out=new  ObjectOutputStream(fut);
            out.writeObject(majors);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readFromFile(ArrayList<Student> students,ArrayList<Lesson>lessons,ArrayList<Professor> professors,ArrayList<Major> majors){
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Majors.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            majors = (ArrayList<Major>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Professors.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            professors = (ArrayList<Professor>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Subjects.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            lessons = (ArrayList<Lesson>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\selectUnit (4).zip_expanded\\selectUnit\\Students.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
