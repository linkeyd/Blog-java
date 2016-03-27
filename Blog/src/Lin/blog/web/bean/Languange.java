package Lin.blog.web.bean;

public class Languange {
					private String id;
					private String title;
					private String contenct;
					private String time;
					private String img;
					private String pro;
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
					public String getContenct() {
						return contenct;
					}
					public void setContenct(String contenct) {
						this.contenct = contenct;
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
					public String getPro() {
						return pro;
					}
					public void setPro(String pro) {
						this.pro = pro;
					}
					public Languange(String id, String title, String contenct,
							String time, String img, String pro) {
						super();
						this.id = id;
						this.title = title;
						this.contenct = contenct;
						this.time = time;
						this.img = img;
						this.pro = pro;
					}
					public Languange() {
						super();
					}
					
}
