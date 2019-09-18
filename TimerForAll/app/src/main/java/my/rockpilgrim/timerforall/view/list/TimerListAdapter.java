package my.rockpilgrim.timerforall.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.presenter.list.OnListPresenter;


public class TimerListAdapter extends RecyclerView.Adapter<TimerListHolder> {

    private OnListPresenter listPresenter;

    public TimerListAdapter(OnListPresenter presenter) {
        listPresenter = presenter;
        listPresenter.connectToModel(this::onAcceptChange);
    }

    private void onAcceptChange() {
        notifyDataSetChanged();
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
//        timerListHolder.setTimer(listPresenter.getTimer(index));
//        if (listPresenter.getTimer(index) != null) {
            timerListHolder.bindView(index);
//        }
    }


    @Override
    public int getItemCount() {
        return listPresenter != null ? listPresenter.size() : 0;
    }
}
