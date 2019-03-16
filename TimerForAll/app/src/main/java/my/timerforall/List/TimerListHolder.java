package my.timerforall.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import my.timerforall.R;
import my.timerforall.Timer.TimerFunctional;
import my.timerforall.Timer.TimerHolder;

public class TimerListHolder extends RecyclerView.ViewHolder {

    private TextView textBegin;
    private CardView cardView;
    private TimerHolder timerHolder;
    public static final String LOG = "THIS_LOG";

//    private TimerFunctional timerFun;

    public TimerListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int time,int index){
        textBegin.setText("Start "+(index+1));
        //
        TimerFunctional timerFun = new TimerFunctional(textBegin, time);
        onClickListener(index);
    }
    public void bindView(int index){
        textBegin.setText("Start "+(index+1));
        timerHolder.getTimer(index).setTextView(textBegin);
        onClickListener(index);
    }

    public void setTimerHolder(TimerHolder timerHolder) {
        this.timerHolder = timerHolder;
        Log.i(LOG, "Set");
    }

    private void onClickListener(final int index){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerHolder.start(index);
            }
        });
    }
}
