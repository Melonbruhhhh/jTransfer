package network;
//cliente es quien quiere acceder a algo, osea quien envía :)

import utils.NetworkConfig;

import java.net.Socket;

public class Client
{
    private final static String CLIENT_NETWORK_FILE_PATH = "src/main/data/ClientSettings.json";

    public Client()
    {
        NetworkConfig network_config = NetworkConfig.load(CLIENT_NETWORK_FILE_PATH);
        System.out.println("Cliente preparado con target_ip: " + network_config.getTarget_ip() + ", port: " + network_config.getPort());

        Socket client_socket = clientSocketSetup(network_config.getTarget_ip(), network_config.getPort());
        ClientConnection client_connection = new ClientConnection(client_socket);
        client_connection.send();
    }

    private Socket clientSocketSetup(String target_ip, int port)
    {
        try
        {
            return new Socket(target_ip, port);
        } catch (Exception e)
        {
            System.out.println("Error al crear socket de servidor: " + e);
            return null;
        }
    }
}
