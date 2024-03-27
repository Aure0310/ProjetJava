import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GameGrid {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private String[][] grid;
    private String currentPlayer;

    public GameGrid() {
        initializeGame();
        currentPlayer = "X"; // Commencez avec le joueur "X"
    }

    public void initializeGame() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(grid[i], "");
        }
    }

    public ImageIcon getDiscImage(int row, int column) {
        String disc = grid[row][column];
        String imagePath;

        if (disc.equals("X")) {
            imagePath = "/jetonrouge.png";
        } else if (disc.equals("O")) {
            imagePath = "/jetonjaune.png";
        } else {
            imagePath = "/grille.png";
        }

        File imageFile = new File(imagePath);

        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            return resizeImage(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture de l'image : " + imagePath);
            e.printStackTrace();
            return null;
        }
    }

    public String getDisc(int row, int column) {
        return grid[row][column];
    }
    private ImageIcon resizeImage(ImageIcon originalImage) {
        // Ajoutez la logique pour redimensionner l'image si nécessaire
        return originalImage;
    }

    public boolean isValidMove(int column) {
        return grid[0][column].equals("");
    }

    public void dropDisc(int column, String playerSymbol) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column].equals("")) {
                grid[i][column] = playerSymbol;
                break;
            }
        }
    }

    public boolean checkWin(String playerSymbol) {
        // Ajoutez la logique pour vérifier si le joueur a gagné
        return false;
    }

    public boolean isGridFull() {
        // Ajoutez la logique pour vérifier si la grille est pleine
        return false;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }
}
