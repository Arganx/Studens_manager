import java.util.*;

/**
 * Created by qwerty on 12-Mar-17.
 */
public class University {
    private List<Student> students;
    private List<Activity> activities;

    public void printStudents()
    {
        Iterator<Student> s = students.iterator();
        while(s.hasNext())
        {
            System.out.println(s.next().getName());
        }
    }
    public University() {
        activities = new ArrayList<>();
        students = new ArrayList<>();
    }

    public Student AddStudent(String name, String surname, StudentType typ)
    {
        Student s= new Student(name,surname,typ);
        students.add(s);
        return s;
    }
    public Activity AddActivities(String name)
    {
        Activity a = new Activity(name);
        activities.add(a);
        return a;
    }
    public void assigneStudent(Student stud,Activity act)
    {
        stud.setActivities(act);
        act.setAssignedStudent(stud);
    }
    public void deleteStudent(Student stud)
    {
        students.remove(stud);
        Iterator<Activity> i = activities.iterator();
        while(i.hasNext())
        {
            Activity a = i.next();
            a.deleteAssignedStudent(stud);
        }
    }
    public void deleteStudent(int id)
    {
        Iterator<Student> i = students.iterator();
        Student him;
        while(i.hasNext())
        {
            him = i.next();
            if(him.getId()==id)
            {
                deleteStudent(him);
                return;
            }
        }
    }
    public void deleteStudents(Activity act)
    {
        Iterator<Activity> i = activities.iterator();
        Student him;
        while(i.hasNext())
        {
            Activity tmp = i.next();
            if(tmp==act)
            {
                for(Iterator<Student> s= tmp.getAssignedStudents().iterator();s.hasNext();)
                {
                    him=s.next();
                    students.remove(him);

                    Iterator<Activity> k = activities.iterator();
                    while(k.hasNext())
                    {
                        Activity a = k.next();
                        if(a==act)
                        {
                            continue;
                        }
                        a.deleteAssignedStudent(him);
                    }

                    s.remove();
                }
                return;
            }
        }
    }
    public boolean belongs(Student stud,Activity act)
    {
        Iterator<Student> s = act.getAssignedStudents().iterator();
        while(s.hasNext())
        {
            /*
            if(s.next()==stud)
            {
                return true;
            }
            */
            Student tmp =s.next();
            if(tmp.getName().contains(stud.getName()) && tmp.getSurname().contains(stud.getSurname()) && tmp.getId()==stud.getId())
            {
                return true;
            }
        }
        return false;
    }
    private boolean help(Student stud)
    {
        Iterator<Activity> a = activities.iterator();
        while(a.hasNext())
        {
            if(belongs(stud,a.next()))
            {
                return true;
            }
        }
        return false;
    }
    public Queue<Student> lazyStudents()
    {
        Queue<Student> queue = new LinkedList<Student>();
        Iterator<Student> s = students.iterator();
        while(s.hasNext())
        {
            Student stud = s.next();
            if(help(stud)==false)
            {
                queue.add(stud);
            }
        }
        return queue;
    }
    public void printfromqueue(Queue<Student> a)
    {
        Iterator<Student> i = a.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next().getName());
        }
    }
    public Stack<Student> workingOn(int n)
    {
        Stack<Student> s = new Stack<Student>();
        Iterator<Student> i = students.iterator();
        Student tmp;
        Activity tmp2;
        int counter;
        while(i.hasNext())
        {
            tmp = i.next();
            counter=0;
            Iterator<Activity> a = activities.iterator();
            while(a.hasNext())
            {
                tmp2=a.next();
                if(belongs(tmp,tmp2))
                {
                    counter++;
                }
                if(counter==n)
                {
                    s.add(tmp);
                }
            }
        }
        return s;
    }
    public Student bestOne()
    {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getActivities2().size()-o2.getActivities2().size();
            }
        };
        return Collections.max(students,comparator);
    }
    public HashMap<StudentType,Integer> numbers()
    {
        HashMap<StudentType,Integer> hm = new HashMap<StudentType,Integer>();
        Iterator<Student> s = students.iterator();
        int a=0,b=0,c=0;
        while(s.hasNext())
        {
            StudentType tmp = s.next().getType();
            switch (tmp.toString())
            {
                case "Stationary":
                    a++;
                    break;
                case "Nonstationary":
                    b++;
                    break;
                case "Postgraduate":
                    c++;
                    break;
            }
        }
        hm.getOrDefault("Stationary",a);
        hm.getOrDefault("Nonstationary",b);
        hm.getOrDefault("Postgraduate",c);
        return hm;
    }
    public void sorting()
    {
        Collections.sort(students);
        Student tmp;
        Iterator<Student> s = students.iterator();
        while(s.hasNext())
        {
            tmp = s.next();
            System.out.print(tmp.getName());
            System.out.print(" ");
            System.out.println(tmp.getSurname());
        }
    }
    public boolean together(Activity a1, Activity a2)
    {
        if(Collections.disjoint(a1.getAssignedStudents(),a2.getAssignedStudents())==true)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
