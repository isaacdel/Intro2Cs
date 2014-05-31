import intro.ex7.BlackWhiteGrid;
public class Hadamard {
	public static BlackWhiteGrid paintPattern(int n){
	
	BlackWhiteGrid grid=new BlackWhiteGrid();
	gridBuild(grid, 0, 0, false, n, grid.getHeight());
	
	return grid;
	}
	private static void gridBuild(BlackWhiteGrid grid,int topLeftX, int topLeftY,boolean color,int n, int height){
		if(n==0){
			grid.paintSquare(topLeftX, topLeftY, height, color);
		return;
		}
		int dividedgrid=height/2;

		gridBuild(grid, topLeftX, topLeftY, color, n-1, dividedgrid);//the differently colored square
		gridBuild(grid, topLeftX, topLeftY+dividedgrid, color, n-1, dividedgrid);
		gridBuild(grid, topLeftX+dividedgrid, topLeftY, color, n-1, dividedgrid);
		gridBuild(grid, topLeftX+dividedgrid, topLeftY+dividedgrid, !color, n-1, dividedgrid);
	
	}
	public static void main(String[] args) {
		paintPattern(4);
	}

}
