package cascetvrtakdrugi;
//Marko Kostic, Andrej Burzanovic, Aleksa Obradovic
public class Player {
	private int x;
	private int y;
	private int height;
	private int width;
	private int health;
	
	public Player(int x, int y, int height, int width, int health) {
		this.setX(x);
		this.setY(y);
		this.setHeight(height);
		this.setWidth(width);
		if(health >= 0 && health <= 100) {
			this.setHealth(health);
		}		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health >=0 && health <=100) {
			this.health = health;
		}
	}
	
	public class Enemy {
		private int x;
		private int y;
		private int height;
		private int width;
		private int damage;
		
		public Enemy(int x, int y, int height, int width, int damage) {
			this.setX(x);
			this.setY(y);
			this.setHeight(height);
			this.setWidth(width);
			if(damage >= 0 && damage <= 100) {
				this.setDamage(damage);
			}		
			
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			if(damage >=0 && damage <=100) {
				this.damage = damage;
			}

		}
	}

	
	
	
	
	
	
	
}
