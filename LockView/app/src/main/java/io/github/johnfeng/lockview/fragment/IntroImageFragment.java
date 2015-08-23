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
public class IntroImageFragment extends BaseFragment {

    @InjectView(R.id.intro_image_content1)
    public TextView introImageContent1;

    @InjectView(R.id.intro_image_content2)
    public TextView introImageContent2;

    @InjectView(R.id.intro_image_button)
    public Button introImageButton;

    @OnClick(R.id.intro_image_button)
    public void onButtonClick() {

    }

    public static IntroImageFragment getInstance() {
        IntroImageFragment fragment = new IntroImageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_image, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
