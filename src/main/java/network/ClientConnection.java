package network;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import utils.FileUtils;

public class ClientConnection
{
    private static Scanner scanner = new Scanner(System.in);
    private static DataInputStream data_input = null;
    private static DataOutputStream data_output = null;
    private static FileUtils file_utils = new FileUtils();

    public ClientConnection(Socket socket)
    {
        try
        {
            data_input = new DataInputStream(socket.getInputStream());
            data_output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Conexión establecida con el servidor por medio de ip: " + socket.getInetAddress() + ", port: " + socket.getPort());

        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void send() {
        System.out.println("Escriba la ruta del archivo que quiere enviar: \n");
        String path = scanner.nextLine();
        try
        {
            sendFile(path);
            System.out.println("Archivo: " + path + "enviado correctamente.");
        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void sendFile(String path) throws Exception
    {
        int bytes = 0;
        File file = file_utils.readFile(path);
        FileInputStream file_input = new FileInputStream(file);

        //enviamos el archivo al servidor
        data_output.writeLong(file.length());
        byte[] buffer = new byte[4 * 1024];
        while((bytes = file_input.read(buffer)) != -1)
        {
            data_output.write(buffer, 0, bytes);
            data_output.flush();
        }
        file_input.close();
    }
}
