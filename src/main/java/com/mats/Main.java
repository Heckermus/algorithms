package com.mats;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class Main {

    public static void main(String[] args) {
        TimeSeries x = new TimeSeries("Sorted Amount");
        TimeSeries y = new TimeSeries("Time");

        TimeSeriesCollection data = new TimeSeriesCollection();
        data.addSeries(x);
        data.addSeries(y);

        Plotter plotter = new Plotter("Graph", "X", "Y", data);
        plotter.pack();
        plotter.setVisible(true);
    }
}
