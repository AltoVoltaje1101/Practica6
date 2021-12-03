
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author felix_5bh1a4y
 */
public class Ordenamientos {

    int[] arreglo;

    public Ordenamientos() {

    }

    public void shell(int[] a, int n) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante shell");

        int inter, band, i;
        inter = n + 1;
        while (inter > 1) {
            int entero = inter / 2;
            inter = entero;
            band = 1;
            while (band == 1) {
                band = 0;
                i = 0;
                while ((i + inter) <= n - 1) {
                    if (a[i] > a[i + inter]) {
                        int aux = a[i];
                        a[i] = a[i + inter];
                        a[i + inter] = aux;
                        band = 1;
                    }
                    i = i + 1;
                }
            }
        }
    }

    public void insercion(int[] a, int n) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante insercion");

        int aux, k;
        for (int i = 0; i < n; i++) {
            aux = a[i];
            k = i;
            while (k >= 1 && a[k - 1] > aux) {
                a[k] = a[k - 1];
                k--;
            }
            a[k] = aux;
        }
    }

    public void seleccion(int[] a, int n) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante seleccion");

        int menor, k;
        for (int i = 0; i < n - 1; i++) {
            menor = a[i];
            k = i;
            for (int j = i; j < n; j++) {
                if (a[j] < menor) {
                    menor = a[j];
                    k = j;
                }
            }
            a[k] = a[i];
            a[i] = menor;
        }
    }

    public void imprimir() {
        for (int i = 0; i < this.arreglo.length; i++) {
            System.out.println("" + arreglo[i] + "\n");
        }
    }

    public void quicksort(int[] a, int n) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante quicksort");
        recursivo(0, n - 1, a);

    }

    public void recursivo(int inicio, int fin, int[] arreglo) {
        int izq = inicio, der = fin, pos = inicio;
        boolean band = true;
        while (band == true) {
            band = false;
            while (arreglo[pos] <= arreglo[der] && pos != der) {
                der = der - 1;
            }
            if (pos != der) {
                int aux = arreglo[pos];
                arreglo[pos] = arreglo[der];
                arreglo[der] = aux;
                pos = der;
                while (arreglo[pos] >= arreglo[izq] && pos != izq) {
                    izq = izq + 1;
                }
                if (pos != izq) {
                    band = true;
                    aux = arreglo[pos];
                    arreglo[pos] = arreglo[izq];
                    arreglo[izq] = aux;
                    pos = izq;
                }
            }

        }
        if ((pos - 1) > inicio) {
            recursivo(inicio, pos - 1, arreglo);
        }
        if (fin > (pos + 1)) {
            recursivo(pos + 1, fin, arreglo);
        }
    }

    public void radixSort(int[] a) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante radixsort");

        int[][] bucket = new int[10][a.length];
        int[] bucketOfElement = new int[10];
        int max = 0;
        // Encuentra el elemento más grande en la matriz
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        // Calcula la longitud del elemento más grande
        int maxLength = Integer.toString(max).length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // Coloca los números en el array en los cubos correspondientes según su uni, dec o cent
            for (int j = 0; j < a.length; j++) {
                int digit = a[j] / n % 10;
                // Asignar el valor de arr [i] a la matriz bidimensional en el depósito
                bucket[digit][bucketOfElement[digit]] = a[j];
                bucketOfElement[digit]++;
            }
            int index = 0;
            // Lee los elementos en el depósito y los asigna al arreglo
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketOfElement[j]; k++) {
                    a[index] = bucket[j][k];
                    index++;
                }
                bucketOfElement[j] = 0;// Borrar el número de elementos en cada uno
            }
        }
    }

    public void bucketSort(int[] array) {
        System.out.println("Ordenando el arreglo " + array.length + " mediante bucketsort");

        int[] Bucket = new int[maximoValor(array) + 1];  // crea una matriz de cubos
        int[] sortedArray = new int[array.length];  // creando una matriz para almacenar los elementos ordenados

        for (int i = 0; i < array.length; i++) {
            Bucket[array[i]]++;   //clasificar secciones individuales
        }
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++) {
            for (int j = 0; j < Bucket[i]; j++) {
                sortedArray[outPos++] = i;  // concatenar todos las secciones en un arreglo.
            }
        }
        this.arreglo = sortedArray;  // Igualamos el arreglo ordenado a nuestro arreglo de atributo.
    }

    public int maximoValor(int[] array) {
        int valorMaximo = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > valorMaximo) {
                valorMaximo = array[i];
            }
        }
        return valorMaximo;
    }

    public void sort(int[] a) {
        System.out.println("Ordenando el arreglo " + a.length + " mediante array.sort");

        Arrays.sort(a, 0, a.length);
    }

    public int[] Crear(int[] a) {
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(40);
            System.out.println("" + a[i] + "\n");
        }
        return a;
    }

    //busquedas
    public void binaria(int[] a, int n, int x) {
        int izq = 0, der = n, b = 0, cen = 0;
        while (izq <= der && b == 0) {
            cen = (izq + der) / 2;
            System.out.println("res de la division:" + cen);
            if (x == a[cen]) {
                b = 1;
            } else {
                if (x > a[cen]) {
                    izq = cen + 1;
                } else {
                    der = cen - 1;
                }
            }
        }
        if (b == 1) {
            System.out.println("El elemento esta en:" + cen);
        } else {
            System.out.println("El elemento no esta en el arreglo");
        }

    }

}
