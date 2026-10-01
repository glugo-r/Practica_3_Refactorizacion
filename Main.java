class CorreoLegacy {
    void send_email(String to, String body) {
        System.out.println("Para: " + to);
        System.out.println(body);
    }
}

public class Main {

    static void enviarResultado(Carpeta carpeta, String destino) {
        CorreoLegacy correo = new CorreoLegacy();
        correo.send_email(destino,
                "Tamanio total: " + carpeta.obtenerTamanio());
    }
    // Ejemplo de ejecución de funciones del programa 
    public static void main(String[] args) {
        Carpeta clase = new Carpeta("MyP");
        clase.agregar(new ArchivoPDF("practica.pdf", 120));
        clase.agregar(new ArchivoTexto("notas.txt", 80));

        Carpeta ejemplos = new Carpeta("Ejemplos");
        ejemplos.agregar(new ArchivoTexto("ejemplo.txt", 50));

        clase.agregar(ejemplos);

        System.out.println(clase.obtenerTamanio());
        enviarResultado(clase, "profesor@universidad.edu");


        // Prueba carpeta vacía
        Carpeta vacia = new Carpeta("Vacia"); // preparar
        int total = vacia.obtenerTamanio(); // ejecutar
        comprobar("Carpeta vacia", 0, total); // comprobar

        // Prueba carpeta con un PDF de 120
        Carpeta carpeta120 = new Carpeta("Carpeta 120"); // preparar
        carpeta120.agregar(new ArchivoPDF("prueba2.pdf", 120));
        int total2 = carpeta120.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 120", 120, total2); // comprobar


        // Prueba carpeta con PDF de 120 y texto de 80
        Carpeta carpeta200 = new Carpeta("Carpeta 200"); // preparar
        carpeta200.agregar(new ArchivoPDF("prueba3.pdf", 120));
        carpeta200.agregar(new ArchivoTexto("prueba3.txt", 80));
        int total3 = carpeta200.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 200", 200, total3); // comprobar

        // Ejemplo completo con subcarpeta de 250
        Carpeta carpeta250 = new Carpeta("Carpeta 250"); // preparar
        carpeta250.agregar(new ArchivoPDF("prueba4.pdf", 120));
        carpeta250.agregar(new ArchivoTexto("prueba4.txt", 80));
        Carpeta subcarpeta250 = new Carpeta("subCarpeta 250"); // preparar}
        subcarpeta250.agregar(new ArchivoTexto("prueba4_1.txt", 50));
        carpeta250.agregar(subcarpeta250);
        int total4 = carpeta250.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 250", 250, total4); // comprobar

        // Carpeta con un archivo de tamaño 0
        Carpeta carpeta0 = new Carpeta("Carpeta archivo 0");
        carpeta0.agregar(new ArchivoPDF("prueba5.pdf", 0));
        int total5 = carpeta0.obtenerTamanio(); // ejecutar
        comprobar("Carpeta archivo 0", 0, total5); // comprobar
    }

    // Método auxiliar para comprobar pruebas
    static void comprobar(String nombre, int esperado, int obtenido) {
        if (esperado == obtenido) {
            System.out.println("OK: " + nombre);
        } else {
            System.out.println("FALLO: " + nombre
            + " | esperado=" + esperado
            + " | obtenido=" + obtenido);
        }
    }
}
