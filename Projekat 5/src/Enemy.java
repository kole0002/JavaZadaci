public class Enemy extends GameObject implements Attacker {
    private String type;
    private int damage; 
    private int health; 

    public Enemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() { return type; }
    public int getDamage() { return damage; }
    public int getHealth() { return health; }

    public void setType(String type) {
        if (type == null) type = "";
        type = type.trim();
        if (type.isEmpty()) throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) throw new IllegalArgumentException("Damage must be between 0 and 100");
        this.damage = damage;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health must be between 0 and 100");
        this.health = health;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Enemy[type=%s, damage=%d, health=%d, x=%d, y=%d, collider=%s]",
                type, damage, health, getX(), getY(), getCollider().getClass().getSimpleName());
    }
}
