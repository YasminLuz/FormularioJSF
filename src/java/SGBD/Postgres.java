package SGBD;

/**
 *
 * @author Yasmin
 */
public class Postgres extends SGBD {

  private static Postgres postgres;
    
    private Postgres() {
        super.driverName = "org.postgresql.Driver";
        super.serverName = "localhost:5432";
        super.url = "jdbc:postgresql://"+ serverName + "/" + mydatabase;
        super.username = "postgres";
        super.password = "12345"; //"aluno";//
    }
    
    public static Postgres getInstance() {
        if (postgres == null) {
            postgres = new Postgres();
        }
        return postgres;
    }
}
