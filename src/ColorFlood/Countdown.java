package ColorFlood;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    private final int INITIAL_TIME = 90_000;
    private int remainingTime;
    private Timer timer;

    public Countdown() {
        this.timer = new Timer();
        remainingTime = INITIAL_TIME;
    }

    public void runTimer() {
        TimerTask decrement = new TimerTask() {
            @Override
            public void run() {
                remainingTime = remainingTime - 1000;
            }
        };
        timer.schedule(decrement, 50, 1000);
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public String getRemainingTimeString() {
        int min = remainingTime / 60_000;
        int sec = remainingTime % 60_000/1000 ;
        return String.format("%02d:%02d", min, sec);
    }
}