package io.github.johnfeng.lockview.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by guangweifeng on 27/07/15.
 */
public class BaseFragment extends Fragment {

    protected Dialog mDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    public Dialog getDialog() {
        return mDialog;
    }

    public void showDialog(Dialog dialog) {
        dismissDialog();
        mDialog = dialog;
        mDialog.show();
    }

    public void dismissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = null;
    }

    public void showProgress(String msg) {
        dismissDialog();
        mDialog = ProgressDialog.show(getActivity(), null, msg, true, true);
    }

    public void showProgress(int msg) {
        dismissDialog();
        mDialog = ProgressDialog.show(getActivity(), null, getString(msg), true, true);
    }

    public static interface ErrorCallback {
        public void callback(Throwable throwable);
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getActivity());
    }

    protected void showSoftInput(View view) {
        InputMethodManager ims = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        ims.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    protected void hideSoftInput(View view) {
        InputMethodManager ims = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        ims.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onClickActionBar() {
        // do thing
    }
}
