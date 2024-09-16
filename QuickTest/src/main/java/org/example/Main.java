package org.example;

public class Main {
    public static void main(String[] args) {
        Double[] Temperatures = {100.5, 98.5, 102.0, 103.9, 87.5, 105.2, 90.3,
                94.8, 109.1, 102.1, 107.4, 93.2};
        int longestWave = longestHeatWave(Temperatures);
        System.out.println("Longest Heat wave was: " + longestWave);
    }
    public static int longestHeatWave(Double[] Temperatures ){
        int heatCount = 0;
        int longestWave = 0;
        for (int i = 0; i < Temperatures.length; i++){
            if (Temperatures[i] >= 100.5){
                heatCount++;
                longestWave = heatCount;
            } else if (Temperatures[i] < 100.5){
                heatCount = 0;
            }
        }
        return longestWave;
    }
}