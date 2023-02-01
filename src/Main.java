import javax.swing.*;

class FrameInit extends JFrame {
    public FrameInit() {
        this.setLayout(null);

        JButton button = new JButton("버튼");
        button.setBounds(100, 100, 50, 50);
        this.add(button);




        setSize(300, 200);
        setTitle("SmartPicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
public class Main {
    public static void main(String[] args) {
        FrameInit f = new FrameInit();

    }
}