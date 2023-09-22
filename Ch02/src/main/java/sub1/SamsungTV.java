package sub1;

public class SamsungTV {

	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn...");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV powerOff...");
	}
	
	public void soundUp() {
		spk.soundUp(); // null 참조 에러발생
	}
	
	public void soundDown() {
		spk.soundDown();
	}
}
