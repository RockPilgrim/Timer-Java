package my.rockpilgrim.timerforall.presenter._test;

import android.util.ArrayMap;

import java.util.ArrayList;

import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class TimerHolder1_0 {
    private ArrayMap<Long, Timer> timerMap;


    public TimerHolder1_0() {
        timerMap = new ArrayMap<>();
        for (int i = 0; i < 4; i++) {
        }
    }

    public void onStart(long index) {
        if (timerMap.get(index * +1) != null) {
            int i = 1;
            while (timerMap.get(index * 10 + i) != null) {
                timerMap.get(index * 10 + i).start();
                i++;
            }
        }
    }

    public void onFinish(long index) {
        if (timerMap.get(index * 10 + 1) != null) {
            int i = 1;
            while (timerMap.get(index * 10 + i) != null) {
                timerMap.get(index * 10 + i).start();
                i++;
            }
        }
    }

    public void addTimer(long index, Timer timer) {
        timerMap.put(index, timer);
    }


    public ArrayList getList() {
        ArrayList<Timer> list = new ArrayList<>();
        try {

            for (int i = 0; i < timerMap.size(); i++) {
                list.add(timerMap.valueAt(i));
            }
        } catch (NullPointerException e) {

        }
        return list;
    }
}
