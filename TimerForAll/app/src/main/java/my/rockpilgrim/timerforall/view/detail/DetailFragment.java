package my.rockpilgrim.timerforall.view.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.detail.DetailPresenter;

public class DetailFragment extends MvpAppCompatFragment implements MvpDetailView {

    @BindView(R.id.mainTime_textView)
    public TextView mainTextView;
    @BindView(R.id.afterTime_textView)
    public TextView afterTextView;
    @BindView(R.id.nextTime_textView)
    public TextView nextStartTextView;


    @InjectPresenter
    public DetailPresenter presenter;

    @ProvidePresenter
    public DetailPresenter providePresenter() {
        return new DetailPresenter();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void setMainTime(String time) {
        mainTextView.setText(time);
    }

    @Override
    public void setAfterTime(String time) {
        afterTextView.setText(time);
    }

    @Override
    public void setNextStartTime(String time) {
        nextStartTextView.setText(time);
    }
}
