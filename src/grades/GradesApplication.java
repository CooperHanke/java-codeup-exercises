package grades;

import java.util.HashMap;
import java.util.Map;

import util.Input;

public class GradesApplication {
    private static HashMap<String, Student> students = new HashMap<>();
    public static void main(String[] args) {
        listMaker();
        presentStudents();
    }
    private static void listMaker() {
        Student cooper = new Student("Cooper");
        Student joseph = new Student("Joseph");
        Student rob = new Student ("Rob");
        cooper.addGrade(80);
        cooper.addGrade(90);
        cooper.addGrade(79);
        joseph.addGrade(20);
        joseph.addGrade(90);
        joseph.addGrade(70);
        rob.addGrade(60);
        rob.addGrade(60);
        rob.addGrade(60);
        students.put("CooperHanke", cooper);
        students.put("Joseph999", joseph);
        students.put("Robby95", rob);
    }
    private static void presentStudents() {
        System.out.println("Student List\n--------------");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String key = entry.getKey();
            System.out.println("| " + key + " |\t");
        }
        System.out.println();
        System.out.println("Type 'all' to see all students' grades.");
        System.out.println("Type 'exit' to quit.");
        System.out.println();
        selectStudent();
    }
    private static void selectStudent() {
        System.out.print("Which student: > ");
        Input input = new Input();
        String choice = input.getString();
        if (choice.contains("exit")) {
            exit();
        } else if (choice.contains("all")) {
            allStudentsGrades();
            presentStudents();
        } else if (students.containsKey(choice)) {
            closeupStudent(students.get(choice), choice);
            presentStudents();
        } else {
            System.out.println((char)27 + "[31mThere is no student under " + choice + ". Try again." + (char)27 + "[39m");
            selectStudent();
        }
    }
    private static void closeupStudent(Student student, String choice) {
        System.out.println();
        System.out.println("Student Name: " + student.getName());
        System.out.println("Github Username: " + choice);
        student.showGrades();
        if (student.getGradeAverage() <= 70) {
            System.out.println("Current Average: " + (char)27 + "[31m" + (int)(student.getGradeAverage()) + (char)27 + "[39m\n");
        } else {
            System.out.println("Current Average: " + (int)(student.getGradeAverage()) + "\n");
        }
    }
    private static void allStudentsGrades() {
        System.out.println("All grades for all students: ");
        students.forEach((k, v) -> {
            System.out.println();
            System.out.println(v.getName());
            v.showGrades();
        });
        System.out.println();
    }
    private static void exit() {
        System.out.println();
        System.out.println("Thank you for using the grading application!");
        System.exit(0);
    }
}

