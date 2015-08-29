package io.github.johnfeng.lockview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.github.johnfeng.lockview.R;

/**
 * Created by guangweifeng on 27/07/15.
 */
public class IntroTopicFragment extends BaseFragment {
    public static IntroTopicFragment getInstance() {
        IntroTopicFragment fragment = new IntroTopicFragment();
        return fragment;
    }

    @InjectView(R.id.intro_topic_content1)
    public TextView introImageContent1;

    @InjectView(R.id.intro_topic_content2)
    public TextView introImageContent2;

    @InjectView(R.id.intro_topic_content3)
    public TextView introImageContent3;

    @InjectView(R.id.intro_topic_button)
    public Button introImageButton;

    @OnClick(R.id.intro_topic_button)
    public void onButtonClick() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_topic, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
