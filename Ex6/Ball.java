import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;
/**
 * 
A Ball class implements a moving ball

 */
public class Ball extends java.lang.Object{
	private static final int LOWEST_SPEED = 2;
	private static final int ANGLE_MAX = 360;
	/**
	 * Constructs a new ball.
	 * @param x the X coordinate of the center of the ball
	 * @param y the Y coordinate of the center of the ball
	 * @param speed the speed of the ball (using the same rules as the setSpeed method)
	 * @param direction the direction in which the ball moves.
  Direction is represented in degrees,
  e.g. a ball with direction 0 moves to the right, a ball with
  direction 270 moves down.
  direction may be ANY number, e.g 90 = 450 = -270.
	 * @param radius the radius of the ball
	 * @param color the color of the ball
	 */
	private int ballSpeed;
	private int ballDirection;
	private int ballRadius;
	private int xCenterPosition;
	private int yCenterPosition;
	private Color ballColor;
	
	public Ball(int x, int y, int speed, int direction, int radius, java.awt.Color color) {//BAll constructor
		xCenterPosition=x;
		yCenterPosition=y;
		ballDirection=direction;
		ballSpeed=speed;
		ballRadius=radius;
		ballColor=color;
	}
	/**
	 * returns the X coordinate of the center of the ball

	 * @return the X coordinate of the center of the ball
	 */
	public int getX() {
		return  this.xCenterPosition;
	}
	/**
	 * returns the Y coordinate of the center of the ball

	 * @return the Y coordinate of the center of the ball
	 */
	public int getY() {
		return this.yCenterPosition;
	}
	/**
	 * Draws the ball

	 * @param g the graphics object associated with the window in which
  the ball draws itself
	 */
	public void paint(java.awt.Graphics g) {
		g.setColor(ballColor);
		g.fillOval(xCenterPosition-ballRadius, yCenterPosition-ballRadius, ballRadius*Ball.LOWEST_SPEED, ballRadius*Ball.LOWEST_SPEED);
	}
	/**
	 * A method used to inform the ball that a quantum of time has passed.
  The ball calculates its new position (based on its speed,
  direction and old position).
  To calculate the new position, first calculate the accurate position of the ball as a double and then
  round it to an int using the Math.round method.
  Notice that because of the rounding, some game scenarios will look a bit odd.
  For example: try starting the ball with direction 3 and then increase the speed after a bit.
  or start with direction 89, the ball will always move in a straight line.

	 */
	public void timeTick() {//updates the new position by calculating components
		double newXPosition=Math.round(this.xCenterPosition+this.ballSpeed*Math.cos(Math.toRadians(ballDirection)));//calculates new x comp
		double newYPosition=Math.round(this.yCenterPosition-this.ballSpeed*Math.sin(Math.toRadians(ballDirection)));//calculates new y comp
		this.xCenterPosition=(int)newXPosition;//updates the new coardinates
		this.yCenterPosition=(int)newYPosition;
	}
	/**
	 * returns the direction of the ball

	 * @return The direction returned is in the [0, 360) interval
	 */
	public int getDirection() {
		int newdirection=ballDirection;
		if (ballDirection<Ball.ANGLE_MAX&&ballDirection>=0){//returns same angle if between valid values
			return ballDirection;
		}
		else{
			if(ballDirection>=Ball.ANGLE_MAX){
				do{//lowers the angle value until valid values
					newdirection-=Ball.ANGLE_MAX;
				}while(newdirection>=Ball.ANGLE_MAX);
				return newdirection;
			}
			if(ballDirection<0){//max the angle value until valid values
				do{
					newdirection+=Ball.ANGLE_MAX;
				}while(newdirection<0);
				return newdirection;
			}
		}
		return this.ballDirection;
	}
	/**
	 * Sets a new direction for the ball

	 * @param direction the new direction
  Direction is represented in degrees,
  e.g. a ball with direction 0 moves to the right, a ball with
  direction 270 moves down.
  direction may be ANY number, e.g. 90 = 450 = -270.
	 */
	public void setDirection(int direction) {
//		int newdirection;
//		if (direction>=360&&direction>=0){
//			direction=ballDirection;
//		}
//		else{
//			if(direction>360){
//
//
//				do{
//					newdirection=direction-360;
//				}while(newdirection>360);
//				ballDirection=newdirection;
//
//			}
//			if(direction<0){
//				do{
//					newdirection=direction+360;
//				}while(newdirection<-360&&newdirection<0);
//				ballDirection=360+newdirection;
//			}
//		}
		//this.ballDirection=ballDirection;
		this.ballDirection = ((direction%Ball.ANGLE_MAX)+Ball.ANGLE_MAX)%Ball.ANGLE_MAX; //sets the new direction only in valid values
	}


	/**
	 * returns the speed of the ball

	 * @return the speed of the ball
	 */
	public int getSpeed() {
		return this.ballSpeed;
	}
	/**
	 * returns the radius of the ball

	 * @return the radius of the ball
	 */
	public int getRadius() {
		return this.ballRadius;
	}
	/**
	 * Sets a new speed for the ball.
 If the given speed is larger than the radius, sets it to radius. If it is less than 2, sets it to 2.

	 * @param speed the new speed, you may assume it's non-negative.
	 */
	public void setSpeed(int speed) {
		if (speed<=Ball.LOWEST_SPEED){//dosent let user go under lowest speed
			this.ballSpeed=Ball.LOWEST_SPEED;
		}
		else if(speed>=this.ballRadius){
			this.ballSpeed=this.ballRadius;	
		}
		else{//makes it faster
			this.ballSpeed=speed;
		}
	}
}

