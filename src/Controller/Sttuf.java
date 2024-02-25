package Controller;
import Course.*;
import View.*;
import java.util.ArrayList;

public class Sttuf {
    private ArrayList<General> generals = new ArrayList<>();
    private ArrayList<Special> specials = new ArrayList<>();
    private ArrayList<Student> AllofStudents = new ArrayList<>();
    public void AddGeneral(General general){
        generals.add(general);
    }
    public void AddSpecial(Special special){
        specials.add(special);
    }
    public void AddStudnet(Student student){
        for(Student student1 : AllofStudents){
            if(student1.getName().equals(student.getName()) && student1.getCode().equals(student.getCode())){
                System.out.println("You Have Been Register Before!");
                return;
            }
        }
        AllofStudents.add(student);
        System.out.println("You Have Register Successfuly!!");

    }
    public boolean AddStuSp(String CodeOfStudent, Sttuf sttuf, Special special){
        for(Student student : sttuf.getAllofStudents()){
            if(student.getCode().equals(CodeOfStudent)){
                if(student.getCountOfgeneral() + student.getCountOfspecil() + special.getUnit()> 20){
                    System.out.println("\nSorry you Cant have more than 20 Unit!\n");
                    return false;
                }
                if(special.getCapacity()== 0){
                    System.out.println("\nSorry you Cant have this Lesson because this lesson if Full!!\n");
                    return false;
                }
                if(student.TadaKhold(special.getExamDay(), special.getClassDay(), special.getStartOfExam(), special.getEndOfExam(), special.getStartOfClass(), special.getEndOfClass())){
                    System.out.println("\nSorry you Cant have this Lesson because Two of your courses overlap!!\n");
                    return false;
                }
                special.setCapacity(special.getCapacity() - 1);
                special.addStudent(student);
                student.AddSpecial(special);
                System.out.println("\n Done!\n");
                return true;
            }
        }
        System.out.println("You are Not Register to The System !");
        return false;
    }

    public boolean AddStuGn(String CodeOfStudent, Sttuf sttuf, General general){
        for(Student student : sttuf.getAllofStudents()){
            if(student.getCode().equals(CodeOfStudent)){
                if(student.getCountOfgeneral() + student.getCountOfspecil() + general.getUnit()> 20){
                    System.out.println("\nSorry you Cant have more than 20 Unit!\n");
                    return false;
                }
                if(general.getCapacity()== 0){
                    System.out.println("\nSorry you Cant have this Lesson because this lesson if Full!!\n");
                    return false;
                }
                if(student.TadaKhold(general.getExamDay(), general.getClassDay(), general.getStartOfExam(), general.getEndOfExam(), general.getStartOfClass(), general.getEndOfClass())){
                    System.out.println("\nSorry you Cant have this Lesson because Two of your courses overlap!!\n");
                    return false;
                }
                general.setCapacity(general.getCapacity() - 1);
                general.addStudent(student);
                student.AddGeneral(general);
                System.out.println("\n Done!\n");
                return true;
            }
        }
        System.out.println("You are Not Register to The System !");
        return false;
    }
    public void AddStudent(Student student){
        AllofStudents.add(student);
    }
    public ArrayList<General> getGenerals() {
        return generals;
    }
    public void setGenerals(ArrayList<General> generals) {
        this.generals = generals;
    }
    public ArrayList<Special> getSpecials() {
        return specials;
    }
    public void setSpecials(ArrayList<Special> specials) {
        this.specials = specials;
    }
    public ArrayList<Student> getAllofStudents() {
        return AllofStudents;
    }
    public void setAllofStudents(ArrayList<Student> allofStudents) {
        AllofStudents = allofStudents;
    }
}
