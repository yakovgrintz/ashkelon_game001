import javax.swing.*;
public class MyWindow extends JFrame implements MyPanels{
    public MyWindow(){

            this.setSize( MyPanels.WIDTH, MyPanels.HIGH);
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
