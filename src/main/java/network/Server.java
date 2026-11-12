package network;

//servidor es a quien se conectan, receptor :)

import utils.NetworkConfig;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket ;

public class Server
{
    private final static String SERVER_NETWORK_FILE_PATH = "src/main/data/ServerSettings.json";
    private static DataInputStream data_input = null;
    private static DataOutputStream data_output = null;

    public Server()
    {
        try
        {
            NetworkConfig network_config = NetworkConfig.load(SERVER_NETWORK_FILE_PATH);
            System.out.println("Servidor creado en puerto: " + network_config.getPort());

            ServerSocket server_socket = serverSocketSetup(network_config.getPort());
            System.out.println("Socket de servidor creado");

            Socket client_socket = server_socket.accept();
            System.out.println("Conectado con el cliente: " + client_socket);

            data_input = new DataInputStream(client_socket.getInputStream());
            data_output = new DataOutputStream(client_socket.getOutputStream());

            //metodo para recibir cosas...
            receiveFile("received.png");

            data_input.close();
            data_output.close();
            client_socket.close();

        } catch (Exception e)
        {
            System.out.println("Error al crear servidor: " + e);
        }

    }

    private ServerSocket serverSocketSetup(int port)
    {
        try
        {
            return new ServerSocket(port);
        } catch (Exception e)
        {
            System.out.println("Error al crear socket de servidor: " + e);
            return null;
        }
    }

    private static void receiveFile(String file_name) throws Exception
    {
        int bytes = 0;
        FileOutputStream file_output = new FileOutputStream(file_name);

        long size = data_input.readLong(); //lee el tamaño del archivo
        byte[] buffer = new byte[4 * 1024];

        while(size > 0 && (bytes = data_input.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1)
        {
            file_output.write(buffer, 0, bytes);
            size -= bytes;
        }

        System.out.println("Archivo recibido");
        file_output.close();
    }

}
