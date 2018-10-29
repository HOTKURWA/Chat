package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class RegisterWindow {

    public void one() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setTitle("Регистрация");

        JPanel panel = new JPanel();

        frame.add(panel);

        Box NameBox = Box.createHorizontalBox();
        Box LoginBox = Box.createHorizontalBox();
        Box PasswordBox = Box.createHorizontalBox();

        JLabel RegisterText = new JLabel("Регистрация");
        RegisterText.setFont(new Font("Serif",Font.PLAIN,25));
        JLabel NameLabel = new JLabel("Имя: ");
        JLabel loginLabel = new JLabel("Логин: ");
        JLabel PasswordLabel = new JLabel("Пароль: ");

        JTextField NameField = new JTextField(10);
        JTextField LoginField = new JTextField(10);
        JPasswordField PasswordField = new JPasswordField(10);

        JButton RegisterButton = new JButton("OK");

        //panel.setBackground(Color.pink);
        RegisterButton.setBackground(Color.WHITE);

        NameBox.add(NameLabel);
        NameBox.add(NameField);
        LoginBox.add(loginLabel);
        LoginBox.add(LoginField);
        PasswordBox.add(PasswordLabel);
        PasswordBox.add(PasswordField);

        panel.add(RegisterText);
        panel.add(NameBox);
        panel.add(LoginBox);
        panel.add(PasswordBox);
        panel.add(RegisterButton);

        frame.setVisible(true);

        RegisterButton.addActionListener((ActionEvent e) -> {

            String StringName = (NameField.getText());
            String StringLogin = (LoginField.getText());
            String StringPassword = (PasswordField.getText());
           
        int i = 0;
        String[] regex = new String[5];
        
        if( StringPassword.length() >= 8 )      //проверка пароля на "сложность"
        {
            regex[0] = ("(\\w*)([a-z]+)(\\w*)");
            regex[1] = ("(\\w*)([A-Z]+)(\\w*)");
            regex[2] = ("(\\w*)([0-9]+)(\\w*)");
            
            for( int n = 0; n < 3; n++ )
            {
                Pattern pattern = Pattern.compile(regex[n]);
                Matcher matcher = pattern.matcher(StringPassword);
                
                if(matcher.matches()) 
                    i++;
            }
            
            if(i == 3)
            {
                System.out.println("Введен надежный пароль");
                                                                                                    // Добавить запись ноового пользователя в бд
//                System.out.println(StringName + "\n" + StringLogin + "\n" + StringPassword);
                LoginPanel login = new LoginPanel();
                login.connect();
                frame.dispose();
            }
            else
                System.out.println("Введен не надежный пароль");
        }
        else
            System.out.println("Введенный пароль меньше 8 символов");
        });
    }
}
