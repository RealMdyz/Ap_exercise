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
        CliConnector cliConnector = new CliConnector(sttuf);
        scanner.nextLine();
        if (choice == 1) {
            removelesson();
        } else if (choice == 2) {
            addlesson();
        } else if (choice == 0) {
            cliConnector.init();
        }
        else {
            init();
        }
    }
    public void addlesson(){

    }
    public void removelesson(){

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
