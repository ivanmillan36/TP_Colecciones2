/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones2;

import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class Ingrediente {
    String nombre;
    double cantidad;
    String unidadDeMedida;
    
    
    public void crearIngrediente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del ingrediente: ");
        this.nombre = sc.nextLine();
        System.out.println("Ingrese cantidad: ");
        this.cantidad = sc.nextDouble();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese unidad de medida: ");
        this.unidadDeMedida = teclado.nextLine();
    }
    
    public void mostrarInfo(){
        System.out.printf("%-20s%-20s%-20s\n",this.nombre,String.valueOf(this.cantidad),this.unidadDeMedida);
    }
}
