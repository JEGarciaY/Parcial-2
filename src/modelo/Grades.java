package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grades {
    private int id;
    private int enrollmentId;
    private int gradeTypeId;
    private double grade;

    public Grades(int id, int enrollmentId, int gradeTypeId, double grade) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.gradeTypeId = gradeTypeId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public int getGradeTypeId() {
        return gradeTypeId;
    }

    public double getGrade() {
        return grade;
    }


    public static void insertGrades(Grades grades) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO grades (id, enrrollment_id, grade_type_id, grade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, grades.getId());
            statement.setInt(2, grades.getEnrollmentId());
            statement.setInt(3, grades.getGradeTypeId());
            statement.setDouble(4, grades.getGrade());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Grades> getAllGrades() {
        Connection con = connection.getConnection();
        List<Grades> grades = new ArrayList<>();

        String sql = "SELECT * FROM grades";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Grades grades1 = new Grades(
                        rs.getInt("id"),
                        rs.getInt("Enrrollment_id"),
                        rs.getInt("GretType_id"),
                        rs.getDouble("grade")
                );
                grades.add(grades1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
}