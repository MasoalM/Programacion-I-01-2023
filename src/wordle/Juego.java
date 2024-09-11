/*************************************************************************************
*   -FUNCIONALIDAD: Juego Wordle que permite elegir idioma, rondas y letras. Se      *
*                   trata de adivinar una palabra mediante un sistema de colores.    *
*   -ASIGNATURA: Programación I                                                      *
*   -GRUPO: 3                                                                        *
*   -ESTUDIOS: ING. Informática                                                      *
*   -AUTOR: Marcos Socías Alberto                                                    *
*   -DNI: 41619112Z                                                                  *
*   -FECHA DE CREACIÓN: 21/12/22                                                     *
*   -FECHA DE ÚLTIMA MODIFICACIÓN: 21/01/23                                          *
*************************************************************************************/
/*  SOLUCION ALGORITMICA
Algoritmo Juego {
    Método main;
}
Algoritmo método main {
    Método principal;
}
Declaración atributos static de rondas, letras e idioma;
Algoritmo método principal {
    Declaración método booleano "fin" que finalizará el programa cuando sea true;
    mientras (fin sea true) {
        Subprograma "menu";
        Según(Número leído) {
            Si el número recibido es 1 -> Subprograma partida;
            Si el número recibido es 2 -> Subprograma ajustes;
            Si el número recibido es 3 -> Subprograma estadisticas;
            Si el número recibido es otro -> fin es true;
        }
    }
}
Algoritmo limpiarPantalla (mensaje) {
    Visualizar saltos de linea y mensaje;
}
Algoritmo pausa (mensaje) {
    Visualizar mensaje;
    Esperar a leer un caracter;
}
Algoritmo menu () {
    Según (el número de idioma recibido) {
        Si es 1 -> castellano;
        Si es 2 -> catalán;
        Si es 3 -> inglés;
    }
    método limpiarPantalla(mensaje);
    Visualización menú;
}
Algoritmo ajustes () {
    variable booleana salir;
    mientras(sea lo contrario a salir) {
        limpiarPantalla(mensaje);
        visualización submenú de ajustes;
        Según (el número recibido) {
            Si es 1 -> subprograma seleccionIdioma();
            Si es 2 -> subprograma seleccionRondas();
            Si es 3 -> subprograma seleccionLetras();
            Si es otro número -> salir es true;
        }
    }    
}
Algoritmo seleccionIdioma() {
    limpiarPantalla(mensajeEnviado);
    Visualización mensaje;
    Lectura número introducido por el usuario;
    Si (está fuera del rango entre 1 y 3) {
        Visualizar error;
        Establecer el valor 1;
        pausa(mensaje);
    }
}
Algoritmo seleccionIdioma() {
    limpiarPantalla(mensajeEnviado);
    Visualización mensaje;
    Lectura número introducido por el usuario;
    Si (está fuera del rango entre 1 y 3) {
        Visualizar error;
        Establecer el valor 1;
        pausa(mensaje);
    }
}
Algoritmo seleccionRondas() {
    limpiarPantalla(mensajeEnviado);
    Visualización mensaje;
    Lectura número introducido por el usuario;
    Si (está fuera del rango entre 4 y 10) {
        Visualizar error;
        Establecer el valor 6;
        pausa(mensaje);
    }
}
Algoritmo seleccionLetras() {
    limpiarPantalla(mensajeEnviado);
    Visualización mensaje;
    Lectura número introducido por el usuario;
    Si (está fuera del rango entre 4 y 5) {
        Visualizar error;
        Establecer el valor 5;
        pausa(mensaje);
    }
}
Algoritmo partida () {
    LimpiarPantalla, declaración nombre y pedir nombre al usuario;
    LimpiarPantalla, visualización y declaración de array de PalabrasJugadas y palabraObjetivo;
    Almacenar el valor obtenido del método generarPalabraObjetivo en palabraObjetivo;
    Declaración intento con valor 1;
    mientras(el intento actual sea menor a la cantidad de intentos máxima) {
        Inicialización palabraTeclado;
        Visualización intento;
        Lectura palabraTeclado;
        Si (palabraTeclado tiene la cantidad de caracteres seleccionada al principio) {
            Si (palabraTeclado existe en el diccionario (comprobación con un método)) {
                Almacenar palabraTeclado en palabrasJugadas;
                mientras(inicialización variable "i" a 1; i sea menor a intento; i++) {
                    Visualizar y colorear con el método "colorear" cada palabra de cada intento;
                }
                Si (la palabraObjetivo y la palabraTeclado son iguales (comprobación con el método "iguales")){
                    Visualizar victoria;
                    Salir del bucle;
                }
            }
            Si no {
                Visualizar aviso;
                Restar 1 a intento;
                mientras(inicialización variable "i" a 1; i sea menor a intento; i++) {
                    Visualizar y colorear con el método "colorear" cada palabra de cada intento;
                }
            }
        }
        Si no {
            Visualizar aviso;
            Restar 1 a intento;
            mientras(inicialización variable "i" a 1; i sea menor a intento; i++) {
                Visualizar y colorear con el método "colorear" cada palabra de cada intento;
            }
        }
        Aumentar 1 a intento;
    }
    Si ("intento" es mayor a la cantidad de intentos máxima) {
        Visualizar mensaje de derrota;
        Restar 1 a "intento" para devolverlo al valor de verdad;
    }
    método Pausa;
    LineaFicherosEscritura de los datos de la partida;
}
Algoritmo comprobacionDiccionario () {
    Crear fichero temporal según el idioma y la cantidad de letras;
    Mientras(haya palabras en el fichero) {
        Si(palabraIntroducida igual a palabraDiccionario) {
            cerrarFichero;
            Devolver true;
        }
    }
    cerrarFichero;
    Devolver false;
}
Algoritmo estadisticas () {
    limpiarPantalla(mensajeIntroducido);
    método lecturaYVisualizacionEstadisticas;
    Pausa(mensaje);
}
*/
package wordle;

