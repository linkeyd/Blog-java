package Lin.blog.web.bean;

public class Carousel {
					private String id;
					private String img;
					public String getId() {
						return id;
					}
					public void setId(String id) {
						this.id = id;
					}
					public String getImg() {
						return img;
					}
					public void setImg(String img) {
						this.img = img;
					}
					public Carousel(String id, String img) {
						super();
						this.id = id;
						this.img = img;
					}
					public Carousel() {
						super();
					}
					
}
