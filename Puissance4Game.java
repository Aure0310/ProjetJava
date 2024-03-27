public class Puissance4Game {
    private GameGrid gameGrid;
    private GameGUI gameGUI;
    private DatabaseManager databaseManager;
    private String player1Name;
    private String player2Name;
    private boolean isPlayer1Turn;

    public Puissance4Game() {
        gameGrid = new GameGrid();
        gameGUI = new GameGUI(this);
        databaseManager = new DatabaseManager();
    }

    public void startGame() {
        gameGUI.showMainMenu();
    }

    public void startNewGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        isPlayer1Turn = true;
        gameGrid.initializeGame();
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

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }
}
