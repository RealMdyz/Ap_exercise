package View;

import Controller.CliConnector;
import Controller.Sttuf;
import Course.General;
import Course.Special;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    String PassWord, Name;
    public Sttuf sttuf;

    public Admin(Sttuf sttuf){
        this.sttuf = sttuf;
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("you have entered as a Admin\n what do you want to do:\n 0- back\n 1- list of colleges");
        int choice = scanner.nextInt();
        CliConnector cliConnector = new CliConnector(sttuf);
        scanner.nextLine();
        if (choice == 0) {
            cliConnector.init();
        }
        else if(choice == 1){
            seecolleges();
        }
        else {
            init();
        }
    }
    public void seecolleges(){
        ArrayList<String> Colleges = new ArrayList<>();
        for(General general : sttuf.getGenerals()){
            if(!Colleges.contains(general.getCollegeName())){
                Colleges.add(general.getCollegeName());
                System.out.println(general.getCollegeName());
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(!Colleges.contains(special.getCollegeName())){
                Colleges.add(special.getCollegeName());
                System.out.println(special.getCollegeName());
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose your option :\n 0- back \n chose a college name");
        String s = scanner.next();
        if(s == "0"){
            init();
        }
        Keepgoing(s);
    }
    public void Keepgoing(String s){
        for(General general : sttuf.getGenerals()){
            if(general.getCollegeName() == s){
                System.out.println(general.getLessonName() + " " + general.getLessonCode());
            }
        }
        for(Special special : sttuf.getSpecials()){
            if(special.getCollegeName() == s){
                System.out.println(special.getLessonName() + " " + special.getLessonCode());
            }
        }
        System.out.println("Chose your option :\n 1- add a Lesson to this College\n 2- add Capacity to a lesson\n 3-See Registered Student for adding them or removing them ");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        if(p == "1"){

        }
        else if(p == "2"){

        }
        else if(p == "3"){

        }
        else {
            init();
        }

    }
}
