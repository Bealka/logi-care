/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * Classe affichant les messages d'erreurs SQL.
 */
/**
 * @author Bealka
 */
public class SQLWarningsExceptions {

    /**
     * Print SQL warnings associated with a database connection.
     *
     * @param conn a database connection
     */
    public static void printWarnings(Connection conn) {
        SQLWarning warn = null;
        try {
            warn = conn.getWarnings();
        } catch (SQLException se) {
            System.err.println("SQL Exception: "
                    + se.getMessage());
            se.printStackTrace();
            return;
        }
// Print all warnings
        while (warn != null) {
            System.out.print("SQL Warning: ");
            System.out.print("State : "
                    + warn.getSQLState());
            System.out.print(", Message: "
                    + warn.getMessage());
            System.out.println(", Error : "
                    + warn.getErrorCode());
            warn = warn.getNextWarning();
        }
    }

    /**
     * Print information about SQL exceptions.
     *
     * @param se an SQL exception
     */
    public static void printExceptions(SQLException se) {
// Loop through SQL Exceptions
        while (se != null) {
            System.out.println("State : "
                    + se.getSQLState());
            System.out.println("Message: "
                    + se.getMessage());
            System.out.println("Error : "
                    + se.getErrorCode());
            se = se.getNextException();
        }
    }

}
