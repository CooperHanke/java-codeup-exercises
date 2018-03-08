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
