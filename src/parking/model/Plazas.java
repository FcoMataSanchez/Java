
package parking.model;

/**
 *
 * @author alumneDAM
 */
public class Plazas {

    private boolean estado=false;
    private int planta,fila,plaza;

    /**
     * Constructor objeto plazas
     * @param planta int
     * @param fila int
     * @param plaza int
     */
    public Plazas(int planta,int fila,int plaza) {
        this.planta=planta;
        this.fila=fila;
        this.plaza=plaza;
        this.estado = estado;

    }

    /**
     * Devuelve un boleano del estado de la plaza
     * @return boolean 
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la plaza
     * @param estado boolean con true o false
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
