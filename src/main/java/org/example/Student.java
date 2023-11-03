package org.example;

// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
// Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
// В решении не использовать циклы! Только StreamAPI

import java.util.*;

public class Student {
    private String name;
    private List<Double> grades;
    private String speciality;

    public Student(String name, List<Double> grades, String speciality) {
        this.name = name;
        this.grades = grades;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getSpeciality() {
        return speciality;
    }

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(n -> n)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
