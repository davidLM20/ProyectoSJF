/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Proceso {
    public String nombre;
    public int tLlegada;
    public int RCPU ;
    public int Tespera;
    public int Tretorno;
    public ArrayList<RangosProceso> RangosProceso = new ArrayList<>();

    public Proceso() {
    }

    public Proceso(String Nombre) {
        this.nombre = Nombre;
    }
    
    
    public Proceso(String Nombre, int Tllegada, int RCPU) {
        this.nombre = Nombre;
        this.tLlegada = Tllegada;
        this.RCPU = RCPU;
    }

    
    public Proceso(String  Numero, int Tllegada, int RCPU, int Tespera, int Tretorno) {
        this.nombre = nombre;
        this.tLlegada = Tllegada;
        this.RCPU = RCPU;
        this.Tespera = Tespera;
        this.Tretorno = Tretorno;
        this.RangosProceso = RangosProceso;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getTllegada() {
        return tLlegada;
    }

    public void setTllegada(int Tllegada) {
        this.tLlegada = Tllegada;
    }

    public int getRCPU() {
        return RCPU;
    }

    public void setRCPU(int RCPU) {
        this.RCPU = RCPU;
    }

    public int getTespera() {
        return Tespera;
    }

    public void setTespera(int Tespera) {
        this.Tespera = Tespera;
    }

    public int getTretorno() {
        return Tretorno;
    }

    public void setTretorno(int Tretorno) {
        this.Tretorno = Tretorno;
    }

    public ArrayList<RangosProceso> getRangosProceso() {
        return RangosProceso;
    }

    public void setRangosProceso(ArrayList<RangosProceso> RangosProceso) {
        this.RangosProceso = RangosProceso;
    }

    @Override
    public String toString() {
        return "Proceso{" + "Nombre=" + nombre + ", Tllegada=" + tLlegada + ", RCPU=" + RCPU + ", Tespera=" + Tespera + ", Tretorno=" + Tretorno + ", RangosProceso=" + RangosProceso + '}';
    }
    
    

    

}
