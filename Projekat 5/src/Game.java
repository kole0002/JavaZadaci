import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    public Game() {}

    public Player getPlayer() { return player; }
    public List<Enemy> getEnemies() { return enemies; }
    public List<String> getLog() { return log; }

    public void setPlayer(Player p) { this.player = p; }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int before = p.getHealth();
        int after = Math.max(0, before - dmg);
        p.setHealth(after);
        log.add(String.format("Player %s took %d damage from %s (%s). Health %d -> %d",
                p.getName(), dmg, e.getType(), e.getDisplayName(), before, after));
        if (after == 0) {
            log.add("Player has been defeated.");
            JOptionPane.showMessageDialog(null, "Player defeated!");
        }
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Added enemy: " + e.toString());
    }

    public List<Enemy> findByType(String query) {
        List<Enemy> res = new ArrayList<>();
        if (query == null) return res;
        String q = query.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) res.add(e);
        }
        return res;
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> res = new ArrayList<>();
        if (player == null) return res;
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) res.add(e);
        }
        return res;
    }

    public void resolveCollisions() {
        if (player == null) return;
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
                log.add("Collision resolved between " + player.getName() + " and " + e.getType());
            }
        }
        if (player.getHealth() > 0 && enemies.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Player survived and won!");
            log.add("Player won - no more enemies.");
        }
    }

    public static List<Enemy> loadEnemiesFromCSV(String filePath) throws Exception {
        List<Enemy> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (first && line.toLowerCase().startsWith("type")) { first = false; continue; }
                String[] parts = line.split(",");
                if (parts.length < 9) throw new IllegalArgumentException("Invalid CSV format: " + line);
                String type = parts[0].trim();
                String cls = parts[1].trim();
                int damage = Integer.parseInt(parts[2].trim());
                int health = Integer.parseInt(parts[3].trim());
                int x = Integer.parseInt(parts[4].trim());
                int y = Integer.parseInt(parts[5].trim());
                String shape = parts[6].trim();
                Collidable collider = null;
                if (shape.equalsIgnoreCase("rectangle")) {
                    int width = Integer.parseInt(parts[7].trim());
                    int height = Integer.parseInt(parts[8].trim());
                    collider = new RectangleCollider(x, y, width, height);
                } else if (shape.equalsIgnoreCase("circle")) {
                    int radius = Integer.parseInt(parts[9].trim());
                    collider = new CircleCollider(x, y, radius);
                } else {
                    throw new IllegalArgumentException("Unknown shape: " + shape);
                }
                Enemy e;
                if (cls.equalsIgnoreCase("melee")) {
                    e = new MeleeEnemy(type, damage, health, x, y, collider);
                } else if (cls.equalsIgnoreCase("boss")) {
                    e = new BossEnemy(type, damage, health, x, y, collider);
                } else {
                    throw new IllegalArgumentException("Unknown class: " + cls);
                }
                list.add(e);
            }
        }
        return list;
    }
}
