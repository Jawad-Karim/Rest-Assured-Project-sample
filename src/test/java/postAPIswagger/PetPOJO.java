package postAPIswagger;

import java.util.List;

public class PetPOJO {

	private int id;
	private CategoryPOJO category;
	private String name;
	private List <Object> photoUrls;
	private List<TagsPOJO> tags;
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
	public List<Object> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<Object> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<TagsPOJO> getTags() {
		return tags;
	}
	public void setTags(List<TagsPOJO> tagList) {
		this.tags = tagList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
