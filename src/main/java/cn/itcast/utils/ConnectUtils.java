package cn.itcast.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;


    public Connection getThreadConnection() {

        Connection conn = tl.get();

        try{
            if (conn == null) {
                Connection connection = dataSource.getConnection();
                tl.set(connection);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void removeConnection(){
        tl.remove();
    }
}
