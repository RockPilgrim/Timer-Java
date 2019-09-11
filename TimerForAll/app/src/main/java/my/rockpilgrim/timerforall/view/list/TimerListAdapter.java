package my.rockpilgrim.timerforall.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;


public class TimerListAdapter extends RecyclerView.Adapter<TimerListHolder> {

    private ListPresenter listPresenter;

    public TimerListAdapter() {
        listPresenter = new ListPresenter();
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
        timerListHolder.setPresenter(listPresenter);
//        if (listPresenter.getTimer(index) != null) {
            timerListHolder.bindView(index);
//        }
    }


    @Override
    public int getItemCount() {
        return listPresenter != null ? listPresenter.size() : 0;
    }
}
