package gui;

import network.Client;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ClientWindow
{
    private JButton back_button;
    private JButton start_button;
    private JTextField file_path_text_field;
    private FileDialog file_path_chooser;
    private JButton file_path_chooser_button;
    private JLabel label;
    private JFrame frame = new JFrame();

    public ClientWindow()
    {
        setWindow(frame);
        setFrame(frame);
        frame.setVisible(true);
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
        frame.setLayout(new GridBagLayout());

        JPanel center_panel = new JPanel();
        center_panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 2), BorderFactory.createEmptyBorder(10,10,10,10)));
        center_panel.setLayout(new GridBagLayout());
        GridBagConstraints center_panel_gridbag_constrains = new GridBagConstraints();
        center_panel_gridbag_constrains.insets = new Insets(5,5,5,5);

        label = new JLabel("Elija el archivo que quiere enviar");
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
        start_button.addActionListener(e -> start());

        center_panel_gridbag_constrains.gridx = 0;
        center_panel_gridbag_constrains.gridy = 2;
        center_panel_gridbag_constrains.gridwidth = 2;
        center_panel_gridbag_constrains.fill = GridBagConstraints.NONE;
        center_panel.add(button_panel, center_panel_gridbag_constrains);

        frame.add(center_panel);
    }

    private void openFileChooser()
    {
        file_path_chooser = new FileDialog(frame, "Select a file");
        file_path_chooser.setVisible(true);
        String directory = file_path_chooser.getDirectory();
        String filename = file_path_chooser.getFile();

        if(directory != null && filename != null)
        {
            File selected_file = new File(directory, filename);
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

    private void start()
    {
        new Client();
    }
}
