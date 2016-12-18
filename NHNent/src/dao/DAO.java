package dao;

import java.sql.PreparedStatement;

//DB의 CRUD기능을 위한 클래스
public class DAO {
			private DAO() {}
			private static DAO dao;
			
			//싱글톤을 위한 함수
			public DAO getInstancd(){
						if(dao==null){
									dao = new DAO();
						}
						return dao;
			}
			
			public void insert(){
						PreparedStatement pstmt = null;
			}
			public void select(){
						
			}
			public void delete(){
						
			}
}
