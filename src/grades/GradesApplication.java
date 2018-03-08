package grades;

import java.util.HashMap;
import java.util.Map;

import util.Input;

public class GradesApplication {
    private static HashMap<String, Student> students = new HashMap<>();
    public static void listMaker() {
        Student cooper = new Student("Cooper");
        Student joseph = new Student("Joseph");
        Student rob = new Student ("Rob");
        cooper.addGrade(80);
        cooper.addGrade(90);
        cooper.addGrade(79);
        joseph.addGrade(80);
        joseph.addGrade(90);
        joseph.addGrade(70);
        rob.addGrade(80);
        rob.addGrade(90);
        rob.addGrade(60);
        students.put("CooperHanke", cooper);
        students.put("Joseph999", joseph);
        students.put("Robby95", rob);
    }
    public static void presentStudents() {
        System.out.println("Student List\n--------------");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String key = entry.getKey();
            System.out.println("|" + key + "|\t");
        }
        System.out.println("Type 'exit' in order to quit.");
        selectStudent();
    }
    public static void selectStudent() {
        System.out.print("Which student: > ");
        Input input = new Input();
        String choice = input.getString();
        if (choice.contains("exit")) {
            exit();
        } else if (students.containsKey(choice)) {
            closeupStudent(students.get(choice), choice);
            presentStudents();
        } else {
            System.out.println("No student is listed by that name.");
            selectStudent();
        }
    }
    public static void closeupStudent(Student student, String choice) {
        System.out.println();
        System.out.println("Student Name: " + student.getName());
        System.out.println("Github Username: " + choice);
        student.showGrades();
        System.out.println("Current Average: " + (int)(student.getGradeAverage()) + "\n");
    }
    public static void exit() {
        System.out.println("Thank you for using the grading application!");
        System.exit(0);
    }
    public static void main(String[] args) {
        listMaker();
        presentStudents();
    }
}

