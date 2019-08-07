package SGBD;

/**
 *
 * @author Yasmin
 */
class Sqlite extends SGBD{

    private static Sqlite sqllite;
    
    private Sqlite() {
        driverName = "org.sqlite.JDBC";
        serverName = "localhost";
        url = "jdbc:sqlite://  "+ serverName + "/" + mydatabase;//"jdbc:sqlite://C:\Users\Aluno\Documents\NetBeansProjects\FormularioJSF-master\banco.db";
        username = "";
        password = "";
    }
    
    public static Sqlite getInstance() {
        if (sqllite == null) {
            sqllite = new Sqlite();
        }
        return sqllite;
    }
    
}
