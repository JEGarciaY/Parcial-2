import controlador.*;
import db.connection;
import modelo.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema academico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment viewEnrollment = new ViewEnrollment();
        ViewGrades viewGrades = new ViewGrades();
        ViewGradeType viewGradeType = new ViewGradeType();

        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(viewEnrollment);
        GradesController gradesController = new GradesController(viewGrades);
        GradeTypeController gradeTypeController = new GradeTypeController(viewGradeType);

        //Inicializar objetos

        // Inicializar objeto estudiante
        Student newStudent = new Student(1, "Daniel", "daniel@gmail.com");
        // Guardar estudiante en la base de datos
        studentController.insertNewStudent(newStudent);
        // Mostrar datos en las vistas
        studentController.displayAllStudents();

        //Inicializar objeto profesor
        Teacher newTeacher1 = new Teacher(1, "Pablo", "Ciencias Sociales");
        teacherController.insertNewTeacher(newTeacher1);
        teacherController.displayAllTeachers();

        //Inicializar objeto curso
        Course newCourse = new Course(1, "Historia", "políticos, sociales, económicos, científicos, tecnológicos...", true, newTeacher1.getId());
        courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        //Inicializar objeto inscripcion
        Enrollment newEnrollment1 = new Enrollment(1,newStudent.getId(), newCourse.getId());
        enrollmentController.insertNewEnrollment(newEnrollment1);
        enrollmentController.displayAllEnrollments();

        //Inicializar objeto tipo calificacion
        GradeType newGradeType = new GradeType(1,"name",50.5);
        gradeTypeController.insertNewGradeType(newGradeType);
        gradeTypeController.displayAllGradeTypes();

        //Inicializar objeto calificacion
        Grades newGrades = new Grades(1, newEnrollment1.getId(),newGradeType.getId(),2.5);
        gradesController.insertNewGrades(newGrades);
        gradesController.displayAllGrades();

    }
}