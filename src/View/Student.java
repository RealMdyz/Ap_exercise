package View;

import Controller.*;
import Course.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Student {

    String PassWord, Name, Code, esm;

    ArrayList<General> generallessons = new ArrayList<>();
    ArrayList<Special> Speciallessons = new ArrayList<>();
    int countOfgeneral, countOfspecil;

    CliConnector cliConnector;
    public static Sttuf sttuf;

    public Student(Sttuf sttuf){
        this.sttuf = sttuf;
        cliConnector = new CliConnector(sttuf);
    }

    public void Register(){
        Scanner scanner = new Scanner(System.in);
        Student student1 = new Student(sttuf);
        String Esm, Pas, Code1;
        System.out.println("Please Enter Your Name:");
        Esm = scanner.next();
        System.out.println("Please Enter Your PassWord:");
        Pas = scanner.next();
        System.out.println("Please Enter Your Code:");
        Code1 = scanner.next();
        student1.setName(Esm);
        student1.setPassWord(Pas);
        student1.setCode(Code1);
        sttuf.AddStudnet(student1);
    }
    public boolean CheckValidation(){
        String  pas;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Name:");
        esm = scanner.next();
        System.out.println("Please Enter your PassWord:");
        pas = scanner.next();
        for (Student student : sttuf.getAllofStudents()){
            if(student.getName().equals(esm) && student.getPassWord().equals(pas)){
                return true;
            }
        }
        return false;
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("you have entered as a Student\n 1-Sing up \n 2- Sing in \n 0- back");
        String s = scanner.nextLine();
        if(s.equals("1")){
            Register();
            init();
        }
        else if(s.equals("2") && !CheckValidation() ){
            System.out.println("Your PassWord or Your Name is not Correct!");
            init();
        }
        else if(!s.equals("2")){
            cliConnector.init();
        }

        System.out.println("you have entered as a " + esm +"\n what do you want to do:\n 0- back\n 1- List of My lesson\n 2- List of Available courses");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("You Have been Register for " + ((int)generallessons.size() + (int)Speciallessons.size())+ " Lesson :");
            for(General general : generallessons){
                System.out.println(general.getLessonName() + " " + general.getLessonCode() + " " + general.getTeacherName());
            }
            for(Special special : Speciallessons){
                System.out.println(special.getLessonName() + " " + special.getLessonCode() + " " + special.getTeacherName());
            }
        }
        else if (choice == 2) {
            List_OF_ALL_COLLEGES();
        }
        else if (choice == 0) {
            cliConnector.init();
        }
        else {
            init();
        }
    }
    public void List_OF_ALL_COLLEGES(){
        ArrayList<String> Colleges = new ArrayList<>();
        for(General general : sttuf.getGenerals()){
            boolean c = true;
            for(String s : Colleges){
                if(s.equals(general.getCollegeName())){
                    c = false;
                }
            }
            if(c)
                Colleges.add(general.getCollegeName());

        }
        for(Special special : sttuf.getSpecials()){
            boolean c = true;
            for(String s : Colleges){
                if(s.equals(special.getCollegeName())){
                    c = false;
                }
            }
            if(c)
                Colleges.add(special.getCollegeName());
        }
        if(!Colleges.isEmpty()) {
            System.out.println("The College Names is :");
            for (String s : Colleges) {
                System.out.println(s);

            }

        }
        System.out.println("Chose One of Them!:");
        Scanner scanner = new Scanner(System.in);
        String CollegeName = scanner.next();
        List_All_OF_THE_LESSON_OF_A_COLLEGE(CollegeName);
    }
    public void List_All_OF_THE_LESSON_OF_A_COLLEGE(String CollegeName){
        for(General general : sttuf.getGenerals()){
            if(general.getCollegeName().equals(CollegeName)){
                System.out.println(general.getLessonName() + " " + general.getLessonCode() + " " + general.getTeacherName());
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(special.getCollegeName().equals(CollegeName)){
                System.out.println(special.getLessonName() + " " + special.getLessonCode() + " " +special.getTeacherName());
            }
        }
        System.out.println("Do you Want to Get Any OF Them?! \n 1- Yes \n 2- No");
        Scanner scanner = new Scanner(System.in);
        String Answer = scanner.next();
        if(Answer.equals("1")){
            System.out.println("Please Enter the Code Of the Lesson");
            String CodeOfLesson = scanner.next();
            for(Special special : sttuf.getSpecials()){
                if(special.getLessonCode().equals(CodeOfLesson)){

                    if(special.AddStu(Code, sttuf, special))
                        Speciallessons.add(special);
                }
            }
            for(General general : sttuf.getGenerals()){
                if(general.getLessonCode().equals(CodeOfLesson)){
                    if(general.AddStu(Code, sttuf, general))
                        generallessons.add(general);
                }
            }
            init();
        }
        else {
          init();
        }
    }

    public boolean TadaKhold(String Examday, String ClassDay, int StartOfexam, int EndOfexam, int StartOfClass, int EndOfClass){
        for(General general : generallessons){
            if(Examday.equals(general.getExamDay()) &&( (StartOfexam >= general.getStartOfExam() && StartOfexam <= general.getEndOfExam()) ||  (EndOfexam >= general.getStartOfExam() && EndOfexam <= general.getEndOfExam()))){
                return true;
            }
            if(ClassDay.equals(general.getClassDay()) &&( (StartOfClass >= general.getStartOfClass() && StartOfClass <= general.getEndOfClass()) ||  (EndOfClass >= general.getStartOfClass() && EndOfClass <= general.getEndOfClass()))){
                return true;
            }
        }
        for(Special special : Speciallessons){
            if(Examday.equals(special.getExamDay()) &&( (StartOfexam >= special.getStartOfExam() && StartOfexam <= special.getEndOfExam()) ||  (EndOfexam >= special.getStartOfExam() && EndOfexam <= special.getEndOfExam()))){
                return true;
            }
            if(ClassDay.equals(special.getClassDay()) &&( (StartOfClass >= special.getStartOfClass() && StartOfClass <= special.getEndOfClass()) ||  (EndOfClass >= special.getStartOfClass() && EndOfClass <= special.getEndOfClass()))){
                return true;
            }
        }
        return false;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCountOfgeneral() {
        return countOfgeneral;
    }

    public void setCountOfgeneral(int countOfgeneral) {
        this.countOfgeneral = countOfgeneral;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public int getCountOfspecil() {
        return countOfspecil;
    }

    public void setCountOfspecil(int countOfspecil) {
        this.countOfspecil = countOfspecil;
    }
    public void AddGeneral(General general){
        generallessons.add(general);
    }
    public void AddSpecial(Special special){
        Speciallessons.add(special);
    }
    public void RemoveSpecial(Special special){
        Speciallessons.remove(special);
    }
    public void RemoveGeneral(General general){
        generallessons.remove(general);
    }
}