//CLASE DEL JUEGO
public class Juego {
    //MÉTODO MAIN
    public static void main (String[]argumentos) throws Exception {
        //CREACIÓN DEL MÉTODO PRINCIPAL
        new Juego().metodoPrincipal();
    }
    
    //DECLARACIÓN DE VARIABLES GLOBALES: La cantidad de rondas, la cantidad de letras de las palabras del juego y el idioma seleccionado.
    static int cantidadIntentos = 6; //VALOR POR DEFECTO DE INTENTOS
    static int letrasPalabra = 5; //VALOR POR DEFECTO DE CANTIDAD DE LETRAS
    static int idioma = 1; //(IDIOMA POR DEFECTO: Castellano)
    //MÉTODO PRINCIPAL
    private void metodoPrincipal() throws Exception {
        //Variable booleana que controla que no haya que terminar la partida hasta que sea true
        boolean fin = false;
        //Mientras no haya que terminar la partida, seguir haciendo iteraciones
        while(!fin){
            //Ejecutar subprograma "menu", que visualizará un menú
            menu();
            //Switch para obtener un número
            switch(LT.readInt()){ //lectura del número introducido por teclado
                case 1 -> partida();    //si el número es 1, empezar partida
                case 2 -> ajustes();    //si el número es 2, ejecutar el subprograma de selección de idioma
                case 3 -> estadisticas(); //si el número es 3, ejecutar el subprograma de lectura del fichero de estadísticas
                
                default -> fin = true;          //si no es un número del 1 al 3, finalizar programa   
              
            }
        }
        
    }
    //Método "limpiarPantalla" que visualiza muchos saltos de linea para dejar vacía la pantalla,
    //únicamente visualizará, a parte de los saltos de linea, el mensaje que se le introduzca.
    private void limpiarPantalla(String mensaje) throws Exception {
        //visualización de saltos de linea "\n" + el mensaje
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n" + mensaje + "\n\n"); 
    }
    //Método "pausa" que sirve para que al acabar, por ejemplo, de ver las estadísticas de las partidas o al acabar una partida
    //no te lleve directamente al menú, así el usuario podrá ver las estadísticas o cuál era la palabra objetivo en su partida.
    //Funciona visualizando un mensaje (en estos casos, "pulsa return para volver al menú") y esperando una respuesta con la clase
    //de lectura LT.
    private void pausa(String mensaje) throws Exception {
        System.out.println(mensaje);    //Visualizacion del mensaje
        
        LT.readChar();  //Pedir al usuario un carácter, hasta no recibirlo, el programa no seguirá
    }
    //Método "menu" que se ocupará de toda la parte visible y estética del menú del juego 
    private void menu() throws Exception {
        //Declaración de variable de tipo String para poder almacenar el texto del idioma y visualizarlo en el menú
        //Aprovecho para hacerlo con una variable String para simplificar, porque hacerlo con un switch con 3 System.out.print 
        //de 6 lineas cada uno, me parecía excesivo, en cambio, con el String realizo la tarea de una manera más óptima y
        //no aprovecho nada que no se pueda hacer sin un String, el uso es legal porque utilizo el String para una salida de datos.
        String textoIdioma = "";
        //Switch para elegir el texto de idioma a visualizar según el int representativo del idioma 
        //recibido a partir de la variable global "idioma"
        switch(idioma){
            case 1 -> textoIdioma = "CASTELLANO";   //si es el idioma 1, almacenar "CASTELLANO" en el String
            case 2 -> textoIdioma = "CATALÁN";      //si es el idioma 2, almacenar "CATALÁN" en el String
            case 3 -> textoIdioma = "INGLÉS";       //si es el idioma 3, almacenar "INGLÉS" en el String
        }
        //utilizo el método "limpiarPantalla" para que no aparezca nada encima del menú. Además, paso por parámetro el mensaje "MENÚ"
        //para decorar y dejar claro en que apartado del juego esta el usuario.
        limpiarPantalla(">>>>> [MENÚ] <<<<<");
        //Visualización del menú con 5 opciones: 1) Jugar 2) Idioma 3) Rondas 4) Estadísticas 5) Finalizar (realmente cualquier carácter
        //que no pertenezca al rango del 1 al 4 finaliza la partida, si es un número finaliza, si no lo es, finaliza dando un error 
        //ya que se pide un número, no otro carácter). Seguidamente, se visualiza un texto que pone "OPCIÓN" y muestra 
        //una flecha, para que el usuario pueda escribir la opción que desea utilizar. Además, en la opción 1 se visualizará el idioma
        //con el que se comenzaría la partida si se seleccionase esa opción (castellano por defecto).
        System.out.print("[1] JUGAR UNA PARTIDA DE WORDLE EN " + textoIdioma + "\n" +
                            "[2] SELECCIONAR AJUSTES DE LA PARTIDA\n" +
                            "[3] CONSULTAR ESTADÍSTICAS\n" +
                            "[4] FINALIZAR\n" +
                            "[OPCIÓN] ---> ");
    }
    //Método ajustes que engloba los tres métodos de personalización de partida en un submenú
    private void ajustes () throws Exception {
        boolean salir = false;
        while(!salir){
            
            //método limpiarPantalla
            limpiarPantalla("<<<<< [AJUSTES] >>>>>");
        
            System.out.print("[1] SELECCIONAR IDIOMA\n" +
                            "[2] SELECCIONAR NÚMERO DE RONDAS (SELECCIONADAS: " + cantidadIntentos +")\n" +
                            "[3] SELECCIONAR CANTIDAD DE LETRAS (SELECCIONADAS: " + letrasPalabra + ")\n"
                    +       "[4] VOLVER AL MENÚ PRINCIPAL\n"
                    +       "[OPCIÓN] --> ");
            //Switch para obtener un número
            switch(LT.readInt()){ //lectura del número introducido por teclado
                case 1 -> seleccionIdioma();    //si el número es 1, ejecutar el subprograma de selección de rondas
                case 2 -> seleccionRondas();   //si el número es 2, ejecutar el subprograma de selección de rondas
                case 3 -> seleccionLetras(); //si el número es 3, ejecutar el subprograma de selección de letras
                
                default -> salir = true;          //si no es un número del 1 al 3, ir al menú
              
            }
        }
    }
    //Método para que el usuario seleccione el idioma
    private void seleccionIdioma() throws Exception {
        //Utilizo el método "limpiarPantalla" para que el usuario vea únicamente este menú, y no el menú principal.
        limpiarPantalla(">>>>> [SELECCIONA IDIOMA] <<<<<");
        //Visualización de este submenú con 3 opciones: 1) Castellano 2) Catalán 3) Inglés
        //Según la que se seleccione, las palabras objetivo y del diccionario serán de ese idioma
        System.out.print  ("[1] CASTELLANO\n" +
                           "[2] CATALÁN\n" +
                           "[3] INGLÉS\n" +
                           "[OPCIÓN] ---> " );
        //Lectura del idioma que diga el usuario
        idioma = LT.readInt();
        //comprobación de que sea correcto el idioma recibido, si no lo es, se visualizará el error y se pondrá por defecto el castellano
        if((idioma < 1)||(idioma > 3)){
            idioma = 1; //idioma por defecto
            System.err.println("SE HA SELECCIONADO EL CASTELLANO YA QUE\n"
                                 + "SE HA INTRODUCIDO UN VALOR INCORRECTO. ");
            pausa("<<<<< PULSA RETURN PARA VOLVER AL MENÚ >>>>>");
        }
    }
    //Método "seleccionRondas" que sirve para que el usuario pueda elegir cuántas palabras/rondas jugar por partida (por defecto 6).
    //El rango que he permitido es de 4 a 10, ya que menos de 4 o más de 10 son casos muy extremos.
    private void seleccionRondas() throws Exception {
        //Método limpiarPantalla y introducción de la cabecera
        limpiarPantalla(">>>>> [SELECCIONA CUÁNTAS RONDAS QUIERES JUGAR] <<<<<");
        //Visualización del mensaje para que el usuario elija cuántas rondas jugar
        System.out.print("[NÚMERO DE RONDAS (DE 4 A 10)] ---> ");
        //Recibir la cantidad que elija el usuario
        cantidadIntentos = LT.readInt();
        //Si la cantidad recibida está fuera del rango, poner 6 rondas y avisar al usuario
        if((cantidadIntentos < 4)||(cantidadIntentos > 10)){
            cantidadIntentos = 6;
            System.err.println("SE HAN ESTABLECIDO 6 INTENTOS PORQUE SE HA\n"
                                 + "INTRODUCIDO UN VALOR INCORRECTO. ");
            pausa("<<<<< PULSA RETURN PARA VOLVER AL MENÚ >>>>>");
        }
    }
    //Método para seleccionar la cantidad de letras que el usuario quiera
    private void seleccionLetras () throws Exception {
        //Método limpiar pantalla para dejarla vacía
        limpiarPantalla(">>>>> [SELECCIONA PALABRAS DE 4 O 5 LETRAS] <<<<<");
        //Visualización de donde el usuario escribirá la opción que quiera seleccionar
        System.out.print("[NÚMERO DE LETRAS (4 o 5)] ---> ");
        //leer cantidad de letras que elija el usuario
        letrasPalabra = LT.readInt();
        //si no son ni 4 ni 5 letras, elegir 5 por defecto y avisar al usuario
        if((letrasPalabra!=4)&&(letrasPalabra!=5)){
           letrasPalabra = 5;  //Por defecto
           System.err.println("SE HAN ESTABLECIDO 5 LETRAS PORQUE\n"
                             +    "SE HA INTRODUCIDO UN VALOR INCORRECTO. ");
           //Método pausa para que el usuario vea el mensaje antes de salir
           pausa("<<<<< PULSA RETURN PARA VOLVER AL MENÚ >>>>>");
        }
    }
    //Método partida, que se iniciará cuando el usuario introduzca '1' en el menú
    private void partida () throws Exception {
        //Declaración de "nombre" de la clase "Palabra" para almacenar el nombre del usuario
        Palabra nombre = new Palabra();
        //Saltos de linea para que el usuario solamente vea el mensaje de introducir el nombre
        limpiarPantalla(">>>>> [INTRODUCE TU NOMBRE] <<<<<");
        //Visualización del lugar donde el usuario introducirá su nombre
        System.out.print("[NOMBRE] ---> ");
        //Bucle while para leer el nombre del usuario mientras haya palabras a leer y almacenarlo en el objeto "nombre"
        while(Palabra.hayPalabras()){
            nombre.lectura();
        }
        
        //Saltos de linea para que solamente se vea la partida
        limpiarPantalla(">>>>> [PARTIDA] <<<<<");
        //Visualización del nombre del jugador y de la cantidad de rondas
        System.out.println("JUGADOR: " + nombre + "\n" + cantidadIntentos + " RONDAS\n" + letrasPalabra + " LETRAS");
        //Visualización del idioma seleccionado con un switch que según el número almacenado en "idioma", visualizará un idioma u otro
        switch(idioma){
            case 1 -> System.out.println("IDIOMA -> CASTELLANO");
            case 2 -> System.out.println("IDIOMA -> CATALÁN");
            case 3 -> System.out.println("IDIOMA -> INGLÉS");
        }
        //Declaración del array de tipo "Palabra" que almacena las palabras que haya jugado el usuario (que tengan la cantidad de letras
        //que toque y que existan en el diccionario)
        Palabra [] palabrasJugadas = new Palabra [cantidadIntentos];
        //Declaración del objeto "palabraObjetivo" de tipo Palabra para que almacene la palabra objetivo generada
        Palabra palabraObjetivo = new Palabra();
        //Se almacena en palabraObjetivo la palabra generada aleatoriamente en el método "generarPalabraObjetivo"
        palabraObjetivo = Palabra.generarPalabraObjetivo(idioma, letrasPalabra);
        //Declaración variable de tipo entero "intento" para controlar en qué intento/ronda está el usuario
        int intento = 1;
        //Bucle iterativo que se repetirá hasta que "intento" sea mayor a la cantidad de intentos 
        //seleccionada por el usuario "cantidadIntentos"
        while(intento<=cantidadIntentos){
            //Declaración objeto "palabraTeclado" que almacenará la palabra introducida por el usuario
            Palabra palabraTeclado = new Palabra();
            //Visualización del número del intento, de la cantidad de intentos que hay y del mensaje "introduce una palabra".
            System.out.print("INTENTO " + intento + "/" + cantidadIntentos + ". INTRODUCE UNA PALABRA: ");
            //Lectura de la palabra introducida por teclado, mientras haya palabras a leer
            while(Palabra.hayPalabras()){
                palabraTeclado.lectura();
            }
            //Si la palabra introducida por teclado tiene la cantidad de letras que debe tener y la palabra está en el diccionario,
            //almacenará la palabra en "palabrasJugadas" en la posición "intento - 1" del array y comenzará un bucle iterativo que 
            //visualizará y coloreará las palabras anteriormente introducidas y la recién introducida. Si la palabra objetivo es
            //igual a la palabra introducida por el jugador, visualizará que se ha encontrado la palabra y finalizar el bucle principal.
            if((palabraTeclado.getNumeroCaracteres()==letrasPalabra)){
                //Método "comprobaciónDiccionario" que recibe la última palabra introducida por el usuario por parámetro y comprueba
                //si está en el diccionario
                if(comprobacionDiccionario(palabraTeclado)){
                    //Almacenar la última palabra introducida en "palabrasJugadas" en la posición del intento menos 1
                    palabrasJugadas[intento-1] = palabraTeclado;
                    //Visualización de las palabras anteriores junto a la reciente, con colores y enumeradas
                    for(int i = 1; i<=intento; i++){
                        //Si el número a visualizar es menor a 10, visualizar el número con un punto y dos espacios. Si no es menor
                        //a 10, visualizar el número con un punto y un espacio. Esto se hace para que a la hora de visualizar,
                        //queden alineadas las palabras, en caso de que se seleccionen 10 rondas.
                        if(i < 10) {
                            System.out.print(i + ".  ");
                        }
                        else {
                            System.out.print(i + ". ");
                        }
                        //Método colorear que recibe por parámetro la palabra jugada en este turno y la palabra objetivo y las compara,
                        //pintando carácter a carácter según si las letras son iguales y si están en las mismas posiciones o no
                        Palabra.colorear(palabrasJugadas[i-1],palabraObjetivo, letrasPalabra);
                    }
                    //Método "iguales" de la clase "Palabra" que compara dos palabras para saber si son la misma exactamente
                    if(Palabra.iguales(palabraObjetivo, palabraTeclado)){
                        //Visualización de fin de partida
                        System.out.println("HAS ENCONTRADO LA PALABRA, ENHORABUENA " + nombre + ". ");
                        break;
                    }  
                }
                //Si la palabra introducida por teclado tiene la cantidad de letras que debe tener, pero la palabra no está en el
                //diccionario, se le restará 1 a "intento", ya que reiniciaremos el intento y se visualizará el mensaje en color
                //de error de que la palabra introducida no existe en el diccionario
                else {
                    intento--;
                    System.err.println("LA PALABRA INTRODUCIDA NO EXISTE EN EL DICCIONARIO. ");
                    //Se vuelven a visualizar las palabras pintadas
                    for(int i = 1; i<=intento; i++){
                        if(i < 10) {
                            System.out.print(i + ".  ");
                        }
                        else {
                            System.out.print(i + ". ");
                        }
                        Palabra.colorear(palabrasJugadas[i-1],palabraObjetivo, letrasPalabra);
                    }
                    
                }
            }
            //Si la palabra introducida por teclado no tiene la cantidad de letras que debe tener, se le resta 1 intento para que
            //el usuario vuelva a intentarlo con una palabra corecta, se visualiza la cantidad de letras que debe tener la palabra y
            //se visualizan las palabras anteriores coloreadas para que el usuairo vuelva a usar su intento.
            else{
                intento--;
                System.err.println("LA PALABRA INTRODUCIDA DEBE TENER " + letrasPalabra + " LETRAS. ");
                for(int i = 1; i<=intento; i++){
                    if(i < 10) {
                        System.out.print(i + ".  ");
                    }
                    else {
                        System.out.print(i + ". ");
                    }
                    Palabra.colorear(palabrasJugadas[i-1],palabraObjetivo, letrasPalabra);
                }
               
            }
            //Se suma 1 intento por cada iteración del bucle, ya que cada iteración será un turno
            intento++;
        }
        //Si al acabar la partida, los intentos realizados por el jugador, son más que la cantidad de intentos permitida, visualizar
        //que no se ha ganado la partida por sobrepasar los intentos y visualizar cuál era la palabra objetivo. 
        if(intento > cantidadIntentos){
            System.out.println("NO HAS ADIVINADO LA PALABRA...");
            System.out.println("LA PALABRA OBJETIVO ERA '" + palabraObjetivo.toString() + "'.");
            //Se resta un intento ya que si, por ejemplo, el usuario hubiera utilizado 6 intentos, el valor de la variable "intento" 
            //sería 7 ahora mismo, así comparo si el usuario hubiese necesitado 7 intentos para jugar, por ejemplo,
            //con los 6 que están permitidos (por defecto).
            intento--;
        }
        //Método "pausa" para que el usuario vea el mensaje enviado por el juego, depende de cuál haya sido su resultado.
        pausa(">>>>> PULSA RETURN PARA VOLVER AL MENÚ <<<<<");
        //Método escrituraFichero, que recibe por parámetro la palabraObjetivo, las palabrasJugadas, el nombre del usuario y los
        //intentos que haya utilizado el usuario. Toda esta información será utilizada para escribirla en el fichero de estadísticas
        LineaFicherosEscritura.escrituraFicheroEstadisticas(palabraObjetivo, palabrasJugadas, nombre, intento);
    }
    
