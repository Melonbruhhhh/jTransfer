package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.lang.reflect.Type;

import java.io.*;

public class NetworkConfig
{
    private final static String NETWORK_FILE_PATH = "src/main/data/network.json";
    private String target_ip;
    private String port;
    private static Type data_type = new TypeToken<ArrayList<NetworkConfig>>() {}.getType();

    public String getTarget_ip() {
        return target_ip;
    }

    private void setTarget_ip(String target_ip) {
        this.target_ip = target_ip;
    }

    public String getPort() {
        return port;
    }

    private void setPort(String port) {
        this.port = port;
    }

    void main()
    {
        try
        {
            FileReader network_config_file_reader = readFile(NETWORK_FILE_PATH);
            Gson gsonObject = new Gson();
            ArrayList<NetworkConfig> data = gsonObject.fromJson(network_config_file_reader, data_type);
            setTarget_ip(data.get(0).getTarget_ip());
            setPort(data.get(0).getPort());
            System.out.println("target ip: " + " " + getTarget_ip());
            System.out.println("port: " + " " + getPort());

        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static FileReader readFile(String path)
    {
        try {

            File file = new File(path);
            return new FileReader(file);

        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
//:(