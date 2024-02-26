package MyProject;
import Controller.*;
import Course.Special;

public class MyProject {
    public MyProject(){
        init();
    }
    public static Sttuf sttuf;
    public void init(){
        sttuf = new Sttuf();
        HardCode();
        CliConnector cliConnector = new CliConnector(sttuf);
        cliConnector.init();
    }
    protected void HardCode(){
        Special special = new Special(sttuf);
        special.setCollegeName("Math");
        special.setLessonName("Liner-Algebra");
        special.setTeacherName("Pornaki");
        special.setCapacity(40);
        special.setLessonCode("24115");
        special.setExamDay("11-April");
        special.setClassDay("Saturday-Monday");
        special.setStartOfClass(10);
        special.setEndOfClass(12);
        special.setStartOfExam(9);
        special.setEndOfExam(14);
        special.setUnit(4);
        sttuf.AddSpecial(special);
        Special special1 = new Special(sttuf);
        special1.setCollegeName("Math");
        special1.setLessonName("Algebra1");
        special1.setTeacherName("Jafari");
        special1.setCapacity(40);
        special1.setLessonCode("24215");
        special1.setExamDay("12-April");
        special1.setClassDay("Saturday-Monday");
        special1.setStartOfClass(8);
        special1.setEndOfClass(9);
        special1.setStartOfExam(9);
        special1.setEndOfExam(14);
        special1.setUnit(3);
        sttuf.AddSpecial(special1);
        Special special2 = new Special(sttuf);
        special2.setCollegeName("Math");
        special2.setLessonName("Algebra2");
        special2.setTeacherName("Jafari");
        special2.setCapacity(30);
        special2.setLessonCode("24915");
        special2.setExamDay("13-April");
        special2.setClassDay("Sunday-Thursday");
        special2.setStartOfClass(8);
        special2.setEndOfClass(9);
        special2.setStartOfExam(9);
        special2.setEndOfExam(14);
        special2.setUnit(3);
        sttuf.AddSpecial(special2);
    }

}
