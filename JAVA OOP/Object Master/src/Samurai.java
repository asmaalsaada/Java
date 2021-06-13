
public class Samurai extends Human {
	static int numberOfSamurai = 0;
	public Samurai() {
	}
	public  Samurai(String name) {
		this.health = 200;
		this.name = name;
		numberOfSamurai +=1;
	}
	public int howMany() {
		return numberOfSamurai;
	}
	public void medidate(Human human) {
	this.setHealth(getHealth() + this.getHealth()/2);
}
}
