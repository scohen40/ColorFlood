package ColorFlood.GUI;


import ColorFlood.Board;
import ColorFlood.Properties;
import ColorFlood.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static ColorFlood.Properties.*;

public class BoardView extends JComponent {

    private Board board;

    private String difficulty;

    private double boardColWidth;
    private double boardRowHeight;

    private ArrayList<JButton> cellButtons;

    public BoardView(String difficulty) {

        this.difficulty = difficulty;


        setUpBoard();


    }

    private void setUpBoard() {

        setUpBoardDimensions();

        setUpBoardButtons();

    }

    private void setUpBoardButtons() {
        cellButtons = new ArrayList<JButton>();
    }

    private void setUpColRowSizes() {
        boardColWidth = this.getWidth() / (double) board.GAME_COLUMNS;
        boardRowHeight = this.getHeight() / (double) board.GAME_ROWS;
    }

    private void setUpBoardDimensions() {
        if(difficulty == DIFFICULTY[0]) {
            board = new Board(GAME_COLUMNS_EASY, GAME_ROWS_EASY);
        }
        else if(difficulty == DIFFICULTY[1]) {
            board = new Board(GAME_COLUMNS_MEDIUM, GAME_ROWS_MEDIUM);
        }
        else if(difficulty == DIFFICULTY[2]) {
            board = new Board(GAME_COLUMNS_HARD, GAME_ROWS_HARD);
        }
    }




    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        setUpColRowSizes();

    //    paintBackground(g);

        paintGrid(g);
    }

    private void paintBackground(Graphics2D g) {
        setBackground(Properties.BACKGROUND_COLOR);
        setOpaque(true);
    }


    private void paintGrid(Graphics2D g) {

        BasicStroke bs = new BasicStroke(3, 1, BasicStroke.CAP_ROUND);
        g.setStroke(bs);

        Cell cell;

        for (int r = 0; r < board.GAME_ROWS; r++)
            for (int c = 0; c < board.GAME_COLUMNS; c++) {
                cell = board.getGameBoard()[r][c];

                g.setColor(cell.getColor());
                g.fillRoundRect((int)(c * boardColWidth + 7),
                        (int)(r * boardRowHeight + 7),
                        (int) (boardColWidth / 1.3),
                        (int) (boardRowHeight / 1.3),
                        10,
                        10);

            }
    }

}