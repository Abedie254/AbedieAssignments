import java.util.*;

public class Main{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		User currentUser = null;
		while(true){
			System.out.println("  Online Catalogue Management System  ");
			System.out.println("    MENU    ");
			System.out.println("1. ADD USER");
			System.out.println("2. USER LOGIN");
			System.out.println("3. VIEW USERS");
			System.out.println("4. CHECK AVAILABLE PRODUCTS");
			System.out.println("5. ADD PRODUCT");
			System.out.println("6. PURCHASE PRODUCT");
			System.out.println("7. EXIT");

			System.out.println("Enter your choice");
			try{
				int choice = scanner.nextInt();
				ProductImpl productService = ProductImpl.getInstance();
				UserImpl userService = UserImpl.getInstance();

				switch(choice){
					case 1:
						userService.createUser();
						break;
					case 2:
						currentUser = userService.login(null, null);
						break;
					case 3:
						userService.displayUsers();
						break;
					case 4:
						if(currentUser != null){
							List<Product> products = productService.getProducts();
							if(products.isEmpty()){
								System.out.println("No Available producs");
							}else{
								for(Product p : products){
									System.out.println("Name: "+p.getName());
									System.out.println("Quantity: "+p.getQuantity());
									System.out.println("Product Type: "+p.getProductType().getType());
								}
							}
						}else{
							System.out.println("Please Login.");
						}
						break;
					case 5:
						if(currentUser != null){
							Product product = new Product();
							ProductType productType = new ProductType();
							productService.createProduct(product, productType);
							break;
						}else{
							System.out.println("Please Login");
						}
						break;

					case 6:
						if(currentUser != null){
							Product prod = new Product();
							User user = new User();
							userService.purchaseProduct(prod, user);
							
						}else{
							System.out.println("Please Login");
						}
						break;
					case 7:
						System.out.println("GoodBye");
						return;
					default:
						System.out.println("Select an available choice");
				}

			}catch(Exception e){
				System.out.println("Error!"+e.getMessage());
			}
		}
	}
}
