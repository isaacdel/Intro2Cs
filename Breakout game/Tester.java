
public class Tester {

		public static void main(String[] args)
		{
				for(int i=400; i<800; i+=5){
					
				Ball k = new Ball(2, 2, 2, i, 2, java.awt.Color.black);
				System.out.println(k.getDirection());
				}
		}
}
 