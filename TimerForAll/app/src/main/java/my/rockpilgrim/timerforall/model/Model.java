package my.rockpilgrim.timerforall.model;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.model.Tree.TreeHandler;
import my.rockpilgrim.timerforall.presenter.Timer.Timer;

public class Model {

    public static final String TAG = "Model";

    private TreeHandler<Timer> treeTimers;

    public Model() {
        treeTimers = new TreeHandler<>();
    }

    public void addTimerToRoot(Timer timer) {
        treeTimers.addToRoot(timer);
    }

    public void addTimer(int fatherIndex,Timer timer) {
        treeTimers.addTimer(fatherIndex, timer);
    }

    public ArrayList getFirstChildList(int index) {
        return treeTimers.getParentOf(index).getChildren();
    }

    public ArrayList getNextChildList(int index) {
        return treeTimers.getChild(index).getChildren();
    }

    public Timer getTimer(int index) {
        return treeTimers.getTimer(index);
    }

    public int size() {
        return treeTimers.size();
    }

}
