package my.timerforall.Timer;

import android.util.Log;

import java.util.ArrayList;

import my.timerforall.Tree.TreeHandler;

public class TimerHolder {

    private TreeHandler<TimerFunctional> treeTimers;
    public static final String LOG = "THIS_LOG";


    public TimerHolder() {
        treeTimers = new TreeHandler<>();
        for (int i = 0; i < 3; i++) {
            treeTimers.addToRoot(new TimerFunctional(5 + i));
        }
        for (int i = 0; i < 2; i++) {
            treeTimers.addTimer(1, new TimerFunctional(5 + i));
        }
        for (int i = 0; i < 2; i++) {
            treeTimers.addTimer(4, new TimerFunctional(5 + i));
        }
    }

    public void start(int index) {
        ArrayList<TimerFunctional> kids = treeTimers.getParentOf(index).getChildren();
        if (!kids.isEmpty()) {
            for (TimerFunctional t : kids) {
                t.setHolder(this);
                Log.i(LOG, "Begin: "+t.getIndex());
                t.start();

            }
        }
    }

    public void finish(int index) {
        Log.i(LOG, "Finish: "+index);

        ArrayList<TimerFunctional> kids = treeTimers.getNode(index).getChildren();
        if (!kids.isEmpty()) {
            for (TimerFunctional t : kids) {
                start(t.getIndex());
//                t.start();
            }
        }
    }

    public TimerFunctional getTimer(int index) {
        return treeTimers.getTimer(index);
    }

    public int size() {
        return treeTimers.size();
    }
}
