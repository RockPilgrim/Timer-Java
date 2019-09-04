package my.rockpilgrim.timerforall.presenter.Timer;

import android.os.CountDownTimer;
import android.util.Log;

import my.rockpilgrim.timerforall.view.List.TimerListHolder;

public class Timer {
    public static final String TAG = "Timer";
    public static final int TIME = 10;
    private CountDownTimer timer;
    private boolean play = false;
    private int time;
    private int index;
    private TimerPresenter presenter;
    private TimerListHolder listener;


    public Timer(int time) {
        this.time = time;
        createTimer();
    }

    public Timer(int time, int index) {
        this.time = time;
        this.index = index;
        createTimer();
    }

    public void start() {
        if (!play) {
            Log.i(TAG+index, "Start: " + index);
            timer.start();
            play = true;
        }
    }

    private void createTimer() {
        timer = new CountDownTimer(time * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                wrightText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                wrightText("END");
                play = false;
                Log.i(TAG+index, "END: " + index);
                //// ERROR ///////
                try {
                    presenter.finish(index);
                } catch (Exception e) {
                    Log.i(TAG+index, "Timer / createTimer: error");
                }
            }
        };
    }
    public void setChangeListener(TimerListHolder listener) {
        this.listener = listener;
    }

    private void wrightText(long millis) {
        float t = ((float) millis) / 1000;
        if (listener != null) {
            if (t >= 10) {
                listener.setTimerText(String.format("%.0f", t));
            } else if (t < 10) {
                listener.setTimerText(String.format("%.1f", t));
            }
        }
    }

    private void wrightText(String t) {
        listener.setTimerText(t);
    }

    public void setPresenter(TimerPresenter presenter) {
        this.presenter = presenter;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
