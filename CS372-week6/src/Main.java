import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "123 Maple St"));
        students.add(new Student(2, "Bob", "456 Oak St"));
        students.add(new Student(3, "Charlie", "789 Pine St"));
        students.add(new Student(4, "David", "321 Birch St"));
        students.add(new Student(5, "Eve", "654 Cedar St"));
        students.add(new Student(6, "Frank", "987 Elm St"));
        students.add(new Student(7, "Grace", "213 Spruce St"));
        students.add(new Student(8, "Heidi", "546 Willow St"));
        students.add(new Student(9, "Ivan", "879 Fir St"));
        students.add(new Student(10, "Judy", "132 Ash St"));

        // Sort by name
        SelectionSort.selectionSort(students, new Student.NameComparator());
        System.out.println("Students sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort by roll number
        SelectionSort.selectionSort(students, new Student.RollnoComparator());
        System.out.println("Students sorted by roll number:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class SelectionSort {
    public static void selectionSort(List<Student> list, Comparator<Student> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Student temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}
