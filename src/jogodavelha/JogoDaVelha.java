package jogodavelha;

import javax.swing.*;

public class JogoDaVelha extends JFrame{

    JButton[] button = new JButton[9];
    public JogoDaVelha() {
        setTitle("Jogo da Velha");
        setBounds(300,400,600,430);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[cont] = new JButton();
                add(button[cont]);
                button[cont].setBounds((100*i) + 50, (100 * j) + 50, 95, 95);
                cont++;
            }
        }
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
