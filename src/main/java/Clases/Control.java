/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author felix_5bh1a4y
 */
public class Control {

    public int[] arreglo;
    private Ordenamientos ordenamientos;
    public Grafica grafica;

    public Control() {
        grafica = new Grafica();
        ordenamientos = new Ordenamientos();
    }

    public void crearArchivoTiempos(long[] tiempo, String metodo, int numMetodo) {
        String nombre = metodo + ".csv";
        try ( PrintWriter writer = new PrintWriter(nombre)) {
            int valor = 100;
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                string.append(i);
                string.append(',');
                string.append(valor);
                string.append(',');
                string.append(tiempo[i]);
                writer.println(string.toString());
                valor *= 5;
                string = new StringBuilder();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        grafica.graficar(tiempo, metodo, numMetodo);
    }
    
    /* Metodo utilizado para depositar los elementos
    del arreglo dentro de un archivo .csv, para leerlo
    despues, cuando se este realizando el proceso de ordenamiento
    */
    public void crearArchivoArreglo(int tamano) {
        System.out.println("" + tamano);
        arreglo = new int[tamano];
        llenarArreglo();
        String nombre = tamano + ".csv";
        try {
            PrintWriter writer = new PrintWriter(nombre);
            for (int i = 0; i < arreglo.length; i++) {
                writer.println(arreglo[i]);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodo utilizado para rellenar el arreglo 
    //con numeros aleatoriois desde el 0 hasta el 1000
    public void llenarArreglo() {
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(1000);
        }
    }

    /*
    public ArrayList<Integer> leerArchivos(String ubicacion) {
        File f = new File(ubicacion);
        Scanner s;
        ArrayList<Integer> cadena = new ArrayList<>();
        int i = 0;
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                cadena.add(Integer.parseInt(s.nextLine()));
                i++;
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cadena;
    }
     */
    public int[] lecturaArchivos(String ubicacion) {
        ArrayList<Integer> cadena = new ArrayList<>();
        try {
//parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader(ubicacion));
            String a = br.readLine();
            int i = 0;
            do//returns a Boolean value  
            {
                if (i % 10000.0 == 0) {
                    System.out.println("Leyendo archivo:" + i);
                }
                cadena.add(Integer.parseInt(a));
                i++;
            } while ((a = br.readLine()) != null);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cadena.stream().mapToInt(i -> i).toArray();
    }

    public void imprimir(String[] datos, int[] datos1) {
        for (int i = 0; i < datos1.length; i++) {
            System.out.print(datos1[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }
    
    
    public long ordenamientosGenerales(int arregloDesordenado, int numMetodo) {
        System.out.println("Archivo a buscar :" + arregloDesordenado + ".csv");
        long startTime = System.nanoTime();
        switch (numMetodo) {
            case 1:
                System.out.println("Usando shell");
                ordenamientos.shell(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"),
                        arregloDesordenado);
                break;
            case 2:
                System.out.println("Usando insercion");
                ordenamientos.insercion(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"),
                        arregloDesordenado);
                break;
            case 3:
                System.out.println("Usando seleccion");
                ordenamientos.seleccion(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"),
                        arregloDesordenado);
                break;
            case 4:
                System.out.println("Usando quicksort");
                ordenamientos.quicksort(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"),
                        arregloDesordenado);
                break;
            case 5:
                System.out.println("Usando radixsort");
                ordenamientos.radixSort(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras"
                        + " de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"));
                break;
            case 6:
                System.out.println("Usando bucketsort");
                ordenamientos.bucketSort(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras "
                        + "de datos\\Laboratorio\\Practica6\\" + arregloDesordenado + ".csv"));
                break;
            case 7:
                System.out.println("Usando sort");
                ordenamientos.sort(lecturaArchivos("D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\"
                        + "Practica6\\" + arregloDesordenado + ".csv"));
                break;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;

    }

    public ChartPanel actualizarGrafica(boolean[] checkedBoxes) {
        grafica.esNulo();
        return grafica.actualizarGrafica(checkedBoxes);
    }

    public ChartPanel obtenerGrafica() {
        return grafica.obtenerPanelGeneral();
    }
}
