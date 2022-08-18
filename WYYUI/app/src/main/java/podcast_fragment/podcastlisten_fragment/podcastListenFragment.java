package podcast_fragment.podcastlisten_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.coolweather.wyyui.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import podcast_fragment.podcastlisten_fragment.one.podcastListenOneFragment;
import podcast_fragment.podcastlisten_fragment.three.podcastListenThreeFragment;
import podcast_fragment.podcastlisten_fragment.two.podcastListenTwoFragment;

public class podcastListenFragment extends Fragment {

    //private CustomViewPager pager;
    private ViewPager pager;
    private TabLayout tabLayout;
    private List<String> tabList;
    private List<Fragment> fragmentList;
    private FragmentManager manager;
    private int hide;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.podcast_listen_fragment, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);

        // prepare fragment list
        prepareFragmentList();

        // prepare tabList
        prepareTabList();

        manager = getActivity().getSupportFragmentManager();

        // add tab
        for (int i = 0; i < tabList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i)));
        }

        //绑定TabLayout和FrameLayout
        manager.beginTransaction()
                .add(R.id.fragment, fragmentList.get(0))
                .commit();
        hide = 0;

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //pager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    /**
     * fragment切换器
     * @param position
     */
    private void switchFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment showFragment = fragmentList.get(position);
        Fragment hideFragment = fragmentList.get(hide);
        if (!showFragment.isAdded()) {
            transaction.add(R.id.fragment, showFragment);
        }
        transaction.show(showFragment);
        transaction.hide(hideFragment);
        transaction.commit();
        hide = position;
    }

    private void prepareTabList() {
        tabList = new ArrayList<>();
        tabList.add("热门");
        tabList.add("精选");
        tabList.add("音乐");
        tabList.add("情感");
        tabList.add("二次元");
        tabList.add("萌新");
        tabList.add("优质主播");
        tabList.add("附近");
        tabList.add("云村唱将");
    }

    private void prepareFragmentList() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new podcastListenOneFragment());
        fragmentList.add(new podcastListenTwoFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
        fragmentList.add(new podcastListenThreeFragment());
    }

}
