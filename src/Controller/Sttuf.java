package Controller;
import Course.*;
import View.*;
import java.util.ArrayList;

public class Sttuf {
    ArrayList<General> generals = new ArrayList<>();
    ArrayList<Special> specials = new ArrayList<>();
    ArrayList<Student> AllofStudents = new ArrayList<>();

    public void AddGeneral(General general){
        generals.add(general);
    }
    public void AddSpecial(Special special){
        specials.add(special);
    }
    public void AddStudent(Student student){
        AllofStudents.add(student);
    }

}
