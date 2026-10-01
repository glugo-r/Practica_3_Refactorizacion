class CorreoLegacy {
    void send_email(String to, String body) {
        System.out.println("Para: " + to);
        System.out.println(body);
    }
}

public class Main {
    static void agregarArchivo(Carpeta carpeta,
            String tipo, String nombre, int tamanio) {
        if (tipo.equals("pdf")) {
            carpeta.agregar(new ArchivoPDF(nombre, tamanio));
        } else if (tipo.equals("txt")) {
            carpeta.agregar(new ArchivoTexto(nombre, tamanio));
        }
    }

    static void enviarResultado(Carpeta carpeta, String destino) {
        CorreoLegacy correo = new CorreoLegacy();
        correo.send_email(destino,
                "Tamanio total: " + carpeta.obtenerTamanio());
    }
    // Ejemplo de ejecución de funciones del programa 
    public static void main(String[] args) {
        Carpeta clase = new Carpeta("MyP");
        agregarArchivo(clase, "pdf", "practica.pdf", 120);
        agregarArchivo(clase, "txt", "notas.txt", 80);

        Carpeta ejemplos = new Carpeta("Ejemplos");
        agregarArchivo(ejemplos, "txt", "ejemplo.txt", 50);
        clase.agregar(ejemplos);

        System.out.println(clase.obtenerTamanio());
        enviarResultado(clase, "profesor@universidad.edu");


        // Prueba carpeta vacía
        Carpeta vacia = new Carpeta("Vacia"); // preparar
        int total = vacia.obtenerTamanio(); // ejecutar
        comprobar("Carpeta vacia", 0, total); // comprobar

        // Prueba carpeta con un PDF de 120
        Carpeta carpeta120 = new Carpeta("Carpeta 120"); // preparar
        agregarArchivo(carpeta120, "pdf", "prueba2.pdf", 120);
        int total2 = carpeta120.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 120", 120, total2); // comprobar


        // Prueba carpeta con PDF de 120 y texto de 80
        Carpeta carpeta200 = new Carpeta("Carpeta 200"); // preparar
        agregarArchivo(carpeta200, "pdf", "prueba3.pdf", 120);
        agregarArchivo(carpeta200, "txt", "prueba3.txt", 80);
        int total3 = carpeta200.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 200", 200, total3); // comprobar

        // Ejemplo completo con subcarpeta de 250
        Carpeta carpeta250 = new Carpeta("Carpeta 250"); // preparar
        agregarArchivo(carpeta250, "pdf", "prueba4.pdf", 120);
        agregarArchivo(carpeta250, "txt", "prueba4.txt", 80);
        Carpeta subcarpeta250 = new Carpeta("Carpeta250"); // preparar
        agregarArchivo(subcarpeta250, "txt", "prueba4.1.txt", 50);
        carpeta250.agregar(subcarpeta250);
        int total4 = carpeta250.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 250", 250, total4); // comprobar

        // Carpeta con un archivo de tamaño 0
        Carpeta carpeta0 = new Carpeta("Carpeta archivo 0");
        agregarArchivo(carpeta0, "pdf", "prueba5.pdf", 0);
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
