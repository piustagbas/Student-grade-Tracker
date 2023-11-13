package org.tutusfunny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();


        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character


        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter the name for student " + i + " (must contain a space, consist only of alphabetical characters, and be greater than 7 characters): ");
            String name = scanner.nextLine().trim();


            while (!isValidName(name)) {
                System.out.println("Invalid name. Name must contain a space, consist only of alphabetical characters, and be greater than 7 characters.");
                System.out.print("Enter a valid name for student " + i + ": ");
                name = scanner.nextLine().trim();
            }

            System.out.print("Enter the grade for student " + i + ": ");
            double grade = scanner.nextDouble();
            students.add(new Student(name, grade));
            scanner.nextLine();
        }


        double average = calculateAverage(students);
        double highest = calculateHighest(students);
        double lowest = calculateLowest(students);

        System.out.println("\nGrade Summary:");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close();
    }

    // Method to calculate the average grade
    private static double calculateAverage(ArrayList<Student> students) {
        double sum = 0;

        for (Student student : students) {
            sum += student.getGrade();
        }

        return sum / students.size();
    }

    private static double calculateHighest(ArrayList<Student> students) {
        return Collections.max(students, Comparator.comparing(Student::getGrade)).getGrade();
    }

    private static double calculateLowest(ArrayList<Student> students) {
        return Collections.min(students, Comparator.comparing(Student::getGrade)).getGrade();
    }


    private static boolean isValidName(String name) {

        return Pattern.matches("[a-zA-Z]+ [a-zA-Z]+", name) && name.length() > 7;
    }
}
