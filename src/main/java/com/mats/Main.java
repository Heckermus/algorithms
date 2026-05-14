package com.mats;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Test test = new Test();

        try {
            test.bubbleSortBenchmark();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
