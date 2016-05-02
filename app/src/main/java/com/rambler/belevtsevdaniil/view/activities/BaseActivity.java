package com.rambler.belevtsevdaniil.view.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.view.callbacks.OnProgressListener;

import butterknife.Bind;

/**
 * Created by Daniil Belevtsev on 02.05.2016 6:04.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class BaseActivity extends AppCompatActivity implements OnProgressListener {

    @Bind(R.id.container)
    protected View fragmentContainer;

    @Bind(R.id.mainProgressBar)
    protected ProgressBar progressBar;

    @Override
    public void showProgressBar() {
        fragmentContainer.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        fragmentContainer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .commit();
    }

    public void addFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment, tag);
        if(addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }
}
