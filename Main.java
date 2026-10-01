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

        CreadorArchivo creadorPDF = new CreadorPDF();
        Archivo practica = creadorPDF.crearArchivo("practica.pdf", 120);
        clase.agregar(practica);
        CreadorArchivo creadorTexto = new CreadorTexto();
        Archivo notas = creadorTexto.crearArchivo("notas.txt", 80);
        clase.agregar(notas);

        Carpeta ejemplos = new Carpeta("Ejemplos");
        Archivo ejemplo = creadorTexto.crearArchivo("ejemplo.txt", 50);
        ejemplos.agregar(ejemplo);

        clase.agregar(ejemplos);

        System.out.println(clase.obtenerTamanio());
        enviarResultado(clase, "profesor@universidad.edu");


        // Prueba carpeta vacía
        Carpeta vacia = new Carpeta("Vacia"); // preparar
        int total = vacia.obtenerTamanio(); // ejecutar
        comprobar("Carpeta vacia", 0, total); // comprobar

        // Prueba carpeta con un PDF de 120
        Carpeta carpeta120 = new Carpeta("Carpeta 120"); // preparar
        Archivo prueba2 = creadorPDF.crearArchivo("prueba2.pdf", 120);
        carpeta120.agregar(prueba2);
        int total2 = carpeta120.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 120", 120, total2); // comprobar


        // Prueba carpeta con PDF de 120 y texto de 80
        Carpeta carpeta200 = new Carpeta("Carpeta 200"); // preparar
        Archivo prueba3 = creadorPDF.crearArchivo("prueba3.pdf", 120);
        carpeta200.agregar(prueba3);
        Archivo prueba3_1 = creadorTexto.crearArchivo("prueba3_1.txt", 80);
        carpeta200.agregar(prueba3_1);
        int total3 = carpeta200.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 200", 200, total3); // comprobar

        // Ejemplo completo con subcarpeta de 250
        Carpeta carpeta250 = new Carpeta("Carpeta 250"); // preparar
        Archivo prueba4 = creadorPDF.crearArchivo("prueba4.pdf", 120);
        carpeta250.agregar(prueba4);
        Archivo prueba4_1 = creadorTexto.crearArchivo("prueba4_1.txt", 80);
        carpeta250.agregar(prueba4_1);
        Carpeta subcarpeta250 = new Carpeta("subCarpeta 250"); // preparar
        Archivo prueba4_2 = creadorTexto.crearArchivo("prueba4_2.txt", 50);
        subcarpeta250.agregar(prueba4_2);
        carpeta250.agregar(subcarpeta250);
        int total4 = carpeta250.obtenerTamanio(); // ejecutar
        comprobar("Carpeta 250", 250, total4); // comprobar

        // Carpeta con un archivo de tamaño 0
        Carpeta carpeta0 = new Carpeta("Carpeta archivo 0");
        Archivo prueba5 = creadorPDF.crearArchivo("prueba5.pdf", 0);
        carpeta0.agregar(prueba5);
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
