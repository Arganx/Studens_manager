import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qwerty on 12-Mar-17.
 */
public class Student implements Comparable<Student> {
    public Student(String name, String surname, StudentType type) {
        this.name = name;
        Surname = surname;
        this.type = type;
        counter++;
        id=counter;
        activities = new ArrayList<>();
    }
    private static int counter;
    static{
        counter=0;
    }
    private int id;

    @Override
    public int compareTo(Student o) {
        if(this.Surname.compareTo(o.Surname)==0)
        {
            return this.name.compareTo(o.name);
        }
        return this.Surname.compareTo(o.Surname);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;
    private String Surname;
    private StudentType type;
    private List<Activity> activities;

    public void setActivities(Activity act) {
        activities.add(act);
    }

    public List<Activity> getActivities2() {
        return activities;
    }

    public void getActivities() {
        Iterator<Activity> i = activities.iterator();
        while(i.hasNext())
        {
            Activity a = i.next();
            System.out.println(a.getName());
        }
    }

    public String getSurname() {
        return Surname;
    }

    public StudentType getType() {
        return type;
    }
}
