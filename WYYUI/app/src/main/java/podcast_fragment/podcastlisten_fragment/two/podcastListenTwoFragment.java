package podcast_fragment.podcastlisten_fragment.two;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.ArrayList;
import java.util.List;

public class podcastListenTwoFragment extends Fragment {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private imageAdapter adapter1;
    private imageAdapter adapter2;
    private LinearLayoutManager manager1;
    private LinearLayoutManager manager2;
    private List<Integer> imagePathList1;
    private List<Integer> imagePathList2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.podcast_listen_two_fragment, container, false);

        // prepare imagePathList
        prepareImagePathList();

        recyclerView1 = view.findViewById(R.id.recycler_view1);
        adapter1 = new imageAdapter(imagePathList1, getContext(), "two");
        manager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(manager1);

        recyclerView2 = view.findViewById(R.id.recycler_view2);
        adapter2 = new imageAdapter(imagePathList2, getContext(), "two");
        manager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(manager2);

        return view;
    }

    private void prepareImagePathList() {
        imagePathList1 = new ArrayList<>();
        imagePathList2 = new ArrayList<>();
        imagePathList1.add(R.drawable.listen_two_one);
        imagePathList1.add(R.drawable.listen_two_two);
        imagePathList1.add(R.drawable.listen_two_three);
        imagePathList1.add(R.drawable.listen_two_four);
        imagePathList1.add(R.drawable.listen_two_five);
        imagePathList1.add(R.drawable.listen_two_six);

        imagePathList2.add(R.drawable.listenone_pager_one);
        imagePathList2.add(R.drawable.listenone_pager_two);
        imagePathList2.add(R.drawable.listenone_pager_three);
        imagePathList2.add(R.drawable.listenone_pager_four);
        imagePathList2.add(R.drawable.listenone_pager_five);
        imagePathList2.add(R.drawable.listenone_pager_six);
    }
}
