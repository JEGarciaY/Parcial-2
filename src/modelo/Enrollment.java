package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO enrollment (id, student_id, course_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getId());
            statement.setInt(2, enrollment.getStudentId());
            statement.setInt(3, enrollment.getCourseId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Enrollment> getAllEnrollment() {
        Connection con = connection.getConnection();
        List<Enrollment> enrollments = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}