package src.ColorFlood;

import java.awt.*;

public class Cell {

    private int col;
    private int row;

    private boolean active = false;

    private Color color;

    public Cell(int col, int row, Color color) {
        this.col = col;
        this.row = row;
        this.color = color;
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
