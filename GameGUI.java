import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameGUI extends JFrame {
    private Puissance4Game puissance4Game;

    public GameGUI(Puissance4Game puissance4Game) {
        super("Puissance 4");
        this.puissance4Game = puissance4Game;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public void showMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton newGameButton = new JButton("Nouvelle Partie");
        JButton loadGameButton = new JButton("Charger Partie");

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1Name = JOptionPane.showInputDialog("Entrez le nom du joueur 1");
                String player2Name = JOptionPane.showInputDialog("Entrez le nom du joueur 2");

                if (player1Name != null && player2Name != null) {
                    puissance4Game.startNewGame(player1Name, player2Name);
                    createGameBoard();
                    updateUI();
                }
            }
        });

        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajoutez la logique pour charger une partie
                // Vous pouvez utiliser des boîtes de dialogue pour sélectionner un fichier de sauvegarde, par exemple
            }
        });

        panel.add(newGameButton);
        panel.add(loadGameButton);

        add(panel);
        setVisible(true);
    }

public void createGameBoard() {
    // Chemin de l'image de la grille
    String cheminImageGrille = "/grille.png";

    // Chargement de l'image de la grille
    ImageIcon grilleIcon = new ImageIcon(getClass().getResource(cheminImageGrille));
    Image grilleImage = grilleIcon.getImage();

    // Création d'une ImageIcon avec l'image de la grille
    ImageIcon grilleImageIcon = new ImageIcon(grilleImage);

    // Création d'une étiquette pour afficher l'image de la grille
    JLabel grilleLabel = new JLabel(grilleImageIcon);

    // Ajout de l'étiquette au cadre
    add(grilleLabel);

    // Configuration du cadre
    pack();  // Ajuster la taille du cadre à celle de l'image
    setLocationRelativeTo(null);
    setVisible(true);
}

    public void updateUI() {
        for (int i = 0; i < GameGrid.ROWS; i++) {
            for (int j = 0; j < GameGrid.COLUMNS; j++) {
                String disc = game.getGameGrid().getDisc(i, j);
                setButtonIcon(i, j, disc);
            }
        }
    }

    public void displayWinner(String winnerName) {
        JOptionPane.showMessageDialog(frame, "Le joueur " + winnerName + " a gagné !", "Partie terminée", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }

    public void displayDraw() {
        JOptionPane.showMessageDialog(frame, "La partie est nulle !", "Partie terminée", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }

    private void setButtonIcon(int row, int column, String disc) {
        // Mettez à jour l'icône du bouton en fonction du jeton (disc)
        // Vous pouvez utiliser une logique similaire à celle de getDiscImage() dans GameGrid
        // Assurez-vous de redimensionner l'image si nécessaire
    }

    private void resetGame() {
        frame.dispose();
        initialize();
        game.startNewGame(game.getPlayer1Name(), game.getPlayer2Name());
    }
}
