package ColorFlood;

import javax.swing.*;
import java.awt.*;


public class BoardPaintTEST extends JComponent{

        private Board board;


        private double boardColWidth;
        private double boardRowHeight;

        public BoardPaintTEST() {

            board = new Board(Properties.GAME_ROWS_EASY, Properties.GAME_COLUMNS_EASY);


        }

        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

//            Graphics2D g = (Graphics2D) graphics;

            setUpColRowSizes();
            graphics.setColor(Color.black);


            paintGrid(graphics);
        }

        private void setUpColRowSizes() {
            boardColWidth = this.getWidth() / (double) board.GAME_COLUMNS;
            boardRowHeight = this.getHeight() / (double) board.GAME_ROWS;
        }

        private void paintGrid(Graphics g) {

//            BasicStroke bs = new BasicStroke(3, 1, BasicStroke.CAP_ROUND);
//            g.setStroke(bs);

            Cell cell;

            for (int r = 0; r < board.GAME_ROWS; r++)
                for (int c = 0; c < board.GAME_COLUMNS; c++) {
                    cell = board.getGameBoard()[r][c];

                    g.setColor(cell.getColor());
                    g.fillRoundRect((int)(r * boardRowHeight + 23),
                            (int)(c * boardColWidth + 3),
                            (int) (boardRowHeight / 1.3),
                            (int) (boardColWidth / 1.3),
                            10,
                            10);
                }
        }


    }

