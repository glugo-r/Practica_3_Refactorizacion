// Clase abstracta para crear Archivos en el método de refactorización Factory Method

abstract class CreadorArchivo {
    abstract Archivo crearArchivo(String nombre, int tamanio);
    }