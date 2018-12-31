package ColorFlood;

import javax.swing.*;
import java.awt.*;

public class Cell {

    private int row;
    private int col;

    private boolean active = false;

    private Color color;

    public Cell(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
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
