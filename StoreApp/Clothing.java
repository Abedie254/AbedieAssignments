public class Clothing extends Product{
	protected int size;
	protected double discount;

	public Clothing(String name, double cost, int size){
		this.name = name;
		this.cost = cost;
		this.size = size;
	}

	public double calculateDiscount(double discount){
		this.discount = discount;
		return discount = 0.1 * cost;
	}

	@Override
	public void displayInfo(){
		super.displayInfo();
		System.out.println("Size: "+size);
		System.out.println("Discount: "+calculateDiscount(discount));
		System.out.println("Selling Price: "+(cost - calculateDiscount(discount)));
	}
}
