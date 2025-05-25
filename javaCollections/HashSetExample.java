
import java.util.*;

public class HashSetExample{
	public static void main(String [] args){
		ArrayList<Integer> duplicateNumbersList = new ArrayList<>(List.of(1,2,3,2,2,4,5,6,4,7,4,8,9));
		
		Set<Integer> unique = getUniqueNumbers(duplicateNumbersList);
		System.out.println("Unique Numbers: "+unique);
	}
	
	public static Set<Integer> getUniqueNumbers(ArrayList<Integer> uniqueNumbersList){
		return new HashSet<>(uniqueNumbersList);
	}
}
