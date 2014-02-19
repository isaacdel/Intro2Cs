import java.util.Scanner;
public class Ex2b {
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("This program solves a system of 2 linear equations.\nEnter the coefficients a11 a12 a21 a22 b1 b2:" );
		double Pol11=scanner.nextDouble();
		double Pol12=scanner.nextDouble();
		double Pol21=scanner.nextDouble();
		double Pol22=scanner.nextDouble();
		double Eq1=scanner.nextDouble();
		double Eq2=scanner.nextDouble();
		//System.out.println(N11);
		//System.out.println(N12);
		//show equation
		System.out.println("Eq1: "+Pol11+"*x1+"+Pol12+"*x2="+Eq1);
		System.out.println("Eq1: "+Pol21+"*x1+"+Pol22+"*x2="+Eq2);
		//one sol
		if(((Pol11*Pol22)-(Pol12*Pol21))!=0){
			//sol for 1((b1a22-b2a12)/(a11a22-a12a21) , (b2a11-b1a21)/(a11a22-a12a21))
			System.out.println("Single solution: ("+(Eq1*Pol22-Eq2*Pol12)/(Pol11*Pol22-Pol12*Pol21)+","+(Eq2*Pol11-Eq1*Pol21)/(Pol11*Pol22-Pol12*Pol21)+")");
			System.exit(0);
		}
		//condition2 for inf b2a11-b1a21==0 and b1a22-b2a12==0
		//else if (((Pol11*Pol22)-(Pol12*Pol21))==0 && ((Eq2*Pol11)-(Eq1*Pol21))==0 && ((Eq1*Pol22)-(Eq2*Pol12))== 0) {
		else if (((Eq2*Pol11)-(Eq1*Pol21))==0 && ((Eq1*Pol22)-(Eq2*Pol12))==0){
			System.out.println("Many solutions");
		}
			//cond 3 for inf
		if (((Pol11==0) && (Pol11==Pol12) && (Eq1!=0)) && (Pol21==0) && (Pol12==Pol22)&&(Eq2!=0)){
				System.out.println("Many solutions");
				System.exit(0);							
		}
			
		
		//no sol
		else {
			System.out.println("No solutions");
		
			
		}
	}
}