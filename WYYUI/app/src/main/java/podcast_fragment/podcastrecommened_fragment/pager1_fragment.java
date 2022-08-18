package podcast_fragment.podcastrecommened_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolweather.wyyui.R;
import com.superluo.textbannerlibrary.TextBannerView;

import java.util.ArrayList;
import java.util.List;

public class pager1_fragment extends Fragment {

    private View view;

    private List<String> bannerTextList;
    private TextBannerView textBanner;
    private String content;
    private String[] contentList;

    private Button button;
    private TextView textView1;
    private TextView textView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommended_pager1_fragment, container, false);
        textView1 = view.findViewById(R.id.text1);
        textView2 = view.findViewById(R.id.text2);
        button = view.findViewById(R.id.button);

        Bundle bundle = getArguments();
        content =  bundle.getString("one");
        contentList = content.split("#");
        Integer integer = bundle.getInt("Integer");

        textView1.setText(contentList[1]);
        textView2.setText(contentList[2]);
        button.setBackground(getContext().getDrawable(integer));

        prepareTextBanner();

        return view;
    }

    private void prepareTextBanner() {
        bannerTextList = new ArrayList<>();
        bannerTextList.add(contentList[0]);
        textBanner = view.findViewById(R.id.text_banner);
        textBanner.setDatas(bannerTextList);
    }
}
