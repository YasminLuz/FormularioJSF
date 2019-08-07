package SGBD;

import Interface.ISGBD;

/**
 *
 * @author Yasmin
 */
public class Sqlite extends SGBD {

    private static Sqlite sqllite;
    
    private Sqlite() {
        super.driverName = "org.sqlite.JDBC";
        super.serverName = "localhost";
        super.url = "jdbc:sqlite://"+ serverName + "/" + mydatabase;//"jdbc:sqlite://C:\Users\Aluno\Documents\NetBeansProjects\FormularioJSF-master\banco.db";
        super.username = "";
        super.password = "";
    }
    
    public static Sqlite getInstance() {
        if (sqllite == null) {
            sqllite = new Sqlite();
        }
        return sqllite;
    }
    
}
