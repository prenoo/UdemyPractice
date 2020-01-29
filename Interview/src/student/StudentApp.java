package student;

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        System.out.println("How many students do you want to add?");
        Scanner sc = new Scanner(System.in);
        int numOfStudents = sc.nextInt();
        Student[] students = new Student[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }

        System.out.println(students[0]);
        System.out.println(students[1]);
        System.out.println(students[2]);

    }
}
