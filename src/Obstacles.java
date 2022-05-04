import java.util.Random;
import java.awt.*;

public class Obstacles implements MyPanels {


    private int _x, _y;
    public final int WIDTH = 20, HEIGHT = 10;
    public final int MAXHEIGHT = 400, MINHEIGHT = 100;//height
    public final int MIN_LOCATE = 0, MAX_LOCATE = MyPanels.WIDTH-WIDTH;//locate


    public Obstacles() {
        Random r = new Random();
        _x = new Random().nextInt(MIN_LOCATE, MAX_LOCATE);
        _y = r.nextInt(MINHEIGHT, MAXHEIGHT);

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(_x, _y, WIDTH, HEIGHT);

    }


    public void moveRight() {
        this._x++;
    }

    public void moveLeft() {
        this._x--;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }


}
