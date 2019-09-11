package my.rockpilgrim.timerforall.view.detail;

import moxy.MvpView;

public interface MvpDetailView extends MvpView {

    public void setMainTime(String time);
    public void setAfterTime(String time);
    public void setNextStartTime(String time);
}
