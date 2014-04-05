import java.util.Scanner;
public class Ex2a {
	final static int MATH_FACTOR1=32;
	final static int MATH_FACTOR2=9;
	final static int MATH_FACTOR3=5;
	final static int MATH_FACTOR4=100;
	final static double MATH_FACTOR5=0.5;
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		//get the Temp from user
		System.out.println("Enter temperature and unit:");
		double TempNumber=scanner.nextDouble(); 
		String TempUnit=scanner.next();
		final String U="F";	
		//converting Temp
			if (TempUnit.equals(U)){
			double Con=((TempNumber-MATH_FACTOR1)/MATH_FACTOR2)*MATH_FACTOR3;
			Con= Math.floor(Con*MATH_FACTOR4 + MATH_FACTOR5)/MATH_FACTOR4;
			System.out.println("Temperature in Celsius: "+Con);
		}	
		else{
				double Con=((TempNumber*MATH_FACTOR2)/MATH_FACTOR3)+MATH_FACTOR1;
				Con= Math.floor(Con*MATH_FACTOR4 + MATH_FACTOR5)/MATH_FACTOR4;
				System.out.println("Temperature in Fahrenheit: "+Con);	
		}				
	}
}
