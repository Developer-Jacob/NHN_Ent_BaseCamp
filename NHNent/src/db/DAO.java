package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Message;

//DB의 CRUD기능을 위한 클래스
public class DAO {
			private static DAO dao;
			private DAO() {}
			// 싱글톤을 위한 함수
			static public DAO getInstance() {
						if (dao == null) {
									dao = new DAO();
						}
						return dao;
			}

			public void insert(Connection conn, Message msg) throws SQLException {
						PreparedStatement pstmt = null;
						try {
									String sql = "insert into guestbook_table "
															+ "(user, content, time, password ) values (?,?,?,?)";
									pstmt = conn.prepareStatement(sql);
									//user
									pstmt.setString(1, msg.getUser());
									//content
									pstmt.setString(2, msg.getContents());
									//time
									pstmt.setString(3, DBUtil.getTime());
									//psw
									pstmt.setString(4, msg.getPassword());
									pstmt.executeUpdate();
						} finally {
									DBUtil.close(pstmt);
									DBUtil.close(conn);
						}
			}

			public void select(Connection conn, int msgId) throws SQLException{
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						try{
//									pstmt = conn.prepareStatement(sql);
						}
						finally {
									
						}
			}

			public void delete() {
						
			}
}
