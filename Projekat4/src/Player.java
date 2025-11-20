public class Player extends GameObject {
    private String name;
    private int health;

    public Player(String name, int x, int y, RectangleCollider collider, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Ime ne moze biti null");
        String cleaned = name.trim().replaceAll("\\s+", " ");
        if (cleaned.isEmpty()) throw new IllegalArgumentException("Ime ne moze biti prazno");
        String[] parts = cleaned.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i].toLowerCase();
            sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1));
            if (i < parts.length - 1) sb.append(' ');
        }
        this.name = sb.toString();
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health mora biti izmedju 0 i 100");
        this.health = health;
    }

    @Override
    public String toString() {
        Collidable c = getCollider();
        String shapeDesc = c.toString();
        return "Player[" + name + "] @ (" + getX() + "," + getY() + ") " + shapeDesc + " HP=" + health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }
}