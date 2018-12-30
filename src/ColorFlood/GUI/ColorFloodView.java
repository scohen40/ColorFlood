package ColorFlood.GUI;

import ColorFlood.BoardProperties;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ColorFloodView extends JFrame {
    private JPanel panel;

    private JPanel boardPanel;
    private BoardView boardView;

    private JPanel gameControls;

    private JButton buttonRed;
    private JButton buttonOrange;
    private JButton buttonYellow;
    private JButton buttonGreen;
    private JButton buttonBlue;
    private JButton buttonMagenta;

    private JButton[] colorButtons = { buttonRed, buttonOrange, buttonYellow, buttonGreen, buttonBlue, buttonMagenta };



    public ColorFloodView() {
        //game view setup
        initializeGamePanel();

        //setUpTimerPanel();

        setUpBoardPanel();

        setUpControlPanel();

        //panel.add(timerPanel, BoarderLayout.NORTH);
        //panel.add(boardPanel, BorderLayout.CENTER);
        panel.add(gameControls);

        add(panel);
    }

    private void initializeGamePanel() {
        panel = new JPanel();
        setTitle("Color Flood");
        setSize(300, 550);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout());
        panel.setBackground(BoardProperties.BACKGROUND_COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
    }

    private void setUpControlPanel() {

        initializeControlPanel();

        setUpControlColorButtons();
    }

    private void initializeControlPanel() {
        gameControls = new JPanel();
        gameControls.setLayout(new BoxLayout(gameControls, BoxLayout.X_AXIS));
        gameControls.setBackground(BoardProperties.BACKGROUND_COLOR);
        gameControls.setSize(BoardProperties.COLOR_BUTTON_HEIGHT, BoardProperties.COLOR_BUTTON_HEIGHT);


    }

    private void setUpControlColorButtons() {

        for(int current = 0; current < colorButtons.length; current++) {
            JButton newButton = new JButton();

            newButton.setPreferredSize(BoardProperties.COLOR_BUTTON_SIZE);
            newButton.setIcon(BoardProperties.createImageIcon(
                    BoardProperties.COLORS[current],
                    BoardProperties.COLOR_BUTTON_HEIGHT,
                    BoardProperties.COLOR_BUTTON_WIDTH));

            colorButtons[current] = newButton;
            gameControls.add(colorButtons[current]);
        }


        addColorControlButtonsListeners();

        //toggleColorControlButtons(false);
    }

    private void addColorControlButtonsListeners() {
        //to do
    }

    private void toggleColorControlButtons(Boolean clickable) {
        for(JButton button : colorButtons) {
            button.setEnabled(clickable);
        }
    }



    private void setUpBoardPanel() {
        String difficulty = preGameQuery();
        boardView = new BoardView(difficulty);
        boardView.setBackground(BoardProperties.BACKGROUND_COLOR);
    }

    private String preGameQuery() {

        String userInput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the level of difficulty for the game. " +
                        "\n If you do not answer, the difficulty will be set for you. ",
                "Pre-Game Query", JOptionPane.QUESTION_MESSAGE,
                null,
                BoardProperties.DIFFICULTY, // Array of choices
                BoardProperties.DIFFICULTY[0]); // Initial choice

        if((userInput != null) && (userInput.length() > 0)) {
            return userInput;
        }
        return BoardProperties.DIFFICULTY[2];
    }










    public static void main(String[] args) {
        new ColorFloodView().setVisible(true);
    }
}