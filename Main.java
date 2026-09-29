import java.util.ArrayList;
import java.util.List;

// CODIGO INICIAL DE LA PRACTICA 3.
// No esta refactorizado: el objetivo es que el equipo detecte y mejore su diseno.
abstract class Archivo {
    String nombre;
    int tamanio;

    Archivo(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }
}

class ArchivoPDF extends Archivo {
    ArchivoPDF(String nombre, int tamanio) {
        super(nombre, tamanio);
    }
}

class ArchivoTexto extends Archivo {
    ArchivoTexto(String nombre, int tamanio) {
        super(nombre, tamanio);
    }
}

class Carpeta {
    String nombre;
    List<Archivo> archivos = new ArrayList<>();
    List<Carpeta> subcarpetas = new ArrayList<>();

    Carpeta(String nombre) {
        this.nombre = nombre;
    }
}

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
            carpeta.archivos.add(new ArchivoPDF(nombre, tamanio));
        } else if (tipo.equals("txt")) {
            carpeta.archivos.add(new ArchivoTexto(nombre, tamanio));
        }
    }

    static int obtenerTamanio(Carpeta carpeta) {
        int total = 0;
        for (Archivo archivo : carpeta.archivos) {
            total += archivo.tamanio;
        }
        for (Carpeta subcarpeta : carpeta.subcarpetas) {
            total += obtenerTamanio(subcarpeta);
        }
        return total;
    }

    static void enviarResultado(Carpeta carpeta, String destino) {
        CorreoLegacy correo = new CorreoLegacy();
        correo.send_email(destino,
                "Tamanio total: " + obtenerTamanio(carpeta));
    }

    public static void main(String[] args) {
        Carpeta clase = new Carpeta("MyP");
        agregarArchivo(clase, "pdf", "practica.pdf", 120);
        agregarArchivo(clase, "txt", "notas.txt", 80);

        Carpeta ejemplos = new Carpeta("Ejemplos");
        agregarArchivo(ejemplos, "txt", "ejemplo.txt", 50);
        clase.subcarpetas.add(ejemplos);

        System.out.println(obtenerTamanio(clase));
        enviarResultado(clase, "profesor@universidad.edu");

        Carpeta vacia = new Carpeta("Vacia"); // preparar
        int total = obtenerTamanio(vacia); // ejecutar
        comprobar("Carpeta vacia", 0, total); // comprobar

        Carpeta carpeta120 = new Carpeta("Carpeta 120"); // preparar
        agregarArchivo(carpeta120, "pdf", "prueba2.pdf", 120);
        int total2 = obtenerTamanio(carpeta120); // ejecutar
        comprobar("Carpeta 120", 120, total2); // comprobar

        Carpeta carpeta200 = new Carpeta("Carpeta 200"); // preparar
        agregarArchivo(carpeta200, "pdf", "prueba3.pdf", 120);
        agregarArchivo(carpeta200, "txt", "prueba3.txt", 80);
        int total3 = obtenerTamanio(carpeta200); // ejecutar
        comprobar("Carpeta 200", 200, total3); // comprobar

        Carpeta carpeta250 = new Carpeta("Carpeta 250"); // preparar
        agregarArchivo(carpeta250, "pdf", "prueba4.pdf", 120);
        agregarArchivo(carpeta250, "txt", "prueba4.txt", 80);
        Carpeta subcarpeta250 = new Carpeta("Carpeta250"); // preparar
        agregarArchivo(subcarpeta250, "txt", "prueba4.1.txt", 50);
        carpeta250.subcarpetas.add(subcarpeta250);
        int total4 = obtenerTamanio(carpeta250); // ejecutar
        comprobar("Carpeta 250", 250, total4); // comprobar

        Carpeta carpeta0 = new Carpeta("Carpeta archivo 0");
        agregarArchivo(carpeta0, "pdf", "prueba5.pdf", 0);
        int total5 = obtenerTamanio(carpeta0); // ejecutar
        comprobar("Carpeta archivo 0", 0, total5); // comprobar
    }

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
