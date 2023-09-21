import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static StudentManager studentManager = new StudentManager();
    static boolean exit = false;

    public static void main(String[] args)
    {
    startMenu();
    }
    public static void startMenu()//start
    {
        while (!exit)
        {
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = keyboard.nextLine();
            if (!input.equals("1"))
            {
                exit = true;
            }
            else
            {
                menu();
            }

        }
        keyboard.close();
    }
    public static void menu() //main menu -> user options
    {
        boolean exit = false;
        while(!exit)
        {
            System.out.println("""
                    Please select one of the following items:\s
                    (1) Capture a new student
                    (2) Search for a student
                    (3) Delete a student\s
                    (4) Print student report\s
                    (5) Manage BCAD event
                    (6) Exit appliation""");

            String input = keyboard.nextLine();
            switch (input) {
                case "1" -> saveStudent();
                case "2" -> searchStudent();
                case "3" -> deleteStudent();
                case "4" -> System.out.println(studentManager.studentsReport());
                case "5" -> manageBcadEvent();
                case "6" -> ExitStudentApplication();
            }
        }
    }
    public static void manageBcadEvent() //bcad event -> user option
    {
        System.out.println("(1) Save attendance list.\n(2) Print attendance list");
        String input5 = keyboard.nextLine();
        if (input5.equals("1")){
            setBcadStudents();
        }
        else if (input5.equals("2"))
        {
            System.out.println(studentManager.printAttedanceList());
        }
    }
    public static void saveStudent()//user input
    {
        System.out.println("Enter student id");
        int id = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter student name");
        String name = keyboard.nextLine();

        System.out.println("Enter student age");
        String ageStr = keyboard.nextLine();
        int age = 0;
        boolean flag = false;
        while(!flag)
        {
            if (!studentAge_InvalidCharacter(ageStr))
            {
                age = Integer.parseInt(ageStr);
                if (studentAge_Invalid(age))
                {
                    System.out.println("Age is invalid");
                }
                else if (studentAge_Valid(age)){
                    flag = true;
                }
            }
            else
            {
                System.out.println("Please enter a number");
            }
            if (!flag)
            {
                System.out.println("Enter student age");
                ageStr = keyboard.nextLine();
            }
        }
        System.out.println("Enter student email");
        String email = keyboard.nextLine();
        System.out.println("Enter student course");
        String course = keyboard.nextLine();
        studentManager.addStudent(new Student(id,name,age,email,course));
        System.out.println("Student has been saved");
    }
    public static boolean studentAge_Valid(int age)
    {
        return age >= 16;
    }
    public static boolean studentAge_Invalid(int age)
    {
        return age < 16;
    }
    public static boolean studentAge_InvalidCharacter(String age)
    {
        if (isNumeric(age)) return false;
        return true;
    }
    public static void searchStudent()
    {
        System.out.println("Enter the student ID");
        int id = Integer.parseInt(keyboard.nextLine());
        Student student = studentManager.searchStudent(id);
        if (student != null) System.out.println(student.toString()); //if student is not null it means it is found
        else System.out.println("Student not found");
    }
    public static void deleteStudent()
    {
        System.out.println("Enter the student ID");
        int id = Integer.parseInt(keyboard.nextLine());
        if (studentManager.studentNotFound(id))
        {
            System.out.println("Student not found");
        }
        else
        {
            studentManager.deleteStudent(id);
            System.out.println("Student has been removed");
        }
    }
    public static void setBcadStudents()//user input to determine whether students qualify for event
    {
        boolean nonFound = true;
        System.out.println("The lecturer has decided that all BCAD students who have attended yesterday's class qualify to a chance to win a free Pizza, indicate whether the student qualifies.");

        for (Student student : studentManager.students)//loop through all students
        {
            if (student.course.equalsIgnoreCase("BCAD"))//only continue if course is bcad
            {
                nonFound = false;
                boolean valid = false;
                System.out.println("Has " + student.name + " id: " + student.id + " attended yesterday's class? respond with yes or no.");
                String attendedStr = Main.keyboard.nextLine();
                while(!valid)
                {
                    if (attendedStr.equalsIgnoreCase("yes") || attendedStr.equalsIgnoreCase("no"))
                    {
                        valid = true;
                        Boolean attended = Boolean.valueOf(attendedStr);
                        studentManager.bcadStudents.add(new BcadStudent(student.id,student.name,student.age,student.email,attended));
                    }
                    if (!valid)
                    {
                        System.out.println("Has " + student.name + " id: " + student.id + " attended yesterday's class? respond with yes or no.");
                        attendedStr = Main.keyboard.nextLine();
                    }
                }
                studentManager.saveAttendanceList();//save to  file
                System.out.println("Attendance list has been saved in a text file");
            }
            else if (nonFound)
            {
                System.out.println("No bcad students found, press enter to continue");
                keyboard.nextLine();
            }
        }
    }
    public static void ExitStudentApplication()
    {
        exit = true;
        System.exit(0);
    }

    public static boolean isNumeric(String str) { //https://stackoverflow.com/a/1102916

        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}