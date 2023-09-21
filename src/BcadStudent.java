public class BcadStudent extends Student{
    protected boolean attended;
    public BcadStudent(int id, String name, int age, String email, boolean attended) {
        super(id, name, age, email, "BCAD");
        this.attended = attended;
    }

}
