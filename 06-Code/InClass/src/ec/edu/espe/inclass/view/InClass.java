package ec.edu.espe.inclass.view;

import ec.edu.espe.inclass.model.Teacher;
import java.util.Scanner;

/**
 *
 * @author Alejandro Cuadrado, Developer Bears, DCCO-ESPE
 * @author Alexander Guaman, Developer Bears, DCCO-ESPE
 * @author Sheylee Enriquez, Developer Bears, DCCO-ESPE
 * @author Stephen Drouet, Developer Bears, DCCO-ESPE
 */
public class InClass {
    public static void main(String[] args) {

        Teacher teacher;
        teacher = new Teacher();
        teacher.setId("L002424");
        teacher.setName("Santiago Valencia");

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

        while (option != 4) {
            System.out.println("-----Teacher Menu-----");
            System.out.println("1. Enter a course");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Back");

            option = askOption();

            switch (option) {
                case 1:
                    ControlCourseMenu();
                    break;

                case 2:
                    System.out.println("Function for add Course");
                    break;

                case 3:
                    System.out.println("Function for remove Course");
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }
    }

    private static void ControlCourseMenu() {
        int option = 0;

        while (option != 8) {
            System.out.println("-----Course Menu-----");
            System.out.println("1. Managament student information");
            System.out.println("2. Show enrolled students");
            System.out.println("3. Add student");
            System.out.println("4. Remove student");
            System.out.println("5. Get grade record");
            System.out.println("6. Get attendance record");
            System.out.println("7. Get tutorship record");
            System.out.println("8. Back");

            option = askOption();

            switch (option) {
                case 1:
                    ControlStudentInfoMenu();
                    break;

                case 2:
                    System.out.println("Function for enrolled students");
                    break;

                case 3:
                    System.out.println("Function for add student");
                    break;

                case 4:
                    System.out.println("Function for remove student");
                    break;

                case 5:
                    System.out.println("Function for grade record");
                    break;

                case 6:
                    System.out.println("Function for attendance record");
                    break;

                case 7:
                    System.out.println("Function for tutorship record");
                    break;

                case 8:
                    break;

                default:
                    System.out.println("Error: Invalid option try again.");
            }
        }
    }

    private static void ControlStudentInfoMenu() {
        int option = 0;

        while (option != 11) {
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
}
