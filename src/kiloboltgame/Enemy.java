package kiloboltgame;

public class Enemy {

	
	private int maxRange;
	
	private int maxHealth, currentHealth, power, speedX, speedY, centerX,
			centerY;
	private Background bg = StartingClass.getBg1();

	private int staticCenterY = centerY;
	private int speedUpdown = -1;
	
	private boolean floatingDown;
	
	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = bg.getSpeedX();
		
		centerY += speedUpdown;
		maxRange += 1;
		
		if (maxRange >= 10) {
			maxRange = 0;
			if(speedUpdown == -1){
				speedUpdown = 1;
			} else {
				speedUpdown = -1;
			}	
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
}
