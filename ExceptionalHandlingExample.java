package codes;

public class ExceptionalHandlingExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
			int a = 5;
			int b = 0;
			int c;
			System.out.println(c=a/b);
		}catch(Exception e){
			System.out.println(e);
		}finally {
			System.out.println("Final block");
		}
	}

}
