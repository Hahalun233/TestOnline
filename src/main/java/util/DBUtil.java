package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 实现数据库驱动的加载、及数据库连接的获取、释放
 * 
 * @author guoli
 *
 */
public class DBUtil {
	private static String url ;
	private static String userName;
	private static String password;

    static{
		//1、补充代码：读取配置文件db.properties，初始化静态变量url、userName、password、driverName
        try {
            Properties properties = new Properties();

            InputStream res = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");

            properties.load(res);

//            InputStream fis =DBUtil.class.getResourceAsStream("db.properties");
//            properties.load(fis);

            url = properties.getProperty("url");
            userName = properties.getProperty("name");
            password = properties.getProperty("password");
//          driverName = properties.getProperty("driverName");
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * 获取一个数据库的连接
	 * @return
	 */
	public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,userName,password);
    }
	/**
	 * 进行资源释放

	 */
	public static void release(PreparedStatement st,Connection conn)  {

		if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}

    public static void release(ResultSet rs,PreparedStatement st,Connection conn)  {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
