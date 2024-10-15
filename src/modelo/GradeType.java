package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeType {
    private int id;
    private String name;
    private double wheight;

    public GradeType(int id, String name, double wheight) {
        this.id = id;
        this.name = name;
        this.wheight = wheight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWheight() {
        return wheight;
    }

    public static void insertGradeType(GradeType gradeType) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO grades (id, enrollment_id, grade_type_id, grade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, gradeType.getId());
            statement.setString(2, gradeType.getName());
            statement.setDouble(3, gradeType.getWheight());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<GradeType> getAllGradeType() {
        Connection con = connection.getConnection();
        List<GradeType> gradeTypes = new ArrayList<>();

        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                GradeType gradeType = new GradeType(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("wheight")
                );
                gradeTypes.add(gradeType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeTypes;
    }
}