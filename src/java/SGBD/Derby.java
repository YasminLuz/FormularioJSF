package SGBD;

import Interface.ISGBD;

/**
 *
 * @author Yasmin
 */
public class Derby extends SGBD {

    private static Derby derby;
    
    private Derby() {
        super.driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        super.serverName = "localhost";
        super.url = "jdbc:derby://"+ serverName + "/" + mydatabase;
        super.username = "root";
        super.password = "root";
    }
    
    public static Derby getInstance() {
        if (derby == null) {
            derby = new Derby();
        }
        return derby;
    }
}
