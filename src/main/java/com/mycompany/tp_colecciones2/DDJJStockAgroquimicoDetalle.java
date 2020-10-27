/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp_colecciones2;

/**
 *
 * @author ivanmillan36
 */
public class DDJJStockAgroquimicoDetalle {
    String codigoAgroquimico;
    String nombreAgroquimico;
    float capacidadEnvase;
    int cantidadEnvases;
    float subtotal;

    public String getCodigoAgroquimico() {
        return codigoAgroquimico;
    }

    public void setCodigoAgroquimico(String codigoAgroquimico) {
        this.codigoAgroquimico = codigoAgroquimico;
    }

    public String getNombreAgroquimico() {
        return nombreAgroquimico;
    }

    public void setNombreAgroquimico(String nombreAgroquimico) {
        this.nombreAgroquimico = nombreAgroquimico;
    }

    public float getCapacidadEnvase() {
        return capacidadEnvase;
    }

    public void setCapacidadEnvase(float capacidadEnvase) {
        this.capacidadEnvase = capacidadEnvase;
    }

    public int getCantidadEnvases() {
        return cantidadEnvases;
    }

    public void setCantidadEnvases(int cantidadEnvases) {
        this.cantidadEnvases = cantidadEnvases;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }
    String numeroLote;
}
