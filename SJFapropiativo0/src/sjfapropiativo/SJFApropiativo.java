/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjfapropiativo;

import CLASES.Proceso;
import CLASES.RangosProceso;
import Logica.LPlanificacion;
import Logica.LProceso;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
public class SJFApropiativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int rafagaAux = 0;
        int maxllegada = 0;
        int t = 0;
        int cont = 0;
        //RangosProceso ObjRp = new RangosProceso();
        Proceso P1 = new Proceso("A", 4, 1);
        Proceso P2 = new Proceso("B", 3, 4);
        Proceso P3 = new Proceso("C", 2, 7);
        Proceso P4 = new Proceso("D", 1, 2);
        Proceso P5 = new Proceso("E", 10, 5);
        Proceso P6 = new Proceso("F", 2, 7);
        Proceso P7 = new Proceso("G", 6, 1);

        ArrayList<Proceso> ListaProcesos = new ArrayList<>();
        ArrayList<Proceso> ProcesosFinal = new ArrayList<>();
        ArrayList<Proceso> AuxProcesos = new ArrayList<>();
        ArrayList<RangosProceso> ArrayRP = new ArrayList<>();

        LProceso LProceso = new LProceso();
        LPlanificacion Lplanif = new LPlanificacion();
        ListaProcesos.add(P1);
        ListaProcesos.add(P2);
        ListaProcesos.add(P3);
        ListaProcesos.add(P4);
        ListaProcesos.add(P5);
        ListaProcesos.add(P6);
        ListaProcesos.add(P7);

        for (Proceso Proc : ListaProcesos) {
            if (Proc.getTllegada() > maxllegada) {
                maxllegada = Proc.getTllegada();
            }
        }
        System.out.println("EL TIEMPO DE LLEGADA MAXIMO ES: " + maxllegada);

        //PARA COMENZAR EL PROCESO
        //RangosProceso ObjRp = new RangosProceso ();
        boolean bandera = false;
        int rango_i = 0;
        int rango_f = 0;
        String ProcesoOcupado = "";
        Proceso MenorRaf = new Proceso();
        boolean planificando = true;
        do {
            //Ingresar a la tabla cuando lleguen los procesos
            for (Proceso Proc : ListaProcesos) {
                if (Proc.getTllegada() == t) {
                    //Proc.Rangos.add(e)
                    Proceso aux = new Proceso(Proc.getNombre(), Proc.getTllegada(), Proc.getRCPU());
                    //Se agregan procesos a tabla auxiliar
                    AuxProcesos.add(aux);
                    System.out.println("Proceso " + aux.getNombre() + " llegó en t=" + t);
                }
            }
            //Mientras el arreglo auxiliar no esté vacío, se resta la rafaga del menor
            if (!AuxProcesos.isEmpty()) {
                int i = ProcesoMenorRafagaI(AuxProcesos);
                int r = (AuxProcesos.get(i).getRCPU());
                System.out.println("Index: " + i + " Rafaga :" + r);
                AuxProcesos.get(i).setRCPU(r - 1);
            }
            //El proceso con menor rafaga es asignado
            MenorRaf = ProcesoMenorRafaga(AuxProcesos);
            //Si la rafaga menor es cero, se remueve
            if (MenorRaf.getRCPU() == 0 && !(AuxProcesos.isEmpty())) {
                AuxProcesos.remove(ProcesoMenorRafagaI(AuxProcesos));
            }

            //Si el proceso ocupado sigue siendo el menor
            if (ProcesoOcupado.equals(MenorRaf.getNombre())) {
                //System.out.println(MenorRaf.Nombre);
            } else { //Si el proceso ocupado ya no es el menor
                //System.out.println(MenorRaf.Nombre);

                System.out.println("Tiempo: " + t + " Se agregó el proceso:"
                        + " " + MenorRaf.getNombre() + " con rafaga " + MenorRaf.getRCPU());
                ProcesosFinal.add(MenorRaf);
                ProcesoOcupado = MenorRaf.getNombre();
                //rellenar izq y der

                System.out.println("------rellenar izq");
                //RangosProceso ObjRp = new RangosProceso (t,0,MenorRaf.getNombre);
                RangosProceso ObjRp = new RangosProceso();
                
                ObjRp.setNombre(MenorRaf.getNombre());
                ObjRp.setNizq(t);
                System.out.println("index parte izq          " + cont);
                System.out.println("numero derecho: "+ ObjRp.getNder());
                
                //bandera = true;
                 
                if (t != 0){
                    System.out.println("agrego parte derecha -----");
                    
                    //ObjRp.setNder(t);
                    ArrayRP.get(cont -1).setNder(t);
                    
                    System.out.println("izquierdo anterior  "+  ArrayRP.get(cont -1).getNizq() );
                    
                    
                }else{}
                cont += 1;
                ArrayRP.add(ObjRp);
            }
            //Calcular rafaga total
            int a = 0;
            for (Proceso Proc : AuxProcesos) {
                a += Proc.getRCPU();
            }
            rafagaAux = a;

            //Si la rafaga es cero y ya no quedan procesos por llegar
            if (rafagaAux == 0 && t >= maxllegada) {
                planificando = false;
            }

            //Se aumenta el tiempo
            t++;
        } while (planificando);
        System.out.println(ArrayRP);
        
        String respuesta = "El orden de planificación es: ";
        for (Proceso Proc : ProcesosFinal) {
            respuesta += Proc.getNombre() + " - ";
        }
        
        System.out.println(respuesta);
        System.out.println("TIEMPO TOTAL: " + t);
        ArrayRP.get(cont -1).setNder(t);
        
        for (RangosProceso Proces : ArrayRP) {
            System.out.println("numero izquiero de proceso:  " + Proces.getNombre() + "  es:");
            System.out.println(Proces.getNizq());
            System.out.println("numero derecho de proceso:  " + Proces.getNombre() + "  es:");
            System.out.println(Proces.getNder());
        }
        ListaProcesos = Lplanif.LlenarRangosTiempos(ListaProcesos, ArrayRP);
        Lplanif.Calculo(ListaProcesos);
        
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
}
