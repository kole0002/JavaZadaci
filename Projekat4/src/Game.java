// Marko Kostic 24/088
//Andrej Burzanovic 24/023
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player player) {
        if (player == null) throw new IllegalArgumentException("Player cannot be null");
        this.player = player;
    }

    public void addEnemy(Enemy e) {
        if (e == null) throw new IllegalArgumentException("Enemy cannot be null");
        enemies.add(e);
        eventLog.add("ADD: " + e.toString());
    }

    public boolean checkCollision(Player p, Enemy e) {
        if (p == null || e == null) throw new IllegalArgumentException("Arguments cannot be null");
        return p.intersects(e);
    }

    public List<Enemy> findByType(String query) {
        List<Enemy> res = new ArrayList<>();
        if (query == null) return res;
        String q = query.toLowerCase();
        for (Enemy en : enemies) {
            if (en.getType().toLowerCase().contains(q)) res.add(en);
        }
        return res;
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> res = new ArrayList<>();
        for (Enemy en : enemies) {
            if (checkCollision(player, en)) res.add(en);
        }
        return res;
    }

    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) throw new IllegalArgumentException("Arguments ne moze biti null");
        int before = p.getHealth();
        int damage = e.getEffectiveDamage();
        int after = before - damage;
        if (after < 0) after = 0;
        p.setHealth(after);
        eventLog.add("HIT: " + p.getDisplayName() + " by " + e.getDisplayName() + " for " + damage + " - HP " + before + " - " + after + ".");
    }

    public void resolveCollisions() {
        for (Enemy en : enemies) {
            if (checkCollision(player, en)) {
                decreaseHealth(player, en);
            }
        }
    }

    public ArrayList<String> getEventLog() { return eventLog; }
    public ArrayList<Enemy> getEnemies() { return enemies; }
    public Player getPlayer() { return player; }

    public static Enemy parseEnemy(String line) {
        if (line == null) throw new IllegalArgumentException("Linija ne moze biti null");
        String[] parts = line.split(";");
        if (parts.length < 5) throw new IllegalArgumentException("Nepravilan enemy format: " + line);
        try {
            String type = parts[0].trim();
            String[] pos = parts[1].trim().split(",");
            int x = Integer.parseInt(pos[0].trim());
            int y = Integer.parseInt(pos[1].trim());
            String[] size = parts[2].trim().split("x");
            int w = Integer.parseInt(size[0].trim());
            int h = Integer.parseInt(size[1].trim());
            int dmg = Integer.parseInt(parts[3].trim());
            String kind = parts[4].trim().toLowerCase();
            RectangleCollider rc = new RectangleCollider(x, y, w, h);
            if (kind.equals("boss")) {
                return new BossEnemy(type, x, y, rc, dmg, 100);
            } else {
                return new MeleeEnemy(type, x, y, rc, dmg, 50);
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Nedozvoljen broj u enemy stringu: " + line);
        }
    }

    public static void main(String[] args) {
        Player p = new Player(" peTar petrović ", 10, 5, new RectangleCollider(10, 5, 32, 32), 85);
        Game g = new Game(p);
        Enemy e1 = new MeleeEnemy("Goblin", 12, 5, new RectangleCollider(12, 5, 16, 16), 20, 60);
        g.addEnemy(e1);
        Enemy e2 = parseEnemy("Goblin King; 10,5;32x32;25;boss");
        g.addEnemy(e2);

        System.out.println("Player before: " + p);
        System.out.println("All enemies:");
        for (Enemy e : g.getEnemies()) System.out.println(" - " + e);

        System.out.println("Find type contains 'gob':");
        for (Enemy e : g.findByType("gob")) System.out.println(" * " + e);

        System.out.println("Colliding with player:");
        for (Enemy e : g.collidingWithPlayer()) System.out.println(" # " + e);

        g.resolveCollisions();

        System.out.println("Player after: " + p);

        System.out.println("Event log:");
        for (String s : g.getEventLog()) System.out.println(s);
    }
}