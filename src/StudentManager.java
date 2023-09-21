import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<BcadStudent> bcadStudents = new ArrayList<BcadStudent>();

    public void addStudent(Student student)
    {
        students.add(student);
    }
    public Student searchStudent(int id)
    {
        for(var student : students)
        {
            if (student.id == id)
            {
                return student;
            }
        }
        return null;
    }
    public void deleteStudent(int id)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).id == id)
            {
                students.remove(i);
            }
        }
    }
    public boolean studentNotFound(int id)
    {
        boolean flag = false;
        for (var student : students)
        {
            if (student.id == id)
            {
                flag = true;
            }
        }
        return  flag;
    }
    public String studentsReport()
    {
        String output = "";
        for (int i = 0; i < students.size(); i++)
        {
            output +=  "STUDENT: " + i + "\n" +  students.get(i).toString();

        }
        return output;
    }
    public void saveAttendanceList()
    {
        for (Student student : bcadStudents)
        {
            try {
                FileWriter fileWriter = new FileWriter("AttendanceList.txt");
                fileWriter.write(student.id + "," + student.name + ","+ student.age + ","+ student.email + ","+ student.course);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String printAttedanceList()
    {
        String output = "";
        try
        {
            Scanner scanner = new Scanner(new File("AttendanceList.txt"));
            while (scanner.hasNext())
            {
                output = output + scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        return output;
    }
}
