package vista;

import Interfaces.IMostrarMensaje;
import modelo.GradeType;

import java.util.List;

public class ViewGradeType implements IMostrarMensaje {
    public void displayListGradeType(List<GradeType> gradeTypes) {
        System.out.println(" == Lista de Tipos Calificaciones == ");
        for (GradeType gradeType : gradeTypes) {
            System.out.println("Id Curso: " + gradeType.getId() + ", Name: " + gradeType.getName()+ "Peso: "+ gradeType.getWeight());
        }
    }
}
