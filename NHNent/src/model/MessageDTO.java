package model;

//DB 테이블에 값 전소을 위한 클래스
public class MessageDTO {
			private int id;
			private String user;
			private String password;
			private String title;
			private String contents;
			private String time;
			
			
			public MessageDTO(String user, String password, String title, String contents) {
						this.user = user;
						this.password = password;
						this.title = title;
						this.contents = contents;
			}
			

			public MessageDTO(int id, String user, String password, String title, String contents, String time) {
						super();
						this.id = id;
						this.user = user;
						this.password = password;
						this.title = title;
						this.contents = contents;
						this.time = time;
			}


			public String getTitle() {
						return title;
			}

			public void setTitle(String title) {
						this.title = title;
			}

			public String getTime() {
						return time;
			}

			public void setTime(String time) {
						this.time = time;
			}

			public int getId() {
						return id;
			}

			public void setId(int id) {
						this.id = id;
			}

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
