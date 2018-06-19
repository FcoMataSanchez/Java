
package parking.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author alumneDAM
 */
public class Parking {

    Scanner lector = new Scanner(System.in);
    private final int numPlantas;
    private final int numFilas;
    private final int numPlazas;
    private final DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private ArrayList<Entrada> listaCoches;
    private Plazas[][][] totalPlazas = null;
    private Date myDate = new Date();

    /**
     * Constructor del objeto parking crea array con las cantidades indicadas de
     * Plantas filas y plazas y llama al metodo generarPlazas
     *
     * @param numPlantas int
     * @param numFilas int
     * @param numPlazas int
     */
    public Parking(int numPlantas, int numFilas, int numPlazas) {
        this.numPlantas = numPlantas;
        this.numFilas = numFilas;
        this.numPlazas = numPlazas;
        listaCoches = new ArrayList();
        totalPlazas = new Plazas[numPlantas][numFilas][numPlazas];         
        generarPlazas();
    }
    
    /**
     * Metodo que crea un objeto plazas en cada posicion del array del constructor
     */
    private void generarPlazas(){
         for (int i = 0; i < totalPlazas.length; i++) {
            for (int j = 0; j < totalPlazas[i].length; j++) {
                for (int k = 0; k < totalPlazas[i][j].length; k++) {
                    totalPlazas[i][j][k] = new Plazas(i,j,k);
                }
            }
        }
    }

    /**
     * Getters del objeto Parking
     * @return int
     */
    public int getNumPlantas() {
        return numPlantas;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    /**
     * Muestra por pantalla la posicion y estado de las plazas del parking con
     * un recuento al final
     * @return String muestra el numero de Planta,fila,plaza y indica si esta libre o ocupada
     */
    public String mostarDisponibilidad() {
      String salida="";
        for (int i = 0; i < totalPlazas.length; i++) {
            for (int j = 0; j < totalPlazas[i].length; j++) {
                for (int k = 0; k < totalPlazas[i][j].length; k++) {
                  String  ocupada=(totalPlazas[i][j][k].getEstado()== false)?"Libre":"Ocupada" ; 
                  salida += "Planta: " + i + " Fila: " + j + " Plaza: " + k + " " + ocupada + "\n";
                }
            }
        }
        return salida;
    }
    
    

    /**
     * Crea un nuevo objeto entrada en el array de listaCoches 
     * y modifica el estado de una plaza a ocupada
     * @param matricula String
     * @return String con un mensaje avisando de la creacion de la entrada
     */
    public String crearCoche(String matricula) {
        listaCoches.add(new Entrada(matricula));
        String entradaCoche = "Nueva entrada creada";
        modificarEstadoPlaza(true);
        return entradaCoche;
        
    }
    
    /**
     *Modifica el estado de la primera posicion que no pase la condicion del if  
     * @param estat boolean
     */
    public void modificarEstadoPlaza(boolean estat) {
        boolean modificat = false;
        for (int i = 0; i < totalPlazas.length; i++) {
            for (int j = 0; j < totalPlazas[i].length; j++) {
                for (int k = 0; k < totalPlazas[i][j].length; k++) {
                    if (totalPlazas[i][j][k].getEstado() != estat) {
                        totalPlazas[i][j][k].setEstado(estat);
                        modificat = true;
                        break;
                    }
                    if (modificat == true) {
                        break;
                    }
                }
                if (modificat == true) {
                    break;

                }
            }
                if (modificat == true) {
                    break;
                }
            }
       
               
        }
    /**
     * Busca en el array de lista de coches por la matricula y asigna una hora
     * de salida y modifica el estado de la plaza a libre.
     * @param matricula String
     * @param horaSalida String
     * @return String con el mensaje de salida relizada
     */
    public String salidaCoche(String matricula, String horaSalida) {
        String salida = "";
        for (int i = 0; i < listaCoches.size(); i++) {
            if (listaCoches.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                listaCoches.get(i).setHoraSalida(horaSalida);
               modificarEstadoPlaza(false);
                salida = "Salida realizada: " + horaSalida + " Matricula: " + matricula;

            }

        }
        return salida;
    }

    /**
     * Muestra por pantalla las entradas de los coches con matricula hora
     * entrada y hora salida
     * @return String con los datos de los vehiculos del parking
     */
    public String mostarEntradas() {
        String salida = "";
        for (int i = 0; i < listaCoches.size(); i++) {
            if (listaCoches.get(i).getHoraSalida() == null) {
                salida += "Matricula: " + listaCoches.get(i).getMatricula() + " Hora Entrada: " + listaCoches.get(i).getHoraEntrada().format(myDate) + " Hora Salida: " + listaCoches.get(i).getHoraSalida() + "\n";
            }
        }
        return salida;
    }
/**
 * Muestra los datos del vehiculo que se pasa por parametro
 * @param matricula String
 * @return String con los datos del vehiculo que se pasa por parametro
 */
    public String entradasPorMatricula(String matricula) {
        String salida = "";
        for (int i = 0; i < listaCoches.size(); i++) {
            if (listaCoches.get(i).getMatricula().equalsIgnoreCase(matricula) && listaCoches.get(i).getHoraSalida() == null) {
                salida = "Matricula: " + listaCoches.get(i).getMatricula() + " Hora Entrada: " + listaCoches.get(i).getHoraEntrada().format(myDate) + " Hora Salida: " + listaCoches.get(i).getHoraSalida();
            }

        }
        return salida;
    }
    /**
     *Muestra el estado de una plaza pasandole por parametro el numero de planta,fila y plaza
     * @param planta int
     * @param fila int
     * @param plaza int
     * @return String con el mensaje de ocupacion de la plaza
     */
    public String mostarDisponibilidadPlaza(int planta,int fila,int plaza) {
        String mensaje = totalPlazas[planta][fila][plaza].getEstado() ? "ocupada" : "libre";
        return "La plaza esta: "+mensaje;
    }

}
