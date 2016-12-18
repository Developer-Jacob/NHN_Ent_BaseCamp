package model;

//DB 테이블에 값 전소을 위한 클래스
public class Message {
			private int id;
			private String name;
			private String password;
			private String content;
			
			public int getId() {
						return id;
			}
			public void setId(int id) {
						this.id = id;
			}
			public String getName() {
						return name;
			}
			public void setName(String name) {
						this.name = name;
			}
			public String getPassword() {
						return password;
			}
			public void setPassword(String password) {
						this.password = password;
			}
			public String getContent() {
						return content;
			}
			public void setContent(String content) {
						this.content = content;
			}
			
}
