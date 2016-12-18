package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBUtil {
			public static String getTime(){
						Date date = new Date();
						SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.KOREA);
						String time = fomatter.format(date);
						return time;
			}
			public static void close(Connection conn){
						if(conn != null){
									try {
												conn.close();
									} catch (SQLException e) {
												e.printStackTrace();
									}
						}
			}
			public static void close(Statement stmt){
						if(stmt != null){
									try {
												stmt.close();
									} catch (SQLException e) {
												e.printStackTrace();
									}
						}
			}
}
