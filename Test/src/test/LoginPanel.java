package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class LoginPanel {
    
    public void connect()
    {
        main(null);
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setTitle("Вход");
        
        JPanel panel = new JPanel();
        
        frame.add(panel);
        
        Box LoginBox = Box.createHorizontalBox();
        Box PasswordBox = Box.createHorizontalBox();
        
        JLabel LoginText = new JLabel("Вход"+"\n");
        LoginText.setFont(new Font("Serif",Font.PLAIN,25));
        JLabel loginLabel = new JLabel("Логин: ");
        JLabel PasswordLabel = new JLabel("Пароль: ");
        
        JTextField LoginField = new JTextField(10);
        JPasswordField PasswordField = new JPasswordField(10);
       
        JButton RegisterButton = new JButton("Регистрация");
        JButton LoginButton = new JButton("Войти");
                
       // panel.setBackground(Color.cyan);
        LoginButton.setBackground(Color.WHITE);
        RegisterButton.setBackground(Color.WHITE);

        
        LoginBox.add(loginLabel);           LoginBox.add(LoginField);
        
        PasswordBox.add(PasswordLabel);     PasswordBox.add(PasswordField);
        
        panel.add(LoginText);
        panel.add(LoginBox);
        panel.add(PasswordBox);
        panel.add(RegisterButton);
        panel.add(LoginButton);
       
        
        frame.setVisible(true);
            
        RegisterButton.addActionListener((ActionEvent e) -> {
            System.out.println("Register");
            RegisterWindow reg = new RegisterWindow();
            reg.one();
            frame.dispose();
        });
        
        
        LoginButton.addActionListener((ActionEvent e) -> {

            String StringLogin = (LoginField.getText());
            String StringPassword = (PasswordField.getText());
            if(     ((StringLogin.equals("a"))&(StringPassword.equals("a")))
                ||  ((StringLogin.equals("Андрей"))&(StringPassword.equals("123")))
                ||  ((StringLogin.equals("Кирилл"))&(StringPassword.equals("123")))
                ||  ((StringLogin.equals("Паша"))&(StringPassword.equals("123"))))
            {
                System.out.println("voshel");
                MainWindow main = new MainWindow();
                main.one(StringLogin);
                frame.dispose();
            }
        });
    }
}