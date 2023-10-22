package io.sim3;
/*
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficos {

    public static void main(String[] args) {

        // Cria um conjunto de dados
        XYDataset dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Dados");
        for (int i = 0; i < 100; i++) {
            double x = i;
            double y = Math.sin(x);
            series.add(x, y);
        }
        dataset.addSeries(series);

        // Cria um gráfico
        JFreeChart chart = ChartFactory.createXYLineChart("Gráfico simples", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Configura o gráfico
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);

        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRange(true);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAutoRange(true);

        // Exibe o gráfico
        JFrame frame = new JFrame("Gráfico simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
*/