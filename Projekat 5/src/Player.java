public class Player extends GameObject {
    private String name;
    private int health; // 0..100

    public Player(String name, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() { return name; }
    public int getHealth() { return health; }

    public void setName(String name) {
        if (name == null) name = "";
        name = name.trim();
        if (!name.isEmpty()) {
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
        if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health must be between 0 and 100");
        this.health = health;
    }

    @Override
    public String toString() {
        return String.format("Player[name=%s, health=%d, x=%d, y=%d, collider=%s]",
                name, health, getX(), getY(), getCollider().getClass().getSimpleName());
    }

    @Override
    public String getDisplayName() {
        return name;
    }
}
