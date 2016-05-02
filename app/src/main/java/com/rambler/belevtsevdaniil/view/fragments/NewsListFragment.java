package com.rambler.belevtsevdaniil.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.presenter.interfaces.Presenter;
import com.rambler.belevtsevdaniil.presenter.presenters.NewsListPresenter;
import com.rambler.belevtsevdaniil.view.adapters.NewsListAdapter;
import com.rambler.belevtsevdaniil.view.callbacks.OnNewsListEventsListener;
import com.rambler.belevtsevdaniil.view.interfaces.NewsListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NewsListFragment extends BaseFragment implements NewsListView {
    public static final String TAG = "NewsListFragment";

    @Bind(R.id.list)
    protected RecyclerView recyclerView;

    @Inject
    protected NewsListPresenter presenter;

    private NewsListAdapter newsListAdapter;

    private OnNewsListEventsListener callbacks;

    public NewsListFragment() {
    }

    public static NewsListFragment newInstance() {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewsListEventsListener) {
            callbacks = (OnNewsListEventsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newslist, container, false);
        ButterKnife.bind(this, view);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsListAdapter = new NewsListAdapter(getContext(), callbacks);
        recyclerView.setAdapter(newsListAdapter);
        presenter.onCreateView(savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.saveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Override
    protected Presenter getPresenter() {
        return presenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // CALLBACKS ZONE
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void showLastNews(List<NewsItem> newsFeed) {
        newsListAdapter.setNewsFeed(newsFeed);
    }

    @Override
    public void showEmptyNews() {

    }

    @Override
    public void showFullNews(NewsItem item) {
        callbacks.showFullNews(item);
    }

    @Override
    public void showError(String error) {
        System.out.println(error);
        Snackbar.make(recyclerView, error, Snackbar.LENGTH_LONG).show();
    }
}
