package Negocio;

import Persistencia.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class ConexaoDAO {

    private static Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private static ConexaoDAO connect;
    
    
    private final String create = "INSERT INTO ROOT.TABELA(n_destinatario, tel_destinatario, e_destinatario, n_remetente, tel_remetente, e_remetente, dataEnvio) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String query = "SELECT * FROM ROOT.TABELA";
    
    private ConexaoDAO() { 
        conn = SQLConnection.getInstance().startConnection();
        stmt = null;
    }

    public static ConexaoDAO getInstance(){
       if(connect == null) 
          connect = new ConexaoDAO();
        return connect;
    }
      
    public void create(FormularioDTO f){
        
        try {
            stmt = conn.prepareStatement(create);
            stmt.setString(1, f.getNomeDestinatario());
            stmt.setLong(2, f.getTelefaxDestinatario());
            stmt.setString(3, f.getEmailDestinatario());
            stmt.setString(4, f.getNomeRemetente());
            stmt.setLong(5, f.getTelefaxRemetente());
            stmt.setString(6, f.getEmailRemetente());
            stmt.setDate(7,new Date(Calendar.getInstance().getTimeInMillis()));  
            
            stmt.execute();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar usuario"+ ex);
            ex.printStackTrace();
            
        } finally{
            SQLConnection.getInstance().closeConnection();
            
        }   
    }
    
    public ArrayList<FormularioDTO> AllList(){
        ArrayList<FormularioDTO> list = new ArrayList<>();
        
        try {
            conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FormularioDTO form = new FormularioDTO();
                form.setNomeDestinatario(rs.getString("n_destinatario"));
                form.setTelefaxDestinatario(rs.getInt("tel_destinatario"));
                form.setEmailDestinatario(rs.getString("e_destinatario"));
                form.setNomeRemetente(rs.getString("n_remetente"));
                form.setTelefaxRemetente(rs.getLong("tel_remetente"));
                form.setEmailRemetente(rs.getString("tel_remetente"));
                form.setData(rs.getDate("dataEnvio"));
                
                list.add(form);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return list;
    }
 
    
}
