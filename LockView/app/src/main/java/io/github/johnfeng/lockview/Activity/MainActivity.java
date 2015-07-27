package io.github.johnfeng.lockview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.johnfeng.lockview.R;
import io.github.johnfeng.lockview.fragment.IntroImageFragment;
import io.github.johnfeng.lockview.fragment.IntroTopicFragment;
import io.github.johnfeng.lockview.fragment.PreviewFragment;
import io.github.johnfeng.lockview.fragment.SetColorFragment;
import io.github.johnfeng.lockview.fragment.SetImageFragment;
import io.github.johnfeng.lockview.fragment.SetTopicFragment;
import io.github.johnfeng.lockview.widget.HackViewPager;


public class MainActivity extends BaseActivity {

    static final int PAGERS_COUNT = 6;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initGridView();
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

    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case INDEX_INTRO_IMAGE:
                    fragment = IntroImageFragment.getInstance();
                    break;
                case INDEX_SET_IMAGE:
                    fragment = SetImageFragment.getInstance();
                    break;
                case INDEX_INTRO_TOPIC:
                    fragment = IntroTopicFragment.getInstance();
                    break;
                case INDEX_SET_TOPIC:
                    fragment = SetTopicFragment.getInstance();
                    break;
                case INDEX_SET_COLOR:
                    fragment = SetColorFragment.getInstance();
                    break;
                case INDEX_PREVIEW:
                    fragment = PreviewFragment.getInstance();
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
}
