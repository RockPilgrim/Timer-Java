package my.rockpilgrim.timerforall.model;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Tree.TreeHolder;
import my.rockpilgrim.timerforall.presenter.list.OnListChangeListener;
import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class Model {

    public static final String TAG = "Model";

    OnListChangeListener listener;
    private TreeHolder<Timer> timerList;

    public Model() {
        timerList = new TreeHolder<>();
    }

    public void addTimerToRoot(Timer timer) {
        timerList.addToRoot(timer);
        onChange();
    }

    public void addTimer(int fatherIndex,Timer timer) {
        timerList.addTimer(fatherIndex, timer);
        onChange();
    }

    private void onChange() {
        if (listener != null) {
            listener.onListChange();
        }
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

    public void setListChangeListener(OnListChangeListener listener) {
        this.listener = listener;
    }
}
