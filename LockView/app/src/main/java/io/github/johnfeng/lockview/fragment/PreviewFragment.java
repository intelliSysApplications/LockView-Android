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
public class PreviewFragment extends BaseFragment {

    @InjectView(R.id.preview_title)
    TextView previewTitle;

    @InjectView(R.id.preview_content)
    TextView previewContent;

    @InjectView(R.id.preview_button)
    Button previewButton;

    @OnClick(R.id.preview_button)
    public void onButtonClick() {

    }

    public static PreviewFragment getInstance() {
        PreviewFragment fragment = new PreviewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
