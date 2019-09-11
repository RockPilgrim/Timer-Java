package my.rockpilgrim.timerforall.presenter.timer;

import android.os.CountDownTimer;
import android.util.Log;

import my.rockpilgrim.timerforall.presenter.TimeFormat;
import my.rockpilgrim.timerforall.presenter.detail.TickListener;
import my.rockpilgrim.timerforall.view.list.TimerListHolder;

public class Timer {
    private static final String TAG = "Timer: ";
    public static final int TIME = 10;
    public static final String MAIN_NAME = "Start ";
    private CountDownTimer timer;
    private boolean play = false;
    private int time;
    private int index;
    private String name;
    private TickListener tickListener;
    private TimeListener timeListener;
    private TimerListHolder listener;


    public Timer(int time) {
        this.time = time;
        name = MAIN_NAME;
        createTimer();
    }

    public Timer(int time, int index) {
        this.time = time;
        this.index = index;
        createTimer();
    }
    public Timer(int time, String name) {
        this.time = time;
        if (name.equals("")) {
            this.name = MAIN_NAME;

        } else {
            this.name = name;
        }
        createTimer();
    }

    public void start() {
        if (!play) {
            Log.i(TAG+index, "Start: ");
            timer.start();
            play = true;
        }
    }

    private void createTimer() {
        timer = new CountDownTimer(time * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                wrightText(millisUntilFinished);
                if (tickListener != null) {
                    tickListener.sendTime(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                wrightText("END");
                play = false;
                Log.i(TAG+index, "END: ");
                //// ERROR ///////
                try {
                    timeListener.finish(index);
                } catch (Exception e) {
                    Log.i(TAG+index, "createTimer / onFinish: error");
                }
            }
        };
    }
    public void setChangeListener(TimerListHolder listener) {
        this.listener = listener;
    }
    public void setTickListener(TickListener tickListener) {
        this.tickListener = tickListener;
    }

    private void wrightText(long millis) {
        if (listener != null) {
                listener.setTimerText(TimeFormat.getTime(millis));
        }
    }

    private void wrightText(String t) {
        if (listener != null) {
            listener.setTimerText(t);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListener(TimeListener listener) {
        this.timeListener = listener;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        if (name.equals(MAIN_NAME)) {
            name = MAIN_NAME + " " + (index+1);
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
