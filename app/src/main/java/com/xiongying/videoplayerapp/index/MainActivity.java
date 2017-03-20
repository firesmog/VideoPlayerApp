package com.xiongying.videoplayerapp.index;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.xiongying.videoplayerapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener,ViewPager.OnPageChangeListener{

    private BottomBar mBottomBar;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList=new ArrayList<>();
    private FragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mBottomBar= (BottomBar) findViewById(R.id.bottomBarId);
        mViewPager= (ViewPager) findViewById(R.id.viewpagerId);
        mBottomBar.setOnTabSelectListener(this);
        mViewPager.addOnPageChangeListener(this);
        mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId)
        {
            case R.id.tab_index:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tab_local:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tab_collection:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tab_account:
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomBar.selectTabAtPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
