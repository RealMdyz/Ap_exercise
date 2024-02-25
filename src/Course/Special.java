package Course;

import java.util.ArrayList;

import Controller.Sttuf;
import View.*;
public class Special extends Course{
    String CollegeName;
    String LessonName, LessonCode, TeacherName;
    int Capacity,RegistratioNumber, Unit;
    String ClassDay;
    int StartOfClass, EndOfClass;
    String ExamDay;
    int StartOfExam, EndOfExam;
    ArrayList<Student> students = new ArrayList<>();
    public void removeStu(String Code, Sttuf sttuf, Special special){
        for(Student student: students){
            if(student.getCode().equals(Code)){
                students.remove(student);
                Capacity += 1;
                break;
            }
        }
        for(Student student : sttuf.getAllofStudents()){
            if(student.getCode().equals(Code)){
                student.RemoveSpecial(special);
            }
        }
    }

    public void  addStudent(Student student){
        students.add(student);
    }
    public Special(Sttuf sttuf){
        super(sttuf);
    }
    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getLessonName() {
        return LessonName;
    }

    public void setLessonName(String lessonName) {
        LessonName = lessonName;
    }

    public String getLessonCode() {
        return LessonCode;
    }

    public void setLessonCode(String lessonCode) {
        LessonCode = lessonCode;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getRegistratioNumber() {
        return RegistratioNumber;
    }

    public void setRegistratioNumber(int registratioNumber) {
        RegistratioNumber = registratioNumber;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int unit) {
        Unit = unit;
    }

    public String getClassDay() {
        return ClassDay;
    }

    public void setClassDay(String classDay) {
        ClassDay = classDay;
    }

    public int getStartOfClass() {
        return StartOfClass;
    }

    public void setStartOfClass(int startOfClass) {
        StartOfClass = startOfClass;
    }

    public int getEndOfClass() {
        return EndOfClass;
    }

    public void setEndOfClass(int endOfClass) {
        EndOfClass = endOfClass;
    }

    public String getExamDay() {
        return ExamDay;
    }

    public void setExamDay(String examDay) {
        ExamDay = examDay;
    }

    public int getStartOfExam() {
        return StartOfExam;
    }

    public void setStartOfExam(int startOfExam) {
        StartOfExam = startOfExam;
    }

    public int getEndOfExam() {
        return EndOfExam;
    }

    public void setEndOfExam(int endOfExam) {
        EndOfExam = endOfExam;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
