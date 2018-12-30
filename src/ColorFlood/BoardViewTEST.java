package ColorFlood;

import javax.swing.*;
import java.awt.*;

public class BoardViewTEST extends JFrame {
    JPanel panel;

    BoardPaintTEST boardView;

    public BoardViewTEST() {
        setUpMainPanel();

        boardView = new BoardPaintTEST();

        panel.add(boardView, BorderLayout.CENTER);

        add(panel);

    }

    private void setUpMainPanel() {
        panel = new JPanel();
        setTitle("Color Flood");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        //panel.setBackground(Properties.BACKGROUND_COLOR);
    }

    public static void main(String[] args) {
        new BoardViewTEST().setVisible(true);
    }


}
