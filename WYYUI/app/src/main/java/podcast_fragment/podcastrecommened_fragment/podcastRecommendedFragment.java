package podcast_fragment.podcastrecommened_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.coolweather.wyyui.R;
import com.superluo.textbannerlibrary.TextBannerView;

import java.util.ArrayList;
import java.util.List;
import find_fragment.MyFragmentAdapter;
import find_fragment.viewPagerOneFragment;

public class podcastRecommendedFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView1;
    private List<Integer> imagePathList;
    private List<String> textList;

    private ViewPager pager1;
    private List<Fragment> fragmentList;
    private List<String> bannerTextList;
    private List<Integer> bannerImageList;

    private ViewPager pager2;
    private List<Fragment> fragmentList2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_recommended_fragment, container, false);

        prepareTextAndImagePath();

        prepareRecycler();

        prepareFragment();

        preparePager();

        return view;
    }

    private void preparePager() {
        pager1 = view.findViewById(R.id.podcast_viewpager1);
        pager1.setOffscreenPageLimit(5);
        MyFragmentAdapter adapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList);
        pager1.setAdapter(adapter);

        pager2 = view.findViewById(R.id.podcast_viewpager2);
        pager2.setOffscreenPageLimit(4);
        MyFragmentAdapter adapter2 = new MyFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList2);
        pager2.setAdapter(adapter2);
    }

    private void prepareFragment() {
        fragmentList = new ArrayList<>();
        bannerTextList = new ArrayList<>();
        bannerImageList = new ArrayList<>();
        bannerTextList.add("??????????????????????????????????????????????????????????????????????????????#19175?????????#??????TALK");
        bannerTextList.add("EP.13-???????????????????????? | ??????30??????????????????#21397?????????#????????????#6857?????????#??????????????????");
        bannerTextList.add("????????????????????????????????????????????????????????????????????????#14347?????????#???????????????");
        bannerTextList.add("???????????????????????????????????????Android?????????#23121?????????#????????????");
        bannerTextList.add("The club isn't the best place to find love#4234?????????#????????????");
        bannerImageList.add(R.drawable.listenone_pager_one);
        bannerImageList.add(R.drawable.listenone_pager_two);
        bannerImageList.add(R.drawable.listenone_pager_three);
        bannerImageList.add(R.drawable.listenone_pager_four);
        bannerImageList.add(R.drawable.listenone_pager_five);
        for (int i = 0; i < 5; i++) {
            Fragment fragment = new pager1_fragment();
            fragmentList.add(fragment);
            Bundle bundle = new Bundle();
            bundle.putString("one", bannerTextList.get(i));
            bundle.putInt("Integer", bannerImageList.get(i));
            fragment.setArguments(bundle);
        }

        fragmentList2 = new ArrayList<>();
        fragmentList2.add(new viewPagerOneFragment());
        fragmentList2.add(new viewPagerOneFragment());
        fragmentList2.add(new viewPagerOneFragment());
        fragmentList2.add(new viewPagerOneFragment());
    }

    private void prepareRecycler() {
        recyclerView1 = view.findViewById(R.id.podcast_recycler1);
        MyAdapter adapter = new MyAdapter(imagePathList, textList, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView1.setLayoutManager(manager);
        recyclerView1.setAdapter(adapter);
    }

    private void prepareTextAndImagePath() {
        textList = new ArrayList<>();
        imagePathList = new ArrayList<>();
        textList.add("????????????");
        textList.add("?????????");
        textList.add("????????????");
        textList.add("????????????");
        textList.add("????????????");
        textList.add("????????????");
        imagePathList.add(R.drawable.pod_cast_red);
        imagePathList.add(R.drawable.re_rec_two);
        imagePathList.add(R.drawable.re_rec_three);
        imagePathList.add(R.drawable.re_rec_four);
        imagePathList.add(R.drawable.re_rec_five);
        imagePathList.add(R.drawable.re_rec_six);
    }

}
