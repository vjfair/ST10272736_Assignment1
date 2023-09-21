public class Student {
    int id;
    String name;
    int age;
    String email;
    String course;

    public Student(int id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }
    @Override
    public String toString()
    {
        return "STUDENT ID: " + id + "\nSTUDENT NAME: " + name + "\nSTUDENT AGE: " + age + "\nSTUDENT EMAIL: " + email + "\nSTUDENT COURSE: " + course;
    }
}
