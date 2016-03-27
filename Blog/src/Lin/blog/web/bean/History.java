package Lin.blog.web.bean;

public class History {
					private String id;
					private String title;
					private String time;
					private String contenct;
					private String img;
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
					public String getContenct() {
						return contenct;
					}
					public void setContenct(String contenct) {
						this.contenct = contenct;
					}
					public String getImg() {
						return img;
					}
					public void setImg(String img) {
						this.img = img;
					}
					public History(String id, String title, String time,
							String contenct, String img) {
						super();
						this.id = id;
						this.title = title;
						this.time = time;
						this.contenct = contenct;
						this.img = img;
					}
					public History() {
						super();
					}
					
}
