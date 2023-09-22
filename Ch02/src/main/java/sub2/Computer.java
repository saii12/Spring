package sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {

	private CPU cpu;
	private RAM ram;
	
	// DI - Field Inject
	@Autowired
	private HDD hdd;
	
	// DI - Constructor Inject
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	
	// ID - Setter Inject / setter : 캡슐화 되 있는거 간접적으로 
	@Autowired
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
	
	public void show() {
		cpu.show(); // cpu, ram, hdd 초기화 안해서 null임
		ram.show();
		hdd.show();
		
	}
}
