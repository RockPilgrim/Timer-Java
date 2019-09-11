package my.rockpilgrim.timerforall.model;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Tree.TreeHolder;
import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class Model {

    public static final String TAG = "Model";

    private TreeHolder<Timer> timerList;

    public Model() {
        timerList = new TreeHolder<>();
    }

    public void addTimerToRoot(Timer timer) {
        timerList.addToRoot(timer);
    }

    public void addTimer(int fatherIndex,Timer timer) {
        timerList.addTimer(fatherIndex, timer);
    }

    public ArrayList getBrotherList(int index) {
        return timerList.getParentOf(index).getChildren();
    }

    public ArrayList getChildList(int index) {
        return timerList.getChild(index).getChildren();
    }

    public Timer getTimer(int index) {
        return timerList.getTimer(index);
    }

    public int size() {
        return timerList.size();
    }

}
