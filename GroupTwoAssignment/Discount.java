public class Discount extends BaseModel{
	private String description;
	private double total;
	private User user;
	private ProductType percentageDiscount;

	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public double getTotal(){
		return total;
	}
	public void setTotal(double total){
		this.total = total;
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}
	public ProductType getPercentageDiscount(){
		return percentageDiscount;
	}
	public void setPercentageDiscount(ProductType percentageDiscount){
		this.percentageDiscount = percentageDiscount;
	}
}
