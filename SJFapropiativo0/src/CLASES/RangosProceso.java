/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

/**
 *
 * @author Gerson
 */
public class RangosProceso extends Proceso{
    public int Nizq;
    public int Nder;

    public RangosProceso() {
    }
    
    

    public RangosProceso(int Nizq, int Nder, String Nombre) {
        super(Nombre);
        this.Nizq = Nizq;
        this.Nder = Nder;
    }
    
    
    
    public int getNizq() {
        return Nizq;
    }

    public void setNizq(int Nizq) {
        this.Nizq = Nizq;
    }

    public int getNder() {
        return Nder;
    }

    public void setNder(int Nder) {
        this.Nder = Nder;
    }
    
    
}
