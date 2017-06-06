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

/**
 * <com.flyco.tablayout.SlidingTabLayout
 * android:id="@+id/tly_slidingtablayout"
 * android:layout_width="match_parent"
 * android:layout_height="48dp"
 * android:background="#EEEEEE"                   ----tab背景的颜色
 * app:tl_divider_color="#1A000000"               ----竖线的颜色
 * app:tl_divider_padding="13dp"
 * app:tl_divider_width="1dp"                     ----竖线的宽度
 * app:tl_indicator_color="#000000"               ----滚动条的颜色
 * app:tl_indicator_height="1.5dp"                ----滚动条的高度
 * app:tl_indicator_width_equal_title="true"      ----滚动条宽度是否与内容相等
 * app:tl_tab_padding="22dp"
 * app:tl_tab_space_equal="true"                  ----tab之间是否平分屏幕
 * app:tl_textSelectColor="#FF4081"               ----tab文字被选中的颜色
 * app:tl_textUnselectColor="#000000"             ----tab文字未被选中的颜色
 * app:tl_textBold="BOTH"                         ----tab文字加粗
 * app:tl_underline_color="#1A000000"             ----下面线条的颜色
 * app:tl_underline_height="1dp" />               ----下面线条的高度
 */
public class OneStyleActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SlidingTabLayout mTabLayout;

    private final String[] mTitles = {"tab1", "tab山东测试2", "tab3"};
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
