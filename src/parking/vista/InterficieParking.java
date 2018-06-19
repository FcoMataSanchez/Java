/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.vista;

import java.util.Scanner;

/**
 *
 * @author paco
 */
public class InterficieParking {

    private Scanner lector = new Scanner(System.in);

    /**
     * Es mostra per pantalla un menú amb les diferents operacions i es demana
     * introduir el número de l'opció seleccionada. Es controla que el valor
     * introduït sigui enter i estigui dins del rang de valors de les opcions
     * del menú.
     *
     * @return opcio
     */
    public int mostrarMenuOperacions() {
        int opcio = -1;
        boolean correcte = false;
        do {
            System.out.println("Seleccionar operació:"
                    + "\n1. Registrar entrada"
                    + "\n2. Registrar salida"
                    + "\n3. Buscar y mostrar registro"
                    + "\n4. Mostrar todos los registros de los vehiculos del parking"
                    + "\n5. Ocupar plaza"
                    + "\n6. Vaciar plaza"
                    + "\n7. Consultar estado plaza"
                    + "\n8. Mostrar tabla por planta mostrando estado "
                    + "\n9. Salida");

            if (lector.hasNextInt()) {
                opcio = lector.nextInt();

                if (opcio > 0 && opcio < 10) {
                    correcte = true;
                }

            } else {
                lector.nextLine();
            }
            if (!correcte) {
                System.out.println("Opció incorrecta\n");
            }

        } while (!correcte);
        return opcio;
    }

    /**
     * metodo para pedir numeros por teclado
     *
     * @param mensaje String con el mensaje que se mostrara al pedir introducir
     * un numero
     * @return int valor pedido por teclado
     */
    public int pedirnum(String mensaje) {
        System.out.print("Introduce numero de " + mensaje);
        int valor = 0;
        boolean correcte = false;
        do {
            if (lector.hasNextInt()) {
                valor = lector.nextInt();
                correcte = true;
            } else {
                lector.next();
                System.out.println("Valor incorrecte");
            }

        } while (!correcte);
        return valor;
    }

    /**
     * Metodo que pide introducir la hora de salida
     *
     * @return String con la hora de salida
     */
    public String horasalida() {
        System.out.println("Introduce hora salida: ");
        String texto = lector.next();
        return texto;
    }

    /**
     * Metodo que pide introducir una matricula
     *
     * @return String con el numero de matricula
     */
    public String matricula() {
        System.out.println("introducir matricula: ");
        String valor = "";
        boolean correcte = false;
        do {
            if (lector.hasNext()) {
                valor = lector.next();
                correcte = true;
            } else {
                lector.next();
                System.out.println("Valor incorrecte");
            }

        } while (!correcte);
        return valor;
    }

    /**
     * Mostrara el mensaje que se le pase por paramentro
     *
     * @param mensaje String con el mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
