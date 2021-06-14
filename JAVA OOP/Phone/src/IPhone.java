public class IPhone extends Phone implements Ringable {
	private
	String versionNumber ;
	int batteryPercentage;
	String carrier;
	String ringTone;
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    @Override
    public String ring() {
    	return "Your phone is ringing";     
    }
    @Override
    public String unlock() {
        return "slide to unlock";
    }
    @Override
    public void displayInfo() {
    	System.out.println(versionNumber+ " " + batteryPercentage+ " " + carrier+ " " + ringTone);
       }
}
