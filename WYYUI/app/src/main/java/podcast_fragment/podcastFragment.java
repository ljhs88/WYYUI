package podcast_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.coolweather.wyyui.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import podcast_fragment.podcastClassification_fragment.podcastClassificationFragment;
import podcast_fragment.podcastlisten_fragment.podcastListenFragment;
import podcast_fragment.podcastrecommened_fragment.podcastRecommendedFragment;

public class podcastFragment extends Fragment {

    private ViewPager pager;
    //private CustomViewPager pager;
    private TabLayout tabLayout;
    private List<String> tabList;
    private List<Fragment> fragmentList;
    private podcastFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.podcast_fragment, container, false);

        pager = view.findViewById(R.id.podcast_viewpager);
        tabLayout = view.findViewById(R.id.podcast_tabLayout);

        // prepare tabList
        tabList = new ArrayList<>();
        tabList.add("听听");
        tabList.add("推荐");
        tabList.add("分类");


        // prepare fragment list
        fragmentList = new ArrayList<>();
        fragmentList.add(new podcastListenFragment());
        fragmentList.add(new podcastRecommendedFragment());
        fragmentList.add(new podcastClassificationFragment());

        // set with view pager
        tabLayout.setupWithViewPager(pager);

        adapter = new podcastFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList, tabList);
        pager.setAdapter(adapter);

        return view;
    }

    private class podcastFragmentAdapter extends FragmentPagerAdapter {

        private List<String> tabList;
        private List<Fragment> fragmentList;

        public podcastFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, List<String> tabList) {
            super(fm);
            this.fragmentList = fragmentList;
            this.tabList = tabList;
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }

    }

}
