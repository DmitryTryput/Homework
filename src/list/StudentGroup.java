package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentGroup {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bill", "Gates", 24, 7.3));
        students.add(new Student("Steve", "Jobs", 18, 6.1));
        students.add(new Student("Mark", "Zuckerberg", 20, 8.1));
        students.add(new Student("Steve", "Wozniak", 19, 8.8));
        System.out.println(maxAvrRating(students));
        System.out.println();
        Collections.sort(students, new Student.FullNameComparator());
        printList(students);
        System.out.println();
        Collections.sort(students, new Student.AgeComparator());
        printList(students);
        System.out.println();
        Collections.sort(students, new Student.AvrRatingComparator());
        printList(students);
    }

    public static Student maxAvrRating(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        Student maxRating = list.get(0);
        while (iterator.hasNext()) {
            Student currentStudent = iterator.next();
            if (maxRating.getAvrRating() < currentStudent.getAvrRating()) {
                maxRating = currentStudent;
            }
        }
        return maxRating;
    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
