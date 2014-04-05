import java.util.Scanner;
public class Ex2c {
		public static final int Op1=1;
		public static final int Op2=2;
		public static final int Op3=3;
		public static final int Op4=4;
		public static final int Op5=5;
		public static final int Op6=6;
		public static final int Op7=7;
		static final int MATH_FACTOR=2;
		public static void main(String[] args) {
				final String U="u";
				final String TrimS="s";				
				java.util.Scanner scanner = new java.util.Scanner(System.in);
				System.out.println("Please enter a sentence:");
				String Sentence=scanner.nextLine();			
				System.out.println("1) Number of characters " +
						"\n2) Number of characters without spaces " +
						"\n3) Convert to upper/lower case " +
						"\n4) Trim N characters from start/end" +
						"\n5) Replace a letter" +
						"\n6) Remove the middle characters" +
						"\n7) Replace first and last word" +
						"\nChoose option to execute:");
				int Request=scanner.nextInt();//scans the user string
				switch (Request){
					case Op1://displays the Number of characters in the given sentence 
						System.out.println("The answer is: "+Sentence.length());
						break;
					case Op2://displays the Number of characters in the given sentence without inc the spaces							
						System.out.println("The answer is: "+(Sentence.replace(" ","")).length());
						break;
					case Op3://converts the given sentence to Upper/Lower case.				
						System.out.println("Upper (u) or Lower (l) case?");
						String Ul=scanner.next();
						if (Ul.equals(U)){
							System.out.println("The answer is: "+Sentence.toUpperCase());
						}
						else {
							System.out.println("The answer is: "+Sentence.toLowerCase());							
						}
					break;
					case Op4://removes "n" characters from start/end of given sentence.
						System.out.println("Number of characters to trim:");
						int N=scanner.nextInt();
						System.out.println("Trim from start (s) or end (e):");
						String Trim=scanner.next();
						if (Trim.equals(TrimS)){
						System.out.println("The answer is: "+Sentence.substring(N));
						}
						else {
							System.out.println("The answer is: "+Sentence.substring(0, Sentence.length() - N));
						}
					case Op5://replaces a requested letter choosed by user in his sentence.
						System.out.println("Letter to replace:");
						String Rep=scanner.next();
						System.out.println("New letter:");
						String RepTo=scanner.next();
						System.out.println("The answer is: "+Sentence.replace(Rep,RepTo));
					case Op6://Remove the middle character/s of the sentence.If the number of characters is even, remove the two middle characters.
						if ((Sentence.length())%2==0){							
							System.out.println("The answer is: "+Sentence.substring(0,((Sentence.length()/MATH_FACTOR)-1))+""+Sentence.substring((Sentence.length()/MATH_FACTOR)+1));
						}
						else {
							System.out.println("The answer is: "+Sentence.substring(0,((Sentence.length()/MATH_FACTOR)))+""+Sentence.substring((Sentence.length()/MATH_FACTOR)+1));
						}
						break;
					case Op7://Replace first and last word
						if ((Sentence.indexOf(' '))<1){
							System.out.println("The answer is: "+Sentence);
						}
						else{
						String Last=(Sentence.substring(Sentence.lastIndexOf(' ')+1));
						String First=(Sentence.substring(0,Sentence.indexOf(' ')));					
						System.out.println("The answer is: "+Last+Sentence.substring(Sentence.indexOf(' '),(Sentence.lastIndexOf(' ')+1))+First);
						}
				}			
			}
}