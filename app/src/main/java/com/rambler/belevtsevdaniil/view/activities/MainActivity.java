package com.rambler.belevtsevdaniil.view.activities;

import android.os.Bundle;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.view.callbacks.OnNewsListEventsListener;
import com.rambler.belevtsevdaniil.view.fragments.FullNewsFragment;
import com.rambler.belevtsevdaniil.view.fragments.NewsListFragment;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements OnNewsListEventsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        replaceFragment(NewsListFragment.newInstance(), NewsListFragment.TAG);
    }

    @Override
    public void showFullNews(NewsItem item) {
        addFragment(FullNewsFragment.newInstance(item),FullNewsFragment.TAG, true);
    }




}
