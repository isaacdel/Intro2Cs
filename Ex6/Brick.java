import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;
/**
 * 
This class implements a Brick in the Breakout game.
 It's also used to represent the walls of room in the game.

 */

public class Brick extends java.lang.Object{
	private static final int BUTTOM_DIRECTION = 270;
	private static final int QUARTER_MAX_ANGLE = 90;
	private static final int HALF_MAX_ANGLE = 180;
	private static final int MAX_ANGLE = 360;
	/**
	 * Constructs a new brick that's active upon construction.

	 * @param x the X coordinate of the top left corner of the brick
	 * @param y the Y coordinate of the top left corner of the brick
	 * @param height the height of the brick
	 * @param width the width of the brick
	 * @param color the color of the brick
	 */
	private int topLeftX;
	private int topLeftY;
	private int brickWidth;
	private int brickHeight;
	private Color brickColor;
	private boolean isBrickActive;
	
	public Brick(int x, int y, int height, int width, java.awt.Color color) {//brick constructor
		topLeftX=x;
		topLeftY=y;
		brickWidth=width;
		brickHeight=height;
		brickColor=color;
		isBrickActive=true;
	}
	/**
	 * Constructs a new brick

	 * @param x the X coordinate of the top left corner of the brick
	 * @param y the Y coordinate of the top left corner of the brick
	 * @param height the height of the brick
	 * @param width the width of the brick
	 * @param color the color of the brick
	 * @param isActive does the brick start as active or not.
	 */
	public Brick(int x, int y, int height, int width, java.awt.Color color, boolean isActive) {
		this.topLeftX=x;
		this.topLeftY=y;
		this.brickHeight=height;
		this.brickWidth=width;
		this.brickColor=color;
		isBrickActive=isActive;
	}
	/**
	 * Bounces the ball if it hit one of this Brick's regions.
	 * @param ball the ball object

	 * @return true if the ball hit one of the brick's regions and false otherwise.
	 */
	public boolean bounceBall(Ball ball) {
		if(!isBrickActive){//if bricks are not  active at all
			return false;
		}
		//down paddle hit.checks if in bound in y than in x so it will only hit down
		if(ball.getY()<topLeftY+brickHeight+ball.getRadius()&&ball.getY()>=topLeftY+brickHeight
				&&ball.getX()>=topLeftX-ball.getRadius()&&ball.getX()<topLeftX+brickWidth+ball.getRadius()){
			ball.setDirection(Brick.MAX_ANGLE-ball.getDirection());
			return true;
		}
		//up paddle hit.checks if in bound in y than in x so it will only hit down
		if(ball.getY()<=topLeftY&&ball.getY()>topLeftY-ball.getRadius()
				&&ball.getX()>=topLeftX-ball.getRadius()&&ball.getX()<topLeftX+brickWidth+ball.getRadius()){
			ball.setDirection(Brick.MAX_ANGLE-ball.getDirection());
			return true;
		}
		//right paddle hit.checks if in bound in y than in x so it will only hit down also checks by angles to be sure ball in the correct side
		if(ball.getY()>=topLeftY-ball.getRadius()&&ball.getY()<topLeftY+brickHeight+ball.getRadius()&&
				ball.getX()>=topLeftX+brickWidth&&ball.getX()<topLeftX+brickWidth+ball.getRadius()
				&&ball.getDirection()>Brick.QUARTER_MAX_ANGLE&&ball.getDirection()<Brick.BUTTOM_DIRECTION){
			ball.setDirection(Brick.HALF_MAX_ANGLE-ball.getDirection());
			return true;
		}
		//left paddle hit.checks if in bound in y than in x so it will only hit down also checks by angles to be sure ball in the correct side
		if(ball.getY()>=topLeftY-ball.getRadius()&&ball.getY()<topLeftY+brickHeight+ball.getRadius()
				&&ball.getX()>topLeftX-ball.getRadius()&&ball.getX()<=topLeftX
				&&(ball.getDirection()>Brick.BUTTOM_DIRECTION&&ball.getDirection()<Brick.MAX_ANGLE||ball.getDirection()>=0&&ball.getDirection()<Brick.QUARTER_MAX_ANGLE)){
			ball.setDirection(Brick.HALF_MAX_ANGLE-ball.getDirection());
			return true;
		}
		else {//returns false if ball didnt hit brick
			return false;
		}
	}

	/**
	 * Draws the brick

	 * @param g the graphics object associated with the window in which
 the brick draws itself
	 */
	public void paint(java.awt.Graphics g) {
		g.setColor(brickColor);
		g.fillRect(topLeftX, topLeftY, brickWidth, brickHeight);
	}
	/**
	 * returns this Brick's height.

	 * @return this Brick's height.
	 */
	public int getHeight() {
		return this.brickHeight;
	}
	/**
	 * returns this Brick's width.

	 * @return this Brick's width.
	 */
	public int getWidth() {
		return this.brickWidth;
	}
	/**
	 * returns the X coordinate of this brick's top-left corner.

	 * @return X coordinate of this brick's top-left corner.
	 */
	public int getX() {
		return this.topLeftX;
	}
	/**
	 * returns the Y coordinate of this brick's top-left corner.

	 * @return Y coordinate of this brick's top-left corner.
	 */
	public int getY() {
		return this.topLeftY;
	}
	/**
	 * Returns whether this Brick is active or not.

	 * @return true iff this Brick is active.
	 */
	public boolean getActive() {
		return this.isBrickActive;
	}
	/**
	 * Sets brick's activity to the given value.

	 * @param isActive true if setting the brick to active false for inactive.
	 */
	public void setActive(boolean isActive) {
		this.isBrickActive=isActive;
	}
}

