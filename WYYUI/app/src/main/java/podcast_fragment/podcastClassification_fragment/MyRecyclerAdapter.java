package podcast_fragment.podcastClassification_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.wyyui.R;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<Integer> imagePathList ;
    private Context context;

    public MyRecyclerAdapter(List<Integer> imagePathList, Context context) {
        this.imagePathList = imagePathList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.podcast_class_image_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setBackground(context.getDrawable(imagePathList.get(position)));
    }

    @Override
    public int getItemCount() {
        return imagePathList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.image_button);
        }
    }
}
