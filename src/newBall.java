import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class newBall {
    public final Color[] ballColor = {Color.YELLOW, Color.MAGENTA};
    private int _x, _y;
    public final int WIDTH = 3, HEIGHT = 5;

    public newBall(int x, int y) {
        _x = x;
        _y = y;


    }

    public newBall(newBall ball) {
        _x = ball._x;
        _y = ball._y;
    }

    public void paint(Graphics g) {
        g.setColor(ballColor[new Random().nextInt(ballColor.length)]);
        g.fillRect(this._x, this._y, WIDTH, HEIGHT);
    }

    public void moveUp() {
        this._y--;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public boolean checkCollision(Obstacles obstacles) {
        Rectangle obstRect = new Rectangle(obstacles.getX(), obstacles.getY(), obstacles.WIDTH, obstacles.HEIGHT);
        Rectangle ballRect = new Rectangle(this._x, this._y, WIDTH, HEIGHT);
        if (ballRect.intersects(obstRect)) {
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void remove() {
        _x = -100;
        _y = -100;
    }

    public boolean checkFinishLine(FinishLine line) {
        Rectangle ball = new Rectangle(this._x, this._y, WIDTH, HEIGHT);
        Rectangle lineRect = new Rectangle(new Point(line.X1, line.Y1), new Dimension(line.X2 - line.X1, 1));
        if (ball.intersects(lineRect)) {
            return true;
        }
        return false;
    }
}
