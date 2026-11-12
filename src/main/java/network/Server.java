package network;

//servidor es a quien se conectan, receptor :)

import utils.NetworkConfig;
import java.net.ServerSocket;
import java.net.Socket ;

public class Server
{
    private final static String SERVER_NETWORK_FILE_PATH = "src/main/data/ServerSettings.json";
    private String TRANSFER_DESTINATION;
    private static ServerSocket server_socket;

    public String getTRANSFER_DESTINATION() {
        return TRANSFER_DESTINATION;
    }

    public void setTRANSFER_DESTINATION(String TRANSFER_DESTINATION) {
        this.TRANSFER_DESTINATION = TRANSFER_DESTINATION;
    }


    public Server()
    {
        NetworkConfig network_config = NetworkConfig.load(SERVER_NETWORK_FILE_PATH);
        System.out.println("Servidor escuchando en puerto: " + network_config.getPort());
    }
}
