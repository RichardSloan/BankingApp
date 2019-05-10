import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Joe Blogs","JB001");
		obj.showCustomerDetails();
		obj.showMenu();
	}

}

class BankAccount 
{
	int balance;
	int previousTranscation;
	String customerName;
	String customerId;

	BankAccount(String cName, String cId)
	{
		customerName = cName;
		customerId = cId;
	}

	void deposit(int amount) 
	{		
		if(amount > 0 && amount <= 10000000) 
		{
			balance = balance + amount;
			previousTranscation = amount;
		} else
		{
			System.out.println("You can only deposit between £1-£10,000,001");
		}
	}

	void withdraw(int amount) 
	{		
		if(amount > 0 && amount <= 10000000) 
		{
			balance = balance - amount;
			previousTranscation = -amount;
		} else
		{
			System.out.println("You can only withdraw between £1-£10,000,001");	
		}
	}

	void getPreviousTranscation()
	{
		if(previousTranscation > 0) 
		{
			System.out.println("You Deposited: £" + previousTranscation);
		} 
		else if(previousTranscation < 0) 
		{
			System.out.println("You Withdrew: £" + Math.abs(previousTranscation));			
		}
		else 
		{
			System.out.println("No Transcation Occured");
		}
	}


	void showCustomerDetails()
	{
		System.out.println("==================================================================");
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is :" + customerId);
		System.out.println("==================================================================");
	}

	void showMenu()
	{

		char option='\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("1: Check Balance");
		System.out.println("2: Deposit");
		System.out.println("3: Withdraw");
		System.out.println("4: Previous Transcation");
		System.out.println("5: Exit");

		do
		{
			System.out.println("==================================================================");
			System.out.println("Enter An Option:");
			System.out.println("==================================================================");
			option = scanner.next().charAt(0);

			switch(option)
			{

			case '1':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				System.out.println("Balance = £" + balance);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				showMenu();
				break;

			case '2':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				System.out.println("Enter An Amount To Deposit: £ ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				int depositAmount;
				int depositCounter = 1;

				do {
					try {
						Scanner depositInput = new Scanner(System.in);
						depositAmount = depositInput.nextInt();
						deposit(depositAmount);
						depositCounter = 2;

					} catch (Exception e)
					{
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("That is not a positive number! Please Try Again");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					}
				}
				while(depositCounter == 1);
				showMenu();
				break;	

			case '3':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				System.out.println("Enter An Amount To Withdraw: £");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				int withdrawAmount; 
				int withdrawCounter = 1;

				do {
					try
					{
						Scanner withdrawInput = new Scanner(System.in);
						withdrawAmount = withdrawInput.nextInt();
						withdraw(withdrawAmount);
						withdrawCounter = 2;			
					} catch (Exception e)
					{
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("That is not a positive number! Please Try Again");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					}

				}
				while(withdrawCounter == 1);

				showMenu();
				break;	

			case '4':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				System.out.println("Previous Transaction "); getPreviousTranscation();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				showMenu();
				break;

			case '5':
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				break;	

			default:
				System.out.println("Invalid Option!");
				break;

			}

		}while(option != '5');

		System.out.println("Thank You! See You Again!");
		System.exit(0);

	}
}


