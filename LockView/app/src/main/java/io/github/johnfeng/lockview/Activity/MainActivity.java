package io.github.johnfeng.lockview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.johnfeng.lockview.Constants;
import io.github.johnfeng.lockview.R;
import io.github.johnfeng.lockview.fragment.BaseFragment;
import io.github.johnfeng.lockview.fragment.IntroImageFragment;
import io.github.johnfeng.lockview.fragment.IntroTopicFragment;
import io.github.johnfeng.lockview.fragment.PreviewFragment;
import io.github.johnfeng.lockview.fragment.SettingsFragment;
import io.github.johnfeng.lockview.fragment.SetImageFragment;
import io.github.johnfeng.lockview.fragment.SetTopicFragment;
import io.github.johnfeng.lockview.toolbox.BusProvider;
import io.github.johnfeng.lockview.widget.HackViewPager;


public class MainActivity extends BaseActivity {

    static final int PAGERS_COUNT = 6;

    static final int INDEX_INVAILD = -1;
    static final int INDEX_INTRO_IMAGE = 0;
    static final int INDEX_SET_IMAGE = 1;
    static final int INDEX_INTRO_TOPIC = 2;
    static final int INDEX_SET_TOPIC = 3;
    static final int INDEX_SET_COLOR = 4;
    static final int INDEX_PREVIEW = 5;

    @InjectView(R.id.home_indicator)
    PagerSlidingTabStrip mIndicator;
    @InjectView(R.id.home_view_pager)
    HackViewPager mViewPager;

    FragmentAdapter mAdapter;
    BaseFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initGridView();
        BusProvider.getInstance()
                .register(this);

        switchFragment(INDEX_INTRO_IMAGE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance()
                .unregister(this);
    }

    private void initGridView() {
        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager);
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void switchFragment(int index) {
        int position = INDEX_INVAILD;
        switch (index) {
            case INDEX_INVAILD:
                return;
            case INDEX_INTRO_IMAGE:
                mFragment = IntroImageFragment.getInstance();
                break;
            case INDEX_SET_IMAGE:
                mFragment = SetImageFragment.getInstance();
                break;
            case INDEX_INTRO_TOPIC:
                mFragment = IntroTopicFragment.getInstance();
                break;
            case INDEX_SET_TOPIC:
                mFragment = SetTopicFragment.getInstance();
                break;
            case INDEX_SET_COLOR:
                mFragment = SettingsFragment.getInstance();
                break;
            case INDEX_PREVIEW:
                mFragment = PreviewFragment.getInstance();
                break;
            default:
                return;
        }

        if (mAdapter != null) {
            mViewPager.setCurrentItem(position, true);
        }
    }


    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case INDEX_INVAILD:
                    mFragment = IntroImageFragment.getInstance();
                    break;
                case INDEX_INTRO_IMAGE:
                    mFragment = IntroImageFragment.getInstance();
                    break;
                case INDEX_SET_IMAGE:
                    mFragment = SetImageFragment.getInstance();
                    break;
                case INDEX_INTRO_TOPIC:
                    mFragment = IntroTopicFragment.getInstance();
                    break;
                case INDEX_SET_TOPIC:
                    mFragment = SetTopicFragment.getInstance();
                    break;
                case INDEX_SET_COLOR:
                    mFragment = SettingsFragment.getInstance();
                    break;
                case INDEX_PREVIEW:
                    mFragment = PreviewFragment.getInstance();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return PAGERS_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            switch (position) {
                case INDEX_INTRO_IMAGE:
                    title = getString(R.string.fragment_title_intro_image);
                    break;
                case INDEX_SET_IMAGE:
                    title = getString(R.string.fragment_title_set_image);
                    break;
                case INDEX_INTRO_TOPIC:
                    title = getString(R.string.fragment_title_intro_topic);
                    break;
                case INDEX_SET_TOPIC:
                    title = getString(R.string.fragment_title_set_topic);
                    break;
                case INDEX_SET_COLOR:
                    title = getString(R.string.fragment_title_set_topic);
                    break;
                case INDEX_PREVIEW:
                    title = getString(R.string.fragment_title_preview);
                    break;
            }
            return title;
        }

    }

    @SuppressWarnings("unused")
    public void onBusEvent(BusProvider.BusEvent event) {
        if (event == null) {
            return;
        }
        if (event.eventId == Constants.EVENT_CHANGE_FRAGMENT) {
            if (event.data != null) {
                int fragmentIndex = event.data.getInt(Constants.KEY_FRAGMENT, INDEX_INVAILD);
                switchFragment(fragmentIndex);
            }
        }
    }
}
