package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yasmin
 */
public class SQLConnection {
 
    public static String status = "Não conectou...";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String serverName = "localhost";    //caminho do servidor do BD
    private static String mydatabase = "SystemUser";        
    private static final String url = "jdbc:derby://" + serverName + "/" + mydatabase;
    private static String username = "root";            
    private static String password = "root";   
 
    //Método de Conexão//
    public static Connection getConexaoSQL() {

        Connection connection = null;          

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
                if (connection != null) 
                    status = ("STATUS--->Conectado com sucesso!");
                else 
                    status = ("STATUS--->Não foi possivel realizar conexão");

                return connection;

        } catch (ClassNotFoundException e) {  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
            
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }

    }

    public static String statusConnection() {
        return status;
    }

    public static boolean CloseConnection() {
 
        try { 
            SQLConnection.getConexaoSQL().close();
 
            return true;
 
        } catch (SQLException e) {
            return false;
 
        }

    }
 
    public static java.sql.Connection RestartConnection(){
        CloseConnection();
        return SQLConnection.getConexaoSQL();
     }
 
}

