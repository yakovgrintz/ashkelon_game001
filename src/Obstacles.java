import java.util.Random;
import java.awt.*;

public class Obstacles {
    public int getX;
    private int _x;
    private int _y;
    public final int MAXHEIGHT = 400,MINHEIGHT =100;
    public final int MIN_LOCATE=0,MAX_LOCATE=380;
    public final int WIDTH=20,HEIGHT=10;
    public Obstacles(){
        Random r=new Random();
        _x=new Random().nextInt(MIN_LOCATE,MAX_LOCATE);
        _y=r.nextInt(MINHEIGHT,MAXHEIGHT);

    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(_x,_y,WIDTH,HEIGHT);

    }
    public boolean checkCollision(newBall ball){
        Rectangle obstRect = new Rectangle(_x,_x,WIDTH,HEIGHT);
        Rectangle ballRect = new Rectangle((int) ball.getX(), (int) ball.getY(),ball.getWIDTH(),ball.getHEIGHT());
        if(obstRect.intersects(ballRect)){
            return true;
        }
        else{
            return false;
        }
    }
public void move(int num){

        switch (num){
            case 1:
                moveRight();break;
            case 2:
                moveLeft();break;
        }
}
    public void moveRight() {
        this._x++;
    }
    public void moveLeft(){
        this._x--;
    }
    public int getX() {
        return _x;
    }


}
