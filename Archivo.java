// Clase Archivo implementando Elemento

abstract class Archivo implements Elemento{
    String nombre;
    int tamanio;

    // Constructor
    Archivo(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    //Método para obtener el tamanio de un archivo
    public int obtenerTamanio(){
        return tamanio;
    }
}