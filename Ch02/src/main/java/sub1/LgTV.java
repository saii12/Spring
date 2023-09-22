package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV {

	@Autowired // spk에 자동주입해주는 annotation
	private Speaker spk; // spk 객체 선언만 하고 생성은 안함 -> null임
	
	public void powerOn() {
		System.out.println("LgTv powerOn...");
	}
	
	public void powerOff() {
		System.out.println("LgTv powerOff...");
	}
	
	public void soundUp() {
		spk.soundUp(); // null 참조 에러발생
	}
	
	public void soundDown() {
		spk.soundDown();
	}
}
