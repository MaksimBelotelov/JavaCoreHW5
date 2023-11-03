package org.example;

// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
// Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
// В решении не использовать циклы! Только StreamAPI

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Вася", List.of(3.0, 4.0, 5.0), "Математика"),
                new Student("Петя", List.of(4.0, 5.0, 5.0), "Информатика"),
                new Student("Даша", List.of(5.0, 5.0, 5.0), "Физика"),
                new Student("Маша", List.of(4.0, 3.0, 4.0), "Информатика"),
                new Student("Саша", List.of(5.0, 5.0, 3.0), "Информатика"),
                new Student("Глаша", List.of(3.0, 3.0, 3.0), "Математика"),
                new Student("Рома", List.of(5.0, 5.0, 5.0), "Биология"))
                );

        List<Student> filtered =
                students.stream()
                        .filter(student -> student.getSpeciality().equals("Информатика"))
                        .filter(student -> student.getAverageGrade() > 4.5)
                        .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                        .limit(5)
                        .toList();

        for (var student: filtered)
            System.out.println(student);
    }
}