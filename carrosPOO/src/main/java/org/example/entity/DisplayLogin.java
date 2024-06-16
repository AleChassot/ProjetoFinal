package org.example.entity;

import org.example.dao.UserDAO;
import org.example.model.RentACar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayLogin extends JFrame implements ActionListener {

    private JTextField userTx = new JTextField(15);
    private JPasswordField passTx = new JPasswordField(15);
    private JButton login = new JButton("Logar");

    public DisplayLogin() {
        setTitle("Login");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        displayPanel.add(new JLabel("Usuário: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        displayPanel.add(userTx, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        displayPanel.add(new JLabel("Senha: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        displayPanel.add(passTx, gbc);

        login.setPreferredSize(new Dimension(80, 30));
        buttonPanel.add(login);

        getContentPane().add(displayPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        login.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String user = userTx.getText();
            String password = new String(passTx.getPassword());

            UserDAO con = new UserDAO();
            if(con.validateLogin(user,password)){
                JOptionPane.showMessageDialog(this, "Conectado com sucesso");
                this.dispose();
                new DisplayRent();
            }else{
                JOptionPane.showMessageDialog(this,"Usuário ou senha estão incorretos");
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayLogin());
    }
}
