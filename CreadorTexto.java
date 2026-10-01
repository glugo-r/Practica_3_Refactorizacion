// Clase que extiende CreadorArchivo para crear Archivos de Texto

class CreadorTexto extends CreadorArchivo {
    @Override
    Archivo crearArchivo(String nombre, int tamanio) {
        return new ArchivoTexto(nombre, tamanio);
    }
}