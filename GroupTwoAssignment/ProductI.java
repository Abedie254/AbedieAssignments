import java.util.*;

public interface ProductI{
	Product createProduct(Product product, ProductType productType);
	List<Product> getProducts();
	Product applyDiscount(Product product) throws Exception;
}
