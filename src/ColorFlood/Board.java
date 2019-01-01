package ColorFlood;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Board extends JPanel {

    public Cell[][] gameBoard;

    public final int GAME_ROWS;
    public final int GAME_COLUMNS;


    public Color selectedColor;

    private int activeCells;

    private int time;

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

        setUpBoardPanel();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[GAME_COLUMNS][GAME_ROWS];
        for (int col = 0; col < GAME_COLUMNS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                cellColor = random.nextInt(Properties.COLORS.length);
                Cell newCell = new Cell(col, row,Properties.COLORS[cellColor]);
                gameBoard[col][row] = newCell;
            }
        }
    }

    private void setUpBoardPanel() {
        setLayout(new GridLayout(GAME_COLUMNS, GAME_ROWS));
        setBorder(new EmptyBorder(20, 10, 20, 10));
        setBackground(Properties.BACKGROUND_COLOR);

        addBoardPanelComponents();
    }

    private void addBoardPanelComponents() {
        for(int col = 0; col < GAME_COLUMNS; col++) {
            for(int row = 0; row < GAME_ROWS; row++) {
                add(gameBoard[col][row]);
            }
        }
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
        flood();
    }

    private void activateNeighbors() {
        for (int col = 0; col < GAME_COLUMNS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard[col][row];
                if (cell.isActive()) {
                    neighborsToActivate(cell);
                }
            }
        }}

    private void neighborsToActivate(Cell cell) {
        //top
        setCellActive(cell.getCol(), cell.getRow() - 1);

        //bottom
        setCellActive(cell.getCol(), cell.getRow() + 1);

        //left
        setCellActive(cell.getCol() - 1, cell.getRow());

        //right
        setCellActive(cell.getCol() + 1, cell.getRow());
    }

    public void setCellActive(int col, int row) {
        if (boardContains(col, row)) {
            if (!gameBoard[col][row].isActive()) {
                if (gameBoard[col][row].getColor() == selectedColor) {
                    gameBoard[col][row].setActive(true);
                    activeCells++;
                }
            }
        }
    }

    public void activateFirstCell(int col, int row)
    {
        if (boardContains(col, row))
        {
            gameBoard[col][row].setActive(true);
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
        repaint();
    }

    public void flood() {
        activateNeighbors();
        colorActiveCells(selectedColor);
    }

    public boolean gameOver() {
        return (GAME_COLUMNS * GAME_ROWS) == activeCells || timesUp();
    }

    public boolean timesUp() {
        return time == 0;
    }


    private void endGame(){
        if (gameOver()){

        }
        //do the other stuff
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }
}