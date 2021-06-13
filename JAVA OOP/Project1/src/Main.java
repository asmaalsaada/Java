public class Main {
	public static void main (String[] args) {
	Project1 newP = new Project1();
	Project1 newProAndName = new Project1("nth");
	Project1 newProAndNameAndString = new Project1("nth","nth");
	System.out.println(newP.elevatorPitch());
//	newProAndName.setName("y2");
//	String nameopo1 = newP.getName();
//	System.out.println(nameopo1);
	System.out.println(newProAndName.elevatorPitch());
	System.out.println(newProAndNameAndString.elevatorPitch());
	}
}

