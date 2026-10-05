1. El método agregarArchivo se encarga de verificar el tipo de archivo, si es pdf o txt, posteriormente crea un un archivoPDF o archivoTexto con un nombre y tamaño.
2. El método obtenerTamanio se encarga de sumar el tamaño de todos los archivos dentro de una carpeta y obtener el tamaño de los archivos dentro de subcarpetas también recursivamente.
3. El método enviarResultado se encarga de crear un correo y enviarlo a un destinatario junto con el tamaño total del correo, es decir el tamaño de la carpeta.
4. Identifiquen tres problemas concretos. Para cada uno indiquen: dónde aparece, qué cambio sería difícil
y qué clase o interfaz podría hacerse responsable.

4.1. 

* Problema: Carpeta no trata de la misma forma a archivos y subcarpetas.
Aparece en Carpeta en las líneas 28 y 29, se crean 2 listas separadas. List<Archivo> archivos y List<Carpeta> subcarpetas.
También, para calcular el tamaño en Main en las líneas 53-62 se recorren por separado los arhcivos y las subcarpetas.

* ¿Qué cambio sería díficil?
Main tiene quesaber cómo calcular el tamaño de subcarpetas y archivos, si hubieran otros nuevos tipos de elementos que puedieran ir en la carpeta se tendría que cambiar el método para saber cómo calcular su tamaño para cada nuevo tipo elemento.

* ¿Qué clase o interfaz podría hacerse responsable?
Una interfaz Elemento que defina el método obtenerTamanio(). Dónde archivo solo devuelva su propio tamaño y Carpeta sume el tamaño de sus elementos, así main solo pide el tamaño de la carpeta.

4.2. 

* Problema: Main elige el tipo de archivo que crear
En el método agregarArchivo(), en las líneas 44-51.
Se usa un if y newArchivoPDF y new ArchivoTexto para elegir cuál crear.

* ¿Qué cambio sería difícil?
Si se agregaran más tipos de archivos, se tendría que modificar Main con otra condicion para crear los archivos causando más dificultades mientras más tipos de archivos existan.

* ¿Qué clase o interfaz podría haacerse responsable?
Se puede crear una clase CreadorArchivo para definir la operación para crear archivos, al igual que clases CreadorPDF y CreadorTTexto para crear sus tipos. Así se encargan estos creadores en lugar de Main.

4.3

* Problema: Main depende del método send_email()
En el método enviarResultado(), en las líneas 64-68, Main crea un CorreoLegacy y llama a correo.send_email

* ¿Qué cambio sería difícil?
Si se quisiera cambiar CorreoLegacy por otro se tendría que modificar Main, si este nuevo utilizara un método distinto para enviar correos se tendría que cambiar el código para poder usarlo.

* ¿Qué clase o interfaz podría hacerse responsable?
Se puede crear una interfaz Notificador con un método enviar(destino, mensaje). AdaptadorCorrreo implementa la interfaz y traduce la llamada send_email() de CorreoLegacy. Así Main usa Notificador y no depende de CorreoLegacy.

* Diagrama Final
https://canva.link/w9eikhvyj14mkc7

* Etapa 6

* ¿Qué responsabilidad se movió a cada clase?

- Elemento: Define la operación obtenerTamanio() que deben tener los elementos que pueden estar en una carpeta.
- Archivo: Representa un archivo y devuelve su propio tamaño con obtenerTamanio().
- Carpeta: Almacena elementos y calcula su tamaño total. Puede contener ahora archivos y otras caarpetas, obteniendo el tamaño de cada elemento con obtenerTamanio().
- CreadorArchivo: Define la operación para creaer un archivo
- CreadorPDF: Crea objetos ArchivoPDF.
- CreadorTexto: Crea objetos ArchivoTexto.
- Notificador: Define la forma en que el programa solicita el envió de un mensaje con enviar(destino, mensaje
- AdaptadorCorreo: Adapta la interfaz Notificador al método que usa CorreoLegacy, convierte la llamada a enviar() en una llamada a send_email()
- CorreoLegacy: Mantiene el envió del correo usando el método original send_email(), no tuvo que ser modificada.
- Main: Define que objetos crear y como organizarlos, y como usar sus operaciones.

* ¿Que permaneció igual para quien usa el programa?
Para quien usa el programa su compotamiento principal se permanece igual.
- Se pueden crear archivos PDF y de texto
- Agregar archivos a una carpeta
- Crear subcarpetas y agregarlas a otras carpetas
- Calcular el tamaño total de una carpeta, con sus subcarpetas
- Enviar el correo con el tamanio

