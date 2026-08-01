import java.util.HashMap;

/**
 * courses class represents a course offered by the school.
 * Manages course details and student enrollment/removal.
 */
class courses {
    // Unique identifier for the course
    public int id;
    
    // Name of the course
    public String name;
    
    // Maximum enrollment capacity for the course
    private int length;
    
    // Maps student IDs to their names for enrolled students
    private HashMap<Integer, String> students = new HashMap<>();

    /**
     * Constructor to initialize a course with ID, name, and maximum capacity.
     * @param id the unique course ID
     * @param name the course name
     * @param length the maximum enrollment capacity
     */
    public courses(int id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }
    /**
     * Enrolls a student in this course if there is available capacity.
     * Prevents duplicate enrollments and notifies when course is full.
     * @param key the student ID
     * @param name the student name
     */
    public void addStudents(int key, String name) {
        if (length != students.size()) {
            if (students.containsKey(key)) {
                System.out.println("Student already enrolled!");
            } else {
                students.put(key, name);
                System.out.println("Student " + key + " " + name + " enrolled!");
            }
        } else {
            System.out.println("Error course is full!");
        }
    }
    /**
     * Retrieves all student IDs enrolled in this course.
     * @return array of student IDs
     */
    public Integer[] getAllStudents() {
        return students.keySet().toArray(new Integer[0]);
    }
    /**
     * Removes a student from the course by their ID.
     * Notifies if the student is not found in the course.
     * @param key the student ID to remove
     */
    public void removeStudents(int key) {
        if (students.containsKey(key)) {
            students.remove(key);
            System.out.println("Student " + key + " " + students.get(key) + " dropped!");
        } else {
            System.out.println("Student not found in this course!");
        }
    }
}