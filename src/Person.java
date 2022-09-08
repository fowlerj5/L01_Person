import java.time.*;
import java.util.Calendar;
import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private String IDnum;
    private String title;
    private int YOB;
    Scanner in = new Scanner(System.in);

    public Person(String IDnum, String firstName, String lastName, String title, int YOB) {
        this.IDnum = IDnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDnum() {
        return IDnum;
    }

    public void setIDnum(String IDnum) {
        this.IDnum = IDnum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + firstName + " " + lastName;
    }

    public String getAge() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - YOB + " years old";
    }

    public String getAge(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        return calendar.get(Calendar.YEAR) - YOB + " years old in " + year;
    }

    public String toCSVDataRecord() {
        return IDnum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}