import java.util.HashSet;
import java.util.Set;

/**
 * Created by qwerty on 12-Mar-17.
 */
public class Activity {
    private String name;
    private Set<Student> assignedStudents;

    public Activity(String name) {
        this.name = name;
        assignedStudents = new HashSet<>();
    }

    public void setAssignedStudent(Student Stud) {
        assignedStudents.add(Stud);
    }

    public void deleteAssignedStudent(Student Stud) {
        assignedStudents.remove(Stud);
    }

    public String getName() {
        return name;
    }

    public Set<Student> getAssignedStudents() {
        return assignedStudents;
    }
}
