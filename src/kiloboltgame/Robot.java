package kiloboltgame;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Robot {
	// In Java, Class Variables should be private so that only its methods can
	// change them
	final int JUMPSPEED = -15;
	final int JUMPSPEED2 = -10;
	final int MOVESPEED = 5;

	private int centerX = 100;
	private int centerY = 377;
	private boolean jumped = false;
	private boolean jumpLimit = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;
	
	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();

	private int speedX = 0;
	private int speedY = 0;
	public static Rectangle rectBody = new Rectangle(0, 0, 0, 0);
	public static Rectangle rectLegs = new Rectangle(0, 0, 0, 0);
	public static Rectangle rectLeft = new Rectangle(0, 0, 0, 0);
	public static Rectangle rectRight = new Rectangle(0, 0, 0, 0);
	public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);
	public static Rectangle footleft = new Rectangle(0,0,0,0);
	public static Rectangle footright = new Rectangle(0,0,0,0);
	
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public void update() {

		// Moves character or scrolls background accordingly
		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);
		}
		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 200) {
			bg1.setSpeedX(-MOVESPEED / 5);
			bg2.setSpeedX(-MOVESPEED / 5);
		}

		// Updates Y position
		centerY += speedY;

		// Handles jumping
		speedY += 1;
	
		if (speedY > 3){
			jumped = true;
			
		}
		
		// Prevents going beyond coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}
		
		rectBody.setRect(centerX - 34, centerY - 63	, 68, 63);
		rectLegs.setRect(rectBody.getX(), rectBody.getY() + 63, 68, 64);
		rectLeft.setRect(rectBody.getX() - 26, rectBody.getY()+32, 26, 20);
		rectRight.setRect(rectBody.getX() + 68, rectBody.getY()+32, 26, 20);		
		yellowRed.setRect(centerX - 110, centerY - 110, 180, 180);
		footleft.setRect(centerX - 50, centerY + 20, 50, 15);
		footright.setRect(centerX, centerY + 20, 50, 15);
	}

	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	public void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}
		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}
		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}
	}

	public void jump() {
		if (jumped == true && jumpLimit == false) {
			speedY += JUMPSPEED2;
			jumpLimit = true;
		}
		
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}

	}

	public void shoot() {
		if (readyToFire) {
			Projectile p = new Projectile(centerX + 50, centerY - 25);
			projectiles.add(p);
		}
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public boolean isJumpLimit() {
		return jumpLimit;
	}

	public void setJumpLimit(boolean jumpLimit) {
		this.jumpLimit = jumpLimit;
	}

}
