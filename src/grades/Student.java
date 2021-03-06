package grades;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades = new ArrayList<>();

    protected Student(String name) {
        this.name = name;
        this.grades = grades;
    }
    protected String getName() {
        return this.name;
    }
    protected void showGrades() {
        System.out.println("Grades: ");
        for (int grade: this.grades) {
            if (grade < 70) {
                System.out.println(" |" + (char)27 + "[31m" + grade + (char)27 + "[39m" + "| ");
                continue;
            }
            System.out.println(" |" + grade + "| ");
        }
    }
    protected void addGrade(int grade) {
        this.grades.add(grade);
    }
    protected double getGradeAverage() {
        double average = 0;
        for (int grade: grades) {
            average += grade;
        }
        return average / this.grades.size();
    }
}
