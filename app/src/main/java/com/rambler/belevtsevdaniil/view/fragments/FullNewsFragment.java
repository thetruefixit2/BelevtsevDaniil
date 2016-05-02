package com.rambler.belevtsevdaniil.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.presenter.interfaces.Presenter;
import com.rambler.belevtsevdaniil.presenter.presenters.FullNewsPresenter;
import com.rambler.belevtsevdaniil.view.interfaces.FullNewsView;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 02.05.2016 1:04.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class FullNewsFragment extends BaseFragment implements FullNewsView {
    public static final String TAG = "FullNewsFragment";
    @Inject
    FullNewsPresenter presenter;

    public static FullNewsFragment newInstance(NewsItem item) {
        Bundle args = new Bundle();
        args.putParcelable(AppConst.EXTRA_NEWS_ITEM, Parcels.wrap(item));
        FullNewsFragment fragment = new FullNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newslist, container, false);
        ButterKnife.bind(this, view);
        presenter.onCreateView(savedInstanceState);
        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.saveInstanceState(outState);
    }

    @Override
    protected Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void showError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showNewsItem(NewsItem item) {

    }

    @Override
    public void showEmptyItem() {

    }
}
