package org.example.java_practice;

import java.util.*;
import java.util.stream.Collectors;


class Actor{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Actor(String name, int age){
        this.name = name;
        this.age = age;
    }
}
class Movie implements Comparable<Movie>{
    private double rating;
    private String name;
    private int year;
    private Actor actor;
    @Override
    public int compareTo(Movie m){
        return this.year - m.year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Actor getActor(){
        return actor;
    }

    public Movie(String name, double rating, int year, Actor actor){
        this.name = name;
        this.rating = rating;
        this.year = year;
        this.actor = actor;
    }
}

class CompareRating implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
        if(m1.getRating() < m2.getRating()) return -1;
        if(m1.getRating() > m2.getRating()) return 1;
        else return 0;
    }
}

class CompareActorName implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
        return m1.getActor().getName().compareTo(m2.getActor().getName());
    }
}

class CompareName implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
        return m1.getName().compareTo(m2.getName());
    }
}

public class Compare {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015, new Actor("John", 30)));
        list.add(new Movie("A", 8.7, 1800, new Actor("Ram", 30)));
        list.add(new Movie("B", 8.8, 2017, new Actor("Anmol", 30)));
        list.add(new Movie("C", 8.4, 1999, new Actor("Rakesh", 30)));
        list.add(new Movie("D", 8.9, 2019, new Actor("Bittu", 30)));
        Collections.sort(list);
        System.out.println("Movies after sorting by Year : ");
        list.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()+ " " + movie.getActor().getName()));
        System.out.println("Movies after sorting by Rating : ");
        Collections.sort(list, new CompareRating());
        list.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()+ " " + movie.getActor().getName()));
        System.out.println("Movies after sorting by Name : ");
        Collections.sort(list, new CompareName());
        list.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()+ " " + movie.getActor().getName()));
        System.out.println("Movies after sorting by Actor Name : ");
        Collections.sort(list, new CompareActorName());
        list.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()+ " " + movie.getActor().getName()));


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Raj");
        map.put(2, "Rahul");
        map.put(3, "Nitish");
        map.put(4, "Rakesh");
        map.put(5, "Raj");
        map.put(6, "Rahul");
        map.put(7, "Nitish");



        List<String> list1 = map.entrySet().stream().filter(e->{
            if(e.getValue().charAt(0) == 'R'){
                return true;
            }
            return false;
        }).map(e->e.getValue()).collect(Collectors.toList());

        List<Integer> list2 = map.entrySet().stream().filter(e->{
            if(e.getValue().charAt(0) == 'R'){
                return true;
            }
            return false;
        }).map(e->e.getKey()).collect(Collectors.toList());

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}
