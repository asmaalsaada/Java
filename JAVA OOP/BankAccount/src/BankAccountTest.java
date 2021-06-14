
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount asd = new BankAccount();
		System.out.println(asd.getAccountNumber());
		asd.depositMoney(100 , "savingBalance");
		System.out.println(asd.getSavingBalance());
		asd.depositMoney(5000 , "checkingBalance");
		System.out.println(asd.getCheckingBalance());
		System.out.println(asd.getTotalBalance());
		asd.withdrawMoney(20000, "savingBalance");
		System.out.println(asd.getSavingBalance());
		asd.depositMoney(5, "checkingBalance");
		System.out.println(asd.getCheckingBalance());		

	}

}
