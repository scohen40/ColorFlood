package src.ColorFlood;

import java.awt.*;
import java.util.Random;

public class Board {

    private Cell[][] gameBoard;
    private final int gameColumns;
    private final int gameRows;

    private int activeCells;

    /**
     * The constructor's fields are meant to take one of three set options depending on the user's choice of level.
     * @param gameColumns
     * @param gameRows
     */
    public Board(int gameColumns, int gameRows) {
        this.gameColumns = gameColumns;
        this.gameRows = gameRows;
        createGameBoard();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[gameColumns][gameRows];
        for (int col = 0; col < gameColumns; col++) {
            for (int row = 0; row < gameRows; row++) {
                cellColor = random.nextInt(BoardProperties.COLORS.length - 1);
                Cell cell = new Cell(col, row, BoardProperties.COLORS[cellColor]);
            }
        }
    }

    private Cell startCell() {
        //get start cell from user click
        //mark active
        //iterate active cells
        return null;
    }

    private void findAdjoiningCells(Color color){
        for (int col = 0; col < gameColumns; col++) {
            for (int row = 0; row < gameRows; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
                    //check for neighbors of search color and activate
                    //iterate active cells
                }
            }

        }
    }

    private void colorActiveCells(Color color){
        for (int col = 0; col < gameColumns; col++) {
            for (int row = 0; row < gameRows; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
                    cell.setColor(color);
                }
            }
        }
    }

    private boolean gameOver() {
        return (gameColumns * gameRows) == activeCells || timesUp();
    }

    private boolean timesUp() {
        //if timer = 0
        return false;
    }
}
