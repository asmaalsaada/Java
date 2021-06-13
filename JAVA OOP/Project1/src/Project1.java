
public class Project1 {
	public String name,desc;
  public Project1(){ 
	  
  }
  public Project1(String name) {
	  this.name = "this is name"; //set default value 
  }
  public Project1(String name, String desc) {
	  this.name = "name";
	  this.desc="this is desc"; //set default value for desc and name
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name= name;
  }
  public String getDesc() {
	  return desc;
  }
  public void setDesc(String desc) {
	  this.desc= desc;
  }
  public String elevatorPitch(){
	   return (this.name + " : "  + this.desc);
  }
}
