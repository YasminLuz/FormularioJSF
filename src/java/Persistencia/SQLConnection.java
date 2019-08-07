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
    private static String driverName = "org.sqlite.JDBC";//org.postgresql.Driver";//"org.apache.derby.jdbc.EmbeddedDriver";
    private static String serverName = "localhost:5432";    
    private static String mydatabase = "Formulario";        
    private static final String url = "jdbc:sqlite://C:\Users\Aluno\Documents\NetBeansProjects\FormularioJSF-master\banco.db"; 
//jdbc:postgresql://" + serverName + "/" + mydatabase; //"jdbc:derby://" + serverName + "/" + mydatabase;
    private static String username = "";//"postgres";//"root";            
    private static String password = "";//"aluno"; //"root";   
    
    private static SQLConnection connect;

    private SQLConnection() {}
 
    public static SQLConnection getInstance(){
       if(connect == null) 
          connect = new SQLConnection();
        return connect;
    }
      
    public Connection startConnection() {

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
            System.out.println("O driver expecificado nao foi encontrado."+e.getMessage());
            return null;
            
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados."+ e.getSQLState());
            return null;
        }

    }

    public static String statusConnection() {
        return status;
    }

    public static boolean closeConnection() {
 
        try { 
            SQLConnection.getInstance().startConnection().close();
            return true;
 
        } catch (SQLException e) {
            System.err.println("Não foi possivel fechar a conexao");
            return false;
 
        }

    }
 
    public static java.sql.Connection RestartConnection(){
        closeConnection();
        return SQLConnection.getInstance().startConnection();
     }
 
}

