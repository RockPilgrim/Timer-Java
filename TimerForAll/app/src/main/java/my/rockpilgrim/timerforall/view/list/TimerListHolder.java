package my.rockpilgrim.timerforall.view.list;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.presenter.timer.Timer;


public class TimerListHolder extends RecyclerView.ViewHolder {

    public static final String LOG = "THIS_LOG";
    private TextView textBegin;
    private CardView cardView;
    private Timer timer;

    private ListPresenter presenter;


    public TimerListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int index) {
//        textBegin.setText(String.format("Start %d", index + 1));
        textBegin.setText(timer.getName());
        onClickListener(index);
    }

    public void setPresenter(ListPresenter presenter) {
        this.presenter = presenter;
        presenter.getTimer(getAdapterPosition()).setChangeListener(this);
        Log.i(LOG, "Set");
    }
    public void setTimer(Timer timer) {
        this.timer = timer;
        timer.setChangeListener(this);
        Log.i(LOG, "Set timer");
    }

    public void setTimerText(String time) {
        textBegin.setText(time);
    }

    private void onClickListener(final int index) {
        cardView.setOnClickListener(v -> timer.start());
    }
}
