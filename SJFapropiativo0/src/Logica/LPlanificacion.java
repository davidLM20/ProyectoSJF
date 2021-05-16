/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLASES.Planificacion;
import CLASES.RangosProceso;
import CLASES.Proceso;
import java.util.ArrayList;
import static sjfapropiativo.SJFApropiativo.ProcesoMenorRafagaI;

/**
 *
 * @author Usuario
 */
public class LPlanificacion {

    Proceso ObjProceso = new Proceso();
    RangosProceso ObjRP = new RangosProceso();
    LProceso ObjLproceso = new LProceso();
    int rafagaAux = 0;
    int maxllegada = 0;
    int t = 0;
    int cont = 0;
    //int i = 0;
    public static ArrayList<RangosProceso> ArrayRP = new ArrayList<RangosProceso>();
    Planificacion ObjPlan = new Planificacion();

    public ArrayList<RangosProceso> PlanificacionP(ArrayList<Proceso> ListaProcesos) {
        ArrayList<Proceso> ProcesosFinal = new ArrayList<>();
        ArrayList<Proceso> AuxProcesos = new ArrayList<>();
        ArrayList<RangosProceso> ArrayRP = new ArrayList<>();
        LPlanificacion Lplanif = new LPlanificacion();
        boolean bandera = false;
        int rango_i = 0;
        int rango_f = 0;
        String ProcesoOcupado = "";
        Proceso MenorRaf = new Proceso();
        boolean planificando = true;

        maxllegada = ObjLproceso.TiempoLlMax(ListaProcesos);
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
            MenorRaf = ObjLproceso.ProcesoMenorRafaga(AuxProcesos);
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
                System.out.println("numero derecho: " + ObjRp.getNder());

                //bandera = true;
                if (t != 0) {
                    System.out.println("agrego parte derecha -----");

                    //ObjRp.setNder(t);
                    ArrayRP.get(cont - 1).setNder(t);

                    System.out.println("izquierdo anterior  " + ArrayRP.get(cont - 1).getNizq());

                } else {
                }
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
        ArrayRP.get(cont - 1).setNder(t);

        for (RangosProceso Proces : ArrayRP) {
            System.out.println("numero izquiero de proceso:  " + Proces.getNombre() + "  es:");
            System.out.println(Proces.getNizq());
            System.out.println("numero derecho de proceso:  " + Proces.getNombre() + "  es:");
            System.out.println(Proces.getNder());
        }


        return ArrayRP;
    }

    public ArrayList<Proceso> LlenarRangosTiempos(ArrayList<Proceso> Procesos, ArrayList<RangosProceso> Rprocesos) {
        for (Proceso Proc : Procesos) {

            int tesperaaux = 0;
            for (RangosProceso RP : Rprocesos) {
                if (Proc.getNombre().equals(RP.getNombre())) {

                    Proc.RangosProceso.add(RP);

                }

            }

            for (int i = 0; i <= Proc.getRangosProceso().size() - 1; i++) {
            
                if (i == 0) {

                    tesperaaux = Proc.getRangosProceso().get(i).getNizq() - Proc.getTllegada();
                } else {

                    tesperaaux += Proc.getRangosProceso().get(i).getNizq() - Proc.getRangosProceso().get(i - 1).getNder();
                }
                Proc.setTespera(tesperaaux);
                Proc.setTretorno(Proc.getRangosProceso().get(Proc.getRangosProceso().size() - 1).getNder());
               
            }

        }
        for (Proceso Proc : Procesos) {
            System.out.println(" tiempo espera " + Proc.getNombre() + ":  " + Proc.getTespera());
            System.out.println(" tiempo retorno " + Proc.getNombre() + ":  " + Proc.getTretorno());
        }

        return Procesos;
    }

    public Planificacion Calculo(ArrayList<Proceso> ArrayP) {
        double sumaE = 0;
        double sumaR = 0;

        for (Proceso Proc : ArrayP) {
            sumaE += Proc.getTespera();
            sumaR += Proc.getTretorno();
        }
        ObjPlan.setPromTE(sumaE / ArrayP.size());
        ObjPlan.setPromTR(sumaR / ArrayP.size());

        System.out.printf("%npromedio espera %.2f", ObjPlan.getPromTE());
        System.out.printf("%npromedio espera   %.2f", ObjPlan.getPromTR());
        System.out.println("   ");
        return ObjPlan;
    }
}
