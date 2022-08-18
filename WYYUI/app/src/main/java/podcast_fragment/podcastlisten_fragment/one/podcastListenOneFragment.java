package podcast_fragment.podcastlisten_fragment.one;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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

public class podcastListenOneFragment extends Fragment implements OnBannerListener {

    private View view;
    private Banner banner;
    private ImageLoader imageLoader;
    private List<String> titleList;
    private List<Integer> imagePathList;
    private List<Integer> adapterImagePathList;
    private imageAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_listen_one_fragment, container, false);

        prepareImagePathAndTitle();

        prepareBanner();

        // prepare recyclerview
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new imageAdapter(adapterImagePathList, getContext(), "one");
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void prepareImagePathAndTitle() {
        titleList = new ArrayList<>();
        imagePathList = new ArrayList<>();
        adapterImagePathList = new ArrayList<>();
        titleList.add("");
        titleList.add("");
        titleList.add("");
        titleList.add("");
        titleList.add("");
        imagePathList.add(R.drawable.find_banner_one);
        imagePathList.add(R.drawable.find_banner_two);
        imagePathList.add(R.drawable.find_banner_three);
        imagePathList.add(R.drawable.find_banner_four);
        imagePathList.add(R.drawable.find_banner_five);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randomNum = random.nextInt(5);
            if (randomNum == 1) {
                adapterImagePathList.add(R.drawable.listenone_pager_one);
            } else if (randomNum == 2) {
                adapterImagePathList.add(R.drawable.listenone_pager_two);
            } else if (randomNum == 3) {
                adapterImagePathList.add(R.drawable.listenone_pager_three);
            } else if (randomNum == 4) {
                adapterImagePathList.add(R.drawable.listenone_pager_four);
            } else if (randomNum == 5) {
                adapterImagePathList.add(R.drawable.listenone_pager_five);
            } else {
                adapterImagePathList.add(R.drawable.listenone_pager_six);
            }
        }
    }

    private void prepareBanner() {
        imageLoader = new MyImageLoader();
        banner = view.findViewById(R.id.banner);
        //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(imageLoader);
        banner.setBannerAnimation(Transformer.ZoomOutSlide);
        banner.setBannerTitles(titleList);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setImages(imagePathList)
                .setOnBannerListener(this)
                .start();

    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), titleList.get(position), Toast.LENGTH_SHORT).show();
    }


    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }
}
