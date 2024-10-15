package vista;

import Interfaces.IMostrarMensaje;
import modelo.Course;
import modelo.GradeType;

import java.util.List;

public class ViewGradeType implements IMostrarMensaje {
    public void displayListGradeType(List<GradeType> gradeTypes) {
        System.out.println(" == Lista de Cursos == ");
        for (GradeType gradeType : gradeTypes) {
            System.out.println("Id Curso: " + gradeType.getId() + ", Nombre: " + gradeType.getName()+ "Peso: "+ gradeType.getWheight());
        }
    }
}
