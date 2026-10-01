// Clase carpeta implementando interfaz Elemento

import java.util.ArrayList;
import java.util.List;

class Carpeta implements Elemento{
    String nombre;
    List<Elemento> elementos = new ArrayList<>();

    // Constructor
    Carpeta(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar elementos a la carpeta
    void agregar(Elemento elemento){
        elementos.add(elemento);
    }


    // Método para obtener tamanio de una carpeta
    @Override
    public int obtenerTamanio() {
        int total = 0;
        for (Elemento elemento : elementos) {
            total += elemento.obtenerTamanio();
        }
        return total;
    }
}