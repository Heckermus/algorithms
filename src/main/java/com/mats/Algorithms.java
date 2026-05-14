package com.mats;

import java.util.Arrays;

public class Algorithms {

    static int[] output;
    static int[] count = new int[10];

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isSwapped = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!isSwapped) break;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElemIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElemIdx]) minElemIdx = j;
            }
            if (minElemIdx != i) {
                int temp = array[i];
                array[i] = array[minElemIdx];
                array[minElemIdx] = temp;
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int selectedValue = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > selectedValue) {
                array[j + 1] = array[j--];
            }
            array[j + 1] = selectedValue;
        }
    }

    public static void mergeSort(int[] array) {
        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] aux, int l, int h) {
        if (l >= h) return;

        int m = l + ((h - l) >> 1);

        mergeSort(array, aux, l, m);
        mergeSort(array, aux, m + 1, h);

        if (array[m] <= array[m + 1]) return;

        merge(array, aux, l, m, h);
    }

    private static void merge(int[] array, int[] aux, int l, int m, int h) {
        int i = l,
            j = m + 1,
            k = 0;

        while (i <= m && j <= h) {
            if (array[i] <= array[j]) aux[k++] = array[i++];
            else aux[k++] = array[j++];
        }
        while (i <= m) aux[k++] = array[i++];
        while (j <= h) aux[k++] = array[j++];

        for (i = 0, j = l; j <= h; i++, j++) array[j] = aux[i];
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int l, int h) {
        if (l < h) {
            int p = partition(array, l, h);
            quickSort(array, l, p);
            quickSort(array, p + 1, h);
        }
    }

    private static int partition(int[] array, int l, int h) {
        int m = l + ((h - l) >> 1);
        if (array[l] > array[m]) {
            int temp = array[l];
            array[l] = array[m];
            array[m] = temp;
        }
        if (array[l] > array[h]) {
            int temp = array[l];
            array[l] = array[h];
            array[h] = temp;
        }
        if (array[m] > array[h]) {
            int temp = array[m];
            array[m] = array[h];
            array[h] = temp;
        }
        int pivot = array[m];

        int i = l - 1,
            j = h + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i >= j) return j;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void countSort(int[] array) {
        int maxVal = array[0];
        for (int v : array) {
            if (v > maxVal) maxVal = v;
        }

        int[] cntArr = new int[maxVal + 1];
        for (int v : array) cntArr[v]++;

        int idx = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (cntArr[i]-- > 0) array[idx++] = i;
        }
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) heapify(array, array.length, i);

        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) largest = l;
        if (r < n && array[r] > array[largest]) largest = r;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    public static void radixsort(int[] array) {
        int m = array[0];
        for (int i = 1; i < array.length; i++) if (array[i] > m) m = array[i];

        for (int exp = 1; m / exp > 0; exp *= 10) countSort(array, exp);
    }

    private static void countSort(int[] array, int exp) {
        if (output == null || output.length < array.length) output = new int[array.length];
        int i;
        Arrays.fill(count, 0);

        for (i = 0; i < array.length; i++) count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++) count[i] += count[i - 1];

        for (i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < array.length; i++) array[i] = output[i];
    }
}
