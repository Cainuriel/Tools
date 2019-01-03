/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_genericas;

/**
 *
 * @author cainuriel
 */
public class Clases_Genericas {

    public static void main(String[] args) {
        
        ClaseGenerica<String> primerobjeto = new ClaseGenerica<String>();

        primerobjeto.setcampodeclase("Hemos convertido en String "
                + "el tipo de la clase generica");
        System.out.println(primerobjeto.getcampodeclase());

        // creamos un objeto de otra clase
        Objeto objeto = new Objeto("Cacerola");

        // creamos una segunda instancia de un objeto de la clase generica
        // esta vez, utilizando el tipo de la clase Objeto.          
        ClaseGenerica<Objeto> segundobjeto = new ClaseGenerica<Objeto>();

        // y ahora seremos capaces de introducir en el campo de la clase 
        //  generica el objeto creado de la clase ejemplo: Objeto.
        segundobjeto.setcampodeclase(objeto);

        System.out.println(segundobjeto.getcampodeclase());

        // Probamos el metodo generico. Que es estatico para no tener que
        //instanciar un objeto para su uso.
        String[] sagradafamilia = {"Jose", "Maria", "Jesus"};
        Integer[] diez = {60, 23, 29, 42, 35, 36, 27, 38, 29, 30};
        // da igual el tipo del objeto, ya que el metodo es generico.
        // aun asi, no acepta tipos primitivos. puedes ver metoso genericos
        //que incluyen el tipo entre <>, pero no es necesario. 
        System.out.println(longitudArray.getLongitud(sagradafamilia));
        System.out.println(longitudArray.getLongitud(diez));

        // probamos el otro metodo generico.
        System.out.println(longitudArray.datoMenor(sagradafamilia));
        System.out.println(longitudArray.datoMenor(diez));
        
        System.out.println("PROBANDO LA HERENCIA EN CLASES GENERICAS");
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''");
        
        System.out.println("La herencia con otros tipos de objetos es de la "
                + "siguiente manera:\n"
                + "si un objeto, es otro tipo de objeto, entonces dispone de "
                + "esa herencia \n"
                + "Ejemplo: podemos guardar un String en un objeto de la clase "
                + "cosmica Object");
        
        String string = "soy un objeto de clase Object";
        Object  ejemplo;
        ejemplo = string;
        System.out.println(ejemplo);
        
        System.out.println("Como lo realizamos con las clases genericas?");
        
        ClaseGenerica <Objeto> pizarra = new ClaseGenerica <Objeto>();
        
        System.out.println("Esta pizarra como clase Generica Objeto"
                + "que \n"
                + "hemos creado en este Script, no puede recibir directamente un"
                + " objeto \n"
                + "de la clase Objeto, como el creado anteriormente. No podemos "
                + "hacer: \n"
                + "pizarra = objeto;");
        
                System.out.println("La forma adecuada seria crear un metodo con"
                        + " un tipo comodin. \n"
                        + "public static void tipoComodin(ClaseGenerica <? extends"
                        + " Objeto> o) {}");
// hemos creado una clase que hereda de objeto para probar la herencia en
// clases genericas.
                ClaseGenerica <Objetocomplejo> objetocomplejo = 
                        new ClaseGenerica<Objetocomplejo>();
                ClaseGenerica.tipoComodin(pizarra);
                ClaseGenerica.tipoComodin(objetocomplejo);
                
       

    }

}

/**
 *
 * @author cainuriel
 * @param <T> tipo de la clase generica sin definir. En este ejemplo lo
 * definimos a la hora de instanciar el objeto. De esta manera la magia de las
 * clases genericas se pone en marcha. por convencion, las clases genericas usan
 * las letras T U K
 */
class ClaseGenerica<T> {

    private T campodeclase;
    
       /**
     * metodo creado para probar el uso del comodin.
     * @param o objeto de la clase Objeto que puede recibir subclases.
     */
    public static void tipoComodin(ClaseGenerica <? extends Objeto> o) {
        System.out.println(o);
    }
   
    public ClaseGenerica() {

        campodeclase = null;

    }

    public void setcampodeclase(T nuevoValor) {
        campodeclase = nuevoValor;
    }

    public T getcampodeclase() {
        return campodeclase;
    }

}

class Objeto {

    private String nombre;
    
  


    public Objeto(String nombre) {

        this.nombre = nombre;

    }

    @Override
    public String toString() {

        return nombre;
    }

}
/**
 * Clase que hereda de objeto para probar la herencia en Clases genericas.
 * @author cainuriel
 */
class Objetocomplejo extends Objeto {

    private String complejidad;

    public Objetocomplejo(String nombre,String complejidad) {
        
        super(nombre);
        this.complejidad = complejidad;

    }

    @Override
    public String toString() {

        return complejidad;
    }

}



/**
 *
 * @author cainuriel Esta clase nos dara la longitud de cualquier array
 * independientemente del tipo de la array, para observar como funciona un
 * metodo generico.
 */
class longitudArray {

    public static <T> String getLongitud(T array[]) {

        return "La longitud del array es de " + array.length + " elementos.";
    }

    /**
     *
     * @param <T> dato generico QUE IMPLEMENTA la INTERFACE Comparable. no se
     * aceptaran objetos de clases QUE NO HAYAN IMPLEMENTADO esta Interface.
     * @param array que recibe.
     * @return el dato menor. metodo generico que realiza algo mas complicado.
     * devolver el dato menor de un array, con la complejidad de que puede ser
     * de cualquier tipo. ATENCION. COMPRUEBA COMO USAMOS extends EN VEZ DE
     * implements PARA usar la Interface Comparable, IMPRESCINDIBLE PARA
     * COMPARAR LOS OBJETOS.
     */
    public static <T extends Comparable> T datoMenor(T array[]) {
        // vamos a comparar los elementos de la array. por ello introducimos ya
        //el primer elemento en un objeto de clase generica. 
        T eselmenor = array[0];
        if (array == null || array.length == 0) {
            return null;
        }

        // comenzamos por el uno porque ya tenemos el cero en el objeto a comparar.
        for (int i = 1; i < array.length; i++) {
            // usamos la interface para comparar objetos. devuelve un entero mayor de cero
// si es el objeto mayor al comparado.  
            if (eselmenor.compareTo(array[i]) > 0) {
                eselmenor = array[i];
            }

        }

        return eselmenor;

    }
}
