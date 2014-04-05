import intro.ex7.BlackWhiteGrid;
public class PatternPainter {
	
	
	public static BlackWhiteGrid paintPattern(int n){
	
	BlackWhiteGrid grid=new BlackWhiteGrid();
	gridBuild(grid, 0, 0, false, n+1, grid.getHeight(),1);
	
	return grid;
		
	}
	
	
	private static void gridBuild(BlackWhiteGrid grid,int topLeftX, int topLeftY,boolean color,int n, int size,int quarter){
		if(n==1){
			grid.paintSquare(topLeftX, topLeftY, size, color);
			return;
		}
		
		int dividedgrid=size/2;
		if(quarter==1) {//top left squarea
			gridBuild(grid, topLeftX, topLeftY, color, n-1, dividedgrid, 1);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY, color, n-1, dividedgrid, 2);
			gridBuild(grid, topLeftX, topLeftY+dividedgrid, color, n-1, dividedgrid, 3);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY+dividedgrid, !color, n-1, dividedgrid, 4);
		}
		else if(quarter==2){
			gridBuild(grid, topLeftX, topLeftY, color, n-1, dividedgrid, 1);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY, color, n-1, dividedgrid, 2);
			gridBuild(grid, topLeftX, topLeftY+dividedgrid, !color, n-1, dividedgrid, 3);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY+dividedgrid, color, n-1, dividedgrid, 4);
		}
		else if(quarter==3){
			gridBuild(grid, topLeftX, topLeftY, color, n-1, dividedgrid, 1);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY, !color, n-1, dividedgrid, 2);
			gridBuild(grid, topLeftX, topLeftY+dividedgrid, color, n-1, dividedgrid, 3);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY+dividedgrid, color, n-1, dividedgrid, 4);
		}
		else if(quarter==4){
			gridBuild(grid, topLeftX, topLeftY, !color, n-1, dividedgrid, 1);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY, color, n-1, dividedgrid, 2);
			gridBuild(grid, topLeftX, topLeftY+dividedgrid, color, n-1, dividedgrid, 3);
			gridBuild(grid, topLeftX+dividedgrid, topLeftY+dividedgrid, color, n-1, dividedgrid, 4);
		}
	}
	
	public static void main(String[] args) {
		paintPattern(6);
	}
}