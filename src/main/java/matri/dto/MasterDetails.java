package matri.dto;

public class MasterDetails {
	private int id;
	private String category;
	private String value;
	private int relatedId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(int relatedId) {
		this.relatedId = relatedId;
	}
	@Override
	public String toString() {
		return "MasterDetails [id=" + id + ", category=" + category + ", value=" + value + ", relatedId=" + relatedId
				+ "]";
	}
}
