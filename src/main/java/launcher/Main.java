package launcher;

import java.util.Scanner;

import network.Client;
import network.Server;

public class Main
{
    static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliga el modo que quiere utilizar");
        System.out.println("1. Cliente");
        System.out.println("2. Servidor");

        int choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                Client client = new Client();
                break;

            case 2:
                Server server = new Server();
                break;

            default:
                System.out.println("Elección invalida");
        }
    }
}
//1. crear un programa que transfiera un archivo especifico por medio de lan (imagen) -- LISTO
//2. cambiar el uso de consola por jframe o alguna biblioteca similar
//3. añadir la capacidad de elegir que archivo enviar mediante ruta (es posible que tambien ocurra el error de nombre muy largo)
//4. añadir la capacidad de cancelar transferencias
//5. añadir la capacidad de elegir mediante un menu a quien quieres enviar un archivo y ventanas correspondientes a la interaccion (cosas como esperando respuesta y el aceptar conexion, etc.)
//6. listo :)

//11-11-26 inicio del proyecto, hasta ahora tengo que ver como usar sockets en java y el como enviar un archivo.
//1. Se creo la clase networkconfig que carga un archivo json el cual esta en data y existe para ser cargado, obteniendo target ip y puerto para la conexión :O-
//2. Refactorizacion de paquetes, utils e inicio de comunicacion por sockets. debido a que estoy aprendiendo a usar sockets en java posiblemente tome tiempo.
//12-11-26
//1. Ajustes a clases junto a capacidad de enviar archivos por consola y lan. Primer hito completado