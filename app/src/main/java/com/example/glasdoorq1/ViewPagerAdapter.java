package com.example.glasdoorq1;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
public class ViewPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> lstFragment=new ArrayList<>();
    private final List<String> lsttitle=new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lsttitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
    public void AddFragment(Fragment fragment,String title)
    {
        lstFragment.add(fragment);
        lsttitle.add(title);
    }
}



