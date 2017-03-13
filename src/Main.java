public class Main {

    public static void main(String[] args) {
        University AGH = new University();
        Activity a,b,c;
        Student s,j,k;
        a=AGH.AddActivities("Java");
        b=AGH.AddActivities("Bazy danych");
        c=AGH.AddActivities("Sieci");
        j=AGH.AddStudent("Mikolaj","Wasniewski",StudentType.Stationary);
        s=AGH.AddStudent("Jan","Kowalski",StudentType.Stationary);
        k=AGH.AddStudent("Maciej","Ziemba",StudentType.Stationary);
        AGH.AddStudent("Maciej","Truczka",StudentType.Stationary);
        AGH.assigneStudent(s,a);
        AGH.assigneStudent(k,b);
        AGH.assigneStudent(s,c);
        AGH.assigneStudent(s,b);
        AGH.assigneStudent(j,c);
        System.out.println(AGH.numbers().get(StudentType.Stationary));
        //AGH.printStudents();
        //AGH.deleteStudents(b);
        //AGH.printStudents();
        //System.out.println(AGH.bestOne().getName());
        //AGH.sorting();
        //System.out.println(AGH.together(a,c));
        //AGH.printfromqueue(AGH.lazyStudents());
        //System.out.println(AGH.belongs(s,b));
        //AGH.deleteStudents(a);
       // System.out.println(s.getId());
        //System.out.println(j.getId());
        //System.out.println(k.getId());
        //s.getActivities();
        //AGH.deleteStudent(s);
       // AGH.deleteStudent(1);
        //AGH.printStudents();
    }
}
