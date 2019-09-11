package my.rockpilgrim.timerforall.view._test;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

/*    private TimerHolder1_0 timerHolder;
    private LinearLayout linearLayout;
//    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._test_cards_list);

        linearLayout = findViewById(R.id.test_list_linear_layout);

        timerHolder = new TimerHolder1_0();
        timerHolder.getList();

        fillList();
    }

    private void fillList() {
        for (int i = 0; i < 3; i++) {
            View view = getLayoutInflater().inflate(R.layout.timer_card, null);
            linearLayout.addView(view);
            TextView textView = view.findViewById(R.id.inner_text);
            final Timer functional = new Timer(textView, 10);
            timerHolder.addTimer(i + 1, functional);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    functional.start();
                }
            });
        }
    }*/
}
