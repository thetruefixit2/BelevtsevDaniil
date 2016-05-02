package com.rambler.belevtsevdaniil.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.presenter.interfaces.Presenter;
import com.rambler.belevtsevdaniil.presenter.presenters.FullNewsPresenter;
import com.rambler.belevtsevdaniil.view.interfaces.FullNewsView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 02.05.2016 1:04.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class FullNewsFragment extends BaseFragment implements FullNewsView {
    public static final String TAG = "FullNewsFragment";

    @Bind(R.id.item_image)
    ImageView itemImage;

    @Bind(R.id.item_description)
    TextView itemDescription;

    @Inject
    FullNewsPresenter presenter;

    public static FullNewsFragment newInstance(NewsItem item) {
        Bundle args = new Bundle();
        args.putSerializable(AppConst.EXTRA_NEWS_ITEM, item);
        FullNewsFragment fragment = new FullNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        App.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this, getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_news_info, container, false);
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
        loadImageInto(itemImage, item);
        itemDescription.setText(item.getDescription());
    }

    @Override
    public void showEmptyItem() {

    }

    private void loadImageInto(ImageView imageView, NewsItem newsItem) {
        if(newsItem.getImage() != null) {
            Picasso.with(getContext())
                    .load(newsItem.getImage().getUrl())
                    .fit()
                    .centerCrop()
                    .into(imageView);
        } else {
            switch (newsItem.getProvider()) {
                case GAZETA:
                    imageView.setImageResource(R.drawable.gazeta);
                    break;
                case LENTA:
                    imageView.setImageResource(R.drawable.lenta);
                    break;
            }
        }
    }
}
