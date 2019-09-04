package my.rockpilgrim.timerforall.List;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.Timer.TimerFunctional;
import my.rockpilgrim.timerforall.Timer.TimerHolder;


public class TimerListHolder extends RecyclerView.ViewHolder {

    public static final String LOG = "THIS_LOG";
    private TextView textBegin;
    private CardView cardView;
    private TimerHolder timerHolder;

//    private TimerFunctional timerFun;

    public TimerListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int time, int index) {
        textBegin.setText("Start " + (index + 1));
        //
        TimerFunctional timerFun = new TimerFunctional(textBegin, time);
        onClickListener(index);
    }

    public void bindView(int index) {
        textBegin.setText("Start " + (index + 1));
        timerHolder.getTimer(index).setTextView(textBegin);
        onClickListener(index);
    }

    public void setTimerHolder(TimerHolder timerHolder) {
        this.timerHolder = timerHolder;
        Log.i(LOG, "Set");
    }

    private void onClickListener(final int index) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerHolder.start(index);
            }
        });
    }
}
