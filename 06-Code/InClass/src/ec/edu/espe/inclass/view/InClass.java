package ec.edu.espe.inclass.view;

import com.google.gson.Gson;
import ec.edu.espe.inclass.model.AttendanceRecord;
import ec.edu.espe.inclass.model.Course;
import ec.edu.espe.inclass.model.Grade;
import ec.edu.espe.inclass.model.Student;
import ec.edu.espe.inclass.model.Teacher;
import ec.edu.espe.inclass.model.Tutorship;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class InClass {

    static Teacher teacher;

    public static void main(String[] args) {

        teacher = new Teacher();
        teacher.setId("L002424");
        teacher.setName("Santiago Valencia");

        teacher = loadFileJson();

        controlMainMenu();

    }

    public static void controlMainMenu() {
        int option = 0;

        while (option != 3) {
            System.out.println("======================================");
            System.out.println("----------------InClass---------------");
            System.out.println("======================================");
            System.out.println("-----------Developer Bears------------");
            System.out.println("Alejandro Cuadrado, Alexander Guaman");
            System.out.println("Sheylee Enriquez, Stephen Drouet");
            System.out.println("======================================");
            System.out.println("---------------Main Menu--------------");
            System.out.println("======================================");
            System.out.println("1. Teacher Menu");
            System.out.println("2. Student Menu");
            System.out.println("3. Exit");

            option = askOption();

            switch (option) {
                case 1:
                    controlTeacherMenu();
                    break;

                case 2:
                    controlStudentMenu();
                    break;

                case 3:
                    System.out.println("See you...");
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }

            SaveFileJson(teacher);
        }
    }

    private static void controlStudentMenu() {
        int option = 0;
        System.out.println("ask for ESPE ID");
        // verify if espe ID exist an return a student with information
        while (option != 2) {
            System.out.println("-----Student Menu-----");
            System.out.println("1. Request a tutorship");
            System.out.println("2. Back");

            option = askOption();

            switch (option) {
                case 1:
                    Tutorship tutorship = new Tutorship();
                    tutorship.requestTutorship();
                    try {
                        teacher.getTutorships().add(tutorship);
                    } catch (Exception e) {
                        System.out.println("error could not add tutorship");
                    }
                    System.out.println("A tutorship was requested");
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }

    }

    private static void controlTeacherMenu() {
        Course course;

        int option = 0;
        int courseNumber;

        while (option != 5) {
            System.out.println("-----Teacher Menu-----");
            System.out.println("1. Enter a course");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Get tutorship record");
            System.out.println("5. Back");

            option = askOption();

            switch (option) {
                case 1:
                    showCourses();
                    enterCourse();
                    break;

                case 2:
                    System.out.println("Function for add Course");
                    teacher.addCourse();
                    break;

                case 3:
                    System.out.println("Function for remove Course");
                    showCourses();
                    removeCourse();
                    break;

                case 4:
                    for (Tutorship tutorship : teacher.getTutorships()) {
                        printTutorships(tutorship);
                    }

                    System.out.println("Function for tutorship record");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }
    }

    public static void enterCourse() {
        int courseNumber;
        Course course;
        System.out.println("Which course do you want to enter?: ");
        courseNumber = askOption() - 1;
        try {
            course = teacher.getCourses().get(courseNumber);
            ControlCourseMenu(course);
        } catch (Exception e) {
            System.out.println("Error: Course was not find");
        }
    }

    public static void printTutorships(Tutorship tutorship) {
        System.out.println("================================================");
        System.out.println("- Date: " + tutorship.getDate());
        System.out.println("- Course Name: " + tutorship.getCourseName());
        System.out.println("- Student Name: " + tutorship.getName());
        System.out.println("- Student Id: " + tutorship.getId());
        System.out.println("- Student Career: " + tutorship.getCareer() + "\n");
    }

    public static void removeCourse() {
        int courseNumber;
        System.out.println("Which course do you want to remove?: ");
        courseNumber = askOption() - 1;
        try {
            teacher.getCourses().remove(courseNumber);
            System.out.println("The course was remove successfully");
        } catch (Exception e) {
            System.out.println("The course was not remove");
        }
    }

    private static void showCourses() {
        for (int CourseNumber = 0; CourseNumber < teacher.getCourses().size(); CourseNumber++) {
            System.out.println(CourseNumber + 1 + ". " + teacher.getCourses().get(CourseNumber));
        }
    }

    private static void ControlCourseMenu(Course course) {
        Student student;

        int option = 0;
        int studentNumber;

        AttendanceRecord attendanceRecord;
        attendanceRecord = new AttendanceRecord();

        while (option != 9) {
            System.out.println(course);
            System.out.println("-----Course Menu-----");
            System.out.println("1. Managament student information");
            System.out.println("2. Show enrolled students");
            System.out.println("3. Add Grade");
            System.out.println("4. Take Attendance");
            System.out.println("5. Add student");
            System.out.println("6. Remove student");
            System.out.println("7. Get grade record");
            System.out.println("8. Get attendance record");
            System.out.println("9. Back");

            option = askOption();

            switch (option) {
                case 1:
                    showStudents(course);

                    System.out.println("Which student do you want to manage?: ");
                    studentNumber = askOption() - 1;

                    try {
                        student = course.getStudents().get(studentNumber);
                        ControlStudentInfoMenu(student);
                    } catch (Exception e) {
                        System.out.println("Error: Course was not find");
                    }

                    break;

                case 2:
                    System.out.println("Function for enrolled students");
                    showStudents(course);
                    break;

                case 3:
                    System.out.println("Add Grades for all");
                    addGradeForAll(course);
                    break;

                case 4:
                    System.out.println("Function for take Attendance");
                    attendanceRecord.add(course.getStudents());
                    break;

                case 5:
                    System.out.println("Function for add student");
                    course.addStudent();
                    System.out.println(course.getStudents().toString());
                    break;

                case 6:
                    System.out.println("Function for remove student");
                    showStudents(course);

                    System.out.println("Which student do you want to remove?: ");
                    studentNumber = askOption() - 1;

                    try {
                        course.getStudents().remove(studentNumber);
                        System.out.println("The student was remove successfully");
                    } catch (Exception e) {
                        System.out.println("The student was not remove");
                    }
                    break;

                case 7:
                    System.out.println("Function for grade record");
                    for (Student student1 : course.getStudents()) {
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println("- " + student1.getName() + ": \n" + student1.getGradeRecord());
                    }
                    break;

                case 8:
                    System.out.println("Function for attendance record");
                    for (Student student1 : course.getStudents()) {
                        System.out.print("- " + student1.getName());
                        System.out.println(": " + student1.getAttendanceRecord());
                    }
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }
    }

    private static void showStudents(Course course) {
        for (int studentNumber = 0; studentNumber < course.getStudents().size(); studentNumber++) {
            System.out.println((studentNumber + 1) + ". " + course.getStudents().get(studentNumber));
        }
    }

    private static void addGradeForAll(Course course) {
        int option;
        int unitNumber;

        Grade studentSubject;

        System.out.println("What unit do you need to enter? (1, 2 or 3)");
        unitNumber = askOption() - 1;

        if (unitNumber >= 0 && unitNumber < 3) {
            System.out.println("What grade do you want to enter?");
            System.out.println("1. Workshop");
            System.out.println("2. Homework");
            System.out.println("3. Test");
            System.out.println("4. Exam");
            option = askOption();

            switch (option) {
                case 1:
                    for (Student student1 : course.getStudents()) {
                        studentSubject = student1.getGradeRecord().getUnits().get(unitNumber).getWorkshops();
                        AddStudentGrade(student1, studentSubject);
                    }
                    break;

                case 2:
                    for (Student student1 : course.getStudents()) {
                        studentSubject = student1.getGradeRecord().getUnits().get(unitNumber).getHomeworks();
                        AddStudentGrade(student1, studentSubject);
                    }
                    break;

                case 3:
                    for (Student student1 : course.getStudents()) {
                        studentSubject = student1.getGradeRecord().getUnits().get(unitNumber).getTests();
                        AddStudentGrade(student1, studentSubject);
                    }
                    break;

                case 4:
                    for (Student student1 : course.getStudents()) {
                        studentSubject = student1.getGradeRecord().getUnits().get(unitNumber).getExam();
                        AddStudentGrade(student1, studentSubject);
                    }
                    break;

                default:
                    System.out.println("Error: Invalid option");
            }

        } else {
            System.out.println("Error: The selected unit does not exist");
        }
    }

    private static void AddStudentGrade(Student student1, Grade studentSubject) {
        float gradeValue;

        System.out.print("- " + student1.getName() + " Grade: ");

        do {
            gradeValue = inputGrade();            
        } while (Float.isNaN(gradeValue));

        studentSubject.add(gradeValue);
    }

    private static float inputGrade() {
        Scanner scan = new Scanner(System.in);
        float gradeValue = Float.NaN;

        try {
            gradeValue = scan.nextFloat();
            if (gradeValue <= 20 && gradeValue >= 0) {
                return gradeValue;
            } else {
                System.out.println("The range of the grades is from 0 to 20.\nTry again");
                gradeValue = Float.NaN;
            }
            
        } catch (Exception e) {
            System.out.println("Error: Invalid number, please use comma(,) for decimal numbers and the range is (0-20).\nTry again: ");
        }

        return gradeValue;
    }

    private static void ControlStudentInfoMenu(Student student) {
        int unitNumber = 0;
        int option = 0;

        Grade studentSubject;

        while (option != 5) {
            System.out.println(student);
            System.out.println("-----Control student information Menu-----");
            System.out.println("1. Modify workshop grade");
            System.out.println("2. Modify homework grade");
            System.out.println("3. Modify tests grade");
            System.out.println("4. Modify exam grade");
            System.out.println("5. Back");

            option = askOption();

            if (option != 5) {
                System.out.println("What unit do you need to modify? (1, 2 or 3)");
                unitNumber = askOption() - 1;
            }

            if (unitNumber >= 0 && unitNumber < 3) {
                switch (option) {
                    case 1:
                        System.out.println("Function for modify workshop grade");
                        studentSubject = student.getGradeRecord().getUnits().get(unitNumber).getWorkshops();
                        modifyStudenSubject(studentSubject);
                        break;

                    case 2:
                        System.out.println("Function for modify homework grade");
                        studentSubject = student.getGradeRecord().getUnits().get(unitNumber).getHomeworks();
                        modifyStudenSubject(studentSubject);
                        break;

                    case 3:
                        System.out.println("Function for modify test grade");
                        studentSubject = student.getGradeRecord().getUnits().get(unitNumber).getTests();
                        modifyStudenSubject(studentSubject);
                        break;

                    case 4:
                        System.out.println("Function for modify exam grade");
                        studentSubject = student.getGradeRecord().getUnits().get(unitNumber).getExam();
                        modifyStudenSubject(studentSubject);
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Error: Invalid option try again.");
                }
            } else {
                System.out.println("Error: The selected unit does not exist");
            }
        }
    }

    private static void modifyStudenSubject(Grade studentSubject) {
        int gradenNumber;
        float gradeValue;

        System.out.println(studentSubject);

        System.out.println("What workshop do you need to modify");
        gradenNumber = askOption() - 1;

        System.out.println("What is the new grade?");

        do {
            gradeValue = inputGrade();
        } while (Float.isNaN(gradeValue));

        studentSubject.modify(gradenNumber, gradeValue);
    }

    public static int askOption() {
        int option;

        Scanner sc;
        sc = new Scanner(System.in);

        System.out.print("\nChoose an option: ");
        try {
            option = sc.nextInt();
        } catch (Exception e) {
            option = 0;
        }
        sc.nextLine();

        return option;
    }

    private static Teacher loadFileJson() {
        Gson gson = new Gson();

        Teacher newTeacher = new Teacher();
        String jsonFile = "";

        try ( Scanner scFile = new Scanner(new File("./InClass.json"))) {
            while (scFile.hasNextLine()) {
                jsonFile += scFile.nextLine();
            }

            newTeacher = gson.fromJson(jsonFile, Teacher.class);

            System.out.println("----------File was loaded----------");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error: File not open or found");
        }

        return newTeacher;
    }

    private static void SaveFileJson(Teacher teacherInfo) {
        Gson gson = new Gson();
        String json = gson.toJson(teacherInfo);

        File file = new File("./InClass.json");
        try ( FileWriter fw = new FileWriter(file);) {
            fw.write(json);
            System.out.println("----------File was saved----------");
        } catch (Exception e) {
            System.out.println("Error: File not open or found");
        }
    }

}
