
public class Ninja extends Human{
	public Ninja() {
	this.health=10;
}
	public Ninja(String name) {
		this.stealth=10;
		this.name=name;
	}
	public void steal(Human human) {
		human.setHealth(human.getHealth() - stealth);
		System.out.println("stealer");
	}
	public void runAway() {
		this.setHealth(this.getHealth()-10);
		System.out.println("YEET");
	}
}
