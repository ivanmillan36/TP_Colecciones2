/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones2;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author ivanmillan36
 */
public class CargaDDJJStockAgroquimico {
    static String agroquimicos[][] = {
        {"1001", "2EC JEBAGRO", "A"},
        {"1002", "D 60 GREEN CROPS", "V"},
        {"1003", "ESTER 97", "A"},
        {"1004", "AMINA ICONA SL", "A"},
        {"1005", "ABAMECTINA AGRO", "A"},
        {"1006", "FURACARB 31 TS", "R"},
        {"1007", "FURAFARM 48F", "R"},
        {"1008", "ACETOCLOR ASSA", "A"},
        {"1009", "GLIFOSATO ACTIVE SIL", "R"},
        {"1010", "ABRIGO PLUS", "V"}   
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long cuit;
        int mes, anio;
        Calendar calendario = Calendar.getInstance();
        String razonSocial;
        
        DDJJStockAgroquimico stockAgroquimico = new DDJJStockAgroquimico();
        
        System.out.println("Ingrese la razon social de la empresa: ");
        do{
            razonSocial = sc.nextLine();
            if("".equals(razonSocial)){
                System.out.println("Error al ingresar razon social, intente de nuevo...");
            }
        }while("".equals(razonSocial));
        
        System.out.println("Ingrese el cuit de la empresa: ");
        do{
            cuit = sc.nextLong();
            if(Long.toString(cuit).length() != 11){
                System.out.println("Error al ingresar cuit, intente de nuevo...");
            }
        }while(Long.toString(cuit).length() != 11);
        
        System.out.println("Ingrese el año de la declaracion: ");
        do{
            anio = sc.nextInt();
            if(anio > calendario.get(Calendar.YEAR)){
                System.out.println("Error al ingresar año, intente de nuevo...");
            }
        }while(anio > calendario.get(Calendar.YEAR));
        
        System.out.println("Ingrese el mes de la declaracion: ");
        do{
            mes = sc.nextInt();
            if(mes > calendario.get(Calendar.MONTH) && anio == calendario.get(Calendar.YEAR)){
                System.out.println("Error al ingresar mes, intente de nuevo...");
            }
        }while(mes > calendario.get(Calendar.MONTH) && anio == calendario.get(Calendar.YEAR));
        
        
        stockAgroquimico.setEmpresa(razonSocial);
        stockAgroquimico.setCuit(cuit);
        stockAgroquimico.setMesDeclaracion(mes);
        stockAgroquimico.setAnioDeclaracion(anio);
        
       //*********************************************************************************************** 
        int cantAgroquimicos;
        System.out.println("Ingrese la cantidad de agroquimicos que desea informar: ");
        do{
            cantAgroquimicos = sc.nextInt();
            if(cantAgroquimicos < 0 && cantAgroquimicos > 10){
                System.out.println("Error al ingresar cantidad de agroquimicos, intente de nuevo...");
            }
        }while(cantAgroquimicos < 0 && cantAgroquimicos > 10);
        
        
        
        //***********************************************************************************************
        
        
        String codigoAgroquimico, capacidadEnvase, cantidadAInformar, numeroLote = "";
        Float subtotal;
        Scanner teclado = new Scanner(System.in);
        
        for (int i=0; i < cantAgroquimicos ; i++){
            
            System.out.println("Ingrese el codigo del agroquimico a informar: ");
            do{
                codigoAgroquimico = teclado.nextLine();
                if(buscarPorCodigo(codigoAgroquimico) == false){
                    System.out.println("El códigodel agroquímicoingresado no existe, intente nuevamente");
                }
            }while(buscarPorCodigo(codigoAgroquimico) == false);
        
            System.out.println("Ingrese la capacidad del envase:");
            do{
                capacidadEnvase = teclado.nextLine();
                if(Float.parseFloat(capacidadEnvase) <= 0){
                    System.out.println("Error, ingrese un numero mayor que cero...");
                }
            }while(Float.parseFloat(capacidadEnvase) <= 0);
        
            System.out.println("Ingrese la cantidad a informar:");
            do{
                cantidadAInformar = teclado.nextLine();
                if(Integer.parseInt(cantidadAInformar) <= 0){
                    System.out.println("Error, ingrese un numero mayor que cero...");
                }
            }while(Integer.parseInt(cantidadAInformar) <= 0);
        
            if(getBanda(codigoAgroquimico).equals("R")) {
                System.out.println("Ingrese el numero de lote: ");
                numeroLote = teclado.nextLine();
            }else{
                numeroLote = "";
            }
            
            subtotal = Float.parseFloat(capacidadEnvase) * Integer.parseInt(cantidadAInformar);
            
            DDJJStockAgroquimicoDetalle detalleAgroquimico = new DDJJStockAgroquimicoDetalle();
            
            detalleAgroquimico.setCodigoAgroquimico(codigoAgroquimico);
            detalleAgroquimico.setNombreAgroquimico(getNombre(codigoAgroquimico));
            detalleAgroquimico.setCapacidadEnvase(Float.parseFloat(capacidadEnvase));
            detalleAgroquimico.setCantidadEnvases(Integer.parseInt(cantidadAInformar));
            detalleAgroquimico.setSubtotal(subtotal);
            detalleAgroquimico.setNumeroLote(numeroLote);
            
            stockAgroquimico.addDetallesAgroquimicos(detalleAgroquimico);
                    
        }
        //**************************************************************************************
        
        stockAgroquimico.calcularTotalKiloLitros();
        
        //**************************************************************************************
        System.out.println("*****************************************************************************************");
        System.out.println("\n\nEmpresa:\t\t\t" + stockAgroquimico.getEmpresa());
        System.out.println("Cuit:   \t\t\t" + stockAgroquimico.getCuit());
        System.out.println("Mes:    \t\t\t" + stockAgroquimico.getMesDeclaracion());
        System.out.println("Año:    \t\t\t" + stockAgroquimico.getAnioDeclaracion());
        stockAgroquimico.mostrarDetallesAgroquimicos();
        
    } 
    
        
    
    private static boolean buscarPorCodigo(String codigo){
        for(String fila[] : agroquimicos){
            if(fila[0].equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    private static String getBanda(String codigo){
        for(String fila[] : agroquimicos){
            if(fila[0].equals(codigo)){
                return fila[2];
            }
        }
        return "";
    }
    
    private static String getNombre(String codigo){
        for(String fila[] : agroquimicos){
            if(fila[0].equals(codigo)){
                return fila[1];
            }
        }
        return "";
    }
}
