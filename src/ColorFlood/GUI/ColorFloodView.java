package ColorFlood.GUI;

import ColorFlood.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ColorFloodView extends JFrame {
    private JPanel panel;

    private JPanel timerPanel;

    private JPanel boardPanel;

    private JPanel gameControls;

    private JButton buttonRed;
    private JButton buttonOrange;
    private JButton buttonYellow;
    private JButton buttonGreen;
    private JButton buttonBlue;
    private JButton buttonMagenta;

    private JButton[] colorButtons = { buttonRed, buttonOrange, buttonYellow, buttonGreen, buttonBlue, buttonMagenta };



    protected ColorFloodView() {
        //game view setup
        initializeGamePanel();

        setUpTimerPanel();

        setUpBoardPanel();

        setUpControlPanel();

        panel.add(timerPanel, BorderLayout.NORTH);
        panel.add(boardPanel, BorderLayout.CENTER);
        panel.add(gameControls, BorderLayout.SOUTH);

        add(panel);
    }

    private void initializeGamePanel() {
        panel = new JPanel();
        setTitle("Color Flood");
        setSize(300, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Properties.BACKGROUND_COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
    }


    private void setUpTimerPanel() {
        timerPanel = new JPanel();
        timerPanel.setPreferredSize(Properties.TIMER_PANEL_SIZE);
        timerPanel.setMinimumSize(Properties.TIMER_PANEL_SIZE);
        timerPanel.setBackground(Properties.BACKGROUND_COLOR);
        timerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        timerPanel.setBorder(new LineBorder(Color.WHITE));
    }


    private void setUpBoardPanel() {
        boardPanel = new JPanel();

        String difficulty = preGameQuery();
        BoardView boardView = new BoardView(difficulty);

        boardPanel.setBorder(new LineBorder(Color.WHITE));
        boardPanel.setBackground(Properties.BACKGROUND_COLOR);
        boardPanel.setPreferredSize(Properties.BOARD_SIZE);
        boardPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        boardPanel.add(boardView);
    }

    private String preGameQuery() {

        String userInput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the level of difficulty for the game. " +
                        "\n If you do not answer, the difficulty will be set for you. ",
                "Pre-Game Query", JOptionPane.QUESTION_MESSAGE,
                null,
                Properties.DIFFICULTY, // Array of choices
                Properties.DIFFICULTY[0]); // Initial choice

        if((userInput != null) && (userInput.length() > 0)) {
            return userInput;
        }
        return Properties.DIFFICULTY[2];
    }



    private void setUpControlPanel() {

        initializeControlPanel();

        setUpControlColorButtons();
    }

    private void initializeControlPanel() {
        gameControls = new JPanel();
        gameControls.setLayout(new BoxLayout(gameControls, BoxLayout.X_AXIS));
        gameControls.setBackground(Properties.BACKGROUND_COLOR);
        gameControls.setSize(Properties.COLOR_BUTTON_HEIGHT, Properties.COLOR_BUTTON_HEIGHT);
        gameControls.setBorder(new EmptyBorder(10, 0, 10, 0));

    }

    private void setUpControlColorButtons() {

        for(int current = 0; current < colorButtons.length; current++) {
            JButton newButton = new JButton();

            newButton.setPreferredSize(Properties.COLOR_BUTTON_SIZE);
            newButton.setIcon(Properties.createImageIcon(
                    Properties.COLORS[current],
                    Properties.COLOR_BUTTON_HEIGHT,
                    Properties.COLOR_BUTTON_WIDTH));

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








    public static void main(String[] args) {
        new ColorFloodView().setVisible(true);
    }
}