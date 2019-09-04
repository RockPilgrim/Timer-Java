package my.rockpilgrim.timerforall.presenter.Timer;

import android.util.Log;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Model;

public class TimerPresenter {

    public static final String TAG = "TimerPresenter";
    public Model model;
//    private TreeHandler<Timer> treeTimers;

    public TimerPresenter() {
        model = new Model();
        initTimerList();
    }

    private void initTimerList() {
        for (int i = 0; i < 3; i++) {
            model.addTimerToRoot(new Timer(5 + i));
        }
        for (int i = 0; i < 2; i++) {
           model.addTimer(1, new Timer(5 + i));
        }
        for (int i = 0; i < 2; i++) {
            model.addTimer(4, new Timer(5 + i));
        }
    }

    public void start(int index) {
        ArrayList<Timer> kids = model.getFirstChildList(index);
        if (!kids.isEmpty()) {
            for (Timer t : kids) {
                t.setPresenter(this);
                Log.i(TAG, "Begin: " + t.getIndex());
                t.start();
            }
        }
    }

    public void finish(int index) {
        Log.i(TAG, "Finish: " + index);

        ArrayList<Timer> kids = model.getNextChildList(index);
        if (!kids.isEmpty()) {
            for (Timer t : kids) {
                start(t.getIndex());
//                t.start();
            }
        }
    }
    public Timer getTimer(int index) {
        return model.getTimer(index);
    }

    public int size() {
        return model.size();
    }

}
