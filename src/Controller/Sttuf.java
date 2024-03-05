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
    public boolean AddStudnet(Student student){
        for(Student student1 : AllofStudents){
            if(student1.getName().equals(student.getName()) && student1.getCode().equals(student.getCode())){
                System.out.println("You Have Been Register Before");
                return false;
            }
        }
        AllofStudents.add(student);
        System.out.println("You Have Register Successfuly!!");
        return true;
    }
    public boolean AddStuSp(String CodeOfStudent, Special special){
        for(Student student : AllofStudents){
            if(student.getCode().equals(CodeOfStudent)){
                int unit = 0;
                for(General general1 : student.getGenerallessons())
                    unit += general1.getUnit();
                for (Special special1 : student.getSpeciallessons())
                    unit += special1.getUnit();

                if(unit + special.getUnit()> 20){
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
                student.AddSpecial(special);
                special.addStudent(student);
                System.out.println("\n Done!\n");
                return true;
            }
        }
        System.out.println("You are Not Register to The System !");
        return false;
    }
    public boolean AddStuSpFromSt(String CodeOfStudent, Special special){
        for(Student student : AllofStudents){
            if(student.getCode().equals(CodeOfStudent)){
                int unit = 0;
                for(General general1 : student.getGenerallessons())
                    unit += general1.getUnit();
                for (Special special1 : student.getSpeciallessons())
                    unit += special1.getUnit();

                if(unit + special.getUnit()> 20){
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
                student.AddSpecial(special);
                special.addStudent(student);
                System.out.println("\n Done!\n");
                return true;
            }
        }
        System.out.println("You are Not Register to The System !");
        return false;
    }

    public boolean AddStuGn(String CodeOfStudent, General general){
        for(Student student : AllofStudents){
            if(student.getCode().equals(CodeOfStudent)){
                int unit = 0;
                for(General general1 : student.getGenerallessons())
                    unit += general1.getUnit();
                for (Special special1 : student.getSpeciallessons())
                    unit += special1.getUnit();

                if(unit + general.getUnit()> 20){
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
                if(student.getCountOfgeneral() + general.getUnit() > 5){
                    System.out.println("You Cant Have More Than 5 General Unit!");
                    return false;
                }
                general.setCapacity(general.getCapacity() - 1);
                student.AddGeneral(general);
                general.addStudent(student);
                System.out.println("\n Done!\n");
                return true;
            }
        }
        System.out.println("You are Not Register to The System !");
        return false;
    }
    public boolean AddStuGnFromSt(String CodeOfStudent, General general){

        for(Student student : AllofStudents){
            if(student.getCode().equals(CodeOfStudent)){
                int unit = 0;
                for(General general1 : student.getGenerallessons())
                    unit += general1.getUnit();
                for (Special special1 : student.getSpeciallessons())
                    unit += special1.getUnit();
                if(unit + general.getUnit()> 20){
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
                if(student.getCountOfgeneral() + general.getUnit() > 5){
                    System.out.println("You Cant Have More Than 5 General Unit!");
                    return false;
                }
                general.setCapacity(general.getCapacity() - 1);
                student.AddGeneral(general);
                general.addStudent(student);
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
