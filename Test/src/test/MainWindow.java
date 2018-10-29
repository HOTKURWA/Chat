package test;

import javax.swing.JFrame;

public class MainWindow {
    public void one(String UserName)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setTitle("Чат для "+UserName);
        
        frame.setVisible(true);
    }
}

