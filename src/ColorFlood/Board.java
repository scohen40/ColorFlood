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
    public Board(int GAME_ROWS, int GAME_COLUMNS) {
        this.GAME_COLUMNS = GAME_COLUMNS;
        this.GAME_ROWS = GAME_ROWS;


        createGameBoard();

        setUpBoardPanel();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[GAME_ROWS][GAME_COLUMNS];
        for (int row = 0; row < GAME_ROWS; row++) {
            for (int col = 0; col < GAME_COLUMNS; col++) {
                cellColor = random.nextInt(Properties.COLORS.length);
                Cell newCell = new Cell(row, col,Properties.COLORS[cellColor]);
                gameBoard[row][col] = newCell;
            }
        }
    }

    private void setUpBoardPanel() {
        setLayout(new GridLayout(GAME_ROWS, GAME_COLUMNS));
        setBorder(new EmptyBorder(20, 10, 20, 10));
        setBackground(Properties.BACKGROUND_COLOR);

        addBoardPanelComponents();
    }

    private void addBoardPanelComponents() {
        for(int r = 0; r < GAME_ROWS; r++) {
            for(int c = 0; c < GAME_COLUMNS; c++) {
                add(gameBoard[r][c]);
            }
        }
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

    public void flood() {
        activateNeighbors();
        colorActiveCells(selectedColor); //call here or in repaint?
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

    public Color getSelectedColor() {
        return selectedColor;
    }
}