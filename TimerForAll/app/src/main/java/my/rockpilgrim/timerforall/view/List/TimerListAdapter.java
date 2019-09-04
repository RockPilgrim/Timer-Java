package my.rockpilgrim.timerforall.view.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.Timer.TimerPresenter;


public class TimerListAdapter extends RecyclerView.Adapter<TimerListHolder> {

    private TimerPresenter timerPresenter;

    public TimerListAdapter() {
        timerPresenter = new TimerPresenter();
    }

    @NonNull
    @Override
    public TimerListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.timer_card,
                viewGroup,
                false);
        return new TimerListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TimerListHolder timerListHolder, int index) {
        timerListHolder.setPresenter(timerPresenter);
//        if (timerPresenter.getTimer(index) != null) {
            timerListHolder.bindView(index);
//        }
    }


    @Override
    public int getItemCount() {
        return timerPresenter != null ? timerPresenter.size() : 0;
    }
}
