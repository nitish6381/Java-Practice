package org.example.java_practice;

public interface DefaultStaticMethod {
    public void show();
    default void display() {
        System.out.println("Default Method");
    }

    static void print() {
        System.out.println("Static Method");
    }
}
