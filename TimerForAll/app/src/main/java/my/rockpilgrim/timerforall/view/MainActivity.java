package my.rockpilgrim.timerforall.view;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.view.add.AddFragment;
import my.rockpilgrim.timerforall.view.list.TimerListAdapter;

public class MainActivity extends MvpAppCompatActivity implements MvpMainView {


    public static final String TAG = "MainActivity";
    public static final String TIMER_INFO = "Timer info";
    public static final String CHANNEL_ID = "timer_channel_id";

    @BindView(R.id.floatingActionButton)
    public FloatingActionButton actionButton;

    private RecyclerView recyclerView;
    private TimerListAdapter listAdapter;

    private NotificationManager notificationManager;

    private NotificationCompat.Builder builder;

    @InjectPresenter
    public ListPresenter presenter;

    @ProvidePresenter
    public ListPresenter providePresenter() {
        return new ListPresenter();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);
        initList();
    }



    private void initList() {
        listAdapter = new TimerListAdapter(presenter);
        recyclerView = findViewById(R.id.recycler_view);
        // More productivity
//        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);
    }

    @OnClick(R.id.floatingActionButton)
    public void onActionButtonClick() {

        AddFragment addFragment = new AddFragment();
        addFragment.show(getSupportFragmentManager(), "add");
    }

    @Override
    public void notification(int index, String title, String text) {
        Log.i(TAG, "notification");


        getBuilder().setContentTitle(title)
                .setContentText(text);
        getNotificationManager().notify(index, getBuilder().build());
    }

    private NotificationCompat.Builder getBuilder() {
        if (builder == null) {
            builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_add)
                    .setContentTitle("Timer")
                    .setContentText("Now")
//                        .setOngoing(running)
                    .setOnlyAlertOnce(true)
                    .setAutoCancel(true);
        }
        return builder;
    }

    private NotificationManager getNotificationManager() {
        if (notificationManager == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager = getSystemService(NotificationManager.class);
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription(TIMER_INFO);

                notificationManager.createNotificationChannel(channel);
            }
        }
        return notificationManager;
    }

    @Override
    protected void onPause() {
        super.onPause();
        notification(2, "Time", "Pause");
    }
}
