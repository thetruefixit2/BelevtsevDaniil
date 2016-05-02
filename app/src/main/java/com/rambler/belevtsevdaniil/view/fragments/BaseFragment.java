package com.rambler.belevtsevdaniil.view.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.rambler.belevtsevdaniil.presenter.interfaces.Presenter;
import com.rambler.belevtsevdaniil.view.callbacks.OnProgressListener;
import com.rambler.belevtsevdaniil.view.interfaces.View;

/**
 * Created by Daniil Belevtsev on 02.05.2016 2:59.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public abstract class BaseFragment extends Fragment implements View {

    protected OnProgressListener activityCallbacks;

    protected abstract Presenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if(getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProgressListener) {
            activityCallbacks = (OnProgressListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void showLoading() {
        activityCallbacks.showProgressBar();
    }

    @Override
    public void hideLoading() {
        activityCallbacks.hideProgressBar();
    }


}
