package my.rockpilgrim.timerforall.presenter.detail;

import android.util.Log;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.presenter.TimeFormat;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;
import my.rockpilgrim.timerforall.view.detail.MvpDetailView;

@InjectViewState
public class DetailPresenter extends MvpPresenter<MvpDetailView> {


    public static final String TAG = "DetailPresenter";
    @Inject
    TimerHandler timerHandler;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        setMainTime();
    }

    public DetailPresenter() {
        App.getComponent().inject(this);
    }

    private void setMainTime() {

        timerHandler.connectToMainTime(new TickListener() {
            @Override
            public void sendTime(long millis) {
                Log.i(TAG, "tick");
                getViewState().setMainTime(TimeFormat.getTime(millis));
            }
            @Override
            public void onError(String error) {

            }
        });
    }
    private void setAfterTime(String time) {
        getViewState().setAfterTime(time);
    }
    private void setNextStartTime(String time) {
        getViewState().setNextStartTime(time);
    }

}
