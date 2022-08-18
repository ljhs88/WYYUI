package podcast_fragment.podcastrecommened_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Integer> imagePathList;
    private List<String> textList;
    private Context context;

    public MyAdapter(List<Integer> imagePathList, List<String> textList, Context context) {
        this.imagePathList = imagePathList;
        this.textList = textList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommened_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setBackground(context.getDrawable(imagePathList.get(position)));
        holder.textView.setText(textList.get(position));
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
