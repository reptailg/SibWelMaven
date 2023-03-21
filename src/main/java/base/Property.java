package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    public String getProperty(String prop){
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src" + File.separator + "main" + File.separator +
                "resources" + File.separator + "config.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("File 'config.properties' not found");
        }
        return properties.getProperty(prop);
    }
}
