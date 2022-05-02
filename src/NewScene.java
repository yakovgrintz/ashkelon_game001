import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NewScene extends JPanel implements MyPanels {
    private BallStack _ballStack;
    private Obstacles _obstacles;
private int _level;
    public NewScene(int level){_level=level;
        this.setBackground(new Color(15, 238, 215, 255));
        this.setBounds(MyPanels.X,MyPanels.Y,MyPanels.WIDTH,MyPanels.HIGH);
        this.setLayout(null);
        this._obstacles=new Obstacles();
        AtomicInteger num = new AtomicInteger(2);
        new Thread(()->{
            while(true){
                while(_obstacles.getX()<=this.getWidth()-_obstacles.WIDTH){
                    try{

                                _obstacles.moveRight();
                                repaint();
                            Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }while(_obstacles.getX()>=0){
                    try{

                        _obstacles.moveLeft();
                        repaint();

                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        JButton gun = new JButton(new ImageIcon("icons/gun.jpg"));
        gun.setBounds((MyPanels.WIDTH-gun.getIcon().getIconWidth())/2,(MyPanels.HIGH-gun.getIcon().getIconHeight()-50),gun.getIcon().getIconWidth(),gun.getIcon().getIconHeight());
        _ballStack=new BallStack(level*50,(gun.getX()+gun.getWidth())/2,gun.getY());
        gun.addActionListener( (event)->{
try {
    moveBall(_ballStack.pop());
}catch (Exception e){
    System.out.println("המחסנית שלך גמורה");
}
        });
            this.add(gun);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        _obstacles.paint(g);
        BallStack temp=new BallStack();
        while (!_ballStack.isEmpty()){
            newBall ballTemp=_ballStack.pop();
            ballTemp.paint(g);
            temp.push(ballTemp);
        }
        while (!temp.isEmpty()){
            _ballStack.push(temp.pop());
        }



}
private void moveBall(newBall ball){
    new Thread(()->{
        while (true) {
        try {

            ball.moveUp();
            repaint();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }}).start();
}
    }