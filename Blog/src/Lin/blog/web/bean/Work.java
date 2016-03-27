package Lin.blog.web.bean;

public class Work {
					private String id;
					private String title;
					private String url;
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
					public String getUrl() {
						return url;
					}
					public void setUrl(String url) {
						this.url = url;
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
					public Work(String id, String title, String url,
							String img, String contenct) {
						super();
						this.id = id;
						this.title = title;
						this.url = url;
						this.img = img;
						this.contenct = contenct;
					}
					public Work() {
						super();
					}
					
					
}
