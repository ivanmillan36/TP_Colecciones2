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
public class MenuRestaurant {
    public static void main(String[] args) {
        ArrayList<Plato>platosMenu= new ArrayList<Plato>();
        int cantPlatos;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de platos del menu: ");
        do{
            cantPlatos = sc.nextInt();
            if(cantPlatos <= 0){
                System.out.println("Ingrese un numero mayor que cero...");
            }
        }
        while(cantPlatos <= 0);
        
        
        for(int i=0 ; i<cantPlatos ; i++){
            System.out.println("Plato nº " + (i+1));
            Plato plato = new Plato();
            plato.crearPlato();
            platosMenu.add(plato);
        }
        
        System.out.println("-------------MENU--------------");
        for(Plato plato : platosMenu){
            plato.mostrarInfo();
            System.out.println("*************************************************");
        }
        
    }
    
}
