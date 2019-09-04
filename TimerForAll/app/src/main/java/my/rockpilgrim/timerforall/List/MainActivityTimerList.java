package my.rockpilgrim.timerforall.List;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;

public class MainActivityTimerList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TimerListAdapter listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_list);

        listAdapter = new TimerListAdapter();

        recyclerView = findViewById(R.id.recycler_view);

        // More productivity
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);
    }
}
