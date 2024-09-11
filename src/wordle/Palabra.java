/*
CLASE Palabra
AGLUTINA LA DESCRIPCIÓN (ESTADO) Y FUNCIONALIDADES (COMPORTAMIENTO) QUE DEFINEN
A UN OBJETO Palara
*/
package wordle;

//IMPORTAMOS RANDOM PARA UTILIZAR PALABRAS OBJETIVO ALEATORIAS
import java.util.Random;

public class Palabra {
    //DECLARACIONES ATRIBUTOS DE LA CLASE
    //declaración atributo de clase constante entera para representar
    //el número máximo de caracteres que puede tener un objeto Palabra
    private static final int MAXIMO_NUMERO_CARACTERES=20;
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    //declaración atributo de clase constante caracter para representar
    //el caracter que identifica el final de una secuencia de caracteres
    //a introducir por teclado
    private static final char FIN_SECUENCIA='.';
    //declaración atributo de clase constante caracter para representar
    //el caracter espacio 
    private static final char ESPACIO=' ';
    //declaración atributo de clase variable char para almacenar el último
    //caracter leído de la secuencia de caracteres introducida por teclado
    private static char caracter=ESPACIO;
    
    //declaración atributo de objeto array de componentes caracteres
    private char [] caracteres=new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atributode objeto variable entera para almacenar el número
    //de caracteres de un objeto Palabra
    private int numeroCaracteres;
    
    //MÉTODOS CONSTRUCTORES
    //declaración método constructor sin parámetros
    public Palabra() {
        //inicialización atributo numeroCaracteres a 0
        numeroCaracteres=0;
    }
    
    //MÉTODOS FUNCIONALES
    //declaración método de clase hayPalabras que verifica si hay alguna palabra
    //por leer en la secuencia de caracteres introducida por teclado
    //método de clase  boleano hayPalabras que verifica si en la secuencia de caracteres hay
    //al menos una palabra para leer
    public static boolean hayPalabras() throws Exception{
        buscarPalabra();
        if ((caracter!=FIN_SECUENCIA)&&(caracter!=SALTO_LINEA)) {
            return true;
        }
        else {
            //vaciar buffer de entrada
            if (caracter==FIN_SECUENCIA) {
                LT.skipLine();
            }
            //inicializar el atributo caracter a espacio para poder estar preparados
            //para la lectura de la palabras desde una nueva secuencia de caracteres
            //introducida por teclado
            caracter=ESPACIO;
            //devolver false como resultado de este método
            return false;
        }  
    }   
    //declaración método privado buscarPalabra que lleva cabo la búsqueda
    //de una palabra en la secuencia de caracteres introducida por teclado
    private static void buscarPalabra() throws Exception {
        while ((!(((caracter>='a')&&(caracter<='z'))||((caracter>='A')&&(caracter<='Z'))))
                &&(caracter!=FIN_SECUENCIA)&&(caracter!=SALTO_LINEA)){
            caracter=LT.readChar();
        }
    }
    
    //declaración método de objeto lectura que lleva a cabo la lectura, caracter
    //a caracter, de un objeto Palabra desde la secuencia de caracteres introducida
    //por teclado
    public void lectura() throws Exception {
        //inicialización atributo numeroCaracteres a 0 para incializar el
        //objeto Palabra donde vamos a almacenar la palabra a leer desde
        //la secuencia de caracteres
        numeroCaracteres=0;
        //bucle lectura de la palabra caracter a caracter
        while ((caracter!=FIN_SECUENCIA)&&(caracter!=ESPACIO)&&(caracter!=SALTO_LINEA)) {
            //almacenar el caracter leído en la componente correspondiente
            //del atributo caracteres
            caracteres[numeroCaracteres]=caracter;
            //incrementar atributo numeroCaracteres
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia de caracteres
            caracter=LT.readChar();
        }
    }  
    
