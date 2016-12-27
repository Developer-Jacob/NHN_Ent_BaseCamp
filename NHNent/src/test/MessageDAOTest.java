package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import db.ConnectionProvider;
import db.MessageDAO;
import model.MessageDTO;

public class MessageDAOTest {
			int idx=0;
			@Test
			public void testGetInstance() {
						MessageDAO dao1 = MessageDAO.getInstance();
						MessageDAO dao2 = MessageDAO.getInstance();
						assertSame(dao1, dao2);
			}
			
			@Test
			public void testInsert() {
						MessageDAO dao = MessageDAO.getInstance();
						Connection conn = ConnectionProvider.getConnection();
						MessageDTO msg = new MessageDTO("testUser@nhnent.com", "test", "testTitle", "testContent");
						assertEquals(1, dao.insert(conn, msg));
						ConnectionProvider.close(conn);
			}
			@Test
			public void testselect_AllCount(){
						MessageDAO dao = MessageDAO.getInstance();
						Connection conn = ConnectionProvider.getConnection();
						int count = dao.select_AllCount(conn);
						if(count==0){
									fail();
						}
						ConnectionProvider.close(conn);
			}
			@Test
			public void testSelect_AllList() {
						MessageDAO dao = MessageDAO.getInstance();
						Connection conn = ConnectionProvider.getConnection();
						ArrayList<MessageDTO> msgList = dao.select_AllList(conn);
						idx = msgList.get(0).getIdx();
						assertNotNull(msgList);
						ConnectionProvider.close(conn);
			}
			
			
			
			@Test
			public void testUpdate() {
						MessageDAO dao = MessageDAO.getInstance();
						Connection conn = ConnectionProvider.getConnection();
//						assertEquals(1, dao.update(conn, msg));
						ConnectionProvider.close(conn);
			}

			@Test
			public void testDelete() {
						MessageDAO dao = MessageDAO.getInstance();
						Connection conn = ConnectionProvider.getConnection();
						MessageDTO msg = new MessageDTO("testUser@nhnent.com", "test", "testTitle", "testContent");
//						assertEquals(1, dao.delete(conn, msgId));
						ConnectionProvider.close(conn);
			}
			
			

			@Test
			public void testSelect_ById() {
			}

			@Test
			public void testMakeMessage() {
			}

}
