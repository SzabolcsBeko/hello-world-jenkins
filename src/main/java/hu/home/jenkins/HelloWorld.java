package hu.home.jenkins;

public class HelloWorld {

	private String message;
	
	public HelloWorld() {
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" " + message);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Jenkins");
		System.out.println(helloWorld.getMessage().trim());
		
	}
	
}
