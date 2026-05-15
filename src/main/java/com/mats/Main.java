package com.mats;

public class Main {

    public static void main(String[] args) {
        Test test = new Test();

        test.heapsortBenchmark();
        test.countsortBenchmark();
        test.mergesortBenchmark();
        test.quicksortBenchmark();
        test.radixsortBenchmark();
        test.shellsortBenchmark();
        test.bubbleSortBenchmark();
        test.insertionSortBenchmark();
        test.selectionSortBenchmark();
    }
}
