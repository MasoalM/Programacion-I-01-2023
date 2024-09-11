/*
Clase LineasFicherosIn --> aglutina las declaraciones y funcionalidades que
posibilitan la gestión de la lectura de objetos Linea desde un fichero de
texto

NOTA: clase preparada para funcionar a nivel de BufferedReader
 */
package wordle;
//IMPORTACIÓN DE BUFFEREDREADER Y FILEREADER PARA PODER LEER FICHEROS
import java.io.BufferedReader;
import java.io.FileReader;

public class LineaFicherosLectura {
    //DECLARACIONES
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final int FINAL_FICHERO=-1;
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';  
    //declaración atributo de clase variable entero que represente el código
    //de caracter leido desde el fichero
    private static int codigo=SALTO_LINEA;
    //declaración atributo de clase BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private static BufferedReader fichero=null;
    
    //MÉTODOS
    
    //Métodos Funcionales
    
    //método que verifica si hay palabras por leer en un fichero de texto dado
    private static boolean hayLineas() throws Exception {
        //lectura código de caracter desde el fichero
        codigo=fichero.read();
        return (codigo!=FINAL_FICHERO); 
    }
    
    //método que lleva a cabo la lectura de un objeto Linea desde un fichero de texto
    private static Linea lectura() throws Exception {
        Linea linea=new Linea();
        if (codigo==RETURN) {
            //lectura caracter de control SALTO DE LINEA que viene después del
            //caracter RETURN
            codigo=fichero.read();
            //devolver linea vacia
            return linea;
        }  
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)&&(codigo!=SALTO_LINEA)) {
            //añadir elcaracter correspondiente al código leido al objeto Linea
            linea.adicionCaracter(codigo);
            //lectura siguiente código de caracter desde el fichero de texto
            codigo=fichero.read();
        }
        return linea;
    }
    
    //Método "lecturaFicheroEstadisticasYVisualizacion" que sirve para mostrar las estadísticas contenidas en el fichero al usuario
    public static void lecturaFicheroEstadisticasYVisualizacion () throws Exception {
        //Declaración del objeto "fichero" que leerá el fichero "estadisticas.txt"
        fichero = new BufferedReader (new FileReader("estadisticas.txt"));
        //Bucle de recorrido, mientras haya lineas en el fichero, visualizar la lectura de cada linea
        while(hayLineas()){
            System.out.println(lectura());
        }
        
        fichero.close();
    }
    
}
