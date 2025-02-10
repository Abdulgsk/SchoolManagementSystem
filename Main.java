import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View All Teachers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student grade: ");
                    String studentGrade = scanner.nextLine();
                    school.addStudent(new Student(studentName, studentAge, studentGrade));
                    break;
                case 2:
                    System.out.println("\nStudents:");
                    for (Student student : school.getAllStudents()) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.print("Enter teacher name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter teacher subject: ");
                    String teacherSubject = scanner.nextLine();
                    school.addTeacher(new Teacher(teacherName, teacherSubject));
                    break;
                case 4:
                    System.out.println("\nTeachers:");
                    for (Teacher teacher : school.getAllTeachers()) {
                        System.out.println(teacher);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
