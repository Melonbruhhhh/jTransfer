package utils;

import java.io.File;
import java.io.FileReader;

public class FileUtils
{
    public FileReader createFileReader(String path)
    {
        try {

            File file = readFile(path);
            return new FileReader(file);

        } catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public File readFile(String path)
    {
        try
        {
            return new File(path);
        } catch(Exception e)
        {
            System.out.println("Error al leer archivo: " + e);
            return null;
        }
    }
}
