package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.*;

public class MainWindow
{
    static void main()
    {
        JFrame frame = setFrame();
        setWindow(frame);
        frame.pack();
    }

    private static JFrame setFrame()
    {
        JFrame frame = new JFrame();
        frame.setTitle("JTransfer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
        return frame;
    }

    private static void setWindow(JFrame frame)
    {
        frame.getContentPane().setBackground(Color.darkGray);
        JLabel label = new JLabel();
        label.setText("Eliga el modo que va a usar");
        label.setForeground(Color.white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setVerticalAlignment(JLabel.CENTER);
        frame.add(label);
    }
}
