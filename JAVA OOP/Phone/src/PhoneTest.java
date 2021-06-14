
public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPhone ten = new IPhone("Xs", 0, "Jawal","default");
		Galaxy a70 = new Galaxy("A70", 70, "golan", "Soviet National Anthem");
		ten.displayInfo();
		System.out.println(ten.ring());
		System.out.println(ten.unlock());
		a70.displayInfo();
		System.out.println(a70.ring());
		System.out.println(a70.unlock());

	}

}
