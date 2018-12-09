import javax.swing.*;


public class Main extends JFrame{

    public static void main(String[] args) {

        Main drawer = new Main();
        drawer.setSize(300,300);
        drawer.setTitle("Shapes GUI");
        MyPanel myPanel = new MyPanel();

        drawer.add(myPanel);

        drawer.setVisible(true);
        drawer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
