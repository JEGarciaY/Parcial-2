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
    private int teacherId;

    public Enrollment(int id, int studentId, int teacherId) {
        this.id = id;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO enrollment (id, studentId, teacherId) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getId());
            statement.setInt(2, enrollment.getStudentId());
            statement.setInt(3, enrollment.getTeacherId());

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
                        rs.getInt("studenId"),
                        rs.getInt("teacherId")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}