import javax.swing.*;

public class MyWindow extends JFrame implements MyPanels {
    private NewScene _panel;
    private int _level;
    public final int START_LEVEL = 1;

    public MyWindow() {
        _level = START_LEVEL;
        this.setSize(MyPanels.WIDTH, MyPanels.HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        _panel = new NewScene(_level);

        this.add(_panel);
        this.setVisible(true);
    }


    public static void main(String[] args) {

        MyWindow window = new MyWindow();
    }


}



