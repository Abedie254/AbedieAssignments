public class Electronics extends Product{
	protected String brand;
	protected double discount;

	public Electronics(String name, double cost, String brand){
		this.name = name;
		this.cost = cost;
		this.brand = brand;
	}

	public double calculateDiscount(double discount){
		this.discount = discount;
		return discount = 0.1 * cost;
	}

	@Override
	public void displayInfo(){
		super.displayInfo();
		System.out.println("Brand: "+brand);
		System.out.println("Discount: "+calculateDiscount(discount));
		System.out.println("Selling Cost: "+(cost - calculateDiscount(discount)));
	}
}

