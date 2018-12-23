package ColorFlood;

import java.awt.*;
import java.util.Random;

public class Board {

    private Cell[][] gameBoard;
    private final int GAME_COLS;
    private final int GAME_ROWS;
    private Color [] gameColors;

    public Board(int GAME_COLS, int GAME_ROWS) {
        this.GAME_COLS = GAME_COLS;
        this.GAME_ROWS = GAME_ROWS;
        Colors gameColors = new Colors();
        this.gameColors = gameColors.getColors();
        createGameBoard();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[GAME_COLS][GAME_ROWS];
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                cellColor = random.nextInt(gameColors.length - 1);
                Cell cell = new Cell(col, row, gameColors[cellColor]);
            }
        }
    }
}
