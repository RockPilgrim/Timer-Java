package my.rockpilgrim.timerforall.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.Timer.TimerHolder;


public class TimerListAdapter extends RecyclerView.Adapter<TimerListHolder> {

    private TimerHolder timerHolder;

    public TimerListAdapter() {
        timerHolder = new TimerHolder();
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
