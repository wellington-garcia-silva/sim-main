package io.sim4;

public class Pm {
    public static void main(String[] args) {
        int[] sequenceList = new int[10];

        int element = 5;
        for (int i = 0; i < 10; i++) {
            sequenceList[i] += (element + i * 2);
        }

        System.out.println(sequenceList[3] - (element-1));
    }
}