    //Método booleano "comprobacionDiccionario" que recibe la palabra introducida por el usuario y la compara con todas las del
    //diccionario, hasta encontrar la que sea igual. Si no hay ninguna palabra igual a la introducida en el fichero diccionario
    //se devolverá el valor false, ya que no existe en el diccionario, si se encuentra, se devolverá el valor true.
    private boolean comprobacionDiccionario (Palabra palabraIntroducida) throws Exception {
        //Declaración del la lectura de palabras del fichero, en el idioma por defecto
        PalabraFicherosLectura fichero = new PalabraFicherosLectura ("wordle_castellano_diccionari_"+letrasPalabra+".txt");
        //Switch en el que se inicializa "fichero"
        //En este caso no utilizamos String, ya que de las dos maneras únicamente se utiliza un solo Switch
        switch(idioma){
            case 1 -> fichero = new PalabraFicherosLectura ("wordle_castellano_diccionari_"+letrasPalabra+".txt");
            case 2 -> fichero = new PalabraFicherosLectura ("wordle_catala_diccionari_"+letrasPalabra+".txt");
            case 3 -> fichero = new PalabraFicherosLectura ("wordle_english_diccionari_"+letrasPalabra+".txt");
        }
        //Declaración del objeto de clase Palabra que almacenará la palabra del diccionario que toque
        Palabra palabraDiccionario = new Palabra(); 
        //Bucle iterativo de búsqueda que por cada iteración leerá una palabra del fichero diccionario y la almacenará en el objeto
        //"palabraDiccionario". Después comparará la palabra del diccionario con la palabra introducida por el usuario con el método
        //"iguales" de la clase Palabra, que compara carácter a carácter las dos palabras. Si finalmente son iguales, se cerrará
        //el enlace con el fichero y se devolverá el valor true.
        while(fichero.hayPalabras()){
            palabraDiccionario = fichero.lectura();
            
            if(Palabra.iguales(palabraDiccionario, palabraIntroducida)){
                fichero.cerrarEnlaceFichero();
                return true;
            }
        }
        //Si se sale del bucle quiere decir que se habrán leído todas las palabras del fichero sin encontrar ninguna igual a la del usuario,
        //así que habrá que cerrar el enlace con el fichero y devolver el valor false.
        fichero.cerrarEnlaceFichero();
        return false;
    }
    //Método "estadísticas" que sirve para mostrar las estadísticas contenidas en el fichero al usuario
    public void estadisticas () throws Exception {
        //Limpiar pantalla para ver únicamente las estadísticas
        limpiarPantalla("<<<<<[ESTADÍSTICAS]>>>>>");
        //Bucle de recorrido, mientras haya lineas en el fichero, visualizar la lectura de cada linea
        LineaFicherosLectura.lecturaFicheroEstadisticasYVisualizacion();
        //Pausa para que el usuario pueda ver las estadísticas todo el tiempo que quiera
        pausa("PULSA RETURN PARA VOLVER AL MENÚ PRINCIPAL");
    }
}
