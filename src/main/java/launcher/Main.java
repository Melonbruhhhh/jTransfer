package launcher;

import java.util.Scanner;

import network.Client;
import network.Server;
import gui.MainWindow;

public class Main
{
    static void main(String[] args)
    {
        new MainWindow();
        /*
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
        }*/
    }
}
//1. crear un programa que transfiera un archivo especifico por medio de lan (imagen) -- LISTO
//2. cambiar el uso de consola por jframe o alguna biblioteca similar -- Listo
//3. añadir la capacidad de elegir que archivo enviar mediante ruta (es posible que tambien ocurra el error de nombre muy largo) -- Listo
//3.1. añadir la capacidad de elegir donde guardar el archivo entrante
//3.2. añadir una pantalla de progreso, no es necesario usar dispose en las pantallas originales, solo crear una pequeña con una barra de progreso.
//4. añadir la capacidad de cancelar transferencias
//5. añadir la capacidad de elegir mediante un menu a quien quieres enviar un archivo y ventanas correspondientes a la interaccion (cosas como esperando respuesta y el aceptar conexion, etc.)
//6. listo :)

//11-11-26 inicio del proyecto, hasta ahora tengo que ver como usar sockets en java y el como enviar un archivo.
//1. Se creo la clase networkconfig que carga un archivo json el cual esta en data y existe para ser cargado, obteniendo target ip y puerto para la conexión :O-
//2. Refactorizacion de paquetes, utils e inicio de comunicacion por sockets. debido a que estoy aprendiendo a usar sockets en java posiblemente tome tiempo.
//12-11-26
//1. Ajustes a clases junto a capacidad de enviar archivos por consola y lan. Primer hito completado
//22-11-26
//1. Pasaron varios dias con creacion de la gui pero hasta ahora se completaron los hitos 2 y 3, las pantallas funcionan aunque aun no se puede elegir donde guardar el archivo, para eso debo crear metodos en fileUtils para verificaciones.
//Pero con el progreso que hay estoy feliz, voy a tomar un descanzo de una semana si es que no me da por seguir trabajando en el proyecto xd, tambien se añadieron unos "sub" hitos para cosas que planeo agregar.