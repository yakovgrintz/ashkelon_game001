import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FinishLine extends JPanel {
private Line2D.Float _line;
    public FinishLine(){
    _line=new Line2D.Float(50,20,350,20);

}

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
