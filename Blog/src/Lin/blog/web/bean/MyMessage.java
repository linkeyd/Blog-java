package Lin.blog.web.bean;

public class MyMessage {
					private String id;
					private String name;
					private String phone;
					private String email;

					private String message;
					public String getId() {
						return id;
					}
					public void setId(String id) {
						this.id = id;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public String getPhone() {
						return phone;
					}
					public void setPhone(String phone) {
						this.phone = phone;
					}
					public String getMessage() {
						return message;
					}
					public void setMessage(String message) {
						this.message = message;
					}
					public String getEmail() {
						return email;
					}
					public void setEmail(String email) {
						this.email = email;
					}
					
					public MyMessage(String id, String name, String phone,
							String email, String message) {
						super();
						this.id = id;
						this.name = name;
						this.phone = phone;
						this.email = email;
						this.message = message;
					}
					public MyMessage() {
						super();
					}
					
}
