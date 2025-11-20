public class MeleeEnemy extends Enemy {
    public MeleeEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

	@Override
	public int getEffectiveDamage() {
		return getDamage();
	}
}