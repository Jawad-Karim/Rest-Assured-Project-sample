package swaggerNewPet;

import java.util.List;

public class PostSwaggerNewPetPOJO {
	
	private int id;
	private CategoryPOJO category;
	private String name;
	private List<String> photoUrls;
	private List <TagsPOJO> tags;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategoryPOJO getCategory() {
		return category;
	}
	public void setCategory(CategoryPOJO category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<TagsPOJO> getTags() {
		return tags;
	}
	public void setTags(List<TagsPOJO> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PostSwaggerNewPetPOJO [id=" + this.id + ", category=" + this.category + ", name=" + this.name + ", photoUrls="
				+ this.photoUrls + ", tags=" + this.tags + ", status=" + this.status + "]";
	}
	

}
