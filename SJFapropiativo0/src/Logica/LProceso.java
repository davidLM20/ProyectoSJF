/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLASES.Proceso;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class LProceso {
    
    Proceso ObjProceso = new Proceso();
    
    
    
    public static ArrayList <Proceso> ArrayProcesos = new ArrayList<Proceso> ();
    
    public Proceso AgregarProceso(String Nombre, int Tllegada,int RCPU ){
        Proceso objProceso = new Proceso(Nombre,Tllegada,RCPU);
        return objProceso;
    }
    
    public ArrayList<Proceso> EliminarProceso (ArrayList<Proceso> ListaProcesos, int i){
        System.arraycopy(ListaProcesos, i + 1, ListaProcesos.clone(),i, ListaProcesos.size() - 1 - i);
        return ArrayProcesos;
    }
    
    
    
    public ArrayList<Proceso> AgregarProcesos( String Nombre, int Tllegada, int RCPU
                   ){
        Proceso ObjProceso = new Proceso();
        ObjProceso.setNombre(Nombre);
        ObjProceso.setTllegada(Tllegada);
        ObjProceso.setRCPU(RCPU);
        ArrayProcesos.add(ObjProceso);
        return ArrayProcesos;
    }
    
    public int TiempoLlMax( ArrayList<Proceso> ListaProcesos){
        int maxllegada = 0;
        for (Proceso Proc : ListaProcesos) {
            if (Proc.getTllegada() > maxllegada) {
                maxllegada = Proc.getTllegada();
            }
        }
        
        return maxllegada;
    }
    
    
    public static int ProcesoMenorRafagaI(ArrayList<Proceso> ArrayProcesos) {
        int b = 999;
        int i = 0;
        //Determinar menor tiempo de rafaga
        for (Proceso Proc : ArrayProcesos) {
            if (b > Proc.getRCPU()) {
                b = Proc.getRCPU();
                i = ArrayProcesos.indexOf(Proc);
            }
        }
        return i;
    }
    
    public static Proceso ProcesoMenorRafaga(ArrayList<Proceso> ArrayProcesos) {
        int b = 999;
        int cont = 0;
        int i = 0;
        Proceso Aux = new Proceso();

        //Determinar menor tiempo de rafaga
        for (Proceso Proc : ArrayProcesos) {
            if (b > Proc.getRCPU()) {
                b = Proc.getRCPU();
            }
        }
        //Seleccionar en base a menor tiempo de rafaga
        for (Proceso Proc : ArrayProcesos) {
            if (Proc.getRCPU() == b) {
                cont++;
                i = ArrayProcesos.indexOf(Proc);
            }
        }
        
        if (cont > 1) {
            return ProcesoMenorLlegada(ArrayProcesos);
        } else {
            if (ArrayProcesos.isEmpty()){
                Aux = new Proceso("TM",0,0);   
                return Aux;
            }else{
            return ArrayProcesos.get(i);
            }
        }
    }

    public static Proceso ProcesoMenorLlegada(ArrayList<Proceso> ArrayProcesos) {
        int b = 999;
        int i = 0;
        //Determinar menor tiempo de llegada
        for (Proceso Proc : ArrayProcesos) {
            if (b > Proc.getTllegada()) {
                b = Proc.getTllegada();
            }
        }
        //Seleccionar en base a menor tiempo de llegada
        for (Proceso Proc : ArrayProcesos) {
            if (Proc.getTllegada() == b) {
                i = ArrayProcesos.indexOf(Proc);;
            }
        }
        return ArrayProcesos.get(i);
    }

    public Proceso RestarRafaga (Proceso Objproceso) {
        int Raux = Objproceso.getRCPU() - 1;
        Objproceso.setRCPU(Raux);
        return Objproceso;
    }
        
    }