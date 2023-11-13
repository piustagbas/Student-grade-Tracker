package org.tutusfunny;

import java.util.regex.Pattern;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name. Name must contain a space, consist only of alphabetical characters, and be greater than 7 characters.");
        }
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    private boolean isValidName(String name) {

        return Pattern.matches("[a-zA-Z]+ [a-zA-Z]+", name) && name.length() > 7;
    }
}
