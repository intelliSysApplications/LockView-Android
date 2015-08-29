package io.github.johnfeng.lockview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.johnfeng.lockview.R;

/**
 * Created by guangweifeng on 27/07/15.
 */
public class SetTopicFragment extends BaseFragment {

    @InjectView(R.id.set_topic_edit_text)
    EditText setTopicEditText;

    public static SetTopicFragment getInstance() {
        SetTopicFragment fragment = new SetTopicFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_set_topic, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopicEditText.requestFocus();
        showSoftInput(view);
    }
}
