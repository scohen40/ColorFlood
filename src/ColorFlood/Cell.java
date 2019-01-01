package ColorFlood;

import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent{

    private int row;
    private int col;

    private int rowHeight;
    private int colWidth;

    private boolean active = false;

    private Color color;

    public Cell(int row, int col, int rowHeight, int colWidth, Color color) {
        this.row = row;
        this.col = col;

        this.rowHeight = rowHeight;
        this.colWidth = colWidth;

        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRoundRect(50, 50, 100, 100, 10, 10);

        paintSquare(g);
    }

    private void paintSquare(Graphics g) {
        //g.setColor(color);
        g.setColor(Color.white);
        g.fillRoundRect(50, 50, 100, 100, 10, 10);
//                (int) (col * colWidth),
//                (int) (row * rowHeight),
//                (int) (rowHeight),
//                (int) (colWidth),
//                10,
//                10);

    }

    public int getCol()
    {
        return col;
    }

    public int getRow()
    {
        return row;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
