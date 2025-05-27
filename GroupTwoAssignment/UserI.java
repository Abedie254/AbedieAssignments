import java.util.*;

public interface UserI{
	User createUser();
	Product purchaseProduct(Product product, User user);
	User login(String name, String password);
}
