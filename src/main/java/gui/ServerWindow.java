package gui;

import network.Server;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ServerWindow
{
    private JFrame frame = new JFrame();
    private JButton start_button;
    private JButton back_button;
    private JButton file_path_chooser_button;
    private JFileChooser file_path_chooser;
    private JTextField file_path_text_field;
    private JLabel label;


    public ServerWindow()
    {
        setWindow();
        setFrame();
    }

    private void setFrame()
    {
        frame.setTitle("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,800);
        frame.setVisible(true);
    }

    private void setWindow()
    {
        frame.setLayout(new GridBagLayout());

        JPanel center_panel = new JPanel();
        center_panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 2), BorderFactory.createEmptyBorder(10,10,10,10)));
        center_panel.setLayout(new GridBagLayout());
        GridBagConstraints center_panel_gridbag_constrains = new GridBagConstraints();
        center_panel_gridbag_constrains.insets = new Insets(5,5,5,5);

        label = new JLabel("Elija donde quiere guardar el archivo");
        center_panel_gridbag_constrains.gridx = 0;
        center_panel_gridbag_constrains.gridy = 0;
        center_panel_gridbag_constrains.gridwidth = 2;
        center_panel_gridbag_constrains.weightx = 1.0;
        center_panel.add(label, center_panel_gridbag_constrains);

        file_path_text_field = new JTextField(25);
        center_panel_gridbag_constrains.gridx = 0;
        center_panel_gridbag_constrains.gridy = 1;
        center_panel_gridbag_constrains.gridwidth = 1;
        center_panel_gridbag_constrains.weightx = 1;
        center_panel.add(file_path_text_field, center_panel_gridbag_constrains);

        file_path_chooser_button = new JButton("...");
        center_panel_gridbag_constrains.gridx = 1;
        center_panel_gridbag_constrains.weightx = 0;
        center_panel.add(file_path_chooser_button, center_panel_gridbag_constrains);
        file_path_chooser_button.addActionListener(e -> openFileChooser());

        JPanel button_panel = new JPanel();
        button_panel.setLayout(new FlowLayout());

        back_button = new JButton("Back");
        button_panel.add(back_button);
        back_button.addActionListener(e -> back());

        start_button = new JButton("Start");
        button_panel.add(start_button);
        start_button.addActionListener(e -> start(file_path_text_field.getText()));

        center_panel_gridbag_constrains.gridx = 0;
        center_panel_gridbag_constrains.gridy = 2;
        center_panel_gridbag_constrains.gridwidth = 2;
        center_panel_gridbag_constrains.fill = GridBagConstraints.NONE;
        center_panel.add(button_panel, center_panel_gridbag_constrains);

        frame.add(center_panel);
    }

    private void openFileChooser()
    {
        file_path_chooser = new JFileChooser();
        file_path_chooser.setDialogTitle("Select a directory");
        file_path_chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if(file_path_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File selected_file = file_path_chooser.getSelectedFile();
            file_path_text_field.setText(selected_file.getAbsolutePath());
        }
    }

    private void back()
    {
        int selection = JOptionPane.showConfirmDialog(frame, "Go back?", "Confirm", JOptionPane.YES_NO_OPTION);

        if(selection == JOptionPane.YES_OPTION)
        {
            new MainWindow();
            frame.dispose();
        }
    }

    private void start(String path)
    {
        JOptionPane.showMessageDialog(frame, "Server Started", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        new Server(path);

    }
}
