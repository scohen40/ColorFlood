package ColorFlood;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class ColorFlood extends JFrame {
    private JPanel panel;
    private JPanel timerPanel;
    private JPanel board;
    private JPanel controlsPanel;

    private Countdown gameTimer = new Countdown();
    private String time = gameTimer.getRemainingTimeString();
    private JLabel clock = new JLabel(time);


    private JButton buttonRed;
    private JButton buttonCyan;
    private JButton buttonYellow;
    private JButton buttonGreen;
    private JButton buttonBlue;
    private JButton buttonMagenta;

    private JButton[] colorButtons = {buttonRed, buttonCyan, buttonYellow, buttonGreen, buttonBlue, buttonMagenta};


    protected ColorFlood() {

        initializeGamePanel();

        setUpTimerPanel();
        setUpBoardPanel();
        setUpControlPanel();

        panel.add(timerPanel, BorderLayout.NORTH);
        panel.add(board, BorderLayout.CENTER);
        panel.add(controlsPanel, BorderLayout.SOUTH);

        add(panel);


        gameTimer.runTimer();

    }

    private void initializeGamePanel() {
        panel = new JPanel();
        setTitle("Color Flood");
        setSize(Properties.MAIN_PANEL_WIDTH, Properties.MAIN_PANEL_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Properties.BACKGROUND_COLOR);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }


    private void setUpTimerPanel() {
        timerPanel = new JPanel();
        timerPanel.setPreferredSize(Properties.TIMER_PANEL_SIZE);
        timerPanel.setBackground(Properties.BACKGROUND_COLOR);
        timerPanel.setBorder(new EmptyBorder(10, 0, 50, 0));

        clock.setForeground(Color.white);
        clock.setFont(new Font("clock", Font.BOLD, 30));
        timerPanel.add(clock);
    }


    private void setUpBoardPanel() {
        String difficulty = setDifficultyQuery();
        board = new BoardBuilder(difficulty).getBoard();
    }

    private String setDifficultyQuery() {

        String userInput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the level of difficulty for the game. " +
                        "\nIf you do not answer, the difficulty will be set for you. " +
                        "\n\nWhen you exit this window you must select the starting cell. " +
                        "\nGood luck!",
                "Level Selection", JOptionPane.QUESTION_MESSAGE,
                null,
                Properties.DIFFICULTY, // Array of choices
                Properties.DIFFICULTY[0]); // Initial choice


        if((userInput != null) && (userInput.length() > 0)) {

            return userInput;
        } else {
            return Properties.DIFFICULTY[2];
        }
    }


    private void setUpControlPanel() {

        initializeControlPanel();

        setUpControlColorButtons();
    }

    private void initializeControlPanel() {
        controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridLayout(1, 0));
        controlsPanel.setBackground(Properties.BACKGROUND_COLOR);
        controlsPanel.setPreferredSize(Properties.COLOR_BUTTON_SIZE);


    }

    private void setUpControlColorButtons() {


        for(int current = 0; current < colorButtons.length; current++) {

            JButton newButton = new JButton();


            newButton.setPreferredSize(Properties.COLOR_BUTTON_SIZE);
            newButton.setIcon(Properties.createImageIcon(
                    Properties.COLORS[current],
                    Properties.COLOR_BUTTON_WIDTH,
                    Properties.COLOR_BUTTON_HEIGHT));

            newButton.setBorder(new EmptyBorder(0, 50, 0, 50));


            colorButtons[current] = newButton;
            controlsPanel.add(colorButtons[current]);
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


    public class Countdown {
        private final int INITIAL_TIME = 90_000;
        private int remainingTime;
        private java.util.Timer timer;

        Countdown() {
            this.timer = new Timer();
            remainingTime = INITIAL_TIME;
        }

        void runTimer() {
                TimerTask decrement = new TimerTask() {
                    @Override
                    public void run() {
                        if(remainingTime >= 0){
                        clock.setText(getRemainingTimeString());
                        remainingTime = remainingTime - 1000;
                        //todo figure this out
                        // board.setTime(remainingTime);
                    }else {timer.cancel();}}

                };
                timer.schedule(decrement, 50, 1000);
        }

        String getRemainingTimeString() {
            int min = remainingTime / 60_000;
            int sec = remainingTime % 60_000 / 1000;
            return String.format("%02d:%02d", min, sec);
        }

    }

    public static void main(String[] args) {
        new ColorFlood().setVisible(true);
    }

}