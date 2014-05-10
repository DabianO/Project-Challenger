package kiloboltgame;

public class Enemy {

	final int FLOATINGDOWN = 5;
	final int FLOATINGUP = -5;

	private int maxHealth, currentHealth, power, speedX, speedY, centerX,
			centerY;
	private Background bg = StartingClass.getBg1();

	private int staticCenterY = 0;
	private int speedYUp = -1;
	private int speedYDown = 1;
	
	private StartingClass floatingDown;
	
	public void floating(){
		floatingDown = new StartingClass();
	}
	
	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = bg.getSpeedX();
				
		staticCenterY = centerY;

		if (centerY <= staticCenterY + FLOATINGDOWN && floatingDown.isFloatingDown()== true) {
			centerY += speedYDown;
			if (centerY >= staticCenterY + FLOATINGDOWN){
				floatingDown.setFloatingDown(false);
				
			}
		}
		
		if (centerY >= staticCenterY + FLOATINGUP && floatingDown.isFloatingDown() == false) {
			centerY += speedYUp;
			if (centerY >= staticCenterY + FLOATINGUP){
				floatingDown.setFloatingDown(true);
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
