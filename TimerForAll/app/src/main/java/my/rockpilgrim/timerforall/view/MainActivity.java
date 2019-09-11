package my.rockpilgrim.timerforall.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.view.add.AddFragment;
import my.rockpilgrim.timerforall.view.list.TimerListAdapter;
import my.rockpilgrim.timerforall.view.detail.DetailFragment;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.floatingActionButton)
    public FloatingActionButton actionButton;

    private RecyclerView recyclerView;
    private TimerListAdapter listAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);
        initFragment();
        initList();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragments_container);
        if (fragment == null) {
            fragment = new DetailFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragments_container, fragment)
                    .commit();
        }
    }

    private void initList() {
        listAdapter = new TimerListAdapter();
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

}
