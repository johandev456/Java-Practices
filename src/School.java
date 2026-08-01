import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * School class manages the core operations of the BrightPath school system.
 * Handles student enrollment, course management, and student-course relationships.
 */
class School {
    // Maps student IDs to their names
    private HashMap<Integer, String> students = new HashMap<>();
    
    // Stores all available courses in the school
    private HashSet<courses> allCourses = new HashSet<>();
    
    // Scanner for user input from console
    private Scanner sc = new Scanner(System.in);

    /**
     * Main management system loop. Continuously displays menu and processes user choices
     * until user selects exit option (choice 6).
     */
    public void managementSys() {
        int choice = 0;
        while (choice != 6) {
            menu();
            choice = sc.nextInt();
            handler(choice);
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void menu() {
        System.out.println("1 Add Student\n" +
                "\n" +
                "2 Add Course\n" +
                "\n" +
                "3 Enroll Student in Course\n" +
                "\n" +
                "4 Drop Student from Course\n" +
                "\n" +
                "5 View Student Details\n" +
                "\n" +
                "6 Exit");
    }
    /**
     * Routes user choice to the appropriate action method.
     * @param choice the menu option selected by user
     */
    private void handler(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                addCourse();
                break;
            case 3:
                enroll();
                break;
            case 4:
                unenroll();
                break;
            case 5:
                studentInfo();
                break;
            case 6:
                System.out.println("Closing program!!!!");
                break;
            default:
                System.out.println("Choose a valid option!");
                break;
        }
    }
    /**
     * Adds a new student to the school. Ensures unique student IDs.
     */
    private void addStudent() {
        int idStd;
        while (true) {
            System.out.println("Insert a valid student ID and name");
            idStd = sc.nextInt();
            if (!studentExists(idStd)) break;
        }

        sc.nextLine();
        String nameStd = sc.nextLine();
        students.put(idStd, nameStd);
    }
    /**
     * Creates a new course and adds it to the school catalog.
     * Ensures unique course IDs.
     */
    private void addCourse() {
        System.out.println("Insert a valid course ID, name and max capacity");
        int idCourse;

        while (true) {
            System.out.println("Insert a valid course ID");
            idCourse = sc.nextInt();
            if (findCourseById(idCourse) == null) break;
        }
        sc.nextLine();
        String nameCourse = sc.nextLine();
        int lengthCourse = sc.nextInt();

        courses newCourse = new courses(idCourse, nameCourse, lengthCourse);
        allCourses.add(newCourse);
    }
    /**
     * Enrolls a student in a course. Validates that both student and course exist.
     */
    private void enroll() {
        int studID = -1, courseID = -1;
        boolean exist = false;
        while (!exist) {
            System.out.println("Insert a valid Student ID and Course ID");
            try {
                studID = sc.nextInt();
                sc.nextLine();
                courseID = sc.nextInt();

                String actualStudent = students.get(studID);
                courses actualCourse = findCourseById(courseID);
                if (actualCourse == null || actualStudent == null) {
                    throw new Exception("Couldnt find course or student");
                } else {
                    actualCourse.addStudents(studID, actualStudent);
                    exist = true;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Removes a student from a course. Validates that both student and course exist.
     */
    private void unenroll() {
        int studID = -1, courseID = -1;
        boolean exist = false;
        while (!exist) {
            System.out.println("Insert a valid Student ID and Course ID");
            try {
                studID = sc.nextInt();
                sc.nextLine();
                courseID = sc.nextInt();

                String actualStudent = students.get(studID);
                courses actualCourse = findCourseById(courseID);
                if (actualCourse == null || actualStudent == null) {
                    throw new Exception("Couldnt find course or student");
                } else {
                    actualCourse.removeStudents(studID);
                    exist = true;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Finds a course by its ID.
     * @param ID the course ID to search for
     * @return the course object if found, null otherwise
     */
    private courses findCourseById(int ID) {
        for (courses course : allCourses) {
            if (ID == course.id) {
                return course;
            }
        }
        return null;
    }
    /**
     * Retrieves all courses that a student is enrolled in.
     * @param stdID the student ID
     * @return HashMap of course IDs and names for the student
     */
    private HashMap findAllCourses(int stdID) {
        HashMap<Integer, String> studentCourses = new HashMap<>();
        for (courses course : allCourses) {
            Integer[] courseStdKeys = course.getAllStudents();
            for (Integer student : courseStdKeys) {
                if (student == stdID) {
                    studentCourses.put(course.id, course.name);
                }
            }
        }
        return studentCourses;
    }
    /**
     * Displays detailed information about a student including their enrolled courses.
     */
    private void studentInfo() {
        System.out.println("Insert a valid Student ID");
        int stdID = sc.nextInt();
        HashMap<Integer, String> studentCourses = findAllCourses(stdID);

        System.out.println("Student information");
        System.out.println("Student " + stdID + " " + students.get(stdID));
        System.out.println(studentCourses);
    }
    /**
     * Checks if a student with the given ID already exists.
     * @param ID the student ID to check
     * @return true if student exists, false otherwise
     */
    private boolean studentExists(int ID) {
        return students.containsKey(ID);
    }
}