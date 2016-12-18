package model;

//DB 테이블에 값 전소을 위한 클래스
public class Message {
			private String user;
			private String password;
			private String contents;
			public String getUser() {
						return user;
			}
			public void setUser(String user) {
						this.user = user;
			}
			public String getPassword() {
						return password;
			}
			public void setPassword(String password) {
						this.password = password;
			}
			public String getContents() {
						return contents;
			}
			public void setContents(String contents) {
						this.contents = contents;
			}
			
}
