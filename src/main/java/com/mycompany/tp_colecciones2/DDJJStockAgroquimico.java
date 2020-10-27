/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones2;

import java.util.ArrayList;

/**
 *
 * @author ivanmillan36
 */
public class DDJJStockAgroquimico {
    private int anioDeclaracion;
    private int mesDeclaracion;
    private double totalKiloLitros;
    private String empresa;
    private long cuit;
    private ArrayList<DDJJStockAgroquimicoDetalle> detallesAgroquimicos= new ArrayList();

    
    public int getAnioDeclaracion() {
        return anioDeclaracion;
    }

    public void setAnioDeclaracion(int anioDeclaracion) {
        this.anioDeclaracion = anioDeclaracion;
    }

    public ArrayList<DDJJStockAgroquimicoDetalle> getDetallesAgroquimicos() {
        return detallesAgroquimicos;
    }

    public void addDetallesAgroquimicos(DDJJStockAgroquimicoDetalle detalleAgroquimico) {
        this.detallesAgroquimicos.add(detalleAgroquimico);
    }

    public int getMesDeclaracion() {
        return mesDeclaracion;
    }

    public void setMesDeclaracion(int mesDeclaracion) {
        this.mesDeclaracion = mesDeclaracion;
    }

    public double getTotalKiloLitros() {
        return totalKiloLitros;
    }

    public void setTotalKiloLitros(double totalKiloLitros) {
        this.totalKiloLitros = totalKiloLitros;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    
    
    public void calcularTotalKiloLitros(){
        double sumatoria = 0;
        for(DDJJStockAgroquimicoDetalle dato: this.detallesAgroquimicos ){
            sumatoria += dato.subtotal;
        }
        this.totalKiloLitros = sumatoria;
    }
    
    public void mostrarDetallesAgroquimicos(){
        
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s\n","Codigo" , "Nombre", "Capacidad", "Cantidad" , "Subtotal", "Nº de Lote(Si");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s\n","Agroquimico" , "Agroquimico" , "EnvaseKg/Lt" , "Envase" , "      ", "corresponde)");
        for(DDJJStockAgroquimicoDetalle dato: this.detallesAgroquimicos ){
            System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s\n",dato.getCodigoAgroquimico(),dato.getNombreAgroquimico(),dato.getCapacidadEnvase(),dato.getCantidadEnvases(),dato.getSubtotal(),dato.getNumeroLote());      
        }
        System.out.printf("%-70s%-20s%-20s" ,"      ", "Total", this.totalKiloLitros);
    }
   
    
}
