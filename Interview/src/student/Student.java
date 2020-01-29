package student;

import java.util.Queue;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses;
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1001;

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter last name: ");
        this.lastName = in.nextLine();

        System.out.println("\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    //Generate ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    //Enroll in courses
    public void enroll() {
        do {
            System.out.println("Enter course ton enroll (Q to quit)");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance += costOfCourse;
            } else break;
            System.out.println("Enrolled in: " + courses);
            System.out.println("Tuition balance: " + tuitionBalance);
        } while (1 != 0);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition() {
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("How much money do you want to pay? ");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("You've paid: $" + payment + "\nRemaining balance: $" + tuitionBalance);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gradeYear=" + gradeYear +
                ", studentID='" + studentID + '\'' +
                ", courses='" + courses + '\'' +
                ", tuitionBalance=" + tuitionBalance +
                '}';
    }
}
