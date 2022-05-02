import javax.swing.*;
import java.awt.*;

public class Scene_game extends JPanel {
private Ball[] ballIst;
private Obstacles[] obstacles;
    public static final int WIDTH = 1000, HIGH = 500;

    public Scene_game(){
        this.setBackground(Color.RED);
        this.setBounds(0, 0, WIDTH, HIGH);
        this.setLayout(null);
        JButton button1 = new JButton("start game");
        button1.setIcon(new ImageIcon("icons/gun.jpg"));
        button1.setBackground(null);
        button1.setBorder(null);
        button1.setBounds(450, 400, 100, 40);
        this.add(button1);
        this.ballIst=new Ball[25];
        for (int i=0;i<ballIst.length;i++){
            ballIst[i]=new Ball(button1.getX(),button1.getY());
        }
        int sumOfBalls=0;
        button1.addActionListener((event) -> {
        while (sumOfBalls<ballIst.length){
            movmentUp(ballIst[sumOfBalls]);
        }

        });

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0;i<ballIst.length;i++){
            ballIst[i].paint(g);
        }

    }
    private  void movmentUp(Ball obj){
        try{
            new Thread(()->{
                while(true){
                    try{
                        obj.moveUp();
                        repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void loopGame(){

    }
    }//end of class

