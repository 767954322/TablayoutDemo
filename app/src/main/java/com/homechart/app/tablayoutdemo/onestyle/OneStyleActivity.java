package com.homechart.app.tablayoutdemo.onestyle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flyco.tablayout.SlidingTabLayout;
import com.homechart.app.tablayoutdemo.R;

import java.util.ArrayList;
import java.util.List;

public class OneStyleActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SlidingTabLayout mTabLayout;

    private final String[] mTitles = {"tab1", "tab2", "tab3"};
    ;//页卡标题集合
    private List<Fragment> mFragmentsList = new ArrayList<>();//页卡视图集合
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (SlidingTabLayout) findViewById(R.id.tly_slidingtablayout);

        //设置下划线的高度
        mTabLayout.setIndicatorHeight(5f);
        //设置tab的字体大小
        mTabLayout.setTextsize(15f);

        initFragment();

        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager);

        //初始位置
        mViewPager.setCurrentItem(2);
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragmentsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentsList.get(position);
        }
    }


    private void initFragment() {
        mFragmentsList.add(new OneFragment());
        mFragmentsList.add(new TwoFragment());
        mFragmentsList.add(new ThreeFragment());
    }
}
