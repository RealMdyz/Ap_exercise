package View;

import Controller.*;
import Course.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    String PassWord, Name, Code;

    ArrayList<General> generallessons = new ArrayList<>();
    ArrayList<Special> Speciallessons = new ArrayList<>();
    int countOfgeneral, countOfspecil;
    public Sttuf sttuf;
    public Student(Sttuf sttuf){
        this.sttuf = sttuf;
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("you have entered as a Student\n what do you want to do:\n 0- back\n 1- remove lesson\n 2- add lesson");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            removelesson();
        } else if (choice == 2) {
            addlesson();
        } else if (choice == 0) {

        }
        else {
            init();
        }
    }
    public void addlesson(){

    }
    public void removelesson(){

    }
}
