package my.timerforall.WTesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import my.timerforall.R;
import my.timerforall.Timer.TimerFunctional;
import my.timerforall.Timer.TimerHolder1_0;

public class ListActivity extends AppCompatActivity {

    private TimerHolder1_0 timerHolder;
    private LinearLayout linearLayout;
//    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._test_cards_list);

        linearLayout = findViewById(R.id.test_list_linear_layout);

        timerHolder=new TimerHolder1_0();
        timerHolder.getList();

        fillList();
    }
    private void fillList(){
        for (int i = 0; i < 3; i++) {
            View view = getLayoutInflater().inflate(R.layout.timer_card,null);
            linearLayout.addView(view);
            TextView textView = view.findViewById(R.id.inner_text);
            final TimerFunctional functional = new TimerFunctional(textView, 10);
            timerHolder.addTimer(i+1,functional);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    functional.start();
                }
            });
        }
    }
}
