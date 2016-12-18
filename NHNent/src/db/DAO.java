package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
									String sql = "insert into "+DBKeyword.Table_GuestBook+" ("
															+ DBKeyword.Column_User+","
															+ DBKeyword.Column_Content+","
															+ DBKeyword.Column_Time+","
															+ DBKeyword.Column_Password
															+ " ) values (?,?,?,?)";
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
						}
			}
			public ArrayList<Message> select_AllList(Connection conn) throws SQLException{
						Statement stmt = null;
						ResultSet rs = null;
						try{
									String sql = "select * from "
															+DBKeyword.Table_GuestBook
															+"order by"
															+DBKeyword.Column_Time
															+"asc";
									stmt = conn.createStatement();
									rs = stmt.executeQuery(sql);
									if(rs.next()){
												ArrayList<Message> msgList = new ArrayList();
												msgList.add(makeMessage(rs));
												while(rs.next()){
															msgList.add(makeMessage(rs));
												}
												return msgList;
									}else{
												return null;
									}
						}
						finally {
									DBUtil.close(stmt);
									DBUtil.close(rs);
						}
			}
			public Message select_ById(Connection conn, int msgId) throws SQLException{
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						try{
									String sql = "select * from "
															+DBKeyword.Table_GuestBook
															+"where"
															+DBKeyword.Column_id+"= ?";
									pstmt = conn.prepareStatement(sql);
									pstmt.setInt(1, msgId);
									rs = pstmt.executeQuery();
									if(rs.next()){
												return makeMessage(rs);
									}else{
												return null;
									}
						}
						finally {
									DBUtil.close(pstmt);
									DBUtil.close(rs);
						}
			}
			public void update(Message msg){
						PreparedStatement pstmt = null;
						try{
						}finally {
									
						}
			}
			public void delete(Connection conn, int msgId) throws SQLException{
						PreparedStatement pstmt = null;
						try{
									String sql = "delete from"
															+DBKeyword.Table_GuestBook
															+"where"
															+DBKeyword.Column_id+"= ?";
									pstmt = conn.prepareStatement(sql);
									pstmt.setInt(1, msgId);
									pstmt.executeUpdate();
						}finally {
									DBUtil.close(pstmt);
						}
			}
			public Message makeMessage(ResultSet rs) throws SQLException{
						Message msg = new Message();
						msg.setId(rs.getInt(DBKeyword.Column_id));
						msg.setUser(rs.getString(DBKeyword.Column_User));
						msg.setContents(DBKeyword.Column_Content);
						msg.setPassword(DBKeyword.Column_Password);
						return msg;
			}
}
