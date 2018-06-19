
package parking.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paco
 */
public class Entrada {

    public Date myDate = new Date();
    public DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String matricula;
    private DateFormat horaEntrada;
    public String horaSalida = null;

   /**
    * Constructor del objeto Entrada con matricula y hora del momento de la
    * creacion hora salida inicializada como null para asignarla a la salida.
    * @param matricula 
    */

    public Entrada(String matricula) {
        this.matricula = matricula;
        this.horaEntrada = formato;
        this.horaSalida = null;
    }

    /**
     * Devuelve un string con la matricula
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devuelvela hora de la entrada
     * @return DateFormat
     */
    public DateFormat getHoraEntrada() {
        return horaEntrada;
    }
    /**
     * Devuelve hora de salida
     * @return String
     */
    public String getHoraSalida() {
        return horaSalida;
    }
    /**
     * Permite modificar la hora de salida del objeto entrada
     * @param horaSalida String
     */
    public void setHoraSalida(String salida) {
        this.horaSalida = salida;
    }

}
