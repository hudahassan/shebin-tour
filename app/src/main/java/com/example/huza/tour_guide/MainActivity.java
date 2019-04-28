package com.example.huza.tour_guide;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.huza.tour_guide.databinding.ActivityMainBinding;
import com.example.huza.tour_guide.fragment.AttractionFragment;
import com.example.huza.tour_guide.fragment.EatFragment;
import com.example.huza.tour_guide.fragment.HotelFragment;
import com.example.huza.tour_guide.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding Binding;

    ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            switch (position){
                case 0:
                    Binding.imageHeader.setImageResource(R.drawable.header_attractions);
                    break;
                case 1:
                    Binding.imageHeader.setImageResource(R.drawable.header_hotel);
                    break;
                case 2:
                    Binding.imageHeader.setImageResource(R.drawable.header_shop);
                    break;
                case 3:
                    Binding.imageHeader.setImageResource(R.drawable.header_eat);
                    break;
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     Binding= DataBindingUtil.setContentView(this,R.layout.activity_main);


         Binding.tabLayout.setupWithViewPager(Binding.viewPager);

        Binding.viewPager.addOnPageChangeListener(pageChangeListener);

        setupViewPager(Binding.viewPager);



    }

    private void setupViewPager(ViewPager viewPager) {
        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AttractionFragment(), getString(R.string.attraction));
        adapter.addFragment(new HotelFragment(), getString(R.string.hotel));
        adapter.addFragment(new ShopFragment(), getString(R.string.shop));
        adapter.addFragment(new EatFragment(), getString(R.string.eat));
        viewPager.setAdapter(adapter);
    }



    //pager Adapter
    private class pagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> mFragmentList = new ArrayList<>();
        private List<String> mTitleList = new ArrayList<>();


        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }



        @Override
        public int getCount() {
            return 4;
        }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mTitleList.add(title);
    }
}}
