package org.example;

public class Main {
    public static void main(String[] args) {
        String phrase = "String objects store text.";
        int len = phrase.length();
        System.out.printf("The number of characters in the String \"%s\" is %d. \n" , phrase, len);
        String part = phrase.substring(3,7);
        System.out.printf("The characters between position 3 and up to 7 are %s\n", part);
        String shouted = phrase.toUpperCase();
        System.out.printf("In all uppercase it is %s\n", shouted);
        int foundAt = phrase.indexOf("obj");
        System.out.printf("The characters \"obj\" were found at position %d.\n", foundAt);

    }
}