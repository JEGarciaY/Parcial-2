package vista;

import Interfaces.IMostrarMensaje;
import modelo.Grades;

import java.util.List;

public class ViewGrades implements IMostrarMensaje {
    public void displayListGrades(List<Grades> grades) {
        System.out.println(" == Lista de Calificaciones == ");
        for (Grades grade : grades) {
            System.out.println("Id Curso: " + grade.getId() + ", Inscripcion ID: " + grade.getEnrollmentId() + ", Tipo Calificacion ID: " + grade.getGradeTypeId() + ", EstadoCalificacion: " + grade.getGrade());
        }
    }
}
