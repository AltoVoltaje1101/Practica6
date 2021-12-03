/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Random;

/**
 *
 * @author felix_5bh1a4y
 */
public class Arreglos {
    public int[] arreglo;
    public Arreglos(int tamano){
        arreglo = new int[tamano];
    }
    public int[] crearArreglo(){
        Random random = new Random();
        for(int  i = 0;i<arreglo.length;i++){
            arreglo[i] = random.nextInt(1000);
        }
        return arreglo;
    }
}
