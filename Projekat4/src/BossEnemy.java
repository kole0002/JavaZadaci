public class BossEnemy extends Enemy {
    public BossEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return getDamage() * 2;
    }

    @Override
    public String toString() {
        return "BossEnemy[" + getType() + "] @ (" + getX() + "," + getY() + ") " + getCollider().toString()
                + " DMG=" + getDamage() + "x2 HP=" + getHealth();
    }
}