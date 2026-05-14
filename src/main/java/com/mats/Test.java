package com.mats;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

    private Timer timer;
    private final Random random = new Random();
    private CSVWriter writer;

    private int[] field;
    private int[] fieldDuplicate;

    public Test() {
        timer = new Timer();
    }

    public void bubbleSortBenchmark() throws IOException {
        writer = new CSVWriter(new FileWriter("bubble.csv"));
        for (int i = 10; i < 100; i++) {
            String[] data = { String.valueOf(i) };
            System.out.println(i);
            for (int i0 = 10; i0 < 10000; i0 += 10) {
                createArray(i0, i);
                timer.start();
                Algorithms.bubbleSort(field);
                data = append(data, String.format("%.10f", timer.stop()));
                if (!isFieldSorted()) break;
            }
            writer.writeNext(data);
        }
        writer.close();
    }

    public static String[] append(String[] arr, String value) {
        String[] result = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        result[arr.length] = value;
        return result;
    }

    public void createArray(int arrayLength, int numberRange) {
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
