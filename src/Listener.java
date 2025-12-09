import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Listener implements ActionListener {

    int[] bombIndex = new int[3];
    int secretIndex;
    int index = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        int btnName = Integer.parseInt(btn.getName());
        System.out.println(btnName);
        if (btnName == secretIndex) { // secret found
            btn.setBackground(Color.MAGENTA);
            btn.setText("SECRET");

            // Get goomba image URl
            java.net.URL imgURL = getClass().getResource("/images/goomba2.png");

            // Load the original image icon
            ImageIcon originalIcon = new ImageIcon(imgURL);

            // Scale the image
            Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(
                    null,
                    "YOU FOUND GOOMBA SECRET!",
                    "Secret Found!",
                    JOptionPane.INFORMATION_MESSAGE,
                    scaledIcon);
            System.exit(0);
        } else if (btnName == bombIndex[0] || btnName == bombIndex[1] || btnName == bombIndex[2]) { // bomb index found
            btn.setBackground(Color.RED);
            btn.setText("BOMB");
            // Get bomb image URl
            java.net.URL imgURL = getClass().getResource("/images/bomb.png");

            // Load the original image icon
            ImageIcon originalIcon = new ImageIcon(imgURL);

            // Scale the image
            Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(
                    null,
                    "YOU FOUND A BOMB",
                    "Secret Found!",
                    JOptionPane.INFORMATION_MESSAGE,
                    scaledIcon);
            System.exit(0);
        } else { // safe spot
            btn.setBackground(Color.GREEN);
            btn.setText("Safe");
        }
        btn.setEnabled(false);
    }

    public void addBombIndex(int i) {
        bombIndex[index] = i;
        index++;
    }

    public void addSecretIndex(int i) {
        secretIndex = i;
    }

}
