/*
Clase Linea --> aglutina las declaraciones y funcionalidades para gestionar
objetos Lineas.
Un objeto Linea estará constituido por una secuencia de caracteres delimitado por
un salto de linea. Como máximo el número de caracteres que puede conformar un
objeto Linea será de 250 caracteres.
 */
package wordle;


public class Linea {
    //DECLARACIONES
    //declaración atributo de clase constante entero que representa el máximo
    //número de caracteres que puede contener un objetoLinea
    private static final int MAXIMO=255;
    //declaración atributo de objeto variable array de caracteres que representa 
    //los caracteres de un objeto Linea 
    private char [] caracteres=new char[MAXIMO];  
    //declaración atributo de objeto variable entero que represente el número
    //de caracteres de un objeto Linea
    private int numeroCaracteres;
    
    private static final char ESPACIO = ' ';
    //MÉTODOS
    
    //Método Constructor
    public Linea() {
        numeroCaracteres=0;
    }
    
    //método que lleva a cabo la conversión de un objeto Linea a String para su
    //visualización en pantalla

    @Override
    public String toString(){
        String salida="";
        for (int indice=0;indice<numeroCaracteres;indice++) {
            salida=salida+caracteres[indice];
        }
        return salida;
    }
    
    //método que lleva a cabo la adición de un caracter dado por parámetro
    //al objeto Linea
    public void adicionCaracter(int cod) {
        caracteres[numeroCaracteres]=(char)cod;
        numeroCaracteres++;
    }
    
    //método que devuelve el número de caracteres que conforman un objeto Linea
    public int getNumCaracteres() {
        return numeroCaracteres;
    }
    
    //método que lleva a cabo la obtención del caracter del objeto Linea en función
    //de la posición dada por parámetro
    public char obtenerCaracter(int pos) {
        return caracteres[pos];
    }
    //Método de objeto que agrega una palabra a la linea, caracter a caracter. Recibe la palabra por parámetro
    public void adicionPalabra(Palabra palabra) throws Exception {
        //Bucle iterativo de recorrido que agrega a la linea caracter por caracter de la palabra y aumenta el numero de caracteres de la
        //linea en 1
        for(int i = 0; i < palabra.getNumeroCaracteres(); i++){
            caracteres[numeroCaracteres] = palabra.obtenerCaracter(i);
            numeroCaracteres++;
        }
        //Agregar un espacio a la linea para cuando introduzcamos la siguiente palabra, como consecuencia hay que agregar 1 al valor
        //de numeroCaracteres, ya que hemos agregado un caracter nuevo.
        caracteres[numeroCaracteres] = ESPACIO;
        numeroCaracteres++;
        
    }
    //Método de objeto "adicionFecha" para agregar a la linea del fichero, la fecha, hora, minuto y segundo en el que se acabó la partida
    //recibe por parámetro un String que almacena el valor de la fecha
    public void adicionFecha (String fecha) throws Exception {
        //Array de caracteres para almacenar en cada posición un caracter de la fecha
        char [] fechaArray = fecha.toCharArray();
        //Bucle iterativo de recorrido que agrega en el array de caracteres de la linea, caracter a caracter, la fecha
        for(int i = 0; i < fechaArray.length; i++){
            caracteres[numeroCaracteres] = fechaArray[i];
            //Aumentar el numero de caracteres en cada iteración
            numeroCaracteres++;
        }
        //Agregar un espacio en el array de caracteres de la linea, para dejarlo entre la fecha y la palabra siguiente
        caracteres[numeroCaracteres] = ESPACIO;
        numeroCaracteres++;
    }
}
