package ColorFlood.GUI;

import ColorFlood.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorFloodView extends JFrame {
    private JPanel panel;
    private JPanel timerPanel;
    private BoardView boardView;
    private JPanel gameControls;

    private JButton buttonRed;
    private JButton buttonCyan;
    private JButton buttonYellow;
    private JButton buttonGreen;
    private JButton buttonBlue;
    private JButton buttonMagenta;

    private JButton[] colorButtons = {buttonRed, buttonCyan, buttonYellow, buttonGreen, buttonBlue, buttonMagenta};

    protected ColorFloodView() {

        initializeGamePanel();

        setUpBoardView();

        setUpTimerPanel();

        setUpControlPanel();

        panel.add(timerPanel, BorderLayout.NORTH);
        panel.add(boardView, BorderLayout.CENTER);
        panel.add(gameControls, BorderLayout.SOUTH);

        add(panel);
    }

    private void initializeGamePanel() {
        panel = new JPanel();
        setTitle("Color Flood");
        setSize(Properties.MAIN_PANEL_WIDTH, Properties.MAIN_PANEL_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Properties.BACKGROUND_COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }


    private void setUpTimerPanel() {
        timerPanel = new JPanel();
        timerPanel.setPreferredSize(Properties.TIMER_PANEL_SIZE);
        timerPanel.setBackground(Properties.BACKGROUND_COLOR);
        timerPanel.setBorder(new EmptyBorder(10, 0, 50, 0));

        String time = boardView.getTime();
        JLabel clock = new JLabel(time);
        clock.setForeground(Color.white);
        clock.setFont(new Font("clock", Font.BOLD, 30));
        timerPanel.add(clock);
    }


    private void setUpBoardView() {
        String difficulty = preGameQuery();
        boardView = new BoardView(difficulty);
        boardView.setPreferredSize(Properties.BOARD_VIEW_SIZE);
        boardView.setBorder(new EmptyBorder(20, 10, 0, 0));
    }

    private String preGameQuery() {

        String userInput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the level of difficulty for the game. " +
                        "\n If you do not answer, the difficulty will be set for you. ",
                "Level Selection", JOptionPane.QUESTION_MESSAGE,
                null,
                Properties.DIFFICULTY, // Array of choices
                Properties.DIFFICULTY[0]); // Initial choice

        if ((userInput != null) && (userInput.length() > 0)) {
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
        gameControls.setLayout(new GridLayout(1, 0));
        gameControls.setBackground(Properties.BACKGROUND_COLOR);
        gameControls.setPreferredSize(Properties.COLOR_BUTTON_SIZE);

    }

    private void setUpControlColorButtons() {

        for (int current = 0; current < colorButtons.length; current++) {
            JButton newButton = new JButton();


            newButton.setPreferredSize(Properties.COLOR_BUTTON_SIZE);
            newButton.setIcon(Properties.createImageIcon(
                    Properties.COLORS[current],
                    Properties.COLOR_BUTTON_WIDTH,
                    Properties.COLOR_BUTTON_HEIGHT));

            newButton.setBorder(new EmptyBorder(0, 50, 0, 50));


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
        for (JButton button : colorButtons) {
            button.setEnabled(clickable);
        }
    }


    public static void main(String[] args) {
        new ColorFloodView().setVisible(true);
    }

}