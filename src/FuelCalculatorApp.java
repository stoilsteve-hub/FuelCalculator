import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuelCalculatorApp extends JFrame {

    private JTextField milesField, gallonsField;
    private JLabel resultLabel;

    public FuelCalculatorApp() {
        setTitle("Fuel Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Background (dark gray)
        getContentPane().setBackground(new Color(40, 40, 40));

        // Miles input
        JLabel milesLabel = new JLabel("Miles driven:");
        milesLabel.setForeground(Color.WHITE); // white text
        add(milesLabel);

        milesField = new JTextField();
        milesField.setBackground(Color.LIGHT_GRAY);
        milesField.setForeground(Color.BLACK);
        add(milesField);

        // Gallons input
        JLabel gallonsLabel = new JLabel("Gallons used:");
        gallonsLabel.setForeground(Color.WHITE);
        add(gallonsLabel);

        gallonsField = new JTextField();
        gallonsField.setBackground(Color.LIGHT_GRAY);
        gallonsField.setForeground(Color.BLACK);
        add(gallonsField);

        // Deep red button
        JButton calcButton = new JButton("Calculate");
        calcButton.setBackground(new Color(139, 0, 0)); // deep red
        calcButton.setForeground(Color.WHITE);          // white text
        add(calcButton);

        // Result label
        resultLabel = new JLabel("Liters per km: ");
        resultLabel.setForeground(new Color(255, 69, 58)); // bright red result
        add(resultLabel);

        // Button action
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double miles = Double.parseDouble(milesField.getText());
                    double gallons = Double.parseDouble(gallonsField.getText());

                    double liters = gallons * 3.78541;
                    double kilometers = miles * 1.60934;
                    double LPK = liters / kilometers;

                    resultLabel.setText("Liters per km: " + String.format("%.2f", LPK));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FuelCalculatorApp().setVisible(true);
        });
    }
}
