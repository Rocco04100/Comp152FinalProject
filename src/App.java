import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.GridLayout;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame mainWindow = new JFrame();
        Listener L = new Listener();
        mainWindow.setLayout(new GridLayout(8, 8));
        JButton[] buttons = new JButton[64];

        for (int i = 0; i < 64; i++) {
            buttons[i] = new JButton("Click me!");
            buttons[i].setSize(20, 20);
            buttons[i].setName("" + i);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(true);
            buttons[i].setFocusPainted(false);
            buttons[i].setFocusable(false);
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            mainWindow.add(buttons[i]);
            buttons[i].addActionListener(L);
        }
        System.out.print("BOMB INDICES: ");
        for (int i = 0; i < 3; i++) {
            int bombIndex = (int) (Math.random() * 64);
            L.addBombIndex(bombIndex);
            System.out.print(L.bombIndex[i] + ", ");
        }
        System.out.println();
        int secretIndex = (int) (Math.random() * 64);
        L.addSecretIndex(secretIndex);
        System.out.println("SECRET INDEX: " + secretIndex);

        mainWindow.setSize(900, 900);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
}
