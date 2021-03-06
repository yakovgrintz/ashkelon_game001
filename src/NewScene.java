import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewScene extends JPanel implements MyPanels {
    private newBall[] _ballStack;
    private Obstacles[] _obstacles;
    private FinishLine _finishLine;
    private JLabel _myCounter;//MYcounterLabel _myCounter;
    public final String PART1 = "your ball :";
    private String part2 ,part3;
    private Boolean _isRun, _closeWindow;
    public final int numOfBalls = 25, NUM_OF_OBSTACALES = 3, X_OF_BALL = MyPanels.WIDTH / 2, Y_OF_BALL = 420;


    private int _level;

    public NewScene(int level) {
        _level = level;
        _isRun = true;
        _closeWindow = false;
        loopGame(_level);
        this.setBackground(new Color(15, 238, 215, 255));
        this.setBounds(MyPanels.X, MyPanels.Y, MyPanels.WIDTH, MyPanels.HIGH);
        this.setLayout(null);
        _myCounter.setBounds(0, 0, MyPanels.WIDTH, 20);
        _myCounter.setFont(new Font("David", Font.BOLD, 20));
        this.add(_myCounter);
        JButton gun = new JButton(new ImageIcon("icons/gun.jpg"));
        gun.setBounds((MyPanels.WIDTH / 2 - gun.getIcon().getIconWidth() / 2), (MyPanels.HIGH - gun.getIcon().getIconHeight() - 50), gun.getIcon().getIconWidth(), gun.getIcon().getIconHeight());

        AtomicInteger numOfBall = new AtomicInteger();
        numOfBall.set(0);
        gun.addActionListener((event) -> {

            try {
                moveBall(_ballStack[numOfBall.get()], numOfBall.get() == _ballStack.length - 1);

                numOfBall.getAndIncrement();

            } catch (Exception e) {

            }
        });

        this.add(gun);
    }//end of constructor

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < _obstacles.length; i++) {
            _obstacles[i].paint(g);
        }
        for (int i = 0; i < _ballStack.length; i++) {
            _ballStack[i].paint(g);
        }
        _finishLine.paint(g);
        _myCounter.paint(g);
    }//end of paint component

    private void moveBall(newBall ball, boolean end) {
        new Thread(() -> {
            while (!ceckColisionBallTobstacels(ball) && !ball.checkFinishLine(_finishLine)) {
                try {
                    ball.moveUp();
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (end) {
                    checkGameOver(ball);

                }
                if (ceckColisionBallTobstacels(ball)) {


                    ball.remove();
                    repaint();

                }
                if (ball.checkFinishLine(_finishLine)) {
                    ball.remove();
                    repaint();
                    int counter;
                    try {
                        counter = Integer.parseInt(this.part2);
                        counter++;

                    } catch (Exception e) {
                        counter = 0;
                    }
                    this.part2 = String.valueOf(counter);
                    _myCounter.setText("" + PART1 + part2 + part3);
                }
            }
        }).start();
    }//end of move ball

    private void moveObstacels(Obstacles _obstacles) {
        new Thread(() -> {
            while (_isRun) {
                while (_obstacles.getX() <= this.getWidth() - _obstacles.WIDTH) {
                    try {
                        if (_isRun == false) {
                            break;
                        }
                        _obstacles.moveRight();
                        repaint();
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                while (_obstacles.getX() >= 0) {
                    try {
                        if (_isRun == false) {
                            break;
                        }
                        _obstacles.moveLeft();
                        repaint();

                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }//end of move obstacles

    private boolean ceckColisionBallTobstacels(newBall ball) {
        for (int i = 0; i < _obstacles.length; i++) {
            if (ball.checkCollision(_obstacles[i]) == true) {
                return true;
            }
        }
        return false;
    }

    private void checkGameOver(newBall ball) {
        if (ceckColisionBallTobstacels(ball) || (ball.checkFinishLine(_finishLine) && Integer.parseInt(
                this.part2) != Integer.parseInt(this.part3.substring(1)) - 1)) {
            System.out.println("game Over");
            ball.remove();
            _isRun = false;


            JOptionPane.showMessageDialog(new JFrame(),
                    "Game Over ",
                    "game Over",
                    JOptionPane.PLAIN_MESSAGE);
            _closeWindow = true;

        }
        if (ball.checkFinishLine(_finishLine) && Integer.parseInt(
                this.part2) == Integer.parseInt(this.part3.substring(1)) - 1) {
            _isRun = false;
            JOptionPane.showMessageDialog(new JFrame(),
                    "Well done! You succeeded in the game!",
                    "Well done!",
                    JOptionPane.PLAIN_MESSAGE);
            _closeWindow = true;

        }

    }

    public boolean getCloseWindow() {
        return _closeWindow;
    }

    public void loopGame(int level) {
        this.part3 = "/" + level * 25;
        this.part2 = "0";
        _myCounter = new JLabel("" + PART1 + part2 + part3);
        this._obstacles = new Obstacles[_level * NUM_OF_OBSTACALES];
        for (int i = 0; i < _obstacles.length; i++) {
            _obstacles[i] = new Obstacles();
            moveObstacels(_obstacles[i]);
        }
        this._finishLine = new FinishLine();
        this._ballStack = new newBall[_level * numOfBalls];
        for (int i = 0; i < _ballStack.length; i++) {
            _ballStack[i] = new newBall(X_OF_BALL, Y_OF_BALL);
        }
    }




}//end of class
