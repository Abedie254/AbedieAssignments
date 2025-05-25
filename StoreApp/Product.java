public class Product implements Displayable{
	protected String name;
	protected double cost;

	public double calculateDiscount(){
		return 0;
	}

	@Override
	public void displayInfo(){
		System.out.println("Product Name: "+name);
		System.out.println("Product Cost: "+cost);
	}
}
