package org.example.java_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student
{
    public int id;
    public String name;
    public int age;
    public String phone;

    public Student(int i, int i1, String rahul, String number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}

public class CollectionPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(23);
        list.add(56);
        list.add(12);

//        int temp = Collections.binarySearch(list, 4);
//        Collections.sort(list, Collections.reverseOrder());
//        int max = Collections.max(list);
//        int min = Collections.min(list);
//        List<String> list1 = new ArrayList<>();
//        list1.add("Hello");
//        list1.add("World");
//        list1.add("Java");
//        Collections.sort(list1);
//        list1.stream().findFirst().ifPresent(System.out::println);
//        list1.stream().findAny().ifPresent(System.out::println);
//        list1.stream().count();
//        list1.stream().distinct();
//        list1.stream().filter(s -> s.startsWith("J")).forEach(System.out::println);
//        list1.stream().map(String::toUpperCase).forEach(System.out::println);
//        list1.stream().flatMap(s -> s.chars().boxed()).forEach(System.out::println);
//        list1.stream().forEachOrdered(System.out::println);
//        list1.stream().forEach(System.out::println);
//        list1.stream().forEachOrdered(System.out::println);
//        list1.stream().count();
//        list1.stream().dropWhile(s -> s.startsWith("H")).forEach(System.out::println);
//        list1.stream().limit(2).forEach(System.out::println);
//        list1.stream().skip(2).forEach(System.out::println);
//        System.out.println(temp + " " + max + " "+ min);
//        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
//         list.stream().forEach(System.out::println);

         List<Student> listOfStudents = new ArrayList<>();
         listOfStudents.add(new Student(1, 23, "Rahul", "1234567890"));
         listOfStudents.add(new Student(2, 24, "Ram", "1234567890"));
            listOfStudents.add(new Student(3, 35, "Ramesh", "1234567890"));
            listOfStudents.add(new Student(10, 36, "Rakesh", "1234567890"));
            listOfStudents.add(new Student(5, 27, "Lokesh", "1234567890"));
            listOfStudents.add(new Student(166, 48, "Lomesh", "1234567890"));
            listOfStudents.add(new Student(7, 29, "Man", "1234567890"));

            listOfStudents.stream().sorted((s1, s2) -> s1.age - s2.age).forEach(s -> System.out.println(s.name));
    }

}
