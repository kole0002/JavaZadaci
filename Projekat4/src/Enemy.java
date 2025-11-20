public class Enemy extends GameObject implements Attacker {
    private String type;
    private int damage;
    private int health;

    public Enemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() { return type; }

    public void setType(String type) {
        if (type == null) throw new IllegalArgumentException("Tip ne može biti null");
        String t = type.trim();
        if (t.isEmpty()) throw new IllegalArgumentException("Tip ne može biti prazan");
        this.type = t;
    }

    public int getDamage() { return damage; }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) throw new IllegalArgumentException("Damage mora biti između 0 i 100");
        this.damage = damage;
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health mora biti između 0 i 100");
        this.health = health;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + getX() + "," + getY() + ") " + getCollider().toString()
                + " DMG=" + damage + " HP=" + health;
    }

    @Override
    public String getDisplayName() {
        return type;
    }
}