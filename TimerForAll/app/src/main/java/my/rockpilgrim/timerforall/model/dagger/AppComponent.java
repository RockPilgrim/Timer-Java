package my.rockpilgrim.timerforall.model.dagger;

import javax.inject.Singleton;

import dagger.Component;
import my.rockpilgrim.timerforall.presenter.detail.DetailPresenter;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(ListPresenter presenter);
    void inject(TimerHandler handler);
    void inject(DetailPresenter presenter);
}
