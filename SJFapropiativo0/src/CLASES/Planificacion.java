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
public class Planificacion {
    public double promTE;
    public double promTR;
    public ArrayList<Proceso> Procesos;

    public Planificacion() {
    }

    
    public Planificacion(double promTE, double promTR, ArrayList<Proceso> Procesos) {
        this.promTE = promTE;
        this.promTR = promTR;
        this.Procesos = Procesos;
    }

    public double getPromTE() {
        return promTE;
    }

    public void setPromTE(double promTE) {
        this.promTE = promTE;
    }

    public double getPromTR() {
        return promTR;
    }

    public void setPromTR(double promTR) {
        this.promTR = promTR;
    }

    public ArrayList<Proceso> getProcesos() {
        return Procesos;
    }

    public void setProcesos(ArrayList<Proceso> Procesos) {
        this.Procesos = Procesos;
    }
    
    
}
