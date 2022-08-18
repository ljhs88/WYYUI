package podcast_fragment.podcastClassification_fragment.list_one;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import podcast_fragment.podcastClassification_fragment.MyAdapter;
import podcast_fragment.podcastClassification_fragment.MyRecyclerAdapter;

@SuppressLint("ResourceAsColor")
public class list_one_fragment extends Fragment {

    private View view;

    //private ListView listView;
    private RecyclerView recyclerView;
    private List<Integer> imagePathList;
    //private MyAdapter adapter;
    private MyRecyclerAdapter adapter;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.podcast_class_one, container, false);

        //prepareButton();

        prepareImagePath();

        prepareRecycler();
        //prepareListView();

        return view;
    }

    /*private void prepareButton() {
        button1 = view.findViewById(R.id.button_one);
        button2 = view.findViewById(R.id.button_two);
        button3 = view.findViewById(R.id.button_three);
        button4 = view.findViewById(R.id.button_four);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_one :
                changeTextColor();
                button1.setTextColor(R.color.white);
                prepareImagePath();
                adapter.notifyDataSetChanged();
                Log.d("123", "one");
                break;
            case R.id.button_two :
                changeTextColor();
                button2.setTextColor(R.color.white);
                adapter.notifyDataSetChanged();
                Log.d("123", "two");
                break;
            case R.id.button_three :
                changeTextColor();
                button3.setTextColor(R.color.white);
                adapter.notifyDataSetChanged();
                Log.d("123", "three");
                break;
            case R.id.button_four :
                changeTextColor();
                button4.setTextColor(R.color.white);
                adapter.notifyDataSetChanged();
                Log.d("123", "four");
                break;
        }
    }

    private void changeTextColor() {
        button1.setTextColor(R.color.gray);
        button2.setTextColor(R.color.gray);
        button3.setTextColor(R.color.gray);
        button4.setTextColor(R.color.gray);
    }*/

    /*private void prepareListView() {
        listView = view.findViewById(R.id.list_view);
        adapter = new MyAdapter(getContext(), R.layout.podcast_class_image_item, imagePathList);
        listView.setAdapter(adapter);
    }*/

    private void prepareRecycler() {
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        adapter = new MyRecyclerAdapter(imagePathList, getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
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
