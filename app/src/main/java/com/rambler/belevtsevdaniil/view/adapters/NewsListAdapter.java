package com.rambler.belevtsevdaniil.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.utils.TimeFormat;
import com.rambler.belevtsevdaniil.view.callbacks.OnNewsListEventsListener;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.grantland.widget.AutofitTextView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private List<NewsItem> newsFeed;
    private Context context;
    private final OnNewsListEventsListener callBackListener;

    public NewsListAdapter(Context context, OnNewsListEventsListener listener) {
        this.context = context;
        callBackListener = listener;
    }

    public void setNewsFeed(List<NewsItem> newsFeed) {
//        if(this.newsFeed == null) {
//            this.newsFeed = newsFeed;
//        } else {
//            this.newsFeed.addAll(newsFeed);
//        }
        this.newsFeed = newsFeed;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_newslist_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        NewsItem item = newsFeed.get(position);
        holder.newsTitle.setText(item.getTitle());
        holder.pubTime.setText(TimeFormat.format(item.getPublishDate()));
        holder.item = item;

        loadImageInto(holder.newsImage, item);
        holder.view.setOnClickListener(v -> {
            if (callBackListener != null) {
                callBackListener.showFullNews(holder.item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(newsFeed != null) {
            return newsFeed.size();
        } else {
            return 0;
        }
    }

    private void loadImageInto(ImageView imageView, NewsItem newsItem) {
        if(newsItem.getImage() != null) {
            Picasso.with(context)
                    .load(newsItem.getImage().getUrl())
                    .networkPolicy(NetworkPolicy.OFFLINE)
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.news_element_image) ImageView newsImage;
        @Bind(R.id.news_element_title) AutofitTextView newsTitle;
        @Bind(R.id.publishedTime) TextView pubTime;

        public final View view;
        public NewsItem item;
        public ViewHolder(View view) {
            super(view);

            this.view = view;
            ButterKnife.bind(this, view);
        }
    }
}
