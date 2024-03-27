public class Puissance4Game {
    private static GameGrid gameGrid;
    private GameGUI gameGUI;
    private String player1Name;
    private String player2Name;
    private boolean isPlayer1Turn;

    public Puissance4Game() {
        gameGrid = new GameGrid();
        gameGUI = new GameGUI(this);
    }

    public void startGame() {
        gameGUI.createHomePanel();
    }

    public void startNewGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        isPlayer1Turn = true;

        gameGrid.initializeGame();
        gameGUI.createGameBoard();
        gameGUI.updateUI();
    }

    public void updateUI() {
        gameGUI.updateGameBoard(gameGrid); // Met à jour l'interface utilisateur avec l'état actuel de la grille de jeu
    }

    public void displayWinner(String winnerName) {
        gameGUI.displayWinner(winnerName); // Affiche une boîte de dialogue indiquant le gagnant
    }

    public void displayDraw() {
        gameGUI.displayDraw(); // Affiche une boîte de dialogue indiquant un match nul
    }

    public void makeMove(int column) {
        if (gameGrid.isValidMove(column)) {
            gameGrid.dropDisc(column, isPlayer1Turn ? "X" : "O");
            if (gameGrid.checkWin(isPlayer1Turn ? "X" : "O")) {
                gameGUI.displayWinner(isPlayer1Turn ? player1Name : player2Name);
            } else if (gameGrid.isGridFull()) {
                gameGUI.displayDraw();
            } else {
                isPlayer1Turn = !isPlayer1Turn;
                gameGUI.updateUI();
            }
        }
    }

    public static GameGrid getGameGrid() {
        return gameGrid;
    }
}
