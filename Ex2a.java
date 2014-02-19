import java.util.Scanner;
public class Ex2a {
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);		
		System.out.println("Enter temperature and unit:");
		double TempNumber=scanner.nextDouble(); 
		String TempUnit=scanner.next();
		//System.out.println(TempNumber);
		//System.out.println(TempUnit);
		final String U="F";		
			if (TempUnit.equals(U)){
			double Con=((TempNumber-32)/9)*5;
			Con= Math.floor(Con*100 + 0.5)/100;
			System.out.println("Temperature in Celsius: "+Con);
		}	
		else{
				double Con=((TempNumber*9)/5)+32;
				Con= Math.floor(Con*100 + 0.5)/100;
				System.out.println("Temperature in Fahrenheit: "+Con);	
		}
		
		
	}

}
