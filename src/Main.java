import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Student stu9 = new Student("Stu 9",9);
            Student stu10 = new Student("Stu 10",10);
            Student stu11 = new Student("Stu 11",11);
            Student stu12 = new Student("Stu 12",12);


        PriorityQueue<Student> stuList = new PriorityQueue<>(new StudentComparator());

        stuList.add(stu9);
        stuList.add(stu10);
        stuList.add(stu11);
        stuList.add(stu12);

        for(Student stu: stuList) {
            System.out.println(stu.getName());
        }
    }
}