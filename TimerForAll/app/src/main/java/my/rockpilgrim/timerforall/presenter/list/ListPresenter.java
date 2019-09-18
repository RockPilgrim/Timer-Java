package my.rockpilgrim.timerforall.presenter.list;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.timer.TimeListener;
import my.rockpilgrim.timerforall.presenter.timer.Timer;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;
import my.rockpilgrim.timerforall.view.MvpMainView;

@InjectViewState
public class ListPresenter extends MvpPresenter<MvpMainView> implements OnListPresenter {

    private static final String TAG = "ListPresenter";
    public static final String FINISHED = "Finished";
    public static final String START = "Start!";

    @Inject
    public Model model;
    @Inject
    public TimerHandler timerHandler;

    public ListPresenter() {
        App.getComponent().inject(this);
//        initTimerList();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        timerHandler.setNotificationListener(new TimeListener() {
            @Override
            public void start(int index) {
                getViewState().notification(index,model.getTimer(index).getName(), START);
            }

            @Override
            public void finish(int index) {
                getViewState().notification(index,model.getTimer(index).getName(), FINISHED);
            }

            @Override
            public void onTick(int index, long millis) {
                getViewState().notification(index, model.getTimer(index).getName(), String.format("%s", (millis / 1000)));
            }
        });
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



    @Override
    public void start(int index) {
        timerHandler.start(index);
    }

    @Override
    public void connectToModel(OnListChanged listener) {
        model.setListChangeListener(listener);
    }

    @Override
    public Timer getTimer(int index) {
        return model.getTimer(index);
    }

    @Override
    public int size() {
        return model.size();
    }
}
