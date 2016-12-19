package Common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by phoebegl on 2016/12/19.
 */
public class DataInit {

    private static DataSource ds = null;
    private static Context ctx = null;
    private static final String DSNAME = "java:comp/env/jdbc/homework1";

    public static DataSource getDataSource(){
        if(ds == null) {
            try {
                ctx = new InitialContext();
                ds = (DataSource)ctx.lookup(DSNAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ds;
    }
}
