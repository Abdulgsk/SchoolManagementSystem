import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class School {
    private final DatabaseManager dbManager = new DatabaseManager();

    // Student Methods
    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        dbManager.executeUpdate(query, student.getName(), student.getAge(), student.getGrade());
        System.out.println("Student added successfully!");
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            while (rs != null && rs.next()) {
                students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("grade")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // Teacher Methods
    public void addTeacher(Teacher teacher) {
        String query = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
        dbManager.executeUpdate(query, teacher.getName(), teacher.getSubject());
        System.out.println("Teacher added successfully!");
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teachers";
        try (ResultSet rs = dbManager.executeQuery(query)) {
            while (rs != null && rs.next()) {
                teachers.add(new Teacher(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("subject")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
