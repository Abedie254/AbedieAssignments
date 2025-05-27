public class ProductType extends BaseModel{
	public String name;
	public String description;
	public Type type;
	public double percentageDiscount;

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public Type getType(){
		return type;
	}
	public void setType(Type type){
		this.type = type;
	}
	public double getPercentageDiscount(){
		return percentageDiscount;
	}
	public void setPercentageDiscount(double percentageDiscount){
		this.percentageDiscount = percentageDiscount;
	}
}
