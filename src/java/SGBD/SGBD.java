package SGBD;

/**
 *
 * @author Aluno
 */
enum EscolherSGBD {
    POSTGRES, DERBY, MYSQL;
}

public abstract class SGBD {

    protected String driverName, serverName, mydatabase, url, username, password;
    private static SGBD sgbd;
    private SGBD opcao;
    
    protected SGBD() {
        mydatabase = "Formulario";
    }  
    
    public SGBD op(EscolherSGBD op){
        
       if(op == EscolherSGBD.DERBY)
           opcao = Derby.getInstance();
       else if(op == EscolherSGBD.POSTGRES)
           opcao =Postgres.getInstance();
       else  
           opcao = Sqlite.getInstance();
       
       return opcao;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getMydatabase() {
        return mydatabase;
    }

    public void setMydatabase(String mydatabase) {
        this.mydatabase = mydatabase;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
