package find_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.coolweather.wyyui.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class findFragment extends Fragment implements OnBannerListener {

    private View view;
    // banner
    private Banner banner;
    private MyImageLoader imageLoader;
    private ArrayList<Integer> imagePathList;
    private ArrayList<String> titleList;
    // recycler view1
    private List<String> buttonTextList;
    private List<Integer> buttonImagePathList;
    private RecyclerView recyclerView;
    // recycler view2
    private ArrayList<Integer> buttonImagePathList2;
    private ArrayList<String> buttonTextList2;
    private RecyclerView recyclerView2;
    // view pager1
    private List<Fragment> fragmentList1;
    private ViewPager pager1;
    // view pager2
    private List<Fragment> fragmentList2;
    private ViewPager pager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.find_fragment, container, false);

        // prepare image path List
        prepareImagePathAndTitle();
        // prepare banner
        prepareBanner();
        // prepare recycler view list
        prepareButtonTextAndImagePath();
        // prepare recycler view
        prepareRecyclerView();
        // prepare fragmentList
        prepareFragmentList();
        // prepare view pager
        prepareViewPager();

        return view;
    }

    private void prepareViewPager() {
        pager1 = view.findViewById(R.id.view_pager1);
        pager2 = view.findViewById(R.id.view_pager2);
        pager1.setOffscreenPageLimit(3);
        pager2.setOffscreenPageLimit(3);
        MyFragmentAdapter adapter1 = new MyFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList1);
        MyFragmentAdapter adapter2 = new MyFragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList2);
        pager1.setAdapter(adapter1);
        pager2.setAdapter(adapter2);
    }

    private void prepareFragmentList() {
        fragmentList1 = new ArrayList<>();
        fragmentList2 = new ArrayList<>();
        fragmentList1.add(new viewPagerOneFragment());
        fragmentList1.add(new viewPagerOneFragment());
        fragmentList1.add(new viewPagerOneFragment());

        fragmentList2.add(new viewPagerOneFragment());
        fragmentList2.add(new viewPagerOneFragment());
        fragmentList2.add(new viewPagerOneFragment());
    }

    private void prepareRecyclerView() {
        recyclerView = view.findViewById(R.id.find_recycler_view_button);
        buttonAdapter adapter = new buttonAdapter(buttonTextList, buttonImagePathList, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView2 = view.findViewById(R.id.recycler_view2);
        ImageAdapter adapter2 = new ImageAdapter(buttonImagePathList2, buttonTextList2, getContext());
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(manager2);
    }

    private void prepareButtonTextAndImagePath() {
        buttonTextList = new ArrayList<>();
        buttonImagePathList = new ArrayList<>();
        buttonTextList.add("????????????");
        buttonTextList.add("??????FM");
        buttonTextList.add("??????");
        buttonTextList.add("????????????");
        buttonTextList.add("??????FM");
        buttonTextList.add("??????");
        buttonTextList.add("????????????");
        buttonTextList.add("??????FM");
        buttonTextList.add("??????");
        buttonTextList.add("????????????");
        buttonTextList.add("??????FM");
        buttonTextList.add("??????");
        buttonImagePathList.add(R.drawable.every_recommened);
        buttonImagePathList.add(R.drawable.fm);
        buttonImagePathList.add(R.drawable.song_list);
        buttonImagePathList.add(R.drawable.every_recommened);
        buttonImagePathList.add(R.drawable.fm);
        buttonImagePathList.add(R.drawable.song_list);
        buttonImagePathList.add(R.drawable.every_recommened);
        buttonImagePathList.add(R.drawable.fm);
        buttonImagePathList.add(R.drawable.song_list);
        buttonImagePathList.add(R.drawable.every_recommened);
        buttonImagePathList.add(R.drawable.fm);
        buttonImagePathList.add(R.drawable.song_list);

        buttonImagePathList2 = new ArrayList<>();
        buttonTextList2 = new ArrayList<>();
        buttonImagePathList2.add(R.drawable.find_recycler_view2_one);
        buttonImagePathList2.add(R.drawable.find_recycler_view2_two);
        buttonImagePathList2.add(R.drawable.find_recycler_view2_three);
        buttonImagePathList2.add(R.drawable.find_recycler_view2_four);
        buttonImagePathList2.add(R.drawable.find_recycler_view2_five);
        buttonImagePathList2.add(R.drawable.find_recycler_view2_six);
        buttonTextList2.add("??????&ACG | ?????????????????????");
        buttonTextList2.add("??????????????????????????????");
        buttonTextList2.add("???????????????????????????");
        buttonTextList2.add("?????????????????????????????????????????????");
        buttonTextList2.add("??????/???????????????");
        buttonTextList2.add("???????????????(????????????)????????????");
    }

    private void prepareImagePathAndTitle() {
        imagePathList = new ArrayList<>();
        titleList = new ArrayList<>();
        imagePathList.add(R.drawable.find_banner_one);
        imagePathList.add(R.drawable.find_banner_two);
        imagePathList.add(R.drawable.find_banner_three);
        imagePathList.add(R.drawable.find_banner_four);
        imagePathList.add(R.drawable.find_banner_five);
        titleList.add("");
        titleList.add("");
        titleList.add("");
        titleList.add("");
        titleList.add("");
    }

    private void prepareBanner() {
        imageLoader = new MyImageLoader();
        banner = view.findViewById(R.id.find_viewpager_image);
        // ??????????????????????????????????????????????????????????????????
        //banner.setBannerStyle(BannerConfig.CENTER);
        //?????????????????????
        banner.setImageLoader(imageLoader);
        //???????????????????????????,????????????????????????,????????????????????????
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        //?????????????????????
        banner.setBannerTitles(titleList);
        //????????????????????????
        banner.setDelayTime(3000);
        //???????????????????????????????????????true
        banner.isAutoPlay(true);
        //???????????????????????????????????????????????????
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //????????????????????????
        banner.setImages(imagePathList)
                // ??????????????????
                .setOnBannerListener(this)
                // ?????????????????????,???????????????
                .start();
    }

    /**
     * ??????????????????
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(), titleList.get(position), Toast.LENGTH_SHORT).show();
    }


    /**
     * ???????????????
     */
    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }



}
