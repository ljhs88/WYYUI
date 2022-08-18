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
        buttonTextList.add("每日推荐");
        buttonTextList.add("私人FM");
        buttonTextList.add("歌单");
        buttonTextList.add("每日推荐");
        buttonTextList.add("私人FM");
        buttonTextList.add("歌单");
        buttonTextList.add("每日推荐");
        buttonTextList.add("私人FM");
        buttonTextList.add("歌单");
        buttonTextList.add("每日推荐");
        buttonTextList.add("私人FM");
        buttonTextList.add("歌单");
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
        buttonTextList2.add("日系&ACG | 百遍循环遇知音");
        buttonTextList2.add("那些超好听的热歌分享");
        buttonTextList2.add("提升英语感的英文歌");
        buttonTextList2.add("温柔点吧，这个世界已经够浮躁了");
        buttonTextList2.add("动漫/神曲音乐集");
        buttonTextList2.add("写作业必备(学霸刷题)中文安静");
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
        // 设置样式，里面有很多种样式可以自己都看看效果
        //banner.setBannerStyle(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(imageLoader);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        //轮播图片的文字
        banner.setBannerTitles(titleList);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是true
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载地址
        banner.setImages(imagePathList)
                // 轮播图的监听
                .setOnBannerListener(this)
                // 开始调用的方法,启动轮播图
                .start();
    }

    /**
     * 轮播图的监听
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(), titleList.get(position), Toast.LENGTH_SHORT).show();
    }


    /**
     * 图片加载类
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
