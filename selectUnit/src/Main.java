import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        utilities(MenuDetails.students,MenuDetails.lessons, MenuDetails.professors,MenuDetails.majors);
        try{
            MenuDetails.startMenu();
        }catch (Exception e){
            System.out.println("Error!");
        }
        
        FileDetails.updateSubjects(MenuDetails.lessons);
        FileDetails.updateStudents(MenuDetails.students);
        FileDetails.updateProfessors(MenuDetails.professors);
        FileDetails.updateMajors(MenuDetails.majors);

    }

    /**
     * This method add some student and lesson and add to lessons List and Students list(in Menu class)
     * @param students of University
     * @param lessons provided in University
     * @param professors of University
     * @param majors Majors in the University
     */
    public static void utilities(ArrayList<Student> students,ArrayList<Lesson>lessons,ArrayList<Professor> professors,ArrayList<Major> majors){

        FileDetails.readFromFile(students, lessons, professors, majors);

        ArrayList<Integer> entrances = new ArrayList<>();
        entrances.add(1395);
        entrances.add(1396);
        entrances.add(1399);
        ArrayList<Major> fields = new ArrayList<>();
        fields.add(new Major("Math",16));
        fields.add(new Major("Engineering",16));
        fields.add(new Major("physics",16));
        ArrayList<Lesson> lessons2 = new ArrayList<>();
        lessons2.add(new Lesson("science","5643"));
        ArrayList<Student> students2 = new ArrayList<>();
        ArrayList<Lesson> optionalLessons = new ArrayList<>();
        TemporaryProfessor temporaryProfessor1 = new TemporaryProfessor("ali","karimi", "112", "1234",15,24);
        TemporaryProfessor temporaryProfessor2 = new TemporaryProfessor("mohsen","kahe", "115", "1114",15,24);
        HiredProfessor hiredProfessor1 = new HiredProfessor("kave","firooz", "111", "112214",15,12);
        optionalLessons.add(new Lesson("religious",temporaryProfessor1,"5040",2,3,60,entrances,fields,null,students));
        Lesson physics1 = new Lesson("physics1",temporaryProfessor2,"5056",3,7,60,entrances,fields,null,students);
        Lesson math1 = new Lesson("Math1",hiredProfessor1,"5054",3,5,60,entrances,fields,null,students);
        Lesson literature = new Lesson("literature",temporaryProfessor1,"5058",2,1,60,entrances,fields,null,students);
        Major computer = new Major("computer", 18, "computerEngineering",lessons,optionalLessons );
        Major electricity = new Major("electricity", 17, "electricityEngineering",lessons,optionalLessons );
        Major mechanic = new Major("mechanic", 16, "mechanicEngineering",lessons,optionalLessons );
        students.add(new Student("nima","valaye","9910278964","5445646","5445646",null,lessons,computer,1399));
        students.add(new Student("sara","moradi","9910256348","8454684","8454684",null,lessons,electricity,1399));
        students.add(new KnowledgeableStudent("sina", "sori","44655656","45554545848","45554545848", lessons,new ArrayList<Lesson>(Collections.singleton(new Lesson("advancedPhysics", temporaryProfessor2, "5056", 3, 7, 60, entrances, fields, null, students))),computer,1397,mechanic));
        students.add(new MasterStudent("mahla","abbasi","9523647","984448887", "984448887", lessons, new ArrayList<Lesson>(Collections.singleton(new Lesson("advancedMath", temporaryProfessor2, "5085", 3, 7, 60, entrances, fields, null, students))), computer, 1395));
        lessons.add(physics1);
        lessons.add(math1);
        lessons.add(literature);
        professors.add(temporaryProfessor1);
        professors.add(temporaryProfessor2);
        professors.add(hiredProfessor1);
        majors.add(computer);
        majors.add(electricity);
        majors.add(mechanic);

        FileDetails.updateStudents(students);
        FileDetails.updateSubjects(lessons);
        FileDetails.updateProfessors(professors);
        FileDetails.updateMajors(majors);

    }
}
