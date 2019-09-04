package my.rockpilgrim.timerforall.Timer;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class TimerFunctional {
    public static final String LOG = "THIS_LOG";
    public static final int TIME = 10;
    private TextView textView;
    private CountDownTimer timer;
    private boolean play = false;
    private int time;
    private int index;
    private TimerHolder holder;

    ///////
    private CardView cardView;
    private ImageView playButton;
    private LinearLayout settingsPanel;

    public TimerFunctional(TextView innerTextView, int time) {
        this.textView = innerTextView;
        this.time = time;
        createTimer();
    }

    public TimerFunctional(TextView innerTextView) {
        this.textView = innerTextView;
        this.time = TIME;
    }

    public TimerFunctional(int time) {
        this.time = time;
        createTimer();
    }

    public TimerFunctional(int time, int index) {
        this.time = time;
        this.index = index;
        createTimer();
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView innerTextView) {
        this.textView = innerTextView;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void start() {
        if (!play) {
            Log.i(LOG, "Start: " + index);
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
                Log.i(LOG, "END: " + index);
                //// ERROR ///////
                try {
                    holder.finish(index);
                } catch (Exception e) {
                    Log.i(LOG, "TimerFunctional / createTimer: error");
                }
            }
        };
    }

    private void wrightText(long millis) {
        float t = ((float) millis) / 1000;
        if (t >= 10) {
            textView.setText(String.format("%.0f", t));
        } else if (t < 10) {
            textView.setText(String.format("%.1f", t));
        }
    }

    private void wrightText(String t) {
        textView.setText(t);
    }

    public void setHolder(TimerHolder holder) {
        this.holder = holder;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
