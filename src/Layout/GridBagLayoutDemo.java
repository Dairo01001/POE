package Layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dairo García
 */
public class GridBagLayoutDemo extends JFrame {

    public GridBagLayoutDemo() {
        this.initJFrame();
        this.initComponentes();
    }

    private void initJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponentes() {
        this.panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.panel.add(new JButton("Dairo"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.panel.add(new JButton("Garcia"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.panel.add(new JButton("Naranjo"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;
        gbc.weightx = 0;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.panel.add(new JButton("Dairo Garcia Naranjo"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;       //reset to default
        gbc.weighty = 1.0;   //request any extra vertical space
        gbc.anchor = GridBagConstraints.PAGE_END; //bottom of space
        gbc.insets = new Insets(10, 0, 0, 0);  //top padding
        gbc.gridx = 1;       //aligned with button 2
        gbc.gridwidth = 2;   //2 columns wide
        gbc.gridy = 2;       //third row
        this.panel.add(new JButton("Que pasa?"), gbc);

        this.add(this.panel);

        this.pack();
    }

    private JPanel panel;

    public static void main(String[] args) {
        GridBagLayoutDemo ventana = new GridBagLayoutDemo();
        ventana.setVisible(true);
    }
}
