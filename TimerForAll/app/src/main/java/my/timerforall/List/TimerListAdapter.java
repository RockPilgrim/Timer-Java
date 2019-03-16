package my.timerforall.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import my.timerforall.R;
import my.timerforall.Timer.TimerHolder;

public class TimerListAdapter extends RecyclerView.Adapter<TimerListHolder> {

    private TimerHolder timerHolder;

    public TimerListAdapter() {
        timerHolder=new TimerHolder();
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
        timerListHolder.setTimerHolder(timerHolder);
        if (timerHolder.getTimer(index) != null) {
            timerListHolder.bindView(index);
        }
    }


    @Override
    public int getItemCount() {
        return timerHolder != null ? timerHolder.size() : 0;
    }
}
