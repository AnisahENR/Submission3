package com.example.submission3.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.submission3.fragment.ListFollowerFragment;
import com.example.submission3.fragment.ListFollowingFragment;
import com.example.submission3.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    String username;
    Bundle bundle;

    public SectionsPagerAdapter(Context context, FragmentManager fm, String username) {
        super(fm);
        mContext = context;
        this.username = username;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                bundle = new Bundle();
                bundle.putString("username", username); // menginputkan parameter
                ListFollowerFragment listFollowerFragment = new ListFollowerFragment();
                listFollowerFragment.setArguments(bundle);// mengirim parameter
                return listFollowerFragment;

            case 1:
                bundle = new Bundle();
                bundle.putString("username", username); // menginputkan parameter
                ListFollowingFragment listFollowingFragment = new ListFollowingFragment();
                listFollowingFragment.setArguments(bundle);// mengirim parameter
                return listFollowingFragment;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}