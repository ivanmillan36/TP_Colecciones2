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
public class Alumno {
    String nombreCompleto;
    long legajo;
    ArrayList<Nota> notas = new ArrayList();
    
    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
    
    
    public void cargarNotas(){
        int cantNotasACargar;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de notas a cargar para el alumno " + this.nombreCompleto + " : ");
        do{
            cantNotasACargar = sc.nextInt();
            if(cantNotasACargar <= 0){
                System.out.println("Ingrese un numero mayor que cero...");
            }
        }while(cantNotasACargar <= 0);
        
        for(int i=0; i<cantNotasACargar ; i++){
            String catedra = "";
            double notaExamen = 0;
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el nombre de la catedra: ");
            catedra = teclado.nextLine();
            System.out.println("Ingrese la nota del examen: ");
            notaExamen = teclado.nextDouble();
            
            this.notas.add(new Nota(catedra, notaExamen));
        }
        
    }
    
    public float getPromedioNotas (){
        int sumatoria = 0;
        for(Nota nota : this.notas){
            sumatoria += nota.getNotaExamen();
        }
        return sumatoria/this.notas.size();
    }

    
}
