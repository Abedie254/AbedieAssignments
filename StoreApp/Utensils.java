public class Utensils extends Product{
	protected String placeOfMake;
	protected double discount;

	public Utensils(String name, double cost, String placeOfMake){
		this.name = name;
		this.cost = cost;
		this.placeOfMake = placeOfMake;
	}

	public double calculateDiscount(double discount){
		this.discount = discount;
		return discount = 0.1 * cost;
	}

	@Override
	public void displayInfo(){
		super.displayInfo();
		System.out.println("Made in "+placeOfMake);
		System.out.println("Discount: "+calculateDiscount(discount));
		System.out.println("Selling Price: "+(cost - calculateDiscount(discount)));
	}
}
