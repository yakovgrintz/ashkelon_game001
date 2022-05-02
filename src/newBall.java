import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class newBall extends Rectangle2D.Double {
    public final Color[] ballColor={ Color.YELLOW,Color.MAGENTA};
    public newBall(double x,double y) {
        super(x, y, 3, 5);


    }

    public newBall(newBall ball) {
        super(ball.x, ball.y, ball.width, ball.height);
    }

    public void paint(Graphics g){
        g.setColor(ballColor[new Random().nextInt(ballColor.length)]);
        g.fillRect((int) this.x, (int) this.y, (int) this.width, (int) this.height);
    }
    public void moveUp(){
       this.setRect(this.x,this.y-1,this.width,this.height);
}

    public int getWIDTH() {
        return (int) this.width;
    }

    public int getHEIGHT() {
        return (int) this.height ;
    }
}
