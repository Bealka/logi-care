/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Bealka
 */
public class DatabaseAccessProperties {

    private Properties prop = new Properties();
    private String jdbcDriver;
    private String dbUrl;
    private String username, password;

    public DatabaseAccessProperties(String propertiesFile) {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(propertiesFile));
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: "
                    + e.getMessage());
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.err.println("IOException: "
                    + e.getMessage());
            e.printStackTrace();
            return;
        }
        jdbcDriver
                = prop.getProperty("jdbc.driver");
        dbUrl
                = prop.getProperty("database.url");
        username = prop.getProperty("database.username");
        password = prop.getProperty("database.password");
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getDatabaseUrl() {
        return dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

