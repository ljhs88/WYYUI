package podcast_fragment.podcastClassification_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.coolweather.wyyui.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import podcast_fragment.podcastClassification_fragment.list_five.list_five_fragment;
import podcast_fragment.podcastClassification_fragment.list_four.list_four_fragment;
import podcast_fragment.podcastClassification_fragment.list_one.list_one_fragment;
import podcast_fragment.podcastClassification_fragment.list_six.list_six_fragment;
import podcast_fragment.podcastClassification_fragment.list_three.list_three_fragment;
import podcast_fragment.podcastClassification_fragment.list_two.list_two_fragment;

public class podcastClassificationFragment extends Fragment {

    private View view;

    private TabLayout tabLayout;
    private List<String> tabTitleList;
    private List<Fragment> fragmentList;
    private FragmentManager manager;
    private int hide;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_classification_fragment, container, false);

        prepareTitleAndFragment();

        prepareTabLayout();

        return view;
    }

    private void prepareTabLayout() {
        tabLayout = view.findViewById(R.id.tab_layout);
        for (int i = 0; i < tabTitleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitleList.get(i)));
        }

        manager = getActivity().getSupportFragmentManager();

        manager.beginTransaction()
                .add(R.id.fragment_class, fragmentList.get(0))
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
            transaction.add(R.id.fragment_class, showFragment);
        }
        transaction.show(showFragment);
        transaction.hide(hideFragment);
        transaction.commit();
        hide = position;
    }

    private void prepareTitleAndFragment() {
        tabTitleList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        tabTitleList.add("人文历史");
        tabTitleList.add("故事");
        tabTitleList.add("创作翻唱");
        tabTitleList.add("脱口秀");
        tabTitleList.add("新闻资讯");
        tabTitleList.add("情感");

        fragmentList.add(new list_one_fragment());
        fragmentList.add(new list_two_fragment());
        fragmentList.add(new list_three_fragment());
        fragmentList.add(new list_four_fragment());
        fragmentList.add(new list_five_fragment());
        fragmentList.add(new list_six_fragment());
    }
}
