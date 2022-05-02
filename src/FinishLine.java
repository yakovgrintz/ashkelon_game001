import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FinishLine {
private Line2D.Float _line;
public final int X1=50 ,Y1=20 ,X2=350 ,Y2=20;
    public FinishLine(){
    _line=new Line2D.Float(this.X1,this.Y1,this.X2,this.Y2);

}

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(this.X1,this.Y1,this.X2,this.Y2);

    }
    public boolean checkFinishLine(newBall ball){
        Rectangle ballrect=new Rectangle(ball.getX(), ball.getY(),ball.getWIDTH(),ball.getHEIGHT());
        Rectangle lineRect=new Rectangle(new Point(this.X1, this.Y1),new Dimension(this.X2- this.X1,1));
        if(lineRect.intersects(ballrect)){
            return true;
        }
        return false;
    }
}
