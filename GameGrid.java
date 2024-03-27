public class GameGrid {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private String[][] grid;

    public void initializeGame() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "";
            }
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && grid[0][column].equals("");
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
        // Ajouter la logique pour vérifier si le joueur a gagné
        return false;
    }

    public boolean isGridFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (grid[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}
