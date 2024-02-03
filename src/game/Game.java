package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame {

    private JButton[] buttons;
    private char currentPlayer;


    public Game() {
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,3));

        buttons = new JButton[9];
        for (int i = 0; i < buttons.length ; i++) {
            buttons[i] = new JButton();
            panel.add(buttons[i]);
        }
        // Adiciona o painel à janela principal
        getContentPane().add(panel, BorderLayout.CENTER);

        //Definir jogador
        Random random = new Random();
        currentPlayer = random.nextBoolean() ? 'X' : 'O';
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

}
