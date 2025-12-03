package dvanaesta;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.DecimalFormat;

public class CurrencyConverter extends JFrame {
    private final JTextField euroField = new JTextField(10);
    private final JTextField usdField = new JTextField(10);
    private final JTextField gbpField = new JTextField(10);
    private boolean updating = false;

    private static final double EUR_TO_USD = 1.17;
    private static final double EUR_TO_GBP = 0.87;

    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    public CurrencyConverter() {
        super("Konverter valuta - EUR / USD / GBP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addRow(p, gbc, 0, "EUR:", euroField);
        addRow(p, gbc, 1, "USD:", usdField);
        addRow(p, gbc, 2, "GBP:", gbpField);

       
        euroField.getDocument().addDocumentListener(new SimpleListener(() -> onEuroChanged()));
        usdField.getDocument().addDocumentListener(new SimpleListener(() -> onUsdChanged()));
        gbpField.getDocument().addDocumentListener(new SimpleListener(() -> onGbpChanged()));

        
        JLabel help = new JLabel("Unesite iznos u bilo koje polje; ostala dva se automatski izračunavaju.");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        p.add(help, gbc);

        getContentPane().add(p);
    }

    private void addRow(JPanel p, GridBagConstraints gbc, int row, String label, JTextField field) {
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0.0;
        p.add(new JLabel(label), gbc);
        gbc.gridx = 1; gbc.weightx = .0;
        p.add(field, gbc);
    }

    private void onEuroChanged() {
        if (updating) return;
        updating = true;
        try {
            String s = euroField.getText().trim();
            if (s.isEmpty()) {
                usdField.setText("");
                gbpField.setText("");
                return;
            }
            double euro = parseNumber(s);
            double usd = euro * EUR_TO_USD;
            double gbp = euro * EUR_TO_GBP;
            usdField.setText(df.format(usd));
            gbpField.setText(df.format(gbp));
        } catch (NumberFormatException ex) {
           
        } finally {
            updating = false;
        }
    }

    private void onUsdChanged() {
        if (updating) return;
        updating = true;
        try {
            String s = usdField.getText().trim();
            if (s.isEmpty()) {
                euroField.setText("");
                gbpField.setText("");
                return;
            }
            double usd = parseNumber(s);
            double euro = usd / EUR_TO_USD;
            double gbp = euro * EUR_TO_GBP;
            euroField.setText(df.format(euro));
            gbpField.setText(df.format(gbp));
        } catch (NumberFormatException ex) {
           
        } finally {
            updating = false;
        }
    }

    private void onGbpChanged() {
        if (updating) return;
        updating = true;
        try {
            String s = gbpField.getText().trim();
            if (s.isEmpty()) {
                euroField.setText("");
                usdField.setText("");
                return;
            }
            double gbp = parseNumber(s);
            double euro = gbp / EUR_TO_GBP;
            double usd = euro * EUR_TO_USD;
            euroField.setText(df.format(euro));
            usdField.setText(df.format(usd));
        } catch (NumberFormatException ex) {
          
        } finally {
            updating = false;
        }
    }

    private double parseNumber(String s) {
        
        s = s.replaceAll("\\s+", "");
        s = s.replace(',', '.');
        return Double.parseDouble(s);
    }

    private static class SimpleListener implements DocumentListener {
        private final Runnable r;
        SimpleListener(Runnable r) { this.r = r; }
        public void insertUpdate(DocumentEvent e) { r.run(); }
        public void removeUpdate(DocumentEvent e) { r.run(); }
        public void changedUpdate(DocumentEvent e) { r.run(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter cv = new CurrencyConverter();
            cv.setVisible(true);
        });
    }
}
