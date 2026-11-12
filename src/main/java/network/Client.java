package network;
//cliente es quien quiere acceder a algo, osea quien envía :)

import utils.NetworkConfig;

public class Client
{
    private final static String CLIENT_NETWORK_FILE_PATH = "src/main/data/ClientSettings.json";
    private String TRANSFER_SOURCE;

    public String getTRANSFER_SOURCE() {
        return TRANSFER_SOURCE;
    }

    public void setTRANSFER_SOURCE(String TRANSFER_SOURCE) {
        this.TRANSFER_SOURCE = TRANSFER_SOURCE;
    }

    public Client()
    {
        NetworkConfig network_config = NetworkConfig.load(CLIENT_NETWORK_FILE_PATH);
        System.out.println("Cliente preparado con target_ip: " + network_config.getTarget_ip() + ", port: " + network_config.getPort());
    }
}
