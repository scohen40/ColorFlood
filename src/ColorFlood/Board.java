package ColorFlood;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {

    private Cell[][] gameBoard;
    private final int GAME_COLS;
    private final int GAME_ROWS;
    private Color[] gameColors;
    private Color selectedColor;
    private int activeCells;

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

    private Cell startCell() {
        //get start cell from user click
        //mark active
        //iterate active cells
        return null;
    }

    public void setSelectedColor(Color selectedColor)
    {
        //set color based on button clicked
        this.selectedColor = selectedColor;
    }

    private void activateNeighbors(){
        ArrayList<Cell> neighbors = new ArrayList<>();
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
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

    private void neighborsToActivate(Cell cell)
    {
        //ArrayList<Cell> activatedNeighbors = new ArrayList<>();

        //top
        if (cell.getRow() != 0 && !gameBoard[cell.getCol()][cell.getRow() - 1].isActive()
                && gameBoard[cell.getCol()][cell.getRow() - 1].getColor() == selectedColor)
        {
            //activatedNeighbors.add(gameBoard[cell.getCol()][cell.getRow() - 1]);
            setCellActive(gameBoard[cell.getCol()][cell.getRow() - 1]);
        }
        //bottom
        if (cell.getRow() < (GAME_ROWS - 1) && !gameBoard[cell.getCol()][cell.getRow() + 1].isActive()
                && gameBoard[cell.getCol()][cell.getRow() + 1].getColor() == selectedColor)
        {
            //activatedNeighbors.add(gameBoard[cell.getCol()][cell.getRow() + 1]);
            setCellActive(gameBoard[cell.getCol()][cell.getRow() + 1]);
        }
        //left
        if (cell.getCol() != 0 && !gameBoard[cell.getCol() - 1][cell.getRow()].isActive()
                && gameBoard[cell.getCol() - 1][cell.getRow()].getColor() == selectedColor)
        {
            //activatedNeighbors.add(gameBoard[cell.getCol() - 1][cell.getRow()]);
            setCellActive(gameBoard[cell.getCol() - 1][cell.getRow()]);
        }
        //right
        if (cell.getCol() < (GAME_ROWS - 1) && !gameBoard[cell.getCol() + 1][cell.getRow()].isActive()
                && gameBoard[cell.getCol() + 1][cell.getRow()].getColor() == selectedColor)
        {
            //activatedNeighbors.add(gameBoard[cell.getCol() + 1][cell.getRow()]);
            setCellActive(gameBoard[cell.getCol() + 1][cell.getRow()]);
        }

        //return activatedNeighbors;
    }

    private void setCellActive(Cell cell)
    {
        cell.setActive(true);
        activeCells++;
    }

    private void colorActiveCells(Color color){
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
                    cell.setColor(color);
                }
            }
        }
    }

    public void flood(Color color)
    {
        activateNeighbors();
        colorActiveCells(selectedColor); //call here or in repaint?
    }

    private boolean gameOver() {
        return (GAME_COLS * GAME_ROWS) == activeCells || timesUp();
    }

    private boolean timesUp() {
        //if timer = 0
        return false;
    }
}
