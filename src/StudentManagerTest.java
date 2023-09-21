import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentManagerTest {

    @org.junit.Test
    public void addStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student(1234, "Victor",20,"vjohnfair@gmail.com","BCAD");

        studentManager.addStudent(student);
        ArrayList<Student> testStudentArr = new ArrayList<Student>();
        testStudentArr.add(student);
        assertEquals(testStudentArr, studentManager.students);
    }

    @org.junit.Test
    public void searchStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student(1234, "Victor",20,"vjohnfair@gmail.com","BCAD");
        studentManager.addStudent(student);
        assertEquals(student, studentManager.searchStudent(1234));
    }

    @org.junit.Test
    public void deleteStudent() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student(1234, "Victor",20,"vjohnfair@gmail.com","BCAD");
        studentManager.addStudent(student);
        studentManager.deleteStudent(1234);
        ArrayList<Student> testStudentArr = new ArrayList<Student>();
        assertEquals(testStudentArr, studentManager.students);
    }
    @Test
    public void testStudentNotFound() {
        StudentManager studentManager = new StudentManager();
        Student student = new Student(1234, "Victor",20,"vjohnfair@gmail.com","BCAD");
        studentManager.addStudent(student);
        assertFalse(studentManager.studentNotFound(123456));

    }
    @Test
    public void saveAttendanceList(){
    StudentManager studentManager = new StudentManager();
    BcadStudent student = new BcadStudent(1234, "Victor",20,"vjohnfair@gmail.com",true);
    studentManager.bcadStudents.add(student);
    studentManager.saveAttendanceList();
    boolean fileExists = new File("AttendanceList.txt").isFile();
    assertTrue(fileExists);
    }
}