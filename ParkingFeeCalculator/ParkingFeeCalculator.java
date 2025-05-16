import java.util.Scanner;

class InputDurationException extends Exception{
	public InputDurationException(String message){
		super(message);
	}
}

public class ParkingFeeCalculator{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter packing hours: ");
		int hours = scanner.nextInt();
		
		try{
			int fee = 0;
			if(hours < 0)
				throw new InputDurationException("Hours can only be positive.");
				
			if(hours <= 2)
				fee = 0;
			else if(hours <=5)
				fee = (hours - 2) * 10;
			else
				fee = ((3 * 10) + (hours - 5) * 15);
			
			System.out.println("Fees: Rs. "+fee);
		}catch(InputDurationException e){
			System.out.println("Error! "+e.getMessage()); 
		}
	}
}
