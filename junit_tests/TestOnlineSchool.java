package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Instructor;
import model.OnlineSchool;
import model.Participant;
import model.Registration;
/*
 * Requirement: Any classes you create must reside in the `model` package and be imported properly.
 * For example, creating a new class `Foo` in the `model` package should result in:
 * 	import model.Foo;
 */
public class TestOnlineSchool {
    /*
     * Requirement: Any classes you add to the `model` package must not contain any use of the Java library (e.g., ArrayList).
     *
     * Tests included in this class serve as documentation on how instances of an online school operates.
     *
     * Before attempting this lab, it is expected that you already completed the pre-study materials:
     * 	1. Week 7 Java Tutorials:
     * 		https://www.youtube.com/playlist?list=PL5dxAmCmjv_7x3Qn5px_zS0qqgaBK9Sc1
     * 	2.1 Written Notes on Reference-Typed, Multi-Valued Attributes:
     * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/W/EECS1022/notes/EECS1022_W21_Tracing_PointCollectorTester.pdf
     *  2.2 The written notes in 2.1 will make it easier for you to follow Week 8's Java Tutorials:
     *  	https://www.youtube.com/playlist?list=PL5dxAmCmjv_6JyoGf4zvQmg3piNzipWdb
     * 	4. Written Notes on Inferring Classes from JUnit Tests:
     * 		https://www.eecs.yorku.ca/~jackie/teaching/lectures/2021/W/EECS1022/notes/EECS1022_W21_Inferring_Classes_from_JUnit.pdf
     *
     * Item 2.2. will only be available on March 5.
     * You may start attempting the lab after completing: Items 1, 2.1, and 4.
     *
     * Be sure to also read the following sections from your Lab5 instructions PDF:
     * 	- Section 2.3 The Online School Problem
     * 	- Section 2.4 Hints and Requirements
     *
     * Programming IDEs such as Eclipse are able to fix such compilation errors for you.
     * However, you are advised to follow the guidance as specified in the written notes above
     * to fix these compilation errors manually, because:
     * 	1) it helps you better understand how the intended classes and methods work together; and
     * 	2) you may be tested in a written test or exam without the assistance of IDEs.
     *
     */

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */
    @Test
    public void test_1() {
        Registration r = new Registration("Software Design");
        String t = r.getTitle();
        int m = r.getMarks();
        Instructor i = r.getInstructor();
        /* Size of returned array should be 2:
         * 	- 1st element denotes the letter grade.
         * 	- 2nd element denotes its qualitative description (see the mapping table in the instructions PDF).
         */
        String[] gr = r.getGradeReport();
        /* Returned information only displays the marks, grade, and description when there is an instructor. */
        String info = r.getInformation();

        assertEquals("Software Design", t);
        assertEquals(0, m);
        assertNull(i);
        assertTrue(gr.length == 2 && gr[0].equals("F") && gr[1].equals("Failing"));
        assertEquals("Software Design has not yet been assigned an instructor", info);

        Instructor jackie = new Instructor("Jackie", 70130, "jackie@eecs.yorku.ca");
        r.setInstructor(jackie);

        assertEquals("Software Design", r.getTitle());
        assertEquals(0, r.getMarks());
        assertTrue(r.getInstructor() != null
                && r.getInstructor() == jackie /* reference aliasing */
                /* Q. Can you visualize this chain of method calls? */
                && r.getInstructor().getName().equals("Jackie")
                && r.getInstructor().getPhoneExtension() == 70130
                && r.getInstructor().getEmail().equals("jackie@eecs.yorku.ca"));
        assertTrue(r.getGradeReport().length == 2);
        assertEquals(r.getGradeReport()[0], "F");
        assertEquals(r.getGradeReport()[1], "Failing");
        /* When the instructor is assigned for the course, its information displays:
         * 	- Title of course
         * 	- Name of instructor
         * 	- Numerical marks, the corresponding letter grade, and its qualitative description.
         *
         *  Note. Here we only test one case of mapping from marks to its grade and description.
         *        You should test other cases (see the mapping table in the instructions PDF).
         */
        assertEquals("Software Design, taught by Jackie, is completed with raw marks 0 (F ; Failing)", r.getInformation());

        r.setMarks(61);

        assertEquals(61, r.getMarks());
        assertTrue(r.getGradeReport().length == 2
                && r.getGradeReport()[0].equals("C")
                && r.getGradeReport()[1].equals("Competent"));
        assertEquals("Software Design, taught by Jackie, is completed with raw marks 61 (C ; Competent)", r.getInformation());

        Instructor jim = new Instructor("Jim Davies", 70139, "jim@yorku.ca");
        r.setInstructor(jim);

        /* Q. Can you visualize why this assertion is true? */
        assertTrue(r.getInstructor() != null
                && r.getInstructor() != jackie
                && r.getInstructor() == jim);
        assertEquals("Software Design, taught by Jim Davies, is completed with raw marks 61 (C ; Competent)", r.getInformation());
    }
    @Test
    public void test_2() {
        /* Second argument of the constructor call is an anonymous object:
         * 	new Instructor("J. Gibbons", 76283, "jeremy@yorku.ca")
         */
        Registration r = new Registration("Data Structures", new Instructor("J. Gibbons", 76283, "jeremy@yorku.ca"));
        r.setMarks(73);
        assertEquals("Data Structures", r.getTitle());
        assertEquals(73, r.getMarks());
        assertTrue(r.getInstructor().getName().equals("J. Gibbons"));
    }

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */
    @Test
    public void test3() {
        Instructor alan = new Instructor("A. Wassyng", 70130, "jackie@eecs.yorku.ca");
        Instructor mark = new Instructor("M. Lawford", 70139, "jonathan@yorku.ca");

        Participant suyeon = new Participant("S. Y. Lee");
        /*
         * Length of the returned array from `getRegistrations` corresponds to
         * the number of registrations added by the participant so far.
         * See the instructions PDF regarding the max number of registrations that can be added.
         */
        Registration[] suyeonRegistrations = suyeon.getRegistrations();
        String report = suyeon.getGPAReport();

        /* empty list of registrations to begin with */
        assertTrue(suyeonRegistrations.length == 0);
        /* GPA undefined over an empty list of registrations */
        assertEquals("No GPA available yet for S. Y. Lee", report);
        /* non-registered courses have default marks -1 */
        assertTrue(suyeon.marksOf("Intro. to OOP") == -1);

        Registration r1 = new Registration("Intro. to OOP", alan);
        /* add two registrations for suyeon
         * Hints:
         * 	- Are the two `addRegistration` calls denote the same method?
         *	- Or an overloaded method (i.e., methods with the same name but distinct input parameter types)?
         */
        suyeon.addRegistration(r1);
        suyeon.addRegistration("Heavy Metal Music");

        suyeon.getRegistrations()[1].setInstructor(mark);

        assertTrue(suyeon.getRegistrations()[1].getInstructor() == mark);

        /*
         * Notice the format of GPA report:
         *  - GPA value is displayed with 1 digit after the decimal point.
         * 	- The comma-separated list of `GradePoint (LetterGrade)` is surrounded by curly braces.
         * 	- There is a space after each comma and after the colon.
         */
        assertEquals("S. Y. Lee's GPA of {0 (F), 0 (F)}: 0.0", suyeon.getGPAReport());

        suyeon.updateMarks("Intro. to OOP", 61);
        suyeon.updateMarks("Heavy Metal Music", 79);
        /* non-existing course -> do nothing */
        suyeon.updateMarks("Psychology I", 89);
        assertTrue(suyeon.getRegistrations()[0].getMarks() == 61); /* Grade: C; GP: 6  */
        assertTrue(suyeon.marksOf("Intro. to OOP") == 61);
        /* GPA = sum of GPs divided by number of courses */
        assertEquals("S. Y. Lee's GPA of {6 (C), 7 (B)}: 6.5", suyeon.getGPAReport());

        Participant yuna = new Participant("Y. Lee");
        yuna.addRegistration(new Registration("Heavy Metal Music", mark));
        yuna.updateMarks("Heavy Metal Music", 85);

        assertTrue(yuna.getRegistrations()[0].getMarks() == 85); /* Grade: A; GP: 8  */
        assertTrue(yuna.marksOf("Heavy Metal Music") == 85);

        /* At the end of the semester, clear registrations of students. */
        suyeon.clearRegistrations();
        yuna.clearRegistrations();

        assertTrue(suyeon.getRegistrations().length == 0
                && yuna.getRegistrations().length == 0);
        assertTrue(suyeon.getGPAReport().equals("No GPA available yet for S. Y. Lee")
                && yuna.getGPAReport().equals("No GPA available yet for Y. Lee"));
        String[] courses = {"Intro. to OOP", "Heavy Metal Music", "Psychology I", "Software Design"};
        /* Q. Without the loop below,
         * how many lines of assertions need to be written explicitly?
         */
        for(int i = 0; i < courses.length; i ++) {
            assertTrue(suyeon.marksOf(courses[i]) == -1);
            assertTrue(yuna.marksOf(courses[i]) == -1);
        }

        /* Next semester, students may choose to re-take some courses. */
        suyeon.addRegistration("Heavy Metal Music");
        suyeon.updateMarks("Heavy Metal Music", 99);

        assertTrue(suyeon.getRegistrations().length == 1);
        assertEquals("S. Y. Lee's GPA of {9 (A+)}: 9.0", suyeon.getGPAReport());
        assertEquals("Heavy Metal Music has not yet been assigned an instructor", suyeon.getRegistrations()[0].getInformation());
    }

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */

