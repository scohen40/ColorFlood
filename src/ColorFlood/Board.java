package ColorFlood;

import java.awt.*;
import java.util.Random;

public class Board {

    private Cell[][] gameBoard;

    public final int GAME_COLUMNS;
    public final int GAME_ROWS;

    private Color selectedColor;

    private int activeCells;

    /**
     * The constructor's fields are meant to take one of three set options depending on the user's choice of level.
     *
     * @param GAME_COLUMNS
     * @param GAME_ROWS
     */
    public Board(int GAME_COLUMNS, int GAME_ROWS) {
        this.GAME_COLUMNS = GAME_COLUMNS;
        this.GAME_ROWS = GAME_ROWS;

        createGameBoard();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[GAME_COLUMNS][GAME_ROWS];
        for (int col = 0; col < GAME_COLUMNS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
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


    public void setSelectedColor(Color selectedColor) {
        //set color based on button clicked
        this.selectedColor = selectedColor;
    }

    private void activateNeighbors() {
        //ArrayList<Cell> neighbors = new ArrayList<>();
        for (int col = 0; col < GAME_COLUMNS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard[col][row];
                if (cell.isActive()) {
                    //check for neighbors of search color and activate
                    //iterate active cells
                    neighborsToActivate(cell);
                    //neighbors.addAll(neighborsToActivate(cell));
                }
            }
        }
        /*//set active after finding all cells that are active when user clicked
        for (Cell neighbor : neighbors)
        {
            neighbor.setActive(true);
            activeCells++;
        }*/ //set active in neighborstoactivate because then it will keep checking for same colored blocks
    }

    private void neighborsToActivate(Cell cell) {
        //ArrayList<Cell> activatedNeighbors = new ArrayList<>();

        //top
        setCellActive(cell.getCol(), cell.getRow() - 1);

        //bottom
        setCellActive(cell.getCol(), cell.getRow() + 1);

        //left
        setCellActive(cell.getCol() - 1, cell.getRow());

        //right
        setCellActive(cell.getCol() + 1, cell.getRow());

        //return activatedNeighbors;
    }

    private void setCellActive(int col, int row) {
        if (boardContains(col, row)) {
            if (!gameBoard[col][row].isActive()) {
                if (gameBoard[col][row].getColor() == selectedColor) {
                    gameBoard[col][row].setActive(true);
                    activeCells++;
                }
            }
        }
    }

    private boolean boardContains(int col, int row) {
        return (col < GAME_COLUMNS) && (row < GAME_ROWS) && (col >= 0) && (row >= 0);

    }

    private void colorActiveCells(Color color) {
        for (int col = 0; col < GAME_COLUMNS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard[col][row];
                if (cell.isActive()) {
                    cell.setColor(color);
                }
            }
        }
    }

    public void flood(Color color) {
        activateNeighbors();
        colorActiveCells(selectedColor); //call here or in repaint?
    }

    private boolean gameOver() {
        return (GAME_COLUMNS * GAME_ROWS) == activeCells || timesUp();
    }

    private boolean timesUp() {
        //if timer = 0
        return false;
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

}