package launcher;

import network.Client;
import network.Server;

public class Main
{
    static void main(String[] args)
    {
        try
        {
            Client client = new Client();
            Server server = new Server();

            client.setTRANSFER_SOURCE("src/source");
            server.setTRANSFER_DESTINATION("src/transfers");

            System.out.println("cliente enviando archivo: " + client.getTRANSFER_SOURCE() + " al directorio: " + server.getTRANSFER_DESTINATION() + " del servidor");
        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
//1. crear un programa que transfiera un archivo especifico por medio de lan (imagen)
//2. cambiar el uso de consola por jframe o alguna biblioteca similar
//3. añadir la capacidad de elegir que archivo enviar mediante ruta (es posible que tambien ocurra el error de nombre muy largo)
//4. añadir la capacidad de cancelar transferencias
//5. añadir la capacidad de elegir mediante un menu a quien quieres enviar un archivo y ventanas correspondientes a la interaccion (cosas como esperando respuesta y el aceptar conexion, etc.)
//6. listo :)

//11-11-26 inicio del proyecto, hasta ahora tengo que ver como usar sockets en java y el como enviar un archivo.
//1. Se creo la clase networkconfig que carga un archivo json el cual esta en data y existe para ser cargado, obteniendo target ip y puerto para la conexión :O-
//2. Refactorizacion de paquetes, utils e inicio de comunicacion por sockets. debido a que estoy aprendiendo a usar sockets en java posiblemente tome tiempo.