package Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by phoebegl on 2017/2/15.
 */
public class DBHelper {
    private static DBHelper dbHelper = null;

    private DataSource ds = null;
    private Context ctx = null;
    private Connection conn;

    private DBHelper() {
    }

    public static DBHelper getDataInstance(){
        if(dbHelper == null)
            dbHelper = new DBHelper();
        return dbHelper;
    }

    public Connection getConnection() {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        try {
            ctx = new InitialContext(jndiProperties);
            ds = (DataSource)ctx.lookup("java:/MySqlDS");
            if (ds == null)
                System.out.println("datasource is null");
            System.out.println("get context");
            conn = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePreparedStatement(PreparedStatement stmt)
    {
        if(stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeResult(ResultSet result)
    {
        if(result!=null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
