package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        int num = ran.nextInt(25);
        System.out.printf("The number we picked was %d.",num);
    }
}