import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameGUI extends JFrame {
    private Puissance4Game puissance4Game;

    private JPanel gridPanel;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField player1TextField;
    private JTextField player2TextField;
    private JButton newGameButton;
    private JButton loadGameButton;

    public GameGUI(Puissance4Game puissance4Game) {
        this.puissance4Game = puissance4Game;
        initialize();
    }

    private void initialize() {
        setTitle("Puissance 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Création de la page d'accueil
        JPanel homePanel = createHomePanel();
        add(homePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        player1Label = new JLabel("Joueur 1 : ");
        panel.add(player1Label);

        player1TextField = new JTextField();
        panel.add(player1TextField);

        player2Label = new JLabel("Joueur 2 : ");
        panel.add(player2Label);

        player2TextField = new JTextField();
        panel.add(player2TextField);

        newGameButton = new JButton("Nouvelle Partie");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1Name = player1TextField.getText();
                String player2Name = player2TextField.getText();
                puissance4Game.startNewGame(player1Name, player2Name);
                createGameBoard();
            }
        });
        panel.add(newGameButton);

        loadGameButton = new JButton("Charger Partie");
        // Ajoutez un ActionListener pour charger une partie existante
        panel.add(loadGameButton);

        return panel;
    }

    public void createGameBoard() {
        // Chargement de l'image de la grille
        ImageIcon gridIcon = new ImageIcon(getClass().getResource("/grille.png"));

        // Création d'un JLabel pour afficher l'image de la grille
        JLabel gridLabel = new JLabel(gridIcon);

        // Ajustement de la taille de JLabel à la taille de l'image
        gridLabel.setPreferredSize(new Dimension(gridIcon.getIconWidth(), gridIcon.getIconHeight()));

        // Ajout du JLabel contenant l'image de la grille à la fenêtre
        add(gridLabel, BorderLayout.CENTER);

        // Redimensionnement de la fenêtre pour s'adapter à la taille de l'image de la grille
        pack();
    }

    public void updateUI() {
        // Appelez la méthode updateGameBoard en passant la grille de jeu actuelle
        GameGrid gameGrid = puissance4Game.getGameGrid();
        updateGameBoard(gameGrid);

        // Autres mises à jour de l'interface utilisateur si nécessaire
    }
    public void updateGameBoard(GameGrid gameGrid) {
        // Récupération de la grille actuelle du jeu
        String[][] grid = Puissance4Game.getGameGrid().getGrid();
        int rows = grid.length;
        int columns = grid[0].length;

        // Parcours de la grille et mise à jour de l'affichage des jetons
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Récupération du symbole du joueur à cette position
                String playerSymbol = grid[row][col];

                // Création du chemin de l'image du jeton en fonction du symbole du joueur
                String imagePath;
                if (playerSymbol.equals("X")) {
                    imagePath = "/jetonrouge.png";
                } else if (playerSymbol.equals("O")) {
                    imagePath = "/jetonjaune.png";
                } else {
                    // Si la case est vide, ne rien faire
                    continue;
                }

                // Chargement de l'image du jeton
                ImageIcon discIcon = new ImageIcon(getClass().getResource(imagePath));

                // Création d'un JLabel pour afficher l'image du jeton
                JLabel discLabel = new JLabel(discIcon);

                // Ajout du JLabel contenant l'image du jeton à la position correspondante sur la grille
                gridPanel.add(discLabel, new GridBagConstraints(col, row, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
            }
        }

        // Rafraîchissement de l'affichage
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void displayWinner(String winnerName) {
        // Affiche une boîte de dialogue indiquant le gagnant
        JOptionPane.showMessageDialog(null, "Le gagnant est : " + winnerName, "Partie terminée", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayDraw() {
        // Affiche une boîte de dialogue indiquant un match nul
        JOptionPane.showMessageDialog(null, "Match nul !", "Partie terminée", JOptionPane.INFORMATION_MESSAGE);
    }

    // Autres méthodes pour mettre à jour l'interface utilisateur, afficher le gagnant, etc.
}
