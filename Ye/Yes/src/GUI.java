import javax.swing.JFrame;

public class GUI {
    JFrame myFrame;
     GUI(){
        myFrame = new JFrame("Hello world");
        myFrame.setSize(400, 400);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(2);
    }
    public static void main(String[] args) {
        new GUI();
    
    
    }
}
