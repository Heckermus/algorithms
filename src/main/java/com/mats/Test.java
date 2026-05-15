package com.mats;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

    private static final int NUMBER_RANGE = 1000;
    private static final int SAMPLES = 10;

    private Timer timer;
    private final Random random = new Random();
    private CSVWriter writer;

    private int[] field;
    private int[] fieldDuplicate;

    public Test() {
        timer = new Timer();
    }

    public void bubbleSortBenchmark() throws IOException {
        writer = new CSVWriter(new FileWriter("bubble_smallscale.csv"));
        double sum = 0;

        String[] data = { String.valueOf(NUMBER_RANGE) };

        //INFO: Warm up
        for (int i = 0; i < SAMPLES; i++) {
            createArray(i, NUMBER_RANGE);
            Algorithms.bubbleSort(field);
        }

        for (int i = 5; i < 100; i += 5) {
            for (int i0 = 0; i0 < SAMPLES; i0++) {
                createArray(i, NUMBER_RANGE);

                timer.start();
                Algorithms.bubbleSort(field);

                sum += timer.stop();

                if (!isFieldSorted()) break;
            }
            sum /= SAMPLES;
            data = append(data, String.format("%.10f", sum));
        }
        writer.writeNext(data);
        writer.close();
        //-------------------------------------------------------------------------
        writer = new CSVWriter(new FileWriter("bubble_smallscale.csv"));
        sum = 0;

        data = new String[] { String.valueOf(NUMBER_RANGE) };

        //INFO: Warm up
        for (int i = 0; i < SAMPLES; i++) {
            createArray(i, NUMBER_RANGE);
            Algorithms.bubbleSort(field);
        }

        for (int i = 5; i < 100; i += 5) {
            for (int i0 = 0; i0 < SAMPLES; i0++) {
                createArray(i, NUMBER_RANGE);

                timer.start();
                Algorithms.bubbleSort(field);

                sum += timer.stop();

                if (!isFieldSorted()) break;
            }
            sum /= SAMPLES;
            data = append(data, String.format("%.10f", sum));
        }
        writer.writeNext(data);
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
