import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameUI extends JFrame {
    private JTextField nameField = new JTextField(15);
    private JTextField healthField = new JTextField(3);
    private JTextField xField = new JTextField(3);
    private JTextField yField = new JTextField(3);
    private JRadioButton rectBtn = new JRadioButton("Rectangle", true);
    private JRadioButton circBtn = new JRadioButton("Circle");
    private JButton startBtn = new JButton("Pokreni igru");
    private JTextArea output = new JTextArea(20, 50);

    public GameUI() {
        super("Simple Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.add(new JLabel("Name:")); top.add(nameField);
        top.add(new JLabel("Health:")); top.add(healthField);
        top.add(new JLabel("X:")); top.add(xField);
        top.add(new JLabel("Y:")); top.add(yField);
        ButtonGroup g = new ButtonGroup(); g.add(rectBtn); g.add(circBtn);
        top.add(rectBtn); top.add(circBtn);
        top.add(startBtn);

        add(top, BorderLayout.NORTH);
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void startGame() {
        try {
            String name = nameField.getText();
            int health = Integer.parseInt(healthField.getText().trim());
            int x = Integer.parseInt(xField.getText().trim());
            int y = Integer.parseInt(yField.getText().trim());
            Collidable collider;
            if (rectBtn.isSelected()) collider = new RectangleCollider(x, y, 32, 32);
            else collider = new CircleCollider(x, y, 16);
            Player p = new Player(name, health, x, y, collider);
            Game game = new Game();
            game.setPlayer(p);
            output.setText("");
            output.append("Player created: " + p.toString() + "\n\n");
            List<Enemy> enemies = Game.loadEnemiesFromCSV("enemies.csv");
            for (Enemy en : enemies) game.addEnemy(en);
            output.append("Loaded enemies:\n");
            for (Enemy en : game.getEnemies()) output.append(en.toString() + "\n");
            output.append("\nColliding with player:\n");
            for (Enemy en : game.collidingWithPlayer()) output.append(en.toString() + "\n");
            output.append("\nResolving collisions...\n");
            game.resolveCollisions();
            output.append("\nGame log:\n");
            for (String s : game.getLog()) output.append(s + "\n");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameUI().setVisible(true);
        });
    }
}
