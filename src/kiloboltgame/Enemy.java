package kiloboltgame;

import java.awt.Rectangle;

public class Enemy {

	private int maxHealth, currentHealth, power, speedX, speedY, centerX,
			centerY;
	private Background bg = StartingClass.getBg1();

	private int maxRange = 0;
	private int speedUpdown = -1;
	
	private Rectangle heliBoy1 = new Rectangle(0,0,0,0);
	private Rectangle heliBoy2 = new Rectangle(0,0,0,0);

	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = bg.getSpeedX()*5;
		
		getHeliBoy1().setBounds(centerX - 25, centerY - 25,50,60);
		getHeliBoy2().setBounds(centerX - 25, centerY - 25,50,60);
		
		if (getHeliBoy1().intersects(Robot.yellowRed) || getHeliBoy2().intersects(Robot.yellowRed)){
			checkCollision();
		}
			
		centerY += speedUpdown;
		maxRange += 1;

		if (maxRange >= 20) {
				maxRange = 0;
				if (speedUpdown == -1) {
					speedUpdown = 1;
				} else {
					speedUpdown = -1;
				}
			}
		}

	private void checkCollision() {
		if (getHeliBoy1().intersects(Robot.rectBody) || getHeliBoy1().intersects(Robot.rectLegs) || getHeliBoy1().intersects(Robot.rectLeft) || getHeliBoy1().intersects(Robot.rectRight)){
			System.out.println("collision");
			
			}
		
		if (getHeliBoy2().intersects(Robot.rectBody) || getHeliBoy2().intersects(Robot.rectLegs) || getHeliBoy2().intersects(Robot.rectLeft) || getHeliBoy2().intersects(Robot.rectRight)){
			System.out.println("collision");
			
			}
		}

	public void die() {

	}

	public void attack() {

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public Rectangle getHeliBoy1() {
		return heliBoy1;
	}

	public void setHeliBoy1(Rectangle heliBoy1) {
		this.heliBoy1 = heliBoy1;
	}

	public Rectangle getHeliBoy2() {
		return heliBoy2;
	}

	public void setHeliBoy2(Rectangle heliBoy2) {
		this.heliBoy2 = heliBoy2;
	}
}
