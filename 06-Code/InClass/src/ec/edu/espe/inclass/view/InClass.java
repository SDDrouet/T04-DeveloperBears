package ec.edu.espe.inclass.view;

import com.google.gson.Gson;
import ec.edu.espe.inclass.model.AttendanceRecord;
import ec.edu.espe.inclass.model.Course;
import ec.edu.espe.inclass.model.Student;
import ec.edu.espe.inclass.model.Teacher;
import ec.edu.espe.inclass.model.Tutorship;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
        int option = 0;
        Course course;
        int number;

        while (option != 4) {
            System.out.println("-----Teacher Menu-----");
            System.out.println("1. Enter a course");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Get tutorship record");
            System.out.println("5. Back");

            option = askOption();

            switch (option) {
                case 1:
                    for (int i = 0; i < teacher.getCourses().size(); i++) {
                        System.out.println(i + 1 + ". " + teacher.getCourses().get(i));
                    }

                    System.out.println("Which course do you want to enter: ");
                    number = askOption() - 1;

                    try {
                        course = teacher.getCourses().get(number);
                        ControlCourseMenu(course);
                    } catch (Exception e) {
                        System.out.println("Error: Course was not find");
                    }
                    break;

                case 2:
                    System.out.println("Function for add Course");
                    teacher.addCourse();
                    System.out.println(teacher.getCourses().get(0));
                    break;

                case 3:
                    System.out.println("Function for remove Course");
                    break;

                case 4:
                    for (Tutorship tutorship: teacher.getTutorships()){
                        System.out.println("==============================================");
                        System.out.println("- date: "+ tutorship.getDate());
                        System.out.println("- Course Name: "+ tutorship.getCourseName());
                        System.out.println("- Student Name: "+ tutorship.getName());
                        System.out.println("- Student Id: "+ tutorship.getId());
                        System.out.println("- Student Career: "+ tutorship.getCareer()+ "\n");
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

    private static void ControlCourseMenu(Course course) {
        Student student;        
        int option = 0;
        int number;        
        AttendanceRecord attendanceRecord;
        attendanceRecord = new AttendanceRecord();
        
        while (option != 9) {
            System.out.println(course);
            System.out.println("-----Course Menu-----");
            System.out.println("1. Managament student information");
            System.out.println("2. Show enrolled students");
            System.out.println("3. Take Attendance");
            System.out.println("4. Add student");
            System.out.println("5. Remove student");
            System.out.println("6. Get grade record");
            System.out.println("7. Get attendance record");
            System.out.println("8. Back");

            option = askOption();

            switch (option) {
                case 1:
                    for (int i = 0; i < course.getStudents().size(); i++) {
                        System.out.println((i+1) + ". " + course.getStudents().get(i));
                    }

                    System.out.println("Which course do you want to enter: ");
                    number = askOption() - 1;

                    try {
                        student = course.getStudents().get(number);
                        ControlStudentInfoMenu(student);
                    } catch (Exception e) {
                        System.out.println("Error: Course was not find");
                    }                    
                    
                    break;

                case 2:
                    System.out.println("Function for enrolled students");
                    for (int i = 0; i < course.getStudents().size(); i++) {
                        System.out.println((i+1) + ". " + course.getStudents().get(i));
                    }
                    break;
                    
                case 3:
                    System.out.println("Function for take Attendance");
                    attendanceRecord.add(course.getStudents());
                    break;

                case 4:
                    System.out.println("Function for add student");
                    course.addStudent();
                    System.out.println(course.getStudents().toString());
                    break;

                case 5:
                    System.out.println("Function for remove student");
                    break;

                case 6:
                    System.out.println("Function for grade record");                    
                    break;

                case 7:
                    System.out.println("Function for attendance record");
                    for (Student student1 : course.getStudents()) {
                        System.out.print("- " + student1.getName());
                        System.out.println(": " + student1.getAttendanceRecord());
                    }
                    break;
                    
                case 8:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }
    }

    private static void ControlStudentInfoMenu(Student student) {
        int option = 0;        
        
        while (option != 11) {
            System.out.println(student);
            System.out.println("-----Control student information Menu-----");
            System.out.println(" 1. Add attendance of today");
            System.out.println(" 2. Modify attendance of today");
            System.out.println(" 3. Add workshop grade");
            System.out.println(" 4. Add homework grade");
            System.out.println(" 5. Add tests grade");
            System.out.println(" 6. Add exam grade");
            System.out.println(" 7. Modify workshop grade");
            System.out.println(" 8. Modify homework grade");
            System.out.println(" 9. Modify tests grade");
            System.out.println("10. Modify exam grade");
            System.out.println("11. Back");

            option = askOption();

            switch (option) {
                case 1:
                    System.out.println("Function for Add attendance of today");
                    break;

                case 2:
                    System.out.println("Function for Modify attendance of today");
                    break;

                case 3:
                    System.out.println("Function for Add workshop grade");
                    break;

                case 4:
                    System.out.println("Function for Add homework grade");
                    break;

                case 5:
                    System.out.println("Function for Add test grade");
                    break;

                case 6:
                    System.out.println("Function for Add exam grade");
                    break;

                case 7:
                    System.out.println("Function for Modify workshop grade");
                    break;

                case 8:
                    System.out.println("Function for Modify homework grade");
                    break;

                case 9:
                    System.out.println("Function for Modify test grade");
                    break;

                case 10:
                    System.out.println("Function for Modify exam grade");
                    break;

                case 11:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }

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
