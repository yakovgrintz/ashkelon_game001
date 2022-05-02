import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NewScene extends JPanel implements MyPanels {
    private newBall[] _ballStack;
    private Obstacles[] _obstacles;
    private FinishLine _finishLine;
    private JLabel _myCounter;//MYcounterLabel _myCounter;
    public final String PART1 = "your ball :";
    private String part2;
    private String part3;

    public final int numOfBalls=25,NUM_OF_OBSTACALES=3;


    private int _level;
    public NewScene(int level){
        _level=level;


        this.setBackground(new Color(15, 238, 215, 255));
        this.setBounds(MyPanels.X,MyPanels.Y,MyPanels.WIDTH,MyPanels.HIGH);
        this.setLayout(null);this.part3="/"+level*25;
        this.part2="0";
        _myCounter= new JLabel(""+PART1+part2+part3 );
        _myCounter.setBounds(0,0,MyPanels.WIDTH,20);
        _myCounter.setFont(new Font("David",Font.BOLD,20));
        this.add(_myCounter);

        this._obstacles= new Obstacles[_level*NUM_OF_OBSTACALES];
        for (int i = 0; i < _obstacles.length; i++) {
            _obstacles[i]=new Obstacles();
            moveObstacels(_obstacles[i]);
        }
        this._finishLine=new FinishLine();

        JButton gun = new JButton(new ImageIcon("icons/gun.jpg"));
        gun.setBounds((MyPanels.WIDTH/2-gun.getIcon().getIconWidth()/2),(MyPanels.HIGH-gun.getIcon().getIconHeight()-50),gun.getIcon().getIconWidth(),gun.getIcon().getIconHeight());
        this._ballStack =new newBall[_level*numOfBalls];
        for (int i = 0; i < _ballStack.length; i++) {
            _ballStack[i]=new newBall(gun.getX()+gun.getWidth()/2,gun.getY());
        }
        AtomicInteger numOfBall= new AtomicInteger();
        gun.addActionListener( (event)->{

    try {
    moveBall(_ballStack[numOfBall.get()]);
    numOfBall.getAndIncrement();
    }catch (Exception e){
    System.out.println("המחסנית שלך גמורה");
    }
        });

            this.add(gun);
    }
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



}
public void gameLoop(){
        new Thread(()->{
        while (true){}
        }).start();
}
private void moveBall(newBall ball){
    new Thread(()->{
        while (!ceckColisionBallTobstacels(ball)&&!ball.checkFinishLine(_finishLine)) {
        try {

            ball.moveUp();
            repaint();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(ceckColisionBallTobstacels(ball)){
            try{

            ball.remove();
            repaint();

        }catch (Exception e) {
            e.printStackTrace();
        }}
        if (ball.checkFinishLine(_finishLine)){
            ball.remove();
            repaint();
            int counter;
            try {
                counter = Integer.parseInt(this.part2);
                counter++;

            } catch (Exception e) {
                counter = 0;
            }
            this.part2=String.valueOf(counter);
            _myCounter.setText(""+PART1+part2+part3);
        }
    }}).start();
}
private void moveObstacels(Obstacles _obstacles){
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
}
private boolean ceckColisionBallTobstacels(newBall ball){
    for (int i = 0; i < _obstacles.length; i++) {
        if (ball.checkCollision(_obstacles[i])==true){
            return true;
        }
    }
        return false;
}
    }