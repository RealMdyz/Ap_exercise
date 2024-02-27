package View;

import Controller.CliConnector;
import Controller.Sttuf;
import Course.Course;
import Course.General;
import Course.Special;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    String PassWord, Name;
    public  Sttuf sttuf;

    CliConnector cliConnector;
    String AdminPass = "Admin";
    public Admin(Sttuf sttuf){
        this.sttuf = sttuf;
        this.cliConnector = new CliConnector(sttuf);
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Admin PassWord");
        String s = scanner.next();
        if(!s.equals(AdminPass)){
            System.out.println("Its Not Correct !");
            cliConnector.init();
        }
        System.out.println("you have entered as a Admin\n what do you want to do:\n 0- back\n 1- list of colleges \n 2- List Of Students");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            cliConnector.init();
        }
        else if(choice == 1){
            seecolleges();
        }
        else if(choice == 2){
            System.out.println("Student List :");
            for(Student student : sttuf.getAllofStudents()){
                System.out.println(student.getName() + " " + student.getCode());
            }
            init();
        }
        else {
            init();
        }
    }
    public void seecolleges(){
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
        if(!Colleges.isEmpty()){
            System.out.println("The College Names is :");
            for(String s : Colleges){
                System.out.println(s);

            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose your option :\n 0- back \n chose a college name");
        String s = scanner.next();
        if(s.equals("0")){
            init();
        }
        Keepgoing(s);
    }
    public void Keepgoing(String s){
        for(General general : sttuf.getGenerals()){
            if(general.getCollegeName().equals(s)){
                System.out.println(general.getLessonName() + " " + general.getLessonCode()  + " " + general.getTeacherName() + " " + general.getCapacity());
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(special.getCollegeName().equals(s)){
                System.out.println(special.getLessonName() + " " + special.getLessonCode() + " " + special.getTeacherName() + " " + special.getCapacity());
            }
        }
        System.out.println("Chose your option :\n 1- add a Lesson to this College\n 2- add Capacity to a lesson\n 3- See Registered Student for adding them or removing them ");
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        if(p == 1){
            addAlesson(s);
        }
        else if(p == 2){
            addCapacity();
        }
        else if(p == 3){
            AddOrRemoveAStudent(s);
        }
        else {
            init();
        }

    }
    public void addAlesson(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is a General Lesson Or Special one?");
        String typeoflesson = scanner.next();

        if(typeoflesson.equals("Special")){
            Special special = new Special(sttuf);
            special.setCollegeName(s);
            System.out.println("Please Enter the Lesson Name");
            String lessonName = scanner.next();
            special.setLessonName(lessonName);
            System.out.println("Please Enter the Lesson code");
            String lessonCode = scanner.next();
            special.setLessonCode(lessonCode);
            System.out.println("Please Enter the Teacher Name");
            String TeacherName = scanner.next();
            special.setTeacherName(TeacherName);
            System.out.println("Please Enter the Capacity");
            int Capacity = scanner.nextInt();
            special.setCapacity(Capacity);
            System.out.println("Please Enter the Unit");
            int Unit = scanner.nextInt();
            special.setUnit(Unit);
            System.out.println("Please Enter the ClassDay");
            String ClassDay = scanner.next();
            special.setClassDay(ClassDay);
            System.out.println("Please Enter the StartOfClass");
            int StartOfClass = scanner.nextInt();
            special.setStartOfClass(StartOfClass);
            System.out.println("Please Enter the EndOfClass");
            int EndOfClass = scanner.nextInt();
            special.setEndOfClass(EndOfClass);
            System.out.println("Please Enter the ExamDay");
            String ExamDay = scanner.next();
            special.setExamDay(ExamDay);
            System.out.println("Please Enter the StartOfExam");
            int StartOfExam = scanner.nextInt();
            special.setStartOfExam(StartOfExam);
            System.out.println("Please Enter the EndOfExam");
            int EndOfExam = scanner.nextInt();
            special.setEndOfExam(EndOfExam);
            sttuf.AddSpecial(special);
        }
        else if(typeoflesson.equals("General")){
            General general = new General(sttuf);
            general.setCollegeName(s);
            System.out.println("Please Enter the Lesson Name");
            String lessonName = scanner.next();
            general.setLessonName(lessonName);
            System.out.println("Please Enter the Lesson code");
            String lessonCode = scanner.next();
            general.setLessonCode(lessonCode);
            System.out.println("Please Enter the Teacher Name");
            String TeacherName = scanner.next();
            general.setTeacherName(TeacherName);
            System.out.println("Please Enter the Capacity");
            int Capacity = scanner.nextInt();
            general.setCapacity(Capacity);
            System.out.println("Please Enter the Unit");
            int Unit = scanner.nextInt();
            general.setUnit(Unit);
            System.out.println("Please Enter the ClassDay");
            String ClassDay = scanner.next();
            general.setClassDay(ClassDay);
            System.out.println("Please Enter the StartOfClass");
            int StartOfClass = scanner.nextInt();
            general.setStartOfClass(StartOfClass);
            System.out.println("Please Enter the EndOfClass");
            int EndOfClass = scanner.nextInt();
            general.setEndOfClass(EndOfClass);
            System.out.println("Please Enter the ExamDay");
            String ExamDay = scanner.next();
            general.setExamDay(ExamDay);
            System.out.println("Please Enter the StartOfExam");
            int StartOfExam = scanner.nextInt();
            general.setStartOfExam(StartOfExam);
            System.out.println("Please Enter the EndOfExam");
            int EndOfExam = scanner.nextInt();
            general.setEndOfExam(EndOfExam);
            sttuf.AddGeneral(general);
        }
        init();
    }
    public void addCapacity(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Lesson Code");
        String LessonCode = scanner.next();
        int Capacity;
        System.out.println("How much do you want to add to the capacity?");
        Capacity = scanner.nextInt();
        for(General general : sttuf.getGenerals()){
            if(general.getLessonCode().equals(LessonCode)){
                general.setCapacity(general.getCapacity() + Capacity);
                System.out.println("Done!");
                init();
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(special.getLessonCode().equals(LessonCode)){
                special.setCapacity(special.getCapacity() + Capacity);
                System.out.println("Done!");
                init();
            }
        }
        System.out.println("Something Went Wrong");
        init();
    }
    public void AddOrRemoveAStudent(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose a lesson from this college!");
        String lessonName = scanner.next();
        Course course = new Course(sttuf);
        course.seeStudent(lessonName);
        System.out.println("What you do want to do ?\n 1- remove a student from this lesson \n 2- add a student to this lesson");
        int p = scanner.nextInt();
        if(p == 1){
            System.out.println("Please Enter the Code of the Student:");
            String Code = scanner.next();
            for(General general : sttuf.getGenerals()){
                if(general.getLessonName().equals(lessonName)){
                    general.removeStu(Code, sttuf, general);
                }
            }
            for(Special special : sttuf.getSpecials()){
                if(special.getLessonName().equals(lessonName)){
                    special.removeStu(Code, sttuf, special);
                }
            }
        }
        else if(p == 2){
            System.out.println("Please Enter the Code of the Student:");
            String Code = scanner.next();
            for(General general : sttuf.getGenerals()){
                if(general.getLessonName().equals(lessonName)){
                    sttuf.AddStuGn(Code, general);
                }
            }
            for(Special special : sttuf.getSpecials()){
                if(special.getLessonName().equals(lessonName)){
                    sttuf.AddStuSp(Code, special);
                }
            }
        }
        init();
    }
}
