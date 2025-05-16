import java.util.Scanner;
public class ATMWithdrawal{
	
	public static void main(String [] args){
		int startingBalance = 100000;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the amount to withdraw: ");
		int amountToWithdraw = scanner.nextInt();
		
		if(amountToWithdraw > startingBalance){
			System.out.println("Sorry! Insufficient Balance. Your balance is "+startingBalance);
			return;
		}
		if(amountToWithdraw < 0){
			System.out.println("You only can withdraw real money. Not debts.");
			return;
		}
		if(amountToWithdraw % 100 != 0){
			System.out.println("Sorry! You can only withdraw money that can divide 100.");
			return;
		}
		int remaining = amountToWithdraw;
		
		int notes2000 = remaining / 2000;
		remaining %= 2000;
		int notes500 = remaining / 500;
		remaining %= 500;
		int notes100 = remaining / 100;
		
		System.out.println("Collect your cash");
		if(notes2000 > 0){
			System.out.println("2000 x "+notes2000);
		}
		if(notes500 > 0){
			System.out.println("500 x "+notes500);
		}
		if(notes100 > 0){
			System.out.println("100 x "+notes100);
		}
		startingBalance -= amountToWithdraw;
	}
}
