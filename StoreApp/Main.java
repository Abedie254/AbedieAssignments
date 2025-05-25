import java.util.*;

public class Main{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		Map<Integer, ArrayList<Product>> productDetails = new HashMap<>();
		while(true){
			System.out.println("Online Catalogue System");
			System.out.println("    MENU    ");
			System.out.println("1. Electronics");
			System.out.println("2. Clothing");
			System.out.println("3. Utensils");
			System.out.println("4. Exit");
		
			System.out.println("ENTER THE PRODUCT TO ADD DETAILS TO: ");
			try{
				int choice = scanner.nextInt();
				scanner.nextLine();
		
				switch(choice){
					case 1:
						System.out.println("Enter the name of the electronic: ");
						String electronicsName = scanner.nextLine();
						System.out.println("Enter the brand of the electronic: ");
						String electronicsBrand = scanner.nextLine();
						System.out.println("Enter the cost of the electronic: ");
						double electronicsCost = scanner.nextDouble();
						scanner.nextLine();
				
						ArrayList<Product> electronicsProduct = new ArrayList<>();
						Electronics electronicItem = new Electronics(electronicsName, electronicsCost, electronicsBrand);
						electronicsProduct.add(electronicItem);
				
						productDetails.put(1, electronicsProduct);
						break;
				
					case 2:
						System.out.println("Enter the cloth name: ");
						String clothingName = scanner.nextLine();
						System.out.println("Enter the Clothing cost: ");
						double clothingCost = scanner.nextDouble();
						System.out.println("Enter the clothing size: ");
						int clothingSize = scanner.nextInt();
						scanner.nextLine();
				
						ArrayList<Product> clothingProduct = new ArrayList<>();
						Clothing clothingItem = new Clothing(clothingName, clothingCost, clothingSize);
						clothingProduct.add(clothingItem);
				
						productDetails.put(2, clothingProduct);
						break;
				
					case 3:
						System.out.println("Enter the Utensil's name: ");
						String utensilsName = scanner.nextLine();
						System.out.println("Enter the cost of the utensil: ");
						double utensilsCost = scanner.nextDouble();
						scanner.nextLine();
						System.out.println("Enter the Place the Utensil was made: ");
						String utensilsPlaceOfMake = scanner.nextLine();
				
						ArrayList<Product> utensilsProduct = new ArrayList<>();
						Utensils utensilItem = new Utensils(utensilsName, utensilsCost, utensilsPlaceOfMake);
						utensilsProduct.add(utensilItem);
				
						productDetails.put(3, utensilsProduct);
						break;
						
					case 4:
						System.out.println("Good Bye");
						return;
						
					default:
						System.out.println("Enter a number from 1 to 4");
						}
					}catch(Exception e){
						System.out.println("Error! Invalid Choice! Please try again.");
						scanner.nextLine();
					}
				for(Map.Entry<Integer, ArrayList<Product>> entry : productDetails.entrySet()){
					System.out.println(""+entry.getKey());
					
					for(Product product : entry.getValue()){
						product.displayInfo();
						product.calculateDiscount();
					}
				}
			}
	}
}
