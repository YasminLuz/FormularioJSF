package Negocio;

import Persistencia.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ConexaoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    
    private final String create = "INSERT INTO ROOT.Tabela(n_destinatario, tel_destinatatrio, e_destinatario, n_remetente, tel_remetente, e_remetente, data) VALUES (?,?,?,?,?,?,?)";
    private final String query = "SELECT n_destinatario, tel_destinatatrio, e_destinatario, n_remetente, tel_remetente, e_remetente, data FROM ROOT.Tabela ";
    
    public ConexaoDAO() { 
        conn = ConexaoDAO.startConnection();
        stmt = null;
        
    }
    
    public static Connection startConnection(){
       return null; 
    }
   
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
           System.err.println("Não foi possivel fechar a conexao");
        }
    }
    
      public void create(FormularioMB f){
        
        try {
            stmt = conn.prepareStatement(create);
            stmt.setString(1, f.getNomeDestinatario());
            stmt.setLong(2, f.getTelefaxDestinatario());
            stmt.setString(3, f.getEmailDestinatario());
            stmt.setString(4, f.getNomeRemetente());
            stmt.setLong(5, f.getTelefaxRemetente());
            stmt.setString(6, f.getEmailRemetente());
            stmt.setDate(7, (Date) f.getData());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Não foi possivel criar usuario"+ ex);
            ex.printStackTrace();
            
        } finally{
            SQLConnection.CloseConnection();
            
        }   
    }
    
    public ArrayList<FormularioMB> AllList(){
        ArrayList<FormularioMB> list = new ArrayList<>();
        
        try {
            conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FormularioMB form = new FormularioMB();
                form.setNomeDestinatario(rs.getString("n_destinatario"));
                form.setTelefaxDestinatario(rs.getInt("tel_destinatatrio"));
                form.setEmailDestinatario(rs.getString("e_destinatario"));
                form.setNomeRemetente(rs.getString("n_remetente"));
                form.setTelefaxRemetente(rs.getLong("tel_remetente"));
                form.setEmailRemetente(rs.getString("tel_remetente"));
                form.setData(rs.getDate("data"));
                
                list.add(form);
            }
           
            conn.close();
            
        } catch (SQLException ex) {
            System.err.println("Erro ao capturar dados do SGBD"+ ex);
        }
        
        return list;
    }
 
    
}
