import javax.swing.*;
public class MyWindow extends JFrame{
    public static final  int WIDTH=1000,HEIGHT=500;
    public MyWindow(){

            this.setSize( WIDTH, HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.add(new NewScene(1));

        this.setVisible(true);
    }

    public static void main(String[] args) {

        MyWindow window=new MyWindow();
    }


}
