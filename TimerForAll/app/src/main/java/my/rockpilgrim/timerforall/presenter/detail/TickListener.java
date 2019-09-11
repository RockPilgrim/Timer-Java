package my.rockpilgrim.timerforall.presenter.detail;

public interface TickListener {

    void sendTime(long millis);
    void onError(String error);
}
