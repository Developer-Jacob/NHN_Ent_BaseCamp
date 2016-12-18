package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DB의 CRUD기능을 위한 클래스
public class DAO {
			private static DAO dao;
			private Connection conn = null;
			private DAO() {
						conn = DriverManager.getConnection(url)
			}
			
			//싱글톤을 위한 함수
			public DAO getInstancd(){
						if(dao==null){
									dao = new DAO();
						}
						return dao;
			}
			
			public void insert() throws SQLException{
						PreparedStatement pstmt = null;
						try{
									String sql = "insert into geustbook_table values(?,?,?)";
									pstmt = conn.prepareStatement(sql);
									pstmt.setString(1, x);
						}finally {
									
						}
			}
			public void select(){
						
			}
			public void delete(){
						
			}
}
