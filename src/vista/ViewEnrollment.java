package vista;

import Interfaces.IMostrarMensaje;
import modelo.Enrollment;

import java.util.List;

public class ViewEnrollment implements IMostrarMensaje {
    public void displayListEnrollments(List<Enrollment> enrollments) {
        System.out.println(" == Lista de inscripciones == ");
        for (Enrollment enrollment : enrollments) {
            System.out.println("Id Inscripcion: " + enrollment.getId() + ", Estudiante ID: " + enrollment.getStudentId() + ", Profesor ID: " + enrollment.getCourseId());
        }
    }
}

