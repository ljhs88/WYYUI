package podcast_fragment.podcastClassification_fragment.list_six;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolweather.wyyui.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import podcast_fragment.podcastClassification_fragment.MyAdapter;

public class list_six_fragment extends Fragment {

    private View view;

    private ListView listView;
    private List<Integer> imagePathList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_class_six, container, false);

        prepareImagePath();

        prepareListView();

        return view;
    }

    private void prepareListView() {
        listView = view.findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(getContext(), R.layout.podcast_class_image_item, imagePathList);
        listView.setAdapter(adapter);
    }

    private void prepareImagePath() {
        imagePathList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randomNum = random.nextInt(5);
            if (randomNum == 1) {
                imagePathList.add(R.drawable.podcast_class_one);
            } else if (randomNum == 2) {
                imagePathList.add(R.drawable.podcast_class_two);
            } else if (randomNum == 3) {
                imagePathList.add(R.drawable.podcast_class_three);
            } else if (randomNum == 4) {
                imagePathList.add(R.drawable.podcast_class_four);
            } else if (randomNum == 5) {
                imagePathList.add(R.drawable.podcast_class_five);
            } else {
                imagePathList.add(R.drawable.podcast_class_six);
            }
        }
    }

}
