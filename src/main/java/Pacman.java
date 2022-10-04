import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Pacman extends JFrame {

    Image icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/pacman.png"))).getImage();

    public Pacman() {
        playSound("/sounds/theme.wav");
        add(new Model());
    }

    public static void main(String[] args) {
        Pacman pac = new Pacman();
        pac.setVisible(true);
        pac.setSize(380,420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setIconImage(pac.icon);
        pac.setTitle("Pacman Game");
        pac.setLocationRelativeTo(null);

    }

    private void playSound(String url) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(this.getClass().getResourceAsStream(url)));
            clip.open(inputStream);
            clip.start();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
