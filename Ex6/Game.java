import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */
public class Game extends java.lang.Object{

	private static final int BRICK_HEIGHT = 25;
	private static final int STEP_SIZE = 2;
	private static final int BRICK_WIDTH = 65;
	private static final int STARTING_PAINT_POINT = 17;
	private static final int WALL_WIDTH = 15;
	private static final int BALL_RADIUS = 10;
	private static final int PADDLE_HEIGHT = Game.BALL_RADIUS;
	private static final int PADDLE_WIDTH = 75;
	private static final int COLS_VALUE = 6;
	private static final int ROWS_VALUE = 7;
	public static final int LEFT=0;
	public static final int RIGHT=1;
	public static final int DOWN=Game.STEP_SIZE;
	public static final int UP=3;
	/**
	 * The height of the window required by the Game class,
        Should be 400.

	 */
	public static final int WINDOW_HEIGHT=400;
	/**
	 * The width of the window required by the Game class,
        should be 501.

	 */
	public static final int WINDOW_WIDTH =501;
	/**
	 * Creates a new game object.
	 * @param ballX ball's staring x position.
	 * @param ballDir ball's starting direction.
	 */
	private Brick bricks[][];
	private Paddle paddle;
	private Ball ball;
	private Brick blueLeftBrick;
	private Brick blueTopBrick;
	private Brick blueRightBrick;
	
	public Game(int ballX, int ballDir) {//game constructor.creates all game components by the given values
		bricks=new Brick [Game.ROWS_VALUE][Game.COLS_VALUE];//creates an array to hold the bricks
		paddle=new Paddle(WINDOW_WIDTH / Game.STEP_SIZE - Game.PADDLE_WIDTH / Game.STEP_SIZE, WINDOW_HEIGHT - Game.PADDLE_HEIGHT, Game.PADDLE_HEIGHT, Game.PADDLE_WIDTH, Color.black);
		ball=new Ball(ballX, WINDOW_HEIGHT-PADDLE_HEIGHT-Game.BALL_RADIUS, Game.COLS_VALUE, ballDir, Game.PADDLE_HEIGHT, Color.RED);
		blueLeftBrick=new Brick(0, 0, WINDOW_HEIGHT, Game.WALL_WIDTH, Color.blue,true);
		blueTopBrick=new Brick(Game.WALL_WIDTH, 0, Game.WALL_WIDTH, 471, Color.blue,true);
		blueRightBrick=new Brick(WINDOW_WIDTH-Game.WALL_WIDTH, 0, WINDOW_HEIGHT, Game.WALL_WIDTH, Color.blue,true);
		for(int i=0;i<Game.ROWS_VALUE;i++){//tells the paint and array where to place each brick in the window and stores it in the array.
			for(int j=0;j<Game.COLS_VALUE;j++){
				bricks[i][j]=new Brick(Game.STARTING_PAINT_POINT+(Game.BRICK_WIDTH+Game.STEP_SIZE)*i, Game.STARTING_PAINT_POINT +(Game.STEP_SIZE+Game.BRICK_HEIGHT)*j, Game.BRICK_HEIGHT, Game.BRICK_WIDTH, Color.green,true);
			}
		}
	}
	/**
	 * Draws all the components of the game in the window.
	 * @param g The graphics object associated with this game.
	 */
	public void paint(java.awt.Graphics g) {
		blueLeftBrick.paint(g);
		blueRightBrick.paint(g);
		blueTopBrick.paint(g);
		ball.paint(g);
		paddle.paint(g);
		for(int i=0;i<Game.ROWS_VALUE;i++){//paints the bricks by the given array that holds their position
			for(int j=0;j<Game.COLS_VALUE;j++){
				if(bricks[i][j].getActive())
					bricks[i][j].paint(g);
			}
		}
	}
	/**
	 * Invoked by external scheduler each time quantum.
	 */
	public void handleTimeEvent() {
		ball.timeTick();
		blueLeftBrick.bounceBall(ball);
		blueRightBrick.bounceBall(ball);
		blueTopBrick.bounceBall(ball);
		paddle.bounceBall(ball);
		for (int i = 0; i < Game.ROWS_VALUE; i++) {//checks if the ball bounced from a brick.
			for (int j = 0; j < Game.COLS_VALUE; j++) {
				if (bricks[i][j].bounceBall(ball)) {
					bricks[i][j].setActive(false);//switches the bricks active off if it was hit.dosent touch to walls.
					return;
				}
			}
		}
	}
	/**
	 * Invoked when user presses left, right, up and down arrows of the keyboard.
	 * @param direction LEFT or RIGHT or UP or DOWN (according to which key the user pressed).
	 */
	public void handleMoveEvent(int direction) {
		switch(direction){//checks every case of given direction.
		case LEFT:
			if (paddle.getX()>Game.WALL_WIDTH){//moves the paddle left only if in window width bounds without the walls.
				paddle.moveLeft();
				break;
			}
			else{
				break;
			}
		case RIGHT:
			if(paddle.getX()+paddle.getWidth()<WINDOW_WIDTH-Game.WALL_WIDTH)////moves the paddle right only if in window width bounds without the walls.
				paddle.moveRight();
			break;
		case UP:
			ball.setSpeed(ball.getSpeed()+1);//makes the ball faster
			break;
		case DOWN:
			ball.setSpeed(ball.getSpeed()-1);//makes the ball slower
			break;
		}
	}
	/**
	 * Returns whether the game is over or not.
 The game ends after the last brick was hit, or if the ball's Y coordinate is larger or equal
	 * @return Whether the game is over or not.
	 */
	public boolean isGameOver() {
		if(ball.getY()>=WINDOW_HEIGHT){//exits if ball passed the bottom of the window.
			return true;
		}
		for(int i=0;i<Game.ROWS_VALUE;i++){//exits if all of the bricks were hit by the ball
			for(int j=0;j<Game.COLS_VALUE;j++){
				if(bricks[i][j].getActive()){
					return false;
				}
			}
		}
		return true;//continues the game if there are bricks lest and user didnt missed the ball
	}
}

