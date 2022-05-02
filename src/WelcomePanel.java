import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel implements ActionListener {
    public static final int WIDTH = 1000, HIGH = 500;

    public WelcomePanel() {
        this.setBackground(new Color(255, 255, 204));
        this.setBounds(0, 0, WIDTH, HIGH);
        this.setLayout(null);
        // button1
        JButton button1 = new JButton(new ImageIcon("icons/startGame.png"));
        button1.setBackground(null);
        button1.setBorder(null);
        button1.setBounds(365, 141, 270, 217);
button1.setActionCommand("go to play");
        button1.addActionListener(this);
        this.add(button1);


        // button2
        JButton button2 = new JButton();
        button2.setBounds(button1.getX(), button1.getY() + button1.getHeight(), 265, 55);
        button2.setIcon(new ImageIcon("icons/buttonOrder.png"));
        button2.setBackground(null);
        button2.setBorder(null);
        this.add(button2);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="go to play"){
            add(new Scene_game());
        }
    }
}
