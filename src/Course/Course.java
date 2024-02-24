package Course;
import Controller.Sttuf;
import View.Student;

public class Course {
    public Sttuf sttuf;
    public Course(Sttuf sttuf){
        this.sttuf = sttuf;
    }
    public void seeStudent(String lessonName){
        for(General general : sttuf.getGenerals()){
            if(general.getLessonName().equals(lessonName)){
                System.out.println("The List of Students is :");
                for (Student student: general.students){
                    System.out.println(student.getName() + " " + student.getCode());
                }
                System.out.println();
                break;
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(special.getLessonName().equals(lessonName)){
                System.out.println("The List of Students is :");
                for (Student student: special.students){
                    System.out.println(student.getName() + " " + student.getCode());
                }
                System.out.println();
                break;
            }
        }
    }
}
