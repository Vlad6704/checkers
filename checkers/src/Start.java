import javax.swing.*;
import java.awt.*;


public class Start {

    private CreateDesc CD = new CreateDesc();


    public Start() throws InterruptedException {
        JFrame jf = new JFrame("Box");
        jf.setSize(500, 500);
        jf.setLocation(600,500);
        jf.setVisible(true);
        jf.add(CD);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public static void main(String[] args) throws InterruptedException {
        Start mw = new Start();
    }


}