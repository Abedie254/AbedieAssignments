import java.util.*;

public class UserImpl implements UserI{
	private static UserImpl instance = null;
	private ProductImpl productService;
	public static List<Product> availableProducts = new ArrayList<>();
	public static Map<String, User> userMap = new HashMap<>();

	private UserImpl(){}
	public static UserImpl getInstance(){
		if(instance == null){
			instance = new UserImpl();
		}
		return instance;
	}

	public UserImpl(ProductImpl productService){
		this.productService = productService;
	}
	Scanner scanner = new Scanner(System.in);


	@Override
	public User createUser(){
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		System.out.println("Enter your id number");
		long idNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter your email");
		String email = scanner.nextLine();
		System.out.println("Set your password");
		String password = scanner.nextLine();
		System.out.println("Confirm password");
		String pass = scanner.nextLine();

		if(password.equals(pass))
			System.out.println("Register Successful");

		System.out.println("Name: "+name);
		System.out.println("Id Number: "+idNumber);
		System.out.println("Email: "+email);

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setIdNumber(idNumber);

		userMap.put(user.getName(), user);
		return user;
	}

	@Override
	public User login(String name, String password){
		System.out.println("Enter your username");
		String userName = scanner.nextLine();
		System.out.println("Enter your password");
		String pass = scanner.nextLine();

		if(userMap.containsKey(userName)){
			User user = userMap.get(userName);
			if(user.getPassword().equals(pass)){
				System.out.println("Welcome "+user.getName());
				return user;
			}
			else
				System.out.println("Wrong Password!");
		}else{
			System.out.println("User Not Found!");
		}
		return null;

	}

	@Override
	public Product purchaseProduct(Product product, User user){
		System.out.println("Enter the name of the product to purchase");
		String productName = scanner.nextLine();
		System.out.println("Enter the units of product to buy");
		int ProductQantity = scanner.nextInt();
		scanner.nextLine();

		Product foundProduct = null;
		for(Product prod : ProductImpl.availableProducts){
			if(prod.getName().equalsIgnoreCase(productName)){
				foundProduct = prod;
				if(prod.getQuantity() >= ProductQantity){
					prod.setQuantity(prod.getQuantity() - ProductQantity);
				}else{
					System.out.println("Insufficient Stock. Available: "+prod.getQuantity());
					return null;
				}
				break;
			}
		}
		if(foundProduct == null){
			System.out.println("Product not found");
			return null;
		}
		ProductType productType = new ProductType();
		product.setName(productName);
		product.setQuantity(ProductQantity);
		product.setProductType(productType);
		
	
		System.out.println("Name: "+productName);
		System.out.println("Quantity: "+ProductQantity);

		return product;
	}

	public void displayUsers(){
		if(userMap.isEmpty()){
			System.out.println("No available users");
		}else{
			System.out.println("Available users");
			for(Map.Entry<String, User> entry : userMap.entrySet()){
				User user = entry.getValue();
				System.out.println("Name: "+user.getName());
				System.out.println("Id Number: "+user.getIdNumber());
				System.out.println("Email: "+user.getEmail());
			}
		}
	}
}
