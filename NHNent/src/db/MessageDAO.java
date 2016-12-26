package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.css.PseudoClass;
import model.MessageDTO;

//DB의 CRUD기능을 위한 클래스
public class MessageDAO {
			private static MessageDAO dao;
			private MessageDAO() {}
			// 싱글톤을 위한 함수
			static public MessageDAO getInstance() {
						if (dao == null) {
									dao = new MessageDAO();
						}
						return dao;
			}

			public void insert(Connection conn, MessageDTO msg) {
						PreparedStatement pstmt = null;
						
						try {
									String sql = "insert into "+DBKeyword.Table_GuestBook+" ( "
															+ DBKeyword.Column_User+" , "
															+ DBKeyword.Column_Title+" , "
															+ DBKeyword.Column_Content+" , "
															+ DBKeyword.Column_Time+" , "
															+ DBKeyword.Column_Password
															+ " ) values (?,?,?,?,?) ";
									pstmt = conn.prepareStatement(sql);
									//user
									pstmt.setString(1, msg.getUser());
									//title
									pstmt.setString(2, msg.getTitle());
									//content
									pstmt.setString(3, msg.getContent());
									//time
									pstmt.setString(4, DBUtil.getTime());
									//psw
									pstmt.setString(5, msg.getPassword());
									pstmt.executeUpdate();
						}
						catch(SQLException e){ 
									e.printStackTrace();
						}
						finally {
									DBUtil.close(pstmt);
						}
			}
			public ArrayList<MessageDTO> select_AllList(Connection conn){
						Statement stmt = null;
						ResultSet rs = null;
						try{
									String sql = " select * from "
															+DBKeyword.Table_GuestBook
															+" order by "
															+DBKeyword.Column_Time
															+" desc ";
									stmt = conn.createStatement();
									rs = stmt.executeQuery(sql);
									if(rs.next()){
												ArrayList<MessageDTO> msgList = new ArrayList();
												msgList.add(makeMessage(rs));
												while(rs.next()){
															msgList.add(makeMessage(rs));
												}
												return msgList;
									}else{
												return null;
									}
						}
						catch(SQLException e){ 
									e.printStackTrace();
						}
						finally {
									DBUtil.close(stmt);
									DBUtil.close(rs);
						}
						return null;
			}
			public MessageDTO select_ById(Connection conn, int msgId){
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						try{
									String sql = " select * from "
															+DBKeyword.Table_GuestBook
															+" where "
															+DBKeyword.Column_Idx+" = ? ";
									try {
												pstmt = conn.prepareStatement(sql);
												pstmt.setInt(1, msgId);
												rs = pstmt.executeQuery();
												if(rs.next()){
															return makeMessage(rs);
												}else{
															return null;
												}
									} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
									}
						}
						finally {
									DBUtil.close(pstmt);
									DBUtil.close(rs);
						}
						return null;
			}
			public void update(Connection conn, int idx, String title, String content){
						PreparedStatement pstmt = null;
						try{
									String sql = " update "
															+DBKeyword.Table_GuestBook
															+" set "
															+DBKeyword.Column_Title
															+" = ? , "
															+DBKeyword.Column_Content
															+" = ? , "
															+DBKeyword.Column_Time
															+" = ? "
															+" where "
															+DBKeyword.Column_Idx
															+" = ? ";
									try {
												pstmt = conn.prepareStatement(sql);
												pstmt.setString(1, title);
												pstmt.setString(2, content);
												pstmt.setString(3, DBUtil.getTime());
												pstmt.setInt(4, idx);
												pstmt.executeUpdate();
									} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
									}
									
						}finally {
									DBUtil.close(pstmt);
						}
			}
			public void delete(Connection conn, int msgId) {
						PreparedStatement pstmt = null;
						try{
									String sql = " delete from "
															+DBKeyword.Table_GuestBook
															+" where "
															+DBKeyword.Column_Idx+" = ? ";
									try {
												pstmt = conn.prepareStatement(sql);
												pstmt.setInt(1, msgId);
												pstmt.executeUpdate();
									} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
									}
						}finally {
									DBUtil.close(pstmt);
						}
			}
			public MessageDTO makeMessage(ResultSet rs) throws SQLException{
						
						String title = rs.getString(DBKeyword.Column_Title);
						int id =rs.getInt(DBKeyword.Column_Idx);
						String user = rs.getString(DBKeyword.Column_User);
						String content = rs.getString(DBKeyword.Column_Content);
						String password = rs.getString(DBKeyword.Column_Password);
						String time = rs.getString(DBKeyword.Column_Time);
						MessageDTO msg = new MessageDTO(id,user,password,title,content,time);
						return msg;
			}
}
