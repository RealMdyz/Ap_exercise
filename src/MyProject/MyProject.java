package MyProject;
import Controller.*;
import Course.General;
import Course.Special;

public class MyProject {
    public MyProject(){
        init();
    }
    public static Sttuf sttuf;
    public void init(){
        sttuf = new Sttuf();
       //HardCode();
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
            special1.setStartOfClass(10);
            special1.setEndOfClass(11);
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

            General general = new General(sttuf);
            general.setCollegeName("Math");
            general.setLessonName("Math1");
            general.setTeacherName("Khanedani");
            general.setCapacity(200);
            general.setLessonCode("24015");
            general.setExamDay("20-April");
            general.setClassDay("Saturday-Monday");
            general.setStartOfClass(10);
            general.setEndOfClass(12);
            general.setStartOfExam(8);
            general.setEndOfExam(12);
            general.setUnit(4);
            sttuf.AddGeneral(general);

            Special specialPH = new Special(sttuf);
            specialPH.setCollegeName("Physic");
            specialPH.setLessonName("Akostic");
            specialPH.setTeacherName("Moghimi");
            specialPH.setCapacity(40);
            specialPH.setLessonCode("25115");
            specialPH.setExamDay("11-April");
            specialPH.setClassDay("Saturday-Monday");
            specialPH.setStartOfClass(10);
            specialPH.setEndOfClass(12);
            specialPH.setStartOfExam(9);
            specialPH.setEndOfExam(14);
            specialPH.setUnit(4);
            sttuf.AddSpecial(specialPH);

            Special specialPH1 = new Special(sttuf);
            specialPH1.setCollegeName("Physic");
            specialPH1.setLessonName("BioPhysic1");
            specialPH1.setTeacherName("Kargarian");
            specialPH1.setCapacity(40);
            specialPH1.setLessonCode("25117");
            specialPH1.setExamDay("11-April");
            specialPH1.setClassDay("Sunday-Thursday");
            specialPH1.setStartOfClass(10);
            specialPH1.setEndOfClass(12);
            specialPH1.setStartOfExam(9);
            specialPH1.setEndOfExam(14);
            specialPH1.setUnit(3);
            sttuf.AddSpecial(specialPH1);

            Special specialPH2 = new Special(sttuf);
            specialPH2.setCollegeName("Physic");
            specialPH2.setLessonName("BioPhysic2");
            specialPH2.setTeacherName("Kargarian");
            specialPH2.setCapacity(40);
            specialPH2.setLessonCode("25118");
            specialPH2.setExamDay("23-April");
            specialPH2.setClassDay("Sunday-Thursday");
            specialPH2.setStartOfClass(16);
            specialPH2.setEndOfClass(20);
            specialPH2.setStartOfExam(9);
            specialPH2.setEndOfExam(14);
            specialPH2.setUnit(3);
            sttuf.AddSpecial(specialPH2);

            General generalPH = new General(sttuf);
            generalPH.setCollegeName("Physic");
            generalPH.setLessonName("Physic1");
            generalPH.setTeacherName("Baghram");
            generalPH.setCapacity(200);
            generalPH.setLessonCode("25015");
            generalPH.setExamDay("29-April");
            generalPH.setClassDay("Saturday-Monday");
            generalPH.setStartOfClass(7);
            generalPH.setEndOfClass(9);
            generalPH.setStartOfExam(8);
            generalPH.setEndOfExam(12);
            generalPH.setUnit(3);
            sttuf.AddGeneral(generalPH);


            Special specialIE = new Special(sttuf);
            specialIE.setCollegeName("Industry");
            specialIE.setLessonName("OR");
            specialIE.setTeacherName("Hasani");
            specialIE.setCapacity(40);
            specialIE.setLessonCode("26115");
            specialIE.setExamDay("11-April");
            specialIE.setClassDay("Saturday-Monday");
            specialIE.setStartOfClass(10);
            specialIE.setEndOfClass(12);
            specialIE.setStartOfExam(9);
            specialIE.setEndOfExam(14);
            specialIE.setUnit(3);
            sttuf.AddSpecial(specialIE);

            Special specialIE1 = new Special(sttuf);
            specialIE1.setCollegeName("Industry");
            specialIE1.setLessonName("OR2");
            specialIE1.setTeacherName("Hasani");
            specialIE1.setCapacity(40);
            specialIE1.setLessonCode("26117");
            specialIE1.setExamDay("19-April");
            specialIE1.setClassDay("Saturday-Monday");
            specialIE1.setStartOfClass(10);
            specialIE1.setEndOfClass(12);
            specialIE1.setStartOfExam(9);
            specialIE1.setEndOfExam(14);
            specialIE1.setUnit(3);
            sttuf.AddSpecial(specialIE1);

            Special specialIE2 = new Special(sttuf);
            specialIE2.setCollegeName("Industry");
            specialIE2.setLessonName("OR3");
            specialIE2.setTeacherName("Hasani");
            specialIE2.setCapacity(40);
            specialIE2.setLessonCode("26119");
            specialIE2.setExamDay("28-April");
            specialIE2.setClassDay("Saturday-Monday");
            specialIE2.setStartOfClass(16);
            specialIE2.setEndOfClass(18);
            specialIE2.setStartOfExam(9);
            specialIE2.setEndOfExam(14);
            specialIE2.setUnit(3);
            sttuf.AddSpecial(specialIE2);

            General generalOR = new General(sttuf);
            generalOR.setCollegeName("Industry");
            generalOR.setLessonName("KarGah");
            generalOR.setTeacherName("Ahmadi");
            generalOR.setCapacity(200);
            generalOR.setLessonCode("26015");
            generalOR.setExamDay("29-April");
            generalOR.setClassDay("Saturday-Monday");
            generalOR.setStartOfClass(6);
            generalOR.setEndOfClass(10);
            generalOR.setStartOfExam(8);
            generalOR.setEndOfExam(12);
            generalOR.setUnit(3);
            sttuf.AddGeneral(generalOR);

    }
    // this(nothing) --> باعث میشه خود کلاس رو پاس بده بهش
    // برای نوشتن کار با فایل دروس و یوزر ها رو توی چندفایل جدا بنویسم تا راحت تر باشم
    // ساختار پیاده سازی کار با فایل :
    // دوتا فایل جنرال و اسپشیال برای ذخیره سازی کل درس ها
    // برای هر نفر یه پوشه که توی هر پوشه دوتا فایل باشه جنرال و اسپشیال توی هر کدوم درس هایی که داره رو ذخیره سازی کرده باشیم !!!!
}
