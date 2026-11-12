package utils;

import java.io.File;
import java.io.FileReader;

public class FileUtils
{
    public FileReader readFile(String path)
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
