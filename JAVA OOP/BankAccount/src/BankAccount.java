import java.util.Random;
public class BankAccount {
	private String accountNumber;
	private double savingBalance;
	private double checkingBalance;
	
	static int numberOfAccounts=0;
	private double totalBalance;

	public BankAccount() {
	    this.savingBalance = 0;
		this.checkingBalance = 0;
		this.totalBalance = 0;
		this.accountNumber=randomNumber();
		numberOfAccounts++;
	}

	public double getSavingBalance() {
		return savingBalance;
	}



	public double getCheckingBalance() {
		return checkingBalance;
	}
	private static String randomNumber() {
		String num = "";
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i++) {
			num += r.nextInt(10);
			
		}
		return num;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void depositMoney(int money , String saving) {
		if (saving == "savingBalance") {
			savingBalance += money;
			
		}
		if (saving == "checkingBalance") {
			checkingBalance += money;
			
		}
		totalBalance = savingBalance + checkingBalance ;
		
	}
	public void withdrawMoney(int money , String saving) {
		if (saving == "savingBalance" && savingBalance - money >= 0) {
			savingBalance -= money;
			
		}
		else if (saving == "checkingBalance" && checkingBalance - money >= 0) {
			checkingBalance -= money;
			
		}
		else {
			System.out.println("Not enough money in your account");
		}
		totalBalance = savingBalance + checkingBalance ;
		
	}
	public double getTotalBalance() {
		return totalBalance;
	}


	

}
