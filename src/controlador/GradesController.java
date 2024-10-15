package controlador;

import modelo.Grades;
import vista.ViewGrades;

import java.util.List;

public class GradesController {
    private ViewGrades view;

    public GradesController(ViewGrades view) {
        this.view = view;
    }

    public void insertNewGrades(Grades newGrades) {
        Grades.insertGrades(newGrades);
        view.mostrarMensaje("\nCalificacion guardada correctamente!");
    }

    public void displayAllGrades() {
        List<Grades> grades = Grades.getAllGrades();
        view.displayListGrades(grades);
    }
}
