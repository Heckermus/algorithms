package com.mats;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

    private static final int NUMBER_RANGE = 1000;
    private static final int SAMPLES = 10;
    private static final int[] SIZES = {
        10,
        20,
        30,
        40,
        50,
        60,
        70,
        80,
        90,
        100,
        250,
        500,
        750,
        1000,
        2500,
        5000,
        7500,
        10000,
        25000,
        50000,
        75000,
        100000,
        250000,
        500000,
        750000,
        1000000,
        2500000,
        5000000,
        7500000,
        10000000,
        25000000,
        50000000,
        75000000,
        100000000,
        250000000,
        500000000,
    };

    private final Timer timer = new Timer();
    private final Random random = new Random();

    private int[] field;
    private int[] fieldDuplicate;

    public void bubbleSortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("bubble.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Bubblesort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 20; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.bubbleSort(field);
            }

            for (int i = 0; i < 20; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.bubbleSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectionSortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("selection.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Selectionsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 22; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.selectionSort(field);
            }

            for (int i = 0; i < 22; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.selectionSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertionSortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("insertion.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Insertionsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 23; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.insertionSort(field);
            }

            for (int i = 0; i < 23; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.insertionSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mergesortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("merge.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Mergesort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 36; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.mergeSort(field);
            }

            for (int i = 0; i < 36; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.mergeSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quicksortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("quick.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Quicksort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 31; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.quickSort(field);
            }

            for (int i = 0; i < 31; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.quickSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countsortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("count.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Countsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 36; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.countSort(field);
            }

            for (int i = 0; i < 36; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.countSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shellsortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("shell.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Shellsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 31; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.shellSort(field);
            }

            for (int i = 0; i < 31; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.shellSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void heapsortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("heap.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Heapsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 29; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.heapSort(field);
            }

            for (int i = 0; i < 29; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.heapSort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void radixsortBenchmark() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("radix.csv"));
            double sum = 0;
            int runs = 0;

            String[] prefix = { "", "Radixsort-" + String.valueOf(NUMBER_RANGE) };
            writer.writeNext(prefix);

            //INFO: Warm up
            for (int i = 0; i < 32; i++) {
                System.out.println("Warming up: " + SIZES[i]);
                createArray(SIZES[i], NUMBER_RANGE);
                Algorithms.radixsort(field);
            }

            for (int i = 0; i < 32; i++) {
                sum = 0;
                runs = 0;
                String[] data = { String.valueOf(SIZES[i]) };
                for (int i0 = 0; i0 < SAMPLES; i0++) {
                    System.out.println();
                    runs += 1;

                    System.out.println("Creating Array: " + SIZES[i] + " Sample: " + i0);
                    createArray(SIZES[i], NUMBER_RANGE);

                    System.out.println("Sorting: " + SIZES[i] + " Sample: " + i0);
                    timer.start();
                    Algorithms.radixsort(field);
                    sum += timer.stop();

                    if (!isFieldSorted()) break;
                    System.out.println("Sorting complete " + SIZES[i] + " Sample: " + i0);
                }
                sum /= runs;
                data = append(data, String.format("%.6f", sum));
                writer.writeNext(data);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void outputField() {
        StringBuilder sb = new StringBuilder("Output: ");
        for (int v : field) sb.append(v).append(' ');
        System.out.println(sb);
    }
}
