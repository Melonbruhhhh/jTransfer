package launcher;

public class Main
{
    static void main(String[] args)
    {
        System.out.println("Hola, mundo!");
    }
}
//1. crear un programa que transfiera un archivo especifico por medio de lan (imagen)
//2. cambiar el uso de consola por jframe o alguna biblioteca similar
//3. añadir la capacidad de elegir que archivo enviar mediante ruta (es posible que tambien ocurra el error de nombre muy largo)
//4. añadir la capacidad de cancelar transferencias
//5. añadir la capacidad de elegir mediante un menu a quien quieres enviar un archivo y ventanas correspondientes a la interaccion (cosas como esperando respuesta y el aceptar conexion, etc.)
//6. listo :)

//11-11-26 inicio del proyecto, hasta ahora tengo que ver como usar sockets en java y el como enviar un archivo.
//1. Se creo la clase networkconfig que carga un archivo json el cual esta en data y existe para ser cargado, obteniendo target ip y puerto para la conexión :O