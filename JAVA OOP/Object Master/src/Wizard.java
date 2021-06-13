
public class Wizard extends Human{
	public Wizard() {
		this.health = 50;
		this.intelleginece = 8;
}
	public Wizard(String name){
		this.health = 50;
		this.intelleginece = 8;
		this.name = name;
}
	public void heal(Human human) {
		human.setHealth(human.getHealth()-this.intelleginece);
		System.out.println("(" + human.getName() +  "had their health increased " + this.intelleginece + ".)" );
	} 
	public void fireball(Human human) {
		human.setHealth(human.getHealth()-(this.intelleginece*3));
		System.out.println("OUCH! ");
		System.out.println("(" + human.getName() +  "damageded " + this.intelleginece*3 + ".)" );
	}
}

