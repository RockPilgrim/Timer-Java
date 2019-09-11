package my.rockpilgrim.timerforall.view.list;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;


public class TimerListHolder extends RecyclerView.ViewHolder {

    public static final String LOG = "THIS_LOG";
    private TextView textBegin;
    private CardView cardView;
    private ListPresenter presenter;


    public TimerListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int index) {
        textBegin.setText(String.format("Start %d", index + 1));
        onClickListener(index);
    }

    public void setPresenter(ListPresenter presenter) {
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
