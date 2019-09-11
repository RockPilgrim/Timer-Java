package my.rockpilgrim.timerforall.presenter.list;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.timer.Timer;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;

public class ListPresenter {

    private static final String TAG = "ListPresenter";

    @Inject
    public Model model;
    @Inject
    public TimerHandler timerHandler;

    public ListPresenter() {
        App.getComponent().inject(this);
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
        timerHandler.start(index);
    }

    public Timer getTimer(int index) {
        return model.getTimer(index);
    }

    public int size() {
        return model.size();
    }

}
