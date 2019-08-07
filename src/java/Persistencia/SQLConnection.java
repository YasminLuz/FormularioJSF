package Persistencia;

import Interface.ISGBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import SGBD.*;
/**
 *
 * @author Yasmin
 */
public class SQLConnection {
    
    ISGBD database = SGBD.op(EscolherSGBD.POSTGRES);
    public static String status = "Não conectou...";
    private final  String driverName = database.getDriverName();//"org.postgresql.Driver";//"org.sqlite.JDBC";//"org.apache.derby.jdbc.EmbeddedDriver";
//    private final  String serverName = database.getServerName();    
//    private final  String mydatabase = database.getMydatabase();        
    private  final String url = database.getUrl(); //"jdbc:sqlite://C:\Users\Aluno\Documents\NetBeansProjects\FormularioJSF-master\banco.db"; 
    //"jdbc:derby://" + serverName + "/" + mydatabase;
    private final String username = database.getUsername(); //"root";            
    private final  String password = database.getPassword(); //"root";   
    
    private static SQLConnection connect;

    private SQLConnection() {}
 
    public static SQLConnection getInstance(){
       if(connect == null) 
          connect = new SQLConnection();
        return connect;
    }
      
    public Connection startConnection() {

        Connection connection;          

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

