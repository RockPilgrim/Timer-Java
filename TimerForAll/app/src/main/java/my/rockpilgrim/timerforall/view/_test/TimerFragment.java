package my.rockpilgrim.timerforall.view._test;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import my.rockpilgrim.timerforall.R;

public class TimerFragment extends AppCompatActivity {

    public static final String LOG = "THIS_LOG";
    private TextView innerTextView;
    private CardView cardView;
    private CountDownTimer timer;
    private boolean play = false;
    private ImageView playButton;
    private LinearLayout settingsPanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_card);

        Log.i(LOG, "CREATE");

        innerTextView = findViewById(R.id.inner_text);
        cardView = findViewById(R.id.card_view);
        playButton = findViewById(R.id.play_button);
        settingsPanel = findViewById(R.id.settings_panel);

        createTimer(6);
        setOnClick();
    }

    private void createTimer(int time) {
        timer = new CountDownTimer(time * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                wrightText(millisUntilFinished);
            }
            @Override
            public void onFinish() {
                wrightText("END");
                play = false;
                Log.i(LOG, "END");
            }
        };
    }

    private void wrightText(long millis) {
        float t = ((float) millis) / 1000;
        if (t > 3) {
            innerTextView.setText(String.format("%.0f ", t));
        } else {
            innerTextView.setText(String.format(" %.1f", t));
        }
    }

    private void wrightText(String t) {
        innerTextView.setText(t);
    }

    private void playTimer() {
        timer.start();
        play = true;
    }

    private void pauseTimer() {
        try {
            timer.wait();
            play = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setOnClick() {
        Log.i(LOG, "Click CREATE");
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG, "Click");
                if (!play) {
                    playTimer();
//                    settingsPanel.setVisibility(View.GONE);
                } else {
//                    settingsPanel.setVisibility(View.VISIBLE);
//                    pauseTimer();
                }
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG, "Play button");
            }
        });
    }
}
