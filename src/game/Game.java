package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame {

    private JButton[] buttons;
    private char currentPlayer;

    private boolean gameEnded;
    private char[][] board;


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
        board = new char[3][3];

        for (int i = 0; i < buttons.length ; i++) {
            buttons[i] = new JButton();
            panel.add(buttons[i]);
        }
        // Adiciona o painel à janela principal
        getContentPane().add(panel, BorderLayout.CENTER);

        //Definir jogador
        Random random = new Random();
        currentPlayer = random.nextBoolean() ? 'X' : 'O';
        gameEnded = false;
    }

    private void buttonClicked(int index) {
        if(!gameEnded && board[index / 3][index % 3] == '\0') {
            buttons[index].setText(String.valueOf(currentPlayer));
            board[index/3][index%3] = currentPlayer;
        }
    }
    private boolean checkWinner(char player) {

    }
    private boolean isBoardFull() {

    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

}
