package SGBD;

import Interface.ISGBD;

/**
 *
 * @author Aluno
 */
public abstract class SGBD implements ISGBD {

    protected String driverName, serverName, mydatabase, url, username, password;
    private static ISGBD opcao;
    
    public SGBD() {
        mydatabase = "Formulario";
    }  
    
    public static ISGBD op(EscolherSGBD op){
        
       if(op == EscolherSGBD.DERBY)
           opcao = Derby.getInstance();
       else if(op == EscolherSGBD.POSTGRES)
           opcao =Postgres.getInstance();
       else  
           opcao = Sqlite.getInstance();
       
       return opcao;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public String getServerName() {
        return serverName;
    }

     @Override
    public String getMydatabase() {
        return mydatabase;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
