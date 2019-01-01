package ColorFlood.GUI;


import ColorFlood.Board;
import ColorFlood.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static ColorFlood.Properties.*;

public class BoardView extends JComponent implements MouseListener {

    public Board board;
    private String difficulty;
    private double boardColWidth;
    private double boardRowHeight;

    private ArrayList<JButton> cellButtons;

    public BoardView(String difficulty) {

        this.difficulty = difficulty;

        setUpBoardDimensions();
    }

    private void setUpBoardDimensions() {
        if(difficulty.equals(DIFFICULTY[0])) {
            board = new Board(GAME_COLUMNS_EASY, GAME_ROWS_EASY);
        }
        else if(difficulty.equals(DIFFICULTY[1])) {
            board = new Board(GAME_COLUMNS_MEDIUM, GAME_ROWS_MEDIUM);
        }
        else if(difficulty.equals(DIFFICULTY[2])) {
            board = new Board(GAME_COLUMNS_HARD, GAME_ROWS_HARD);
        }
    }

    public Board getBoard() {
        return board;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;

        setUpColRowSizes();

        paintGrid(g);
    }

    private void setUpColRowSizes() {
        boardColWidth = this.getWidth() / (double) board.GAME_COLUMNS;
        boardRowHeight = this.getWidth() / (double) board.GAME_ROWS;
    }

    private void paintGrid(Graphics2D g) {

        Cell cell;

        for (int c = 0; c < board.GAME_COLUMNS; c++){
            for (int r = 0; r < board.GAME_ROWS; r++) {
                cell = board.getGameBoard()[c][r];

                g.setColor(cell.getColor());
                g.fillRoundRect(
                        (int) (c * boardColWidth + 8),
                        (int) (r * boardRowHeight + 3),
                        (int) (boardRowHeight / 1.5),
                        (int) (boardColWidth / 1.5),
                        10,
                        10);

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        board.getGameTimer().runTimer();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}