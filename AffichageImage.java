import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;

public class AffichageImage extends JFrame {

    public AffichageImage() {
        super("Affichage de l'image");

        // Chemin de l'image
        String cheminImage = "/grille.png";

        // Chargement de l'image
        ImageIcon icon = new ImageIcon(getClass().getResource(cheminImage));
        Image image = icon.getImage();

        // Définir les dimensions maximales pour la mise à l'échelle
        int maxWidth = 800;
        int maxHeight = 600;

        // Mise à l'échelle de l'image tout en préservant les proportions
        Image scaledImage = image.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);

        // Création d'une nouvelle ImageIcon avec l'image mise à l'échelle
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Création d'une étiquette pour afficher l'image mise à l'échelle
        JLabel label = new JLabel(scaledIcon);

        // Ajout de l'étiquette au cadre
        add(label);

        // Configuration du cadre
        setSize(maxWidth, maxHeight); // Ajuster la taille du cadre à celle de l'image mise à l'échelle
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}