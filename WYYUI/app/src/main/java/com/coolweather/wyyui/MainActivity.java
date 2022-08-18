package com.coolweather.wyyui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import attention_fragment.attentionFragment;
import cloudcountryside_fragment.cloudCountrysideFragment;
import find_fragment.findFragment;
import my_fragment.myFragment;
import podcast_fragment.podcastFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager pager;
    private BottomNavigationView navigation;

    private DrawerLayout drawerLayout;
    private Button home;

    private BottomNavigationView.OnNavigationItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        pager = findViewById(R.id.view_pager_main);
        navigation = findViewById(R.id.bottom_navigation);

        home = findViewById(R.id.home_as_up);
        drawerLayout = findViewById(R.id.drawer_layout);
        home.setOnClickListener(this);

        // prepare fragments
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new findFragment());
        fragmentList.add(new podcastFragment());
        fragmentList.add(new myFragment());
        fragmentList.add(new attentionFragment());
        fragmentList.add(new cloudCountrysideFragment());

        // Initialize fragment adapter
        FragmentPagerAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        pager.setAdapter(adapter);

        pager.setOffscreenPageLimit(5);

        // setting click events
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.pod_cast:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.my:
                        pager.setCurrentItem(2);
                        break;
                    case R.id.attention:
                        pager.setCurrentItem(3);
                        break;
                    case R.id.cloudCountrySide:
                        pager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

        // setting slide events
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 将滑动到的页面对应的menu设置为选中状态
                navigation.setSelectedItemId(navigation.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    // fragment adapter
    class FragmentAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;

        public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    // open slide window
    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_as_up:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    // 退出后在后台运行
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}