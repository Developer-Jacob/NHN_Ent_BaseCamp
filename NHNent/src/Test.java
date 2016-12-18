import java.sql.SQLException;

import db.DAO;
import model.Message;

public class Test {
public static void main(String[] args) {
			Message msg = new Message();
			msg.setUser("ldh881113@naver.com");
			msg.setContents("abcdefg");
			msg.setPassword("password");
			DAO dao = DAO.getInstance();
			try {
						dao.insert(null,msg);
			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			
}
}
