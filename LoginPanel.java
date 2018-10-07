package test;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setTitle("Вход");
        
        JPanel panel = new JPanel();
        frame.add(panel);
        JTextField LoginField = new JTextField(10);
        JPasswordField PasswordField = new JPasswordField(10);
        JButton LoginButton = new JButton("Войти");
        LoginButton.setBackground(Color.WHITE);

        panel.add(LoginField);
        panel.add(PasswordField);
        panel.add(LoginButton);
        frame.setVisible(true);
            
        LoginButton.addActionListener(e -> {

            String StringLogin = (LoginField.getText());
            String StringPassword = (PasswordField.getText());
            if((StringLogin.equals("a"))&(StringPassword.equals("a")))
            {
                System.out.println("Login");
                MainWindow main = new MainWindow();
                main.one(StringLogin);
            }
        });
    }
}