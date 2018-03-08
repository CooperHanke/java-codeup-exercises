package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class GradesApplication {
    private static HashMap<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
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
        System.out.println(students.get("CooperHanke").getName() + " " + students.get("CooperHanke").getGradeAverage());
    }
}
