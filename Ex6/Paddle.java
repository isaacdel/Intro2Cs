import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;
/**
* 
A Paddle class implements the paddle in the game

*/
public class Paddle extends java.lang.Object{
    private static final int HALF_ANGLE = 180;
	private static final int MAX_ANGLE = 360;
	private static final int MOVING_VALUE = 10;
	/**
    * Creates a new paddle

    * @param x the X coordinate of upper left corner of the paddle
    * @param y the Y coordinate of upper left corner of the paddle
    * @param color the color of the paddle
    * @param height the height of the paddle
    * @param width the width of the paddle
    */
	private int topLeftX;
	private int topLeftY;
	private int paddleWidth;
	private int paddleHeight;
	private Color paddleColor;
	
    public Paddle(int x, int y, int height, int width, java.awt.Color color) {//paddle constructor
    	topLeftX=x;
    	topLeftY=y;
    	paddleWidth=width;
    	paddleHeight=height;
    	paddleColor=color;
    }
    /**
    * Changes the paddle position by 10 to the left (down the X axis).

    */
    public void moveLeft() {
    	this.topLeftX=topLeftX-Paddle.MOVING_VALUE;
    }
    /**
    * Changes the paddle position by 10 to the right (up the X axis).

    */
    public void moveRight() {
    	this.topLeftX=topLeftX+Paddle.MOVING_VALUE;
    }
    /**
    * Draws the paddle

    * @param g the graphics object associated with the window in which
  the paddle draws itself
    */
    public void paint(java.awt.Graphics g) {
    	g.setColor(paddleColor);
    	g.fillRect(topLeftX, topLeftY, paddleWidth, paddleHeight);
    }
    /**
    * Bounces the ball (if appropriate according to the exercise description).
  If the ball is in such a position relative to the paddle that it should
  be bounced the method updates the ball so that its direction reflect
  the effect of the bounce (i.e. it moves in the opposide direction after the bounce).

    * @param ball the ball object

    * @return true if the ball hit the paddle.
    */
    public boolean bounceBall(Ball ball) {//checks if ball hit the wanted paddle bounds.if hit it bounces back
    	if(ball.getX()>=topLeftX-ball.getRadius()&&ball.getX()<=topLeftX+paddleWidth+ball.getRadius()&&ball.getY()>=topLeftY-ball.getRadius()
    			&&ball.getY()<=topLeftY&&ball.getDirection()>Paddle.HALF_ANGLE&&ball.getDirection()<Paddle.MAX_ANGLE){
    		ball.setDirection(Paddle.MAX_ANGLE-ball.getDirection());
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    /**
    * returns the height of the paddle

    * @return the height of the paddle
    */
    public int getHeight() {
    	return this.paddleHeight;
    }
    /**
    * returns the width of the paddle

    * @return the width of the paddle
    */
    public int getWidth() {
    	return this.paddleWidth;
    }
    /**
    * returns the X position of the paddles' top-left corner.

    * @return the X position of the paddles' top-left corner.
    */
    public int getX() {
    	return this.topLeftX;
    }
    /**
    * returns the Y position of the paddles' top-left corner.

    * @return the Y position of the paddles' top-left corner.
    */
    public int getY() {
    	return this.topLeftY;
    }
}

