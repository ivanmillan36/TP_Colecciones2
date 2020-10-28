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
public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno>alumnos= new ArrayList<Alumno>();
        int cantAlumnosACargar = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de alumnos a cargar: ");
        do{
            cantAlumnosACargar = sc.nextInt();
            if(cantAlumnosACargar <= 0){
                System.out.println("Ingrese un numero mayor que cero...");
            }
        }while(cantAlumnosACargar <= 0);
        
        
        for(int i=0; i<cantAlumnosACargar ; i++){
            Scanner teclado = new Scanner(System.in);
            String nombreAlumno = "";
            long legajo = 0;
            System.out.println("Ingrese nombre completo del alumno " + (i+1) + " : ");
            nombreAlumno = teclado.nextLine();
            System.out.println("Ingrese el legajo del alumno: ");
            legajo = teclado.nextLong();
            
            alumnos.add(new Alumno(nombreAlumno, legajo));
        }
        
        
        for(Alumno alumno : alumnos){
            alumno.cargarNotas();
        }
        
        mostrarInfoCargada(alumnos);
        
    }
    
    
    public static void mostrarInfoCargada(ArrayList<Alumno> alumnos){
        for(Alumno alumno : alumnos){
            System.out.printf("\n%-20s%-20s\n", "LEGAJO" , "NOMBRE ALUMNO");
            System.out.printf("%-20s%-20s\n", String.valueOf(alumno.getLegajo()) , alumno.getNombreCompleto());
            System.out.println("\nNotas:");
            for(Nota nota : alumno.getNotas()){
                System.out.printf("%-20s%-20s\n", nota.getCatedra(),String.valueOf(nota.getNotaExamen()));
            }
            System.err.println("*****************************************************");
        }
    }
}
