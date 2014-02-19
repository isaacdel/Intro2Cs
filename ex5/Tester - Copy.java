import intro.ex5.RGBColor;


public class Tester {
	public static void main(String args[]){
		// TODO Auto-generated method stub
		int col=3;
		int row=3;
		RGBImage t=new RGBImage(row,col);
		for (int h=0; h<row; h++){
		for (int l=0; l<col; l++){
		int r= (int)(Math.random()*255);
		int g= (int)(Math.random()*255);
		int b= (int)(Math.random()*255);

		RGBColor p=new RGBColor(r,g,b);
		t.setPixel(h, l, p);
		}
		}
		//t.shiftCol(-1);
		//t.flipVertical();
		//t.flipHorizontal();
		//for (int i=0; i<3; i++)
		t.rotateClockwise();
		//t.rotateCounterClockwise();

		int[][][] f= t.toIntArray();
		int kl= f.length;
		int ds=f[0].length;
		for (int i=0; i<kl; i++){
		System.out.println();
		for (int g=0; g<ds; g++){
		System.out.print(" ");
		for (int d=0; d<3; d++){
		System.out.print(f[i][g][d]);
		System.out.print(" ");
		}
		}
		}
		System.out.println(" ");
		t.blurImage(1);
		f= t.toIntArray();
		for (int i=0; i<kl; i++){
		System.out.println();
		for (int g=0; g<ds; g++){
		System.out.print(" ");
		for (int d=0; d<3; d++){
		System.out.print(f[i][g][d]);
		System.out.print(" ");
		}
		}}

		
		
		
//		int row = 3;
//		int col = 3;
//		RGBImage testImage = new RGBImage(row,col);
//		RGBColor pixel1;
//		for (int i=0; i < row; i++){
//			for (int j=0; j < col; j++){
//				pixel1 = new RGBColor((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)); 
//				testImage.setPixel(i, j, pixel1);
//				System.out.print(testImage.getPixel(i,j).getRed() + ",");
//				System.out.print(testImage.getPixel(i,j).getBlue() + ",");
//				System.out.print(testImage.getPixel(i,j).getGreen() + " | ");	
//			}
//			System.out.println();
//		}
//		System.out.println("__________________________________________________");
//		testImage.blurImage(1);
//		for (int i=0; i < row; i++){
//			for (int j=0; j < col; j++){ 
//				System.out.print(testImage.getPixel(i,j).getRed() + ",");
//				System.out.print(testImage.getPixel(i,j).getBlue() + ",");
//				System.out.print(testImage.getPixel(i,j).getGreen() + " | ");	
//			}
//	
//			System.out.println();}
		
		
		
		
		
		
		
		
	}
}
