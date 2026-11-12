package network;
import java.io.*;
import java.net.Socket;
import java.sql.Array;
import java.util.ArrayList;

public class ClientConnection
{
    private Socket socket;
    private DataInputStream input;
    private OutputStream output;

    public ClientConnection(Socket socket)
    {
        this.socket = socket;
        try
        {
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());
        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
