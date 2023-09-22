package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		if(ctx != null) {
			
			// hello, welcome, greeting 객체 생성
			Hello hello = (Hello) ctx.getBean("hello");
			Welcome welcome = (Welcome) ctx.getBean("welcome");
			Greeting greeting = (Greeting) ctx.getBean("greeting");
			
			// show 메서드 실행
			hello.show();
			welcome.show();
			greeting.show();
			
		}
		
		
	}
}
