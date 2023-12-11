import java.util.Arrays;
import java.util.List;

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create a List to store students
        List<Student> students = Arrays.asList(
                new Student("S001", "John Doe", 20),
                new Student("S002", "Jane Smith", 22),
                new Student("S003", "Bob Johnson", 21)
        );

        // Add courses for each student
        students.get(0).addCourse("Math");
        students.get(0).addCourse("Physics");
        students.get(1).addCourse("Computer Science");
        students.get(2).addCourse("History");
        students.get(2).addCourse("English");

        // Display details of all students using Java streams
        students.stream().forEach(Student::displayDetails);

        // Display students enrolled in "Computer Science" using streams
        System.out.println("Students enrolled in Computer Science:");
        students.stream()
                .filter(student -> student.getCourses().contains("Computer Science"))
                .forEach(Student::displayDetails);

        // Update the age of a specific student using streams
        String studentIDToUpdate = "S002";
        int newAge = 23;
        students.stream()
                .filter(student -> student.getStudentID().equals(studentIDToUpdate))
                .forEach(student -> student.age = newAge);

        // Display details of all students after updating age
        System.out.println("Details after updating age:");
        students.stream().forEach(Student::displayDetails);

        // Calculate and display the average age of all students using streams
        double averageAge = students.stream().mapToInt(Student::getAge).average().orElse(0.0);
        System.out.println("Average age of students: " + averageAge);
    }
}
