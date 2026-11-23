package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static JButton client_button;
    private static JButton server_button;
    private static JPanel north_panel;
    private static JPanel center_panel;


    public MainWindow() {
        setFrame(this);
        setWindow(this);
    }

    private static void setFrame(JFrame frame) {
        frame.setTitle("JTransfer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    private void setWindow(JFrame frame)
    {
        frame.setLayout(new BorderLayout());

        north_panel = new JPanel();
        north_panel.setBackground(Color.blue);
        JLabel label = new JLabel();
        label.setText("Eliga el modo que va a usar");
        label.setForeground(Color.white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        north_panel.add(label);
        frame.add(north_panel, BorderLayout.NORTH);

        center_panel = new JPanel();
        center_panel.setBackground(Color.red);
        center_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        client_button = new JButton();
        buttonSetup(client_button, "Cliente");
        client_button.addActionListener(e -> switchWindow(client_button));

        server_button = new JButton();
        buttonSetup(server_button, "Servidor");
        server_button.addActionListener(e -> switchWindow(server_button));

        center_panel.add(client_button);
        center_panel.add(server_button);

        frame.add(center_panel);
    }

    private static void buttonSetup(JButton button, String text)
    {
        button.setBounds(100, 100, 250, 100);
        button.setText(text);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    private void switchWindow(JButton button)
    {
        if(button == client_button)
        {
            new ClientWindow();
            this.dispose();
        } else if(button == server_button)
        {
            new ServerWindow();
            this.dispose();
        } else
        {
            JOptionPane.showMessageDialog(this, "Option error, please select a valid option", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
