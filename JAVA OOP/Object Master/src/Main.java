public class Main {
public static void main(String[] args) {
	Human homo1 = new Human("name1");
//	Human homo2 = new Human("name2");
	Human homo3 = new Human("name3");
	System.out.println(homo3.getHealth());
	homo1.attack(homo3);
	System.out.println(homo3.getHealth());
	
	Wizard wz = new Wizard("Alaa");
	System.out.println(homo3.getHealth());
	wz.heal(homo3);
	System.out.println(homo3.getHealth());
	
	Samurai sm1 = new Samurai();
	System.out.println(sm1.getHealth());
	sm1.medidate(homo3);
	System.out.println(sm1.getHealth());
	sm1.medidate(homo3);
	sm1.howMany();
	Ninja ninja1 = new Ninja("ninja1");
	System.out.println(homo1.getHealth());
	ninja1.steal(homo1);
	System.out.println(homo1.getHealth());
	ninja1.runAway();
	System.out.println(ninja1.getHealth());
	}
}
