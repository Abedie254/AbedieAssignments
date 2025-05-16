import java.util.Scanner;

public class TrainBooking{
	static boolean [] seats = new boolean[10];
	
	public static boolean isSeatAvailable(){
		for(boolean seat:seats){
			if(!seat) return true;
		}
	return false;
	}
	
	public static void viewAvailableSeats(){
		System.out.println("Available Seats");
		for(int i = 0;i < seats.length;i ++){
			String status = seats[i]? "Booked" : "Available";
			System.out.println("Seat "+(i+1)+ " is "+status);
			
		}
	}
	
	public static void bookTicket(){
		if(!isSeatAvailable()){
			System.out.println("Train is full. Please wait for the next one.");
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter your name: ");
		String name = scanner.nextLine();
		
		System.out.print("\nEnter the seat number to book: ");
		int seatNumber = scanner.nextInt();
		
		try{
			if(seatNumber < 0 || seatNumber > 10){
				System.out.println("Seat range from 1 to 10.");
				return;
			}
			if(seats[seatNumber - 1]){
				System.out.println("Sorry! Seat already booked. Please try a different one.");
			}
			else{
				seats[seatNumber - 1] = true;
				System.out.println("Seat "+seatNumber+ " has been successfully booked by "+name);
			}
				
		}catch(Exception e){
			System.out.println("Invalid Details. Please provide valid ones.");
		}
	}
	
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("   Train Ticket Booking System   ");
		System.out.println("        MENU        ");
		System.out.println("1. Book Ticket");
		System.out.println("2. View Available Seats");
		System.out.println("3. Exit");
		
		System.out.println("Enter your choice: ");
		
		try{
			int choice = scanner.nextInt();
			switch(choice){
				case 1:
					bookTicket();
					break;
				case 2:
					viewAvailableSeats();
					break;
				case 3:
					System.out.println("Goodbye");
					return;
				default:
					System.out.println("Please enter a correct choice.");
			}
		}catch(Exception e){
			System.out.println("Invalid Details. Please provide a better choice.");
		}
	}
}
