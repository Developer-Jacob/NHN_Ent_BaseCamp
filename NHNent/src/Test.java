import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import db.MessageDAO;
import model.MessageDTO;

public class Test {
public static void main(String[] args) {
			MessageDTO msg = new MessageDTO();
			msg.setUser("ldh881113@naver.com");
			msg.setContents("abcdefg");
			msg.setPassword("password");
			MessageDAO dao = MessageDAO.getInstance();
//			try {
//						Connection conn = ConnectionProvider.getConnection();
//						dao.insert(conn,msg);
//			} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//			}
			
}
}