    /*
     * Recommended exercises:
     * 	Visualizing and tracing (on both debugger and paper) on how objects are created and manipulated
     * 	in each test would be extremely valuable for reinforcing your understanding.
     */

    @Test
    public void test3b() {
        Participant heeyeon = new Participant("H. Y. Kang");
        Registration r1 = new Registration("EECS2001");
        Registration r2 = new Registration("EECS2011");
        Registration r3 = new Registration("EECS2021");
        Registration r4 = new Registration("EECS2031");
        Registration r5 = new Registration("EECS1090");
        Registration[] list = {r1, r2, r3, r4, r5};

        /* Q. Without the loop below,
         * how many lines of assertions need to be written explicitly?
         */
        for(int i = 0; i < list.length; i ++) {
            heeyeon.addRegistration(list[i]);
            assertTrue(heeyeon.getRegistrations().length == i + 1);
            assertTrue(heeyeon.getRegistrations()[i] == list[i]);
        }

        /* Maximum number of registrations allowed is 5.
         * Adding beyond the maximum capacity will have no effect.
         */
        heeyeon.addRegistration(new Registration("ECON1000"));
        heeyeon.addRegistration(new Registration("ECON1010"));

        assertTrue(heeyeon.getRegistrations().length == 5);
        assertTrue(heeyeon.getRegistrations()[0] == r1);
        assertTrue(heeyeon.getRegistrations()[1] == r2);
        assertTrue(heeyeon.getRegistrations()[2] == r3);
        assertTrue(heeyeon.getRegistrations()[3] == r4);
        assertTrue(heeyeon.getRegistrations()[4] == r5);
    }
    @Test
    public void test_4() {
        OnlineSchool school = new OnlineSchool();
        /* courses not existing (yet) */
        Participant mark = new Participant("M. Lawford");
        school.addParticipant(mark);
        mark.addRegistration("Intro. to OOP");

        /* Order in which participants appear in the returned array of `getParticipants` should be
         * the same as how they appear in the school's list of participants (e.g., alan, mark, tom).
         */

        /* non-existing course */
//		assertTrue(school.getParticipants("Intro. to OOP").length == 1);
    }

    /* You may want to write a test similar to test03b:
     * an online school can be added up to 100 participants.
     */
}
