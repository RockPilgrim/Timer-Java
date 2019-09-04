package my.rockpilgrim.timerforall.view.List;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.Timer.Timer;
import my.rockpilgrim.timerforall.presenter.Timer.TimerPresenter;


public class TimerListHolder extends RecyclerView.ViewHolder {

    public static final String LOG = "THIS_LOG";
    private TextView textBegin;
    private CardView cardView;
    private TimerPresenter presenter;
//    private Timer timer;


    public TimerListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int index) {
        textBegin.setText("Start " + (index + 1));
//        presenter.getTimer(index).setTextView(textBegin);
        onClickListener(index);
    }

    public void setPresenter(TimerPresenter presenter) {
        this.presenter = presenter;
        presenter.getTimer(getAdapterPosition()).setChangeListener(this);
        Log.i(LOG, "Set");
    }

    public void setTimerText(String time) {
        textBegin.setText(time);
    }

    private void onClickListener(final int index) {
        cardView.setOnClickListener(v -> presenter.start(index));
    }
}
