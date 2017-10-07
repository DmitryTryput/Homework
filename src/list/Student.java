package list;

import java.util.Comparator;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private double avrRating;

    public Student(String firstName, String lastName, int age, double avrRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avrRating = avrRating;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAvrRating() {
        return avrRating;
    }

    public String toString() {
        return firstName + " " + lastName + " Возраст: " + age + " Средний балл: " + avrRating;
    }

    static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student firstStudent, Student secondStudent) {
            return new Integer(firstStudent.getAge()).compareTo(secondStudent.getAge());
        }
    }

    static class AvrRatingComparator implements Comparator<Student> {
        @Override
        public int compare(Student firstStudent, Student secondStudent) {
            return new Double(firstStudent.getAvrRating()).compareTo(secondStudent.getAvrRating());
        }
    }

    static class FullNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student firstStudent, Student secondStudent) {
            return (firstStudent.getFirstName() + firstStudent.getLastName())
                    .compareTo((secondStudent.getFirstName() + secondStudent.getLastName()));
        }
    }
}