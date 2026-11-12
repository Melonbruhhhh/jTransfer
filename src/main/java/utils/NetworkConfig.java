package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.lang.reflect.Type;

import java.io.*;

public class NetworkConfig
{
    private static final FileUtils file_utils = new FileUtils();
    private String target_ip;
    private String port;
    private static final Type data_type = new TypeToken<ArrayList<NetworkConfig>>() {}.getType();

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

    public static NetworkConfig load(String path)
    {

        try
        {
            FileReader network_config_file_reader = file_utils.readFile(path);
            Gson gsonObject = new Gson();
            ArrayList<NetworkConfig> data = gsonObject.fromJson(network_config_file_reader, data_type);
            NetworkConfig network_config = data.getFirst();
            System.out.println("NetworkConfig cargado con target-ip: " + network_config.getTarget_ip() + ", port: " + network_config.getPort());
            return network_config;

        } catch(Exception e)
        {
            System.out.println("Error al leer archivo de configuración: " + path + ", error: " + e);
            return null;
        }
    }
}
//:(