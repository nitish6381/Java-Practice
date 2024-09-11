package org.example.java_practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface IT1 {
    static void method1(){

    }
}
interface Interface1 {
    void method1();

    default void method2(){

    }

    static void method3(){

    }
}

interface I2 extends Interface1 {
    default void method4(){

    }
    static void method5(){

    }
    public void method6();
}

abstract class abs implements Interface1, I2 {

    abstract void method7();
    static void method3(){

    }
}

public class InterfacePractice extends abs {
    public void method7(){
        System.out.println("Method 1");
    }
    public void method1(){
        System.out.println("Method 1");
    }
    public void method6(){
        System.out.println("Method 2");
    }
    public static void main(String[] args) {
        Interface1.method3();
        Interface1 itr = new InterfacePractice();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Collections.reverse(list);
        list.stream().forEach(System.out::println);
        itr.method2();
        itr.method1();
        IT1.method1();
    }
}
