package Lin.blog.web.bean;

public class Rest {
					private String id;
					private String title;
					private String time;
					private String img;
					private String contenct;
					public String getId() {
						return id;
					}
					public void setId(String id) {
						this.id = id;
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
					public String getImg() {
						return img;
					}
					public void setImg(String img) {
						this.img = img;
					}
					public String getContenct() {
						return contenct;
					}
					public void setContenct(String contenct) {
						this.contenct = contenct;
					}
					public Rest(String id, String title, String time,
							String img, String contenct) {
						super();
						this.id = id;
						this.title = title;
						this.time = time;
						this.img = img;
						this.contenct = contenct;
					}
					public Rest() {
						super();
					}
					
					
}
