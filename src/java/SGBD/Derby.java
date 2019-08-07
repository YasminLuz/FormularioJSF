package SGBD;

/**
 *
 * @author Yasmin
 */
public class Derby extends SGBD{

    private static Derby derby;
    
    private Derby() {
        driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        serverName = "localhost";
        url = "jdbc:derby://  "+ serverName + "/" + mydatabase;
        username = "root";
        password = "root";
    }
    
    public static Derby getInstance() {
        if (derby == null) {
            derby = new Derby();
        }
        return derby;
    }
}
