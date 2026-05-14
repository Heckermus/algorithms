package com.mats;

import java.util.Random;

public class Test {

    private final Timer timer = new Timer();
    private final Random random = new Random();

    private int[] field;
    private int[] fieldDuplicate;

    public Test(int arrayLength, int numberRange) {}

    public void createField(int arrayLength, int numberRange) {
        field = new int[arrayLength];
        fieldDuplicate = new int[arrayLength];
        for (int i = 0; i < field.length; i++) {
            field[i] = fieldDuplicate[i] = random.nextInt(numberRange);
        }
    }

    public void resetField() {
        System.arraycopy(fieldDuplicate, 0, field, 0, field.length);
    }

    public boolean isFieldSorted() {
        for (int i = 0; i < field.length - 1; i++) {
            if (field[i] > field[i + 1]) return false;
        }
        return true;
    }

    //info: timer methods
    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        System.out.println("Seconds passed: " + timer.stop());
    }

    //info: output related methods
    public void outputField() {
        StringBuilder sb = new StringBuilder("Output: ");
        for (int v : field) sb.append(v).append(' ');
        System.out.println(sb);
    }

    public void clearOutput() {
        System.out.print('\u000C');
    }
}
