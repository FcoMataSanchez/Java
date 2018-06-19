/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.control;

import parking.model.Parking;
import parking.vista.InterficieParking;

/**
 * @version 1
 * @author paco
 */
public class ControlParking {

    private Parking parking;
    private InterficieParking iParking;

    public ControlParking() {
        this.iParking = new InterficieParking();
    }
/**
 * Ejecuta el programa
 */
    public void inicia() {

        int opcio;

        this.parking = new Parking(iParking.pedirnum("Plantas:"), iParking.pedirnum("Filas:"), iParking.pedirnum("Plazas:"));
        do {

            opcio = iParking.mostrarMenuOperacions();

            if (opcio != 9) {
                switch (opcio) {
                    case 1:
                        iParking.mostrarMensaje(parking.crearCoche(iParking.matricula()));
                        break;
                    case 2:
                        iParking.mostrarMensaje(parking.salidaCoche(iParking.matricula(), iParking.horasalida()));
                        break;
                    case 3:
                        iParking.mostrarMensaje(parking.entradasPorMatricula(iParking.matricula()));
                        break;
                    case 4:
                        iParking.mostrarMensaje(parking.mostarEntradas());
                        break;
                    case 5: 
                       parking.modificarEstadoPlaza(true);
                        break;
                    case 6: 
                      parking.modificarEstadoPlaza(false);
                        break;
                    case 7: 
                        iParking.mostrarMensaje(parking.mostarDisponibilidadPlaza(iParking.pedirnum("Planta:"),
                                iParking.pedirnum("Fila:"), iParking.pedirnum("Plaza:")));
                        break;
                    case 8: 
                        iParking.mostrarMensaje(parking.mostarDisponibilidad());
                        break;
                    case 9:
                        break;
                }
            }
        } while (opcio != 9);
    }
}
