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
        Student newStudent = new Student(10, "Daniel", "daniel@gmail.com");
        Student newStudent1 = new Student(11, "Juanito", "juanito@gmail.com");
        // Guardar estudiante en la base de datos
        studentController.insertNewStudent(newStudent);
        // Mostrar datos en las vistas
        studentController.displayAllStudents();

        //Inicializar objeto profesor
        Teacher newTeacher = new Teacher(13, "Pablo", "Ciencias Sociales");
        teacherController.insertNewTeacher(newTeacher);
        teacherController.displayAllTeachers();

        //Inicializar objeto curso
        Course newCourse = new Course(14, "Historia", "políticos, sociales, económicos, científicos, tecnológicos...", true, newTeacher.getId());
        courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        //Inicializar objeto inscripcion
        Enrollment newEnrollment = new Enrollment(15,newStudent1.getId(),newTeacher.getId());
        enrollmentController.insertNewEnrollment(newEnrollment);
        enrollmentController.displayAllEnrollments();

        //Inicializar objeto tipo calificacion
        GradeType newGradeType = new GradeType(16,"Parcial",0.6);
        gradeTypeController.insertNewGradeType(newGradeType);
        gradeTypeController.displayAllGradeTypes();

        //Inicializar objeto calificacion
        Grades newGrades = new Grades(17,newEnrollment.getId(),newGradeType.getId(),12.0);
        gradesController.insertNewGrades(newGrades);
        gradesController.displayAllGrades();


    }
}