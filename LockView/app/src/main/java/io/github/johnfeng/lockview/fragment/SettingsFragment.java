package io.github.johnfeng.lockview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.github.johnfeng.lockview.R;

/**
 * Created by guangweifeng on 27/07/15.
 */
public class SettingsFragment extends BaseFragment {
    public static SettingsFragment getInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @OnClick(R.id.settings_title_foreground)
    public void onTitleForegroundClick() {

    }

    @InjectView(R.id.settings_title_foreground_color)
    TextView titleForegroundColor;

    @OnClick(R.id.settings_content_foreground)
    public void onContentForegroundClick() {

    }

    @InjectView(R.id.settings_content_foreground_color)
    TextView contentForegroundColor;

    @OnClick(R.id.settings_title_background)
    public void onTitleBackground() {

    }

    @InjectView(R.id.settings_title_background_color)
    TextView titleBackgroundColor;

    @OnClick(R.id.settings_content_background)
    public void onContentBackground() {

    }

    @InjectView(R.id.settings_content_background_color)
    TextView contentBackgroundColor;

    @OnClick(R.id.settings_title_fontsize)
    public void onTitleFontsize() {

    }

    @InjectView(R.id.settings_title_fontsize_num)
    TextView titleFontsizeNum;

    @OnClick(R.id.settings_content_fontsize)
    public void onContentFontsizeClick() {

    }

    @InjectView(R.id.settings_content_fontsize_num)
    TextView contentFontsizeNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container);
        ButterKnife.inject(this, view);
        return view;
    }
}
