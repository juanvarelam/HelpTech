package com.castelaofpe.helptech.perfil;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterPager extends FragmentPagerAdapter {

    int numTabs;

    public AdapterPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

            case 1:

            case 2:

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