    //declaración método de objeto toSTring que lleva a cabo la conversión
    //de un objeto Palabra a String
    @Override
    public String toString() {
        //DECLARACIONES
        //declaración variable String para almacenar a través de la operación
        //de concatenación los diferentes caracteres del objeto Palabra
        //correspondiente
        String resultado="";
        
        //bucle de concatenación para almacenar en el String resultado
        //los caracteres del objeto Palabra correspondiente
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //concatenación en resultado del caracter del objeto
            //Palabra correspondiente a la iteración indice-ésima
            resultado=resultado+caracteres[indice];
        }
        //Devolución resultado
        return resultado;   
    }
    
    //delcaración método de objeto getNumeroCaracteres que devuelve el número
    //de caracteres de un objeto Palabra
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    } 
    
    
    //declaración método de clase iguales que verifica si los dos objetos Palabra
    //dados por parámetros son iguales
    public static boolean iguales(Palabra palabra1, Palabra palabra2) {
        //verificar si tienen el mismo número de caracteres
        if (palabra1.numeroCaracteres==palabra2.numeroCaracteres) {
            //verificar si son iguales caracter a caracter
            for (int indice=0;indice<palabra1.numeroCaracteres;indice++) {
                if (palabra1.caracteres[indice]!=palabra2.caracteres[indice]) {
                    //devolver false porque los objetos Palabra no son iguales
                    return false;
                }
            }
        }
        else {
            //devolver false porque los objetos Palabra no son iguales
            return false;
        }
        //devolver true porque los objetos Palabra son iguales
        return true;
    }
    
    //Método de clase Palabra "generarPalabraObjetivo" que elige aleatoriamente una palabra del fichero de palabras objetivo
    public static Palabra generarPalabraObjetivo(int idioma, int letrasPalabra) throws Exception {
        //Declaración de variable de tipo String para guardar el idioma en forma de texto, así al declarar el fichero, se podrá declarar
        //con un solo switch y no dos, porque inicializamos el fichero dos veces.
        String textoIdiomaFichero = "";
        //Switch para almacenar el idioma en una variable de tipo String
        switch(idioma){
            case 1 -> textoIdiomaFichero = "castellano";
            case 2 -> textoIdiomaFichero = "catala";
            case 3 -> textoIdiomaFichero = "english";
        }
        //Declaración e inicialización del fichero con la clase "PalabraFicherosLectura" para que lea las palabras del fichero de soluciones
        //del idioma seleccionado
        PalabraFicherosLectura fichero = new PalabraFicherosLectura ("wordle_"+textoIdiomaFichero+"_solucions_"+letrasPalabra+".txt");
        //Declaración de un generador Random, para generar un número aleatorio
        Random generador = new Random();
        //Declaración de variable de tipo entero que almacenará el número que haya salido con el generador
        int numero;
        //Declaración de "palabraADevolver" de la clase "Palabra" que será la palabra objetivo que devolverá el juego y que 
        //el usuario tendrá que adivinar
        Palabra palabraADevolver = new Palabra();
        //Generar número aleatorio para elegir la posición en el fichero de la palabra a adivinar. De 0 incluido a la cantidad de
        //palabras objetivo sin incluir.
        numero = generador.nextInt(0,fichero.GetNumeroPalabras());
        //Almacenar el valor obtenido en el método de lectura de ficheros que te lee la palabra que le pides, ya que es un bule de búsqueda
        palabraADevolver = fichero.lectura(numero);
        //Cerrar fichero
        fichero.cerrarEnlaceFichero();
        //Devolver la palabra objetivo
        return palabraADevolver;
    }
    
    //Método "colorear" de clase que, si la letra no está en la palabra objetivo la pinta de gris, si la letra está pero en otra posición la pinta de
    //amarillo, y que si la letra está en la palabra y en la misma posición la pinta de verde
    public static void colorear (Palabra palabraIntroducida, Palabra palabraBuscada, int letrasPalabra) throws Exception {
        //Declaración de variables constantes de tipo entero para guardar el valor de los colores para utilizarlos con LT
        final int VERDE = 1;
        final int AMARILLO = 2;
        final int GRIS = 6;
        //Declaración de array de enteros para almacenar los valores de los colores con los que se tendrán que pintar las palabras
        //introducidas por el usuario. La longitud del array son las letras que tiene la palabra
        int [] colores = new int [letrasPalabra];
        //Declaración de array de caracteres que almacena el alfabeto, pasando el String con todas las letras a array de caracteres
        //con el método ".toCharArray()"
        char[]ALFABETO = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //Declaración de array de enteros que almacena la cantidad de veces que aparece cada letra en la palabra objetivo, el
        //array tiene la longitud del alfabeto para tener una posición por cada letra
        int [] letrasObjetivo = new int [ALFABETO.length];
        //Declaración de array de enteros que almacena la cantidad de veces que aparece cada letra en la palabra introducida por el usuario,
        //el array tiene la longitud del alfabeto para tener una posición por cada letra
        int [] letrasIntroducidas = new int [ALFABETO.length];
        //Bucle de recorrido que llenará los dos arrays de contadores del valor '0', ya que hay que inicializar los contadores a 0 porque
        //no se ha leído la palabra aún
        for(int i = 0; i<ALFABETO.length; i++){
            letrasObjetivo[i] = 0;
            letrasIntroducidas[i] = 0;
        }
        //Bucle que lee la palabra objetivo y la introducida, letra a letra, dentro hay otro bucle que va del principio al final
        //del alfabeto, así se podrá comparar la letra de la palabra con todas las letras del alfabeto hasta encontrar la que coincide
        //con ifs
        for(int i = 0; i<letrasPalabra; i++){
            for(int j = 0; j<ALFABETO.length; j++){
                //Si la letra del alfabeto vista es la misma que la letra de la palabra obtenida, aumentar en 1 el contador
                //de las letras objetivo en esa letra en concreto del alfabeto
                if(ALFABETO[j] == palabraBuscada.obtenerCaracter(i)){
                    letrasObjetivo[j]++;
                }
                //Realizar el mismo proceso anterior pero con la palabra introducida, si coincide la letra con el alfabeto, incrementar
                //esa letra en "letrasIntroducidas"
                if(ALFABETO[j] == palabraIntroducida.obtenerCaracter(i)){
                    letrasIntroducidas[j]++;
                }
            }
        }
        //Bucle en el que se irá "coloreando" con números enteros guardados en "GRIS, AMARILLO Y VERDE" el array de colores, letra por letra
        for(int i = 0; i < letrasPalabra; i++){
            //Posición "i" del array de colores empieza siendo gris
            colores[i] = GRIS; 
            //Si el caracter "i" de la palabra introducida es el mismo que el caracter "i" de la palabra objetivo, es decir, si en
            //esa posición las dos palabras tienen la misma letra, pintar de verde esa letra (almacenando el valor VERDE en el array
            //de colores)
            if(palabraIntroducida.obtenerCaracter(i)==palabraBuscada.obtenerCaracter(i)){
                colores[i] = VERDE;
            } 
            //Si no son iguales, entrar en un bucle en el que se irá comparando la letra de la palabra introducida con las 4 o 5 letras
            //(depende de lo seleccionado) de la palabra objetivo, si alguna de ellas coincide, pintar de amarillo y salir del bucle
            //"break" ya que no hace falta buscar más
            else {
                for(int j = 0; j<letrasPalabra; j++){
                    if((palabraIntroducida.obtenerCaracter(i)==palabraBuscada.obtenerCaracter(j))){
                        colores[i] = AMARILLO;
                        break;
                    }
                }
            }
        }
        //Bucle "inverso" de recorrido ya que va de la posición de las letras que tiene la palabra menos una hasta llegar a la posición 0
        for(int i = (letrasPalabra-1); i >= 0; i--) {
            //Bucle de recorrido que irá de la posición de la primera letra del alfabeto hasta la posición de la última letra
            //del alfabeto
            for(int j = 0; j < ALFABETO.length; j++){
                //Si hay más letras 'j' introducidas que letras objetivo 'j' y la letra 'i' de la palabra introducida es igual a la de la letra
                //anteriormente comparada y el color pintado de esa letra no es el verde, se le resta 1 a las letras introducidas y se pinta de gris
                //la letra, así no cuenta como letra pintada.
                if((letrasIntroducidas[j] > letrasObjetivo[j])&&(palabraIntroducida.obtenerCaracter(i)==ALFABETO[j])
                   &&(colores[i]!=VERDE)){
                    letrasIntroducidas[j]--;
                    colores[i] = GRIS;
                }
            }
        }
        //Método convertidorAMayusculas, para convertir la palabra a mayúsculas para visualizarla así
        palabraIntroducida.convertidorAMayusculas();
        //LT para visualizar las palabras con fondo de color que se encuentra en esa posición del array de colores en cada letra
        LT.visualizadorColorFondo(palabraIntroducida.toString(), colores);
        //Visualización salto de linea
        System.out.println();
        //Método convertidor a minúsculas para poder volver a convertirlas a mayúscula la próxima vez que se vean
        palabraIntroducida.convertidorAMinusculas();
    }
    
    
    //Método que convierte todas las letras de una palabra a mayúsculas, sean minúsculas o mayúsculas funcionará gracias al if implementado
    //que hará que solo funcione cuando el caracter sea minúscula (en el wordle no necesito ese if, ya que siempre que convierta una palabra
    //introducida por el usuario será minúscula entera, pero me parecía más completo y correcto así) 
    public void convertidorAMayusculas()throws Exception {
        int codigo;
        for(int i = 0; i < numeroCaracteres; i++){
            if((caracteres[i] >= 'a')&&(caracteres[i] <= 'z')){
                codigo = (int)caracteres[i]-32;
                caracteres[i] = (char) codigo; 
            }
        }
    }
    //Método que convierte todas las letras de una palabra a minúsculas, sean minúsculas o mayúsculas funcionará, ya que solo 
    //convertirá cuando sea mayúscula el caracter recibido
    public void convertidorAMinusculas () throws Exception {
        int codigo;
        for(int i = 0; i < numeroCaracteres; i++){
            if((caracteres[i] >= 'A')&&(caracteres[i] <= 'Z')){
                codigo = (int) caracteres[i] + 32;
                caracteres[i] = (char) codigo;
            }
        }
    }
}
