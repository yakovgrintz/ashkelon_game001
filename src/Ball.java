import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Ball extends Rectangle {
    //private Rectangle _ball;
private Color _color;
public final int WIDTH=3,HEIGHT=5;

public final Color[] ballColor={ Color.YELLOW,Color.MAGENTA};
public Ball(int x,int y){
    super(x,y,3,5);

    _color=randomColorFromArray(ballColor);
    new Thread(()->{
        while(true){
            try{
                this.moveUp();
                //repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }).start();

}
public void paint(Graphics g){
    g.setColor(_color);
    g.fillRect((int)this.getX(),(int)this.getY(),WIDTH,HEIGHT);

}
    public void moveUp () {
       this.setLocation((int) this.getX(), (int) this.getY()-1);
    }
    private Color randomColorFromArray(Color[] arr){
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
         return arr[randomNumber];
    }

    public int getWIDTH() {
    return 0;
    }

    public int getHEIGHT() {
    return 0;
    }
}
