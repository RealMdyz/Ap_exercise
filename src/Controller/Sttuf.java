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
