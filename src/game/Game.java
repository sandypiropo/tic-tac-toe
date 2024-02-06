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
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonClicked(index);
                }
            });
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
            if (checkWinner(currentPlayer)) {
                JOptionPane.showMessageDialog(this, "Jogador " + currentPlayer + " venceu!");
                gameEnded = true;
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "Empate!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
    private boolean checkWinner(char player) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // Verificar diagonais
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

}
