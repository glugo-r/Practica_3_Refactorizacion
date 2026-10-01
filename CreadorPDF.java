// Clase que extiende CreadorArchivo para crear Arhivos PDF

class CreadorPDF extends CreadorArchivo {
    @Override
    Archivo crearArchivo(String nombre, int tamanio) {
        return new ArchivoPDF(nombre, tamanio);
    }
}