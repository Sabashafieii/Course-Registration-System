import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Major implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3365950438698136689L;
	private String name;
    private final double averageOfLastTerm ;
    private String college;
    private ArrayList<Lesson> mandatoryLessons = new ArrayList<>();
    private ArrayList<Lesson> voluntaryLessons = new ArrayList<>();


    public Major(double averageOfLastTerm) {
        this.averageOfLastTerm = averageOfLastTerm;
    }

    public Major(String name, double averageOfLastTerm, String college, ArrayList<Lesson> necessaryLessons, ArrayList<Lesson> optionalLessons) {
        this.name = name;
        this.averageOfLastTerm = averageOfLastTerm;
        this.college = college;
        this.mandatoryLessons = necessaryLessons;
        this.voluntaryLessons = optionalLessons;
        for (Lesson lesson:necessaryLessons){
            lesson.setFields(new ArrayList<Major>(Collections.singleton(this)));
        }
    }

    public Major(String name, double averageOfLastTerm) {
        this.name = name;
        this.averageOfLastTerm = averageOfLastTerm;
    }

    public double getAverageOfLastTerm() {
        return averageOfLastTerm;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public ArrayList<Lesson> getMandatoryLessons() {
        return mandatoryLessons;
    }

    public void setMandatoryLessons(ArrayList<Lesson> mandatoryLessons) {
        this.mandatoryLessons = mandatoryLessons;
    }

    public ArrayList<Lesson> getVoluntaryLessons() {
        return voluntaryLessons;
    }

    public void setVoluntaryLessons(ArrayList<Lesson> voluntaryLessons) {
        this.voluntaryLessons = voluntaryLessons;
    }

    @Override
    public String toString() {
        return "FieldOfStudy{" +
                "name='" + name + '\'' +
                ", averageOfLastTerm=" + averageOfLastTerm +
                ", college='" + college + '\'' +
                ", necessaryLessons=" + mandatoryLessons +
                ", optionalLessons=" + voluntaryLessons +
                '}';
    }

    /**
     *
     * @param lessons All declared classes in this university
     * @param majors All declared Majors in this university
     */
    public static void MajorMenu(ArrayList<Lesson> lessons, ArrayList<Major> majors){
        System.out.println("1-Add 2-Show all majors 3-Add Course to major 9-Exit");
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        switch (ans){
            case 1:
                System.out.println("name:");
                String name = scanner.next();
                System.out.println("Average of last term:");
                double av = scanner.nextDouble();
//                majors.add(new Major(name,av));
                FileDetails.saveMajors(majors, new Major(name, av));
                break;
            case 2:
                MenuDetails.majors = FileDetails.readMajors();
                break;
            case 3:
                System.out.println("1-Voluntary 2-mandatory");
                int res = scanner.nextInt();
                switch (res){
                    case 1:
                        System.out.println("Enter voluntary lessons Id (in a line)");
                        ArrayList<Lesson> voluntaryLessons= new ArrayList<>();
                        String []ids2 = scanner.nextLine().split(" ");
                        for (String id:ids2){
                            for (Lesson l:lessons){
                                if (l.getID().equals(id)){
                                    voluntaryLessons.add(l);
                                }
                            }
                        }
                        for (Major major:majors){
                            ArrayList<Lesson> voluntaryLessonsArray=major.getVoluntaryLessons();
                            voluntaryLessonsArray.addAll(voluntaryLessons);

                            major.setVoluntaryLessons(voluntaryLessonsArray);

                        }
                        FileDetails.updateMajors(majors);
                        break;

                    case 2:
                        System.out.println("Enter mandatory lessons Id (in a line)");
                        ArrayList<Lesson> mandatoryLessons= new ArrayList<>();
                        String []ids = scanner.nextLine().split(" ");
                        for (String id:ids){
                            for (Lesson l:lessons){
                                if (l.getID().equals(id)){
                                    mandatoryLessons.add(l);
                                }
                            }
                        }
                        for (Major major:majors){
                            if (mandatoryLessons!=null){
                                ArrayList<Lesson> mandatoryLessonsArray=new ArrayList<>();
                                mandatoryLessonsArray=major.getVoluntaryLessons();
                                mandatoryLessonsArray.addAll(mandatoryLessons);
                                major.setMandatoryLessons(mandatoryLessonsArray);

                            }
                        }
                        FileDetails.updateMajors(majors);
                        break;
                }
                break;
            case 9:
                MenuDetails.startMenu();
                break;
            }
        }
    }
