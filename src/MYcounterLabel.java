import javax.swing.*;
import java.awt.*;

public class MYcounterLabel extends JLabel {
    public final String PART1 = "your ball :";
    private String part2;
    private String part3;
    private JLabel _counterLabel;
    public int CONVERT_LEVEL_TO_GOAL = 50;

    public MYcounterLabel(int level) {
        this.part3 = "/" + level * CONVERT_LEVEL_TO_GOAL;
        this.part2 = "0";
        _counterLabel = new JLabel("" + PART1 + part2 + part3);
        _counterLabel.setBounds(0, 0, MyPanels.WIDTH, 20);
        _counterLabel.setFont(new Font("David", Font.BOLD, 20));
        _counterLabel.setBackground(Color.WHITE);
    }

    public void upText() {
        int counter;
        try {
            counter = Integer.parseInt(this.part2);
            counter++;

        } catch (Exception e) {
            counter = 0;
        }
        this.part2 = String.valueOf(counter);
        _counterLabel.setText("" + PART1 + part2 + part3);
    }

    public void paint(Graphics g) {
        super.paint(g);

    }
}



