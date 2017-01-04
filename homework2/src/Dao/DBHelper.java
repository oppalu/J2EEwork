package Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phoebegl on 2017/1/2.
 */
public class DBHelper {
    private static DBHelper dbHelper = null;
    private static final String DSNAME = "java:comp/env/jdbc/homework1";

    private DataSource ds = null;
    private Context ctx = null;
    private Connection conn;

    private DBHelper() {
        if(ds == null) {
            try {
                ctx = new InitialContext();
                ds = (DataSource)ctx.lookup(DSNAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DBHelper getDataInstance(){
        if(dbHelper == null)
            dbHelper = new DBHelper();
        return dbHelper;
    }

    public Connection getConnection() {
        try {
            conn = ds.getConnection();
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
