package org.example;

public class FunWithJava {
    public static void main(String[] args) {
        double[] list = {99.1, 142.0, 85.0, 85.1, 84.6, 94.3, 124.9, 98.0, 101.0, 102.5};

        for (int i = list.length - 1; i < list.length; i--){
            if (list[i] < 85.0 || list[i] > 120.0){
                list[i] = 0;

            }
            if (list[i + 1] != 0 ){
                list[i] = list[i+1];
            }
        }
    }
}