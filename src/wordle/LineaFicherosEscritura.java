/*
Clase LineaFicherosEscritura --> aglutina las declaraciones y funcionalidades que
posibilitan la gestión de la escritura de objetos Linea en ficheros de texto
NOTA: utilización clase BufferedWriter
 */
package wordle;
//IMPORTAMOS BUFFERED WRITER Y FILE WRITER PARA PODER ESCRIBIR EN FICHEROS
import java.io.BufferedWriter;
import java.io.FileWriter;
//IMPORTAMOS FUNCIONALIDADES PARA OBTENER FECHA, HORA, MINUTO Y SEGUNDO EN EL QUE FINALIZAMOS CADA PARTIDA
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LineaFicherosEscritura {
    //DECLARACIONES ATRIBUTOS
    //declaración atributo de clase BufferedWriter que posibilite el enlace
    //con el fichero de texto a nivel de escritura
    private static BufferedWriter fichero=null;
    
    //MÉTODOS
    
    //Método escrituraFicheroEstadisticas que recibe por parámetro la palabra objetivo, las palabras jugadas por el usuario, el nombre del usuario
    //y las rondas que ha jugado el usuario
    public static void escrituraFicheroEstadisticas (Palabra palabraBuscada, Palabra[] palabrasJugadas, Palabra nombre, int intentos) throws Exception {
        //Declaración del objeto "lineafichero" de la clase "LineaFicherosEscritura" para que pueda escribir en el fichero las lineas
        //que reciba, además le introducimos el nombre del fichero de estadísticas y el valor "true" para que agregue palabras y que
        //no se sobreescriba el fichero.
        fichero = new BufferedWriter(new FileWriter("estadisticas.txt", true));
        //Declaración del objeto "linea" de la clase "Linea"
        Linea linea = new Linea();
        //Guardamos la fecha, hora, minuto y segundo en la que se acaba la partida en el objeto "datoFecha"
        DateTimeFormatter datoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //Adición de la fecha en a la linea con el método "adicionFecha" que pasa la fecha a un Array de caracteres
        linea.adicionFecha(datoFecha.format(LocalDateTime.now()));
        //Adición del nombre del usuario a la linea, con el método "adicionPalabra" que agrega una palabra a una linea
        linea.adicionPalabra(nombre);
        //Adición de la palabra objetivo a la linea
        linea.adicionPalabra(palabraBuscada);
        //Bucle de recorrido que agrega todas las palabras jugadas por el usuario
        for(int i = 0; i < intentos; i++){
            linea.adicionPalabra(palabrasJugadas[i]);
        }
        //Escritura de la linea en el fichero
        for (int indice=0;indice<linea.getNumCaracteres();indice++) {
            fichero.write(linea.obtenerCaracter(indice));
        }
        //Escritura de un salto de linea en el fichero, para que cada partida se escriba en una linea del fichero, no todas en la misma
        fichero.newLine();
        //Cierre del enlace con el fichero de estadísticas
        fichero.close();
    }
    
}
