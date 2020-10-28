/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class Plato {
    String nombreCompleto;
    double precio;
    boolean esBebida;
    ArrayList<Ingrediente> ingredientes = new ArrayList();
    
    public void crearPlato(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del plato: ");
        this.nombreCompleto = sc.nextLine();
        System.out.println("Ingrese el precio del plato: ");
        this.precio = sc.nextDouble();
        System.out.println("Es bebida (Y/N):");
        Scanner teclado = new Scanner(System.in);
        if(teclado.nextLine().equalsIgnoreCase("Y")){
            this.esBebida = true;
        }else{
            this.esBebida = false;                    
        }
        
        cargarIngredientes(); 
    }
    
    public void cargarIngredientes(){
        if(!this.esBebida){
            int cantIngredientes;
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la cantidad de ingredientes que componen al plato: " + this.nombreCompleto);
            do{
                cantIngredientes = sc.nextInt();
                if(cantIngredientes <= 0){
                    System.out.println("Ingrese un numero mayor que cero...");
                }
            }while(cantIngredientes <= 0);
            
            for(int i=0 ; i<cantIngredientes ; i++){
                Scanner teclado = new Scanner(System.in);
                System.out.println("Ingrediente nº" + (i+1));
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.crearIngrediente();
                this.ingredientes.add(ingrediente);
            }
        }
    }
    
    public void mostrarInfo(){
        System.out.println(this.nombreCompleto);
        System.out.println("Precio:\t" + this.precio);
        if(!this.esBebida){
            System.out.println("Ingredientes:");
            System.out.printf("%-20s%-20s%-20s\n","NOMBRE","CANTIDAD","UNIDAD DE MEDIDA");
            for(Ingrediente ingrediente : this.ingredientes){
                ingrediente.mostrarInfo();
            }
        }
    }
}
