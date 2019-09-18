package my.rockpilgrim.timerforall.presenter.timer;

import android.util.Log;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.TimeFormat;

public class TimerHandler implements TimeListener {

    private static final String TAG = "TimerHandler";
    private ArrayList<Timer> currentList;
    public Model model;
    private TimeListener notificationListener;

    public TimerHandler(Model model) {
        this.model = model;
        currentList = new ArrayList<>();
    }

    public void setNotificationListener(TimeListener notificationListener) {
        this.notificationListener = notificationListener;
    }

    public void start(int index) {
        notificationListener.start(index);
        ArrayList<Timer> init = model.getBrotherList(index);

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
        notificationListener.finish(index);
        Log.i(TAG, "Finished: " + index);
        currentList.remove(model.getTimer(index));
        ArrayList<Timer> next = model.getChildList(index);
        if (!next.isEmpty()) {
            for (Timer t : next) {
                start(t.getIndex());
            }
        }
    }

    @Override
    public void onTick(int index, long millis) {
//        Log.i(TAG, "Time " + 1000 * (Math.floor(millis / 1000)) + " / " + 100 * (Math.floor(millis / 100)));
        if (1000 * (Math.floor(millis / 1000)) == 100 * (Math.floor(millis / 100))) {
            notificationListener.onTick(index,millis);
        }
    }
}
