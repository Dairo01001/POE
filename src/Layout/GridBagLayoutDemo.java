package Layout;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Dairo García
 */
public class GridBagLayoutDemo extends JFrame {

    public GridBagLayoutDemo() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("GridBagLayout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponets() {
        GridBagLayout grid = new GridBagLayout();
        JPanel jP = new JPanel(grid);
        GridBagConstraints form = new GridBagConstraints();

        form.gridx = 0;
        form.gridy = 0;
        form.gridwidth = 6;
        form.gridheight = 2;
        form.weightx = 1.0;
        form.weighty = 1.0;
        form.fill = GridBagConstraints.BOTH;
        jP.add(new JTextArea(), form);

        form.gridx = 1;
        form.gridy = 2;
        form.gridwidth = 1;
        form.gridheight = 1;
        form.weightx = 1.0;
        form.weighty = 1.0;
        form.fill = GridBagConstraints.BOTH;
        jP.add(this.initJButton("Dairo"), form);

        form.gridx = 2;
        form.gridy = 2;
        form.gridwidth = 1;
        form.gridheight = 1;
        form.weightx = 1.0;
        form.weighty = 1.0;
        form.fill = GridBagConstraints.BOTH;
        jP.add(this.initJButton("Dairo"), form);

        form.gridx = 1;
        form.gridy = 3;
        form.gridwidth = 2;
        form.gridheight = 1;
        form.weightx = 1.0;
        form.weighty = 1.0;
        form.fill = GridBagConstraints.BOTH;
        jP.add(this.initJButton("Dairo"), form);

        form.gridx = 2;
        form.gridy = 2;
        form.gridwidth = 2;
        form.gridheight = 1;
        form.weightx = 1.0;
        form.weighty = 1.0;
        form.fill = GridBagConstraints.BOTH;
        jP.add(this.initJButton("Dairo"), form);

        this.add(jP);
        this.pack();
    }

    private JButton initJButton(String nombre) {
        JButton jB = new JButton(nombre);
        jB.setFont(this.font);
        return jB;
    }

    private final Font font = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        GridBagLayoutDemo ventana = new GridBagLayoutDemo();
        ventana.setVisible(true);
    }
}
