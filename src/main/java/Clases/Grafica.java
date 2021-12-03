/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.TimeUnit;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author felix_5bh1a4y
 */
public class Grafica {

    public XYDataset dataset;
    public ChartPanel graficaGeneral;
    //1 shell       2 insercion     3 seleccion     4 Quicksort
    //5 bucketsort  6 radixsort     7 sort() metodo de la clase arrays

    public XYSeries[] datosMetodos;

    public Grafica() {
        datosMetodos = new XYSeries[8];
    }

    public void graficar(long[] tiempos, String metodo, int numMetodo) {
        JFreeChart chart = ChartFactory.createXYLineChart("Grafica general",
                "Elementos de cada arreglo", "Tiempo (Nanosegundos)", createDataset(tiempos, numMetodo));
        graficaGeneral = new ChartPanel(chart);
    }

    public XYDataset createDataset(long[] x, int metodo) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries(elegirNombre(metodo));
        for (int i = 0; i < 8; i++) {
            series1.add(i+1, x[i]);
        }
        dataset.addSeries(series1);
        this.datosMetodos[metodo - 1] = series1;
        return dataset;
    }

    public ChartPanel actualizarGrafica(boolean[] checkedBoxes) {
        XYSeriesCollection pokemon = new XYSeriesCollection();
        for (int i = 0; i < 7; i++) {
            if (checkedBoxes[i] == true && this.datosMetodos[i] != null) { 
                System.out.println("Valor de i:" + i + " Metodo:" + elegirNombre(i + 1));
                pokemon.addSeries(datosMetodos[i]);
            }
        }
        JFreeChart chart = ChartFactory.createXYLineChart("Grafica General",
                "Arreglo", "Tiempo", pokemon);
        graficaGeneral = new ChartPanel(chart);
        return graficaGeneral;

    }

    public ChartPanel obtenerPanelGeneral() {
        return graficaGeneral;

    }

    public String elegirNombre(int numMetodo) {
        switch (numMetodo) {
            case 1:
                return "Shell";
            case 2:
                return "Insercion";
            case 3:
                return "Seleccion";
            case 4:
                return "Quicksort";
            case 5:
                return "RadixSort";
            case 6:
                return "BucketSort";
            case 7:
                return "Sort";
            default:
                return "ultimo";
        }
    }

    public void ponerGraficaNueva() {
        XYSeriesCollection dataset = new XYSeriesCollection();
    }

    public void esNulo() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Valor de i:" + i);
            if (datosMetodos[i] == null) {
                System.out.println("Si es nulo");
            }
        }
    }
}
