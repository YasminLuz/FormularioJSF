package SGBD;

/**
 *
 * @author Yasmin
 */
class Postgres extends SGBD {

  private static Postgres postgres;
    
    private Postgres() {
        driverName = "org.postgresql.Driver";
        serverName = "localhost:5432";
        url = "jdbc:postgresql://  "+ serverName + "/" + mydatabase;
        username = "postgres";
        password = "12345";
    }
    
    public static Postgres getInstance() {
        if (postgres == null) {
            postgres = new Postgres();
        }
        return postgres;
    }
}
