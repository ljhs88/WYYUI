package podcast_fragment.podcastlisten_fragment.three;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.coolweather.wyyui.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class podcastListenThreeFragment extends Fragment implements OnBannerListener {

    private View view;

    private Banner banner;
    private MyImageLoader imageLoader;
    private List<Integer> bannerImagePathList;
    private List<String> bannerTitleList;

    private RecyclerView recyclerView;
    private List<Integer> imagePathList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_listen_three_fragment, container, false);

        prepareBanner();

        prepareImagePath();

        prepareAdapter();

        Log.d("123", "createView");

        return view;
    }

    private void prepareBanner() {
        prepareBannerImageList();
        banner = view.findViewById(R.id.banner);
        imageLoader = new MyImageLoader();
        banner.setImageLoader(imageLoader);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setBannerTitles(bannerTitleList);
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setImages(bannerImagePathList)
                .setOnBannerListener(this)
                .start();
    }

    private void prepareBannerImageList() {
        bannerImagePathList = new ArrayList<>();
        bannerTitleList = new ArrayList<>();
        bannerImagePathList.add(R.drawable.listenone_pager_one);
        bannerImagePathList.add(R.drawable.listenone_pager_two);
        bannerImagePathList.add(R.drawable.listenone_pager_three);
        bannerImagePathList.add(R.drawable.listenone_pager_four);
        bannerImagePathList.add(R.drawable.listenone_pager_five);
        bannerImagePathList.add(R.drawable.listenone_pager_six);
        bannerTitleList.add("");
        bannerTitleList.add("");
        bannerTitleList.add("");
        bannerTitleList.add("");
        bannerTitleList.add("");
        bannerTitleList.add("");
    }

    private void prepareImagePath() {
        imagePathList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randomNum = random.nextInt(5);
            if (randomNum == 1) {
                imagePathList.add(R.drawable.listenone_pager_one);
            } else if (randomNum == 2) {
                imagePathList.add(R.drawable.listenone_pager_two);
            } else if (randomNum == 3) {
                imagePathList.add(R.drawable.listenone_pager_three);
            } else if (randomNum == 4) {
                imagePathList.add(R.drawable.listenone_pager_four);
            } else if (randomNum == 5) {
                imagePathList.add(R.drawable.listenone_pager_five);
            } else {
                imagePathList.add(R.drawable.listenone_pager_six);
            }
        }
    }

    private void prepareAdapter() {
        recyclerView = view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        imageAdapter adapter = new imageAdapter(imagePathList, getContext(), "three");
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnBannerClick(int position) {
    }


    class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }

}
