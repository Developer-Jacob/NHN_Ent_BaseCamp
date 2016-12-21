package model;

//DB 테이블에 값 전소을 위한 클래스
public class MessageDTO {
			private int id;
			private String user;
			private String password;
			private String contents;
			private String time;
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
