package aula.camila;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

    private JPanel contentPane;

    public Tela() {
        initialize();
    }

    private void initialize() {
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600,300);
            setLocation(300,300);
            setUndecorated(true);

            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            setContentPane(contentPane);

        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ocorreu um problema contate o desenvolvimento","Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}