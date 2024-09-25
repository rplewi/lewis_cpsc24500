package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String name = scan.nextLine();
        String fullName[] = name.split(" ");
        String firstName = fullName[0];
        String lastName = fullName[1];
        System.out.println("Enter your age: ");
        int age = scan.nextInt();
        int ageInMonths = age * 12;
        System.out.printf("Hi! You are %s %s and you're %d months old", firstName, lastName ,ageInMonths);

    }
}