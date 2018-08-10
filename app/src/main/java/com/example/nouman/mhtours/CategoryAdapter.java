package com.example.nouman.mhtours;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nouman.mhtours.fragments.BeachFragment;
import com.example.nouman.mhtours.fragments.CavesFragment;
import com.example.nouman.mhtours.fragments.FortsFragment;
import com.example.nouman.mhtours.fragments.MuseumsFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BeachFragment();
            case 1:
                return new CavesFragment();
            case 2:
                return new FortsFragment();
            default:
                return new MuseumsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_beach);
            case 1:
                return mContext.getString(R.string.category_caves);
            case 2:
                return mContext.getString(R.string.category_forts);
            default:
                return mContext.getString(R.string.category_museums);
        }
    }
}
