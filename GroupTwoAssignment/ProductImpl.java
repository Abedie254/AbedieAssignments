import java.util.*;

public class ProductImpl implements ProductI{
	private User user;
	private static ProductImpl instance = null;
	public static List<Product> availableProducts = new ArrayList<>();

	private ProductImpl(){}

	public static ProductImpl getInstance(){
		if(instance == null){
			instance = new ProductImpl();
		}
		return instance;
	}
	Scanner scanner = new Scanner(System.in);

	@Override
	public Product createProduct(Product product, ProductType productType){
		System.out.println("Select the type of product");
		for(Type type : Type.values()){
			System.out.println((type.ordinal() + 1)+". "+type.name());
		}
		int selectChoice = scanner.nextInt();
		scanner.nextLine();

		Type choiceSelected = Type.values()[selectChoice - 1];
		productType.setType(choiceSelected);

		System.out.println("Proccesing adding item for product "+choiceSelected);
		System.out.println("Enter name of the product");
		String name = scanner.nextLine();
		System.out.println("Set the price of one unit");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Number of units to add");
		int quantity = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the percentage discount on the items in this type");
		double percentageDiscount = scanner.nextDouble();
		scanner.nextLine();

		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setProductType(productType);
		productType.setPercentageDiscount(percentageDiscount);

		System.out.println("Item Added: "+product.getName()+", Price: "+product.getPrice());
		System.out.println("Type: "+product.getProductType().getType());
		try{
			applyDiscount(product);
		}catch(Exception e){
			System.out.println("Failed to apply discount: "+e.getMessage());
		}

		if(product != null)
			availableProducts.add(product);

		return product;
	}

	@Override
	public List<Product> getProducts(){	
		return availableProducts;
	}

	@Override
	public Product applyDiscount(Product product) throws Exception{
		ProductType productType = product.getProductType();

		Double discount = productType.getPercentageDiscount();
		if(productType == null || discount == null)
			throw new Exception("Discount or product type not defined");

		double discountPercent = productType.getPercentageDiscount();
		double price = product.getPrice();
		double total = price - (price * discountPercent / 100);

		product.setPrice(total);

		Discount disc = new Discount();
		disc.setDescription(disc.getDescription());
		disc.setTotal(disc.getTotal());
		disc.setUser(user);
		
		return product;
	}
}
