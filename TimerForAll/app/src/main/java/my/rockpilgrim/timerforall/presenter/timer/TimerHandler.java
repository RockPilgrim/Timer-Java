package my.rockpilgrim.timerforall.presenter.timer;

import android.util.Log;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.detail.TickListener;

public class TimerHandler implements TimeListener {

    private static final String TAG = "TimerHandler";
    private ArrayList<Timer> currentList;
    public Model model;
    public TickListener tickListener;

    public TimerHandler(Model model) {
        this.model = model;
        currentList = new ArrayList<>();
    }

    public void start(int index) {
        ArrayList<Timer> init = model.getBrotherList(index);
        if (!currentList.isEmpty()) {
            currentList.get(0).setTickListener(tickListener);
        }
        if (!init.isEmpty()) {
            for (Timer t : init) {
                t.setListener(this);
                currentList.add(t);
                Log.i(TAG, "Begin: " + t.getIndex());
                t.start();
            }
        }
    }

    public void finish(int index) {
        Log.i(TAG, "Finished: " + index);
        currentList.remove(model.getTimer(index));
        ArrayList<Timer> next = model.getChildList(index);
        if (!next.isEmpty()) {
            for (Timer t : next) {
                start(t.getIndex());
            }
        }
    }

    public void connectToMainTime(TickListener tickListener) {
        this.tickListener = tickListener;
        if (!currentList.isEmpty()) {
            currentList.get(0).setTickListener(tickListener);
        } else {
            tickListener.onError("No timer");
        }
    }
}
